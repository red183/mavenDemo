package com.cnwanweb.quickframework.modules.sys.security;

import com.cnwanweb.quickframework.common.config.Global;
import com.cnwanweb.quickframework.common.security.shiro.Principal;
import com.cnwanweb.quickframework.common.utils.SpringContextHolder;
import com.cnwanweb.quickframework.modules.sys.entity.Menu;
import com.cnwanweb.quickframework.modules.sys.entity.Role;
import com.cnwanweb.quickframework.modules.sys.entity.User;
import com.cnwanweb.quickframework.modules.sys.service.SystemService;
import com.cnwanweb.quickframework.modules.sys.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;

/**
 * Created by firecnwanweb on 2017/9/29.
 */
public abstract class BaseQsRealm extends AuthorizingRealm {

    private static SystemService systemService;

    /**
     * 获取系统业务对象
     */
    public static SystemService getSystemService() {
        if (systemService == null){
            systemService = SpringContextHolder.getBean(SystemService.class);
        }
        return systemService;
    }

    /**
     * 获取当前已登录的用户
     */
    public static final void checkUserMultiAccountLogin(Principal principal) {
        if (!Global.TRUE.equals(Global.getConfig("user.multiAccountLogin"))){
            Collection<Session> sessions = getSystemService().getSessionDao().getActiveSessions(true, principal, UserUtils.getSession());
            if (sessions.size() > 0){
                // 如果是登录进来的，则踢出已在线用户
                if (UserUtils.getSubject().isAuthenticated()){
                    for (Session session : sessions){
                        getSystemService().getSessionDao().delete(session);
                    }
                } else{
                    // 记住我进来的，并且当前用户已登录，则退出当前用户提示信息。
                    UserUtils.getSubject().logout();
                    throw new AuthenticationException("msg:账号已在其它地方登录，请重新登录。");
                }
            }
        }
    }

    public static SimpleAuthorizationInfo initUserPermissions(Principal principal) {
        User user = getSystemService().getUserByLoginName(principal.getLoginName());
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            List<Menu> list = UserUtils.getMenuList();
            for (Menu menu : list){
                if (StringUtils.isNotBlank(menu.getPermission())){
                    // 添加基于Permission的权限信息
                    for (String permission : StringUtils.split(menu.getPermission(),",")){
                        info.addStringPermission(permission);
                    }
                }
            }
            // 添加用户权限
            info.addStringPermission("user");
            info.addStringPermission(user.getUserType());
            // 添加用户角色信息
            for (Role role : user.getRoleList()){
                info.addRole(role.getEnname());
            }
            // 更新登录IP和时间
            getSystemService().updateUserLoginInfo(user);
            return info;
        } else {
            return null;
        }
    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Principal principal = (Principal) getAvailablePrincipal(principals);
        checkUserMultiAccountLogin(principal);
        return initUserPermissions(principal);
    }

    @Override
    protected void checkPermission(Permission permission, AuthorizationInfo info) {
        authorizationValidate(permission);
        super.checkPermission(permission, info);
    }

    @Override
    protected boolean[] isPermitted(List<Permission> permissions, AuthorizationInfo info) {
        if (permissions != null && !permissions.isEmpty()) {
            for (Permission permission : permissions) {
                authorizationValidate(permission);
            }
        }
        return super.isPermitted(permissions, info);
    }

    @Override
    public boolean isPermitted(PrincipalCollection principals, Permission permission) {
        authorizationValidate(permission);
        return super.isPermitted(principals, permission);
    }

    @Override
    protected boolean isPermittedAll(Collection<Permission> permissions, AuthorizationInfo info) {
        if (permissions != null && !permissions.isEmpty()) {
            for (Permission permission : permissions) {
                authorizationValidate(permission);
            }
        }
        return super.isPermittedAll(permissions, info);
    }

    /**
     * 授权验证方法
     * @param permission
     */
    private void authorizationValidate(Permission permission){
        // 模块授权预留接口
    }

    private ToggleCredentialsMatcher matcher = null;

    /**
     * 设定密码校验的Hash算法与迭代次数
     */
    @PostConstruct
    public void initCredentialsMatcher() {
//        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(SystemService.HASH_ALGORITHM);
//        matcher.setHashIterations(SystemService.HASH_INTERATIONS);
        this.matcher = new ToggleCredentialsMatcher();
        setCredentialsMatcher(this.matcher);
    }

//    @Override
//    public CredentialsMatcher getCredentialsMatcher() {
//        return super.getCredentialsMatcher();
//    }

    //	/**
//	 * 清空用户关联权限认证，待下次使用时重新加载
//	 */
//	public void clearCachedAuthorizationInfo(Principal principal) {
//		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
//		clearCachedAuthorizationInfo(principals);
//	}

    /**
     * 清空所有关联认证
     * @Deprecated 不需要清空，授权缓存保存到session中
     */
    @Deprecated
    public void clearAllCachedAuthorizationInfo() {
//		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
//		if (cache != null) {
//			for (Object key : cache.keys()) {
//				cache.remove(key);
//			}
//		}
    }
}
