package com.cnwanweb.quickframework.modules.sys.utils;

import com.cnwanweb.quickframework.common.security.shiro.Principal;
import com.cnwanweb.quickframework.common.service.BaseService;
import com.cnwanweb.quickframework.common.utils.CacheUtils;
import com.cnwanweb.quickframework.common.utils.SpringContextHolder;
import com.cnwanweb.quickframework.common.utils.StringUtils;
import com.cnwanweb.quickframework.modules.sys.dao.AreaDao;
import com.cnwanweb.quickframework.modules.sys.dao.MenuDao;
import com.cnwanweb.quickframework.modules.sys.dao.OfficeDao;
import com.cnwanweb.quickframework.modules.sys.dao.RoleDao;
import com.cnwanweb.quickframework.modules.sys.dao.UserDao;
import com.cnwanweb.quickframework.modules.sys.entity.Area;
import com.cnwanweb.quickframework.modules.sys.entity.Menu;
import com.cnwanweb.quickframework.modules.sys.entity.Office;
import com.cnwanweb.quickframework.modules.sys.entity.Role;
import com.cnwanweb.quickframework.modules.sys.entity.User;
import com.cnwanweb.quickframework.modules.sys.entity.UserDevice;
import com.cnwanweb.quickframework.modules.sys.security.SystemAuthorizingPrincipal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserUtils {
    private static UserDao userDao = (UserDao)SpringContextHolder.getBean(UserDao.class);
    private static RoleDao roleDao = (RoleDao)SpringContextHolder.getBean(RoleDao.class);
    private static MenuDao menuDao = (MenuDao)SpringContextHolder.getBean(MenuDao.class);
    private static AreaDao areaDao = (AreaDao)SpringContextHolder.getBean(AreaDao.class);
    private static OfficeDao officeDao = (OfficeDao)SpringContextHolder.getBean(OfficeDao.class);
    public static final String USER_CACHE = "userCache";
    public static final String USER_CACHE_ID_ = "id_";
    public static final String USER_CACHE_LOGIN_NAME_ = "ln";
    public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";
    public static final String CACHE_ROLE_LIST = "roleList";
    public static final String CACHE_MENU_LIST = "menuList";
    public static final String CACHE_AREA_LIST = "areaList";
    public static final String CACHE_OFFICE_LIST = "officeList";
    public static final String CACHE_OFFICE_ALL_LIST = "officeAllList";
    private static final Logger logger = LoggerFactory.getLogger(UserUtils.class);

    public UserUtils() {
    }

    public static final boolean isAppLogin(UserDevice userDevice) {
        return userDevice != null && StringUtils.isNotBlank(userDevice.getDeviceId());
    }

    public static final boolean isApiSecurity1(UserDevice userDevice) {
        return userDevice.getProtocol().equals("cnwanweb/1.0");
    }

    public static final boolean isApiSecurity2(UserDevice userDevice) {
        return userDevice.getProtocol().equals("cnwanweb/2.0");
    }

    public static final boolean isAppLogin(HttpServletRequest request) {
        UserDevice userDevice = convertToUserDevice(request);
        return isAppLogin(userDevice);
    }

    public static final UserDevice convertToUserDevice(HttpServletRequest request) {
        String userAgentString = request.getHeader("CNWANWEB-SECURITY");
        return convertToUserDevice(userAgentString);
    }

    public static final UserDevice convertToUserDevice(String userAgentString) {
        if(StringUtils.isBlank(userAgentString)) {
            return null;
        } else {
            Pattern pattern = Pattern.compile("(.*):(.*):(.*)");
            Matcher matcher = pattern.matcher(userAgentString);
            if(matcher.find()) {
                String protocol = matcher.group(1);
                UserDevice entity = new UserDevice();
                entity.setProtocol(protocol);
                int dataLength = Integer.parseInt(matcher.group(2));
                String clientInfo = matcher.group(3);
                if(clientInfo.length() != dataLength) {
                    logger.debug("请求头信息大小有误 -> {}", userAgentString);
                    throw new RuntimeException("请求头信息大小有误");
                } else {
                    String[] clientInfos = clientInfo.split(";");
                    entity.setDeviceId(clientInfos[0]);
                    entity.setDeviceName(clientInfos[1]);
                    String[] osInfo = clientInfos[2].split(" ");
                    entity.setOsName(osInfo[0]);
                    entity.setOsVersion(osInfo[1]);
                    entity.setDeviceBrand(clientInfos[3]);
                    entity.setSoftVersion(clientInfos[4]);
                    if(protocol.equals("cnwanweb/1.0")) {
                        entity.setUser(getUser());
                    } else {
                        if(!protocol.equals("cnwanweb/2.0")) {
                            logger.debug("尚未支持的请求头版本 -> {}", userAgentString);
                            throw new RuntimeException("尚未支持的请求头版本");
                        }

                        String token = clientInfos[5];
                        Object obj = CacheUtils.get("tokenCache", token);
                        if(obj != null && obj instanceof User) {
                            entity.setUser((User)obj);
                        }
                    }

                    return entity;
                }
            } else {
                logger.debug("不规范的请求头版本 -> {}", userAgentString);
                throw new RuntimeException("不规范的请求头版本");
            }
        }
    }

    public static User get(String id) {
        User user = (User)CacheUtils.get("userCache", "id_" + id);
        if(user == null) {
            user = (User)userDao.get(id);
            if(user == null) {
                return null;
            }

            user.setRoleList(roleDao.findList(new Role(user)));
            CacheUtils.put("userCache", "id_" + user.getId(), user);
            CacheUtils.put("userCache", "ln" + user.getLoginName(), user);
        }

        return user;
    }

    public static User getByLoginName(String loginName) {
        User user = (User)CacheUtils.get("userCache", "ln" + loginName);
        if(user == null) {
            user = userDao.getByLoginName(new User((String)null, loginName));
            if(user == null) {
                return null;
            }

            user.setRoleList(roleDao.findList(new Role(user)));
            CacheUtils.put("userCache", "id_" + user.getId(), user);
            CacheUtils.put("userCache", "ln" + user.getLoginName(), user);
        }

        return user;
    }

    public static void clearCache() {
        removeCache("roleList");
        removeCache("menuList");
        removeCache("areaList");
        removeCache("officeList");
        removeCache("officeAllList");
        clearCache(getUser());
    }

    public static void clearCache(User user) {
        CacheUtils.remove("userCache", "id_" + user.getId());
        CacheUtils.remove("userCache", "ln" + user.getLoginName());
        CacheUtils.remove("userCache", "ln" + user.getOldLoginName());
        if(user.getOffice() != null && user.getOffice().getId() != null) {
            CacheUtils.remove("userCache", "oid_" + user.getOffice().getId());
        }

    }

    public static User getUser() {
        Principal principal = getPrincipal();
        if(principal != null) {
            User user = get(principal.getId());
            return user != null?user:new User();
        } else {
            return new User();
        }
    }

    public static List<Role> getRoleList() {
        List<Role> roleList = (List)getCache("roleList");
        if(roleList == null) {
            User user = getUser();
            if(user.isAdmin()) {
                roleList = roleDao.findAllList(new Role());
            } else {
                Role role = new Role();
                role.getSqlMap().put("dsf", BaseService.dataScopeFilter(user.getCurrentUser(), "o", "u"));
                roleList = roleDao.findList(role);
            }

            putCache("roleList", roleList);
        }

        return roleList;
    }

    public static List<Menu> getMenuList() {
        List<Menu> menuList = (List)getCache("menuList");
        if(menuList == null) {
            User user = getUser();
            if(user.isAdmin()) {
                menuList = menuDao.findAllList(new Menu());
            } else {
                Menu m = new Menu();
                m.setUserId(user.getId());
                menuList = menuDao.findByUserId(m);
            }

            putCache("menuList", menuList);
        }

        return menuList;
    }

    public static List<Area> getAreaList() {
        List<Area> areaList = (List)getCache("areaList");
        if(areaList == null) {
            areaList = areaDao.findAllList(new Area());
            putCache("areaList", areaList);
        }

        return areaList;
    }

    public static List<Office> getOfficeList() {
        List<Office> officeList = (List)getCache("officeList");
        if(officeList == null) {
            User user = getUser();
            if(user.isAdmin()) {
                officeList = officeDao.findAllList(new Office());
            } else {
                Office office = new Office();
                office.getSqlMap().put("dsf", BaseService.dataScopeFilter(user, "a", ""));
                officeList = officeDao.findList(office);
            }

            putCache("officeList", officeList);
        }

        return officeList;
    }

    public static List<Office> getOfficeAllList() {
        List<Office> officeList = (List)getCache("officeAllList");
        if(officeList == null) {
            officeList = officeDao.findAllList(new Office());
        }

        return officeList;
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static Principal getPrincipal() {
        try {
            Subject subject = SecurityUtils.getSubject();
            Object obj = subject.getPrincipal();
            if(obj instanceof String) {
                String tokenUserName = obj.toString();
                User user = getByLoginName(tokenUserName);
                return new SystemAuthorizingPrincipal(user, false);
            }

            Principal principal = (Principal)obj;
            if(principal != null) {
                return principal;
            }
        } catch (UnavailableSecurityManagerException var4) {
            ;
        } catch (InvalidSessionException var5) {
            ;
        }

        return null;
    }

    public static Session getSession() {
        try {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession(false);
            if(session == null) {
                session = subject.getSession();
            }

            if(session != null) {
                return session;
            }
        } catch (InvalidSessionException var2) {
            ;
        }

        return null;
    }

    public static Object getCache(String key) {
        return getCache(key, (Object)null);
    }

    public static Object getCache(String key, Object defaultValue) {
        Object obj = getSession().getAttribute(key);
        return obj == null?defaultValue:obj;
    }

    public static void putCache(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static void removeCache(String key) {
        getSession().removeAttribute(key);
    }
}
