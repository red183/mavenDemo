package com.cnwanweb.quickframework.modules.sys.security;

import com.cnwanweb.quickframework.common.security.shiro.Principal;
import com.cnwanweb.quickframework.modules.sys.entity.User;
import com.cnwanweb.quickframework.modules.sys.utils.UserUtils;

public class SystemAuthorizingPrincipal implements Principal {
    private static final long serialVersionUID = 1L;
    private String id;
    private String loginName;
    private String name;
    private boolean mobileLogin;

    public SystemAuthorizingPrincipal(User user, boolean mobileLogin) {
        this.id = user.getId();
        this.loginName = user.getLoginName();
        this.name = user.getName();
        this.mobileLogin = mobileLogin;
    }

    public String getId() {
        return this.id;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public String getName() {
        return this.name;
    }

    public boolean isMobileLogin() {
        return this.mobileLogin;
    }

    public String getSessionId() {
        try {
            return (String)UserUtils.getSession().getId();
        } catch (Exception var2) {
            return "";
        }
    }

    public String toString() {
        return this.id;
    }
}
