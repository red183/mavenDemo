package com.cnwanweb.quickframework.modules.sys.service;

import com.cnwanweb.quickframework.common.config.Global;
import com.cnwanweb.quickframework.common.persistence.Page;
import com.cnwanweb.quickframework.common.security.Digests;
import com.cnwanweb.quickframework.common.security.shiro.session.SessionDAO;
import com.cnwanweb.quickframework.common.service.BaseService;
import com.cnwanweb.quickframework.common.service.ServiceException;
import com.cnwanweb.quickframework.common.utils.CacheUtils;
import com.cnwanweb.quickframework.common.utils.Encodes;
import com.cnwanweb.quickframework.common.utils.StringUtils;
import com.cnwanweb.quickframework.common.web.Servlets;
import com.cnwanweb.quickframework.modules.sys.dao.MenuDao;
import com.cnwanweb.quickframework.modules.sys.dao.RoleDao;
import com.cnwanweb.quickframework.modules.sys.dao.UserDao;
import com.cnwanweb.quickframework.modules.sys.entity.Menu;
import com.cnwanweb.quickframework.modules.sys.entity.Office;
import com.cnwanweb.quickframework.modules.sys.entity.Role;
import com.cnwanweb.quickframework.modules.sys.entity.User;
import com.cnwanweb.quickframework.modules.sys.security.SystemAuthorizingRealm;
import com.cnwanweb.quickframework.modules.sys.utils.UserUtils;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(
        readOnly = true
)
public class SystemService extends BaseService implements InitializingBean {
    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private SessionDAO sessionDao;
    @Autowired
    private SystemAuthorizingRealm systemRealm;
    @Autowired
    private IdentityService identityService;
    private static boolean isSynActivitiIndetity = true;

    public SystemService() {
    }

    public SessionDAO getSessionDao() {
        return this.sessionDao;
    }

    public User getUser(String id) {
        return UserUtils.get(id);
    }

    public User getUserByLoginName(String loginName) {
        return UserUtils.getByLoginName(loginName);
    }

    public Page<User> findUser(Page<User> page, User user) {
        user.getSqlMap().put("dsf", dataScopeFilter(user.getCurrentUser(), "o", "a"));
        user.setPage(page);
        page.setList(this.userDao.findList(user));
        return page;
    }

    public List<User> findUser(User user) {
        user.getSqlMap().put("dsf", dataScopeFilter(user.getCurrentUser(), "o", "a"));
        List<User> list = this.userDao.findList(user);
        return list;
    }

    public List<User> findUserByOfficeId(String officeId) {
        List<User> list = (List)CacheUtils.get("userCache", "oid_" + officeId);
        if(list == null) {
            User user = new User();
            user.setOffice(new Office(officeId));
            list = this.userDao.findUserByOfficeId(user);
            CacheUtils.put("userCache", "oid_" + officeId, list);
        }

        return list;
    }

    @Transactional(
            readOnly = false
    )
    public void saveUser(User user) {
        if(StringUtils.isBlank(user.getId())) {
            user.preInsert();
            this.userDao.insert(user);
        } else {
            User oldUser = (User)this.userDao.get(user.getId());
            if(oldUser.getOffice() != null && oldUser.getOffice().getId() != null) {
                CacheUtils.remove("userCache", "oid_" + oldUser.getOffice().getId());
            }

            user.preUpdate();
            this.userDao.update(user);
        }

        if(StringUtils.isNotBlank(user.getId())) {
            this.userDao.deleteUserRole(user);
            if(user.getRoleList() == null || user.getRoleList().size() <= 0) {
                throw new ServiceException(user.getLoginName() + "没有设置角色！");
            }

            this.userDao.insertUserRole(user);
            this.saveActivitiUser(user);
            UserUtils.clearCache(user);
        }

    }

    @Transactional(
            readOnly = false
    )
    public void updateUserInfo(User user) {
        user.preUpdate();
        this.userDao.updateUserInfo(user);
        UserUtils.clearCache(user);
    }

    @Transactional(
            readOnly = false
    )
    public void deleteUser(User user) {
        this.userDao.delete(user);
        this.deleteActivitiUser(user);
        UserUtils.clearCache(user);
    }

    @Transactional(
            readOnly = false
    )
    public void updatePasswordById(String id, String loginName, String newPassword) {
        User user = new User(id);
        user.setPassword(entryptPassword(newPassword));
        this.userDao.updatePasswordById(user);
        user.setLoginName(loginName);
        UserUtils.clearCache(user);
    }

    @Transactional(
            readOnly = false
    )
    public void updateUserLoginInfo(User user) {
        user.setOldLoginIp(user.getLoginIp());
        user.setOldLoginDate(user.getLoginDate());
        user.setLoginIp(StringUtils.getRemoteAddr(Servlets.getRequest()));
        user.setLoginDate(new Date());
        this.userDao.updateLoginInfo(user);
    }

    public static String entryptPassword(String plainPassword) {
        String plain = Encodes.unescapeHtml(plainPassword);
        byte[] salt = Digests.generateSalt(8);
        byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, 1024);
        return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
    }

    /**
     * 迁移需要，MD5值强制转SHA1
     * 第一次用，登录时先判断登录密码生成的MD5值是否和数据库一致，
     * 如果TRUE，则使用登录的密码立即生成 SHA1值覆盖。
     * @param username
     * @param password
     */
    @Transactional(readOnly = false)
    public void migratePasswordMd5ToLocal(String username, String password) {
        User user = getUserByLoginName(username);
        if(user != null) {
            String md5Hex = DigestUtils.md5Hex(password).toLowerCase();
            if(md5Hex.equals(user.getPassword())) {
                updatePasswordById(user.getId(), username, password);
            }
        }
    }

    public User getByWxWareOpenId(String openId) {
        User user = new User();
        user.setOpenId(openId);
        return userDao.getByWxWareOpenId(user);
    }

    @Transactional(readOnly = false)
    public void updateOpenId(User user) {
        userDao.updateOpenId(user);
        User user2= userDao.getByLoginName(user);
        UserUtils.clearCache(user2);
    }

    public static boolean validatePassword(String plainPassword, String password) {
        String plain = Encodes.unescapeHtml(plainPassword);
        byte[] salt = Encodes.decodeHex(password.substring(0, 16));
        byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, 1024);
        return password.equals(Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword));
    }

    public Collection<Session> getActiveSessions() {
        return this.sessionDao.getActiveSessions(false);
    }

    public Role getRole(String id) {
        return (Role)this.roleDao.get(id);
    }

    public Role getRoleByName(String name) {
        Role r = new Role();
        r.setName(name);
        return this.roleDao.getByName(r);
    }

    public Role getRoleByEnname(String enname) {
        Role r = new Role();
        r.setEnname(enname);
        return this.roleDao.getByEnname(r);
    }

    public List<Role> findRole(Role role) {
        return this.roleDao.findList(role);
    }

    public List<Role> findAllRole() {
        return UserUtils.getRoleList();
    }

    @Transactional(
            readOnly = false
    )
    public void saveRole(Role role) {
        if(StringUtils.isBlank(role.getId())) {
            role.preInsert();
            this.roleDao.insert(role);
            this.saveActivitiGroup(role);
        } else {
            role.preUpdate();
            this.roleDao.update(role);
        }

        this.roleDao.deleteRoleMenu(role);
        if(role.getMenuList().size() > 0) {
            this.roleDao.insertRoleMenu(role);
        }

        this.roleDao.deleteRoleOffice(role);
        if(role.getOfficeList().size() > 0) {
            this.roleDao.insertRoleOffice(role);
        }

        this.saveActivitiGroup(role);
        UserUtils.removeCache("roleList");
    }

    @Transactional(
            readOnly = false
    )
    public void deleteRole(Role role) {
        this.roleDao.delete(role);
        this.deleteActivitiGroup(role);
        UserUtils.removeCache("roleList");
    }

    @Transactional(
            readOnly = false
    )
    public Boolean outUserInRole(Role role, User user) {
        List<Role> roles = user.getRoleList();
        Iterator i$ = roles.iterator();

        Role e;
        do {
            if(!i$.hasNext()) {
                return Boolean.valueOf(false);
            }

            e = (Role)i$.next();
        } while(!e.getId().equals(role.getId()));

        roles.remove(e);
        this.saveUser(user);
        return Boolean.valueOf(true);
    }

    @Transactional(
            readOnly = false
    )
    public User assignUserToRole(Role role, User user) {
        if(user == null) {
            return null;
        } else {
            List<String> roleIds = user.getRoleIdList();
            if(roleIds.contains(role.getId())) {
                return null;
            } else {
                user.getRoleList().add(role);
                this.saveUser(user);
                return user;
            }
        }
    }

    public Menu getMenu(String id) {
        return (Menu)this.menuDao.get(id);
    }

    public List<Menu> findAllMenu() {
        return UserUtils.getMenuList();
    }

    @Transactional(
            readOnly = false
    )
    public void saveMenu(Menu menu) {
        menu.setParent(this.getMenu(menu.getParent().getId()));
        String oldParentIds = menu.getParentIds();
        menu.setParentIds(menu.getParent().getParentIds() + menu.getParent().getId() + ",");
        if(StringUtils.isBlank(menu.getId())) {
            menu.preInsert();
            this.menuDao.insert(menu);
        } else {
            menu.preUpdate();
            this.menuDao.update(menu);
        }

        Menu m = new Menu();
        m.setParentIds("%," + menu.getId() + ",%");
        List<Menu> list = this.menuDao.findByParentIdsLike(m);
        Iterator i$ = list.iterator();

        while(i$.hasNext()) {
            Menu e = (Menu)i$.next();
            e.setParentIds(e.getParentIds().replace(oldParentIds, menu.getParentIds()));
            this.menuDao.updateParentIds(e);
        }

        UserUtils.removeCache("menuList");
        CacheUtils.remove("menuNamePathMap");
    }

    @Transactional(
            readOnly = false
    )
    public void updateMenuSort(Menu menu) {
        this.menuDao.updateSort(menu);
        UserUtils.removeCache("menuList");
        CacheUtils.remove("menuNamePathMap");
    }

    @Transactional(
            readOnly = false
    )
    public void deleteMenu(Menu menu) {
        this.menuDao.delete(menu);
        UserUtils.removeCache("menuList");
        CacheUtils.remove("menuNamePathMap");
    }

    public static boolean printKeyLoadMessage() {
        StringBuilder sb = new StringBuilder();
        String separator = System.getProperty("line.separator");
        sb.append(separator);
        sb.append("======================================================================");
        sb.append(separator).append(separator);
        sb.append("\t欢迎使用 ");
        sb.append(Global.getConfig("productName"));
        sb.append("  - Powered By 智慧城市事业部").append(separator);
        sb.append(separator);
        sb.append("======================================================================");
        sb.append(separator);
        System.out.println(sb.toString());
        return true;
    }

    public void afterPropertiesSet() throws Exception {
        if(Global.isSynActivitiIndetity().booleanValue()) {
            if(isSynActivitiIndetity) {
                isSynActivitiIndetity = false;
                List<Group> groupList = this.identityService.createGroupQuery().list();
                if(groupList.size() == 0) {
                    Iterator roles = this.roleDao.findAllList(new Role()).iterator();

                    while(roles.hasNext()) {
                        Role role = (Role)roles.next();
                        this.saveActivitiGroup(role);
                    }
                }

                List<org.activiti.engine.identity.User> userList = this.identityService.createUserQuery().list();
                if(userList.size() == 0) {
                    Iterator users = this.userDao.findAllList(new User()).iterator();

                    while(users.hasNext()) {
                        this.saveActivitiUser((User)users.next());
                    }
                }
            }

        }
    }

    private void saveActivitiGroup(Role role) {
        if (!Global.isSynActivitiIndetity()){
            return;
        }
        String groupId = role.getEnname();

        // 如果修改了英文名，则删除原Activiti角色
        if (StringUtils.isNotBlank(role.getOldEnname()) && !role.getOldEnname().equals(role.getEnname())){
            identityService.deleteGroup(role.getOldEnname());
        }

        Group group = identityService.createGroupQuery().groupId(groupId).singleResult();
        if (group == null) {
            group = identityService.newGroup(groupId);
        }
        group.setName(role.getName());
        group.setType(role.getRoleType());
        identityService.saveGroup(group);

        // 删除用户与用户组关系
        List<org.activiti.engine.identity.User> activitiUserList = identityService.createUserQuery().memberOfGroup(groupId).list();
        for (org.activiti.engine.identity.User activitiUser : activitiUserList){
            identityService.deleteMembership(activitiUser.getId(), groupId);
        }

        // 创建用户与用户组关系
        List<User> userList = findUser(new User(new Role(role.getId())));
        for (User e : userList){
            String userId = e.getLoginName();//ObjectUtils.toString(user.getId());
            // 如果该用户不存在，则创建一个
            org.activiti.engine.identity.User activitiUser = identityService.createUserQuery().userId(userId).singleResult();
            if (activitiUser == null){
                activitiUser = identityService.newUser(userId);
                activitiUser.setFirstName(e.getName());
                activitiUser.setLastName(StringUtils.EMPTY);
                activitiUser.setEmail(e.getEmail());
                activitiUser.setPassword(StringUtils.EMPTY);
                identityService.saveUser(activitiUser);
            }
            identityService.createMembership(userId, groupId);
        }
    }

    public void deleteActivitiGroup(Role role) {
        if(Global.isSynActivitiIndetity().booleanValue()) {
            if(role != null) {
                String groupId = role.getEnname();
                this.identityService.deleteGroup(groupId);
            }

        }
    }

    private void saveActivitiUser(User user) {
        if(Global.isSynActivitiIndetity().booleanValue()) {
            String userId = user.getLoginName();
            org.activiti.engine.identity.User activitiUser = (org.activiti.engine.identity.User)this.identityService.createUserQuery().userId(userId).singleResult();
            if(activitiUser == null) {
                activitiUser = this.identityService.newUser(userId);
            }

            activitiUser.setFirstName(user.getName());
            activitiUser.setLastName("");
            activitiUser.setEmail(user.getEmail());
            activitiUser.setPassword("");
            this.identityService.saveUser(activitiUser);
            List<Group> activitiGroups = this.identityService.createGroupQuery().groupMember(userId).list();
            Iterator i$ = activitiGroups.iterator();

            while(i$.hasNext()) {
                Group group = (Group)i$.next();
                this.identityService.deleteMembership(userId, group.getId());
            }

            Role role;
            for(i$ = user.getRoleList().iterator(); i$.hasNext(); this.identityService.createMembership(userId, role.getEnname())) {
                role = (Role)i$.next();
                String groupId = role.getEnname();
                Group group = (Group)this.identityService.createGroupQuery().groupId(groupId).singleResult();
                if(group == null) {
                    group = this.identityService.newGroup(groupId);
                    group.setName(role.getName());
                    group.setType(role.getRoleType());
                    this.identityService.saveGroup(group);
                }
            }

        }
    }

    private void deleteActivitiUser(User user) {
        if(Global.isSynActivitiIndetity().booleanValue()) {
            if(user != null) {
                String userId = user.getLoginName();
                this.identityService.deleteUser(userId);
            }

        }
    }
}
