package com.cnwanweb.quickframework.modules.sys.security;

import com.cnwanweb.quickframework.modules.sys.entity.User;
import org.apache.shiro.authc.AuthenticationToken;

public class SimpleAuthToken implements AuthenticationToken {
    private String username;
    private String password;

    public SimpleAuthToken() {
    }

    public SimpleAuthToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SimpleAuthToken(User user) {
        this.username = user.getLoginName();
        this.password = user.getPassword();
    }

    public Object getPrincipal() {
        return this.username;
    }

    public Object getCredentials() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
