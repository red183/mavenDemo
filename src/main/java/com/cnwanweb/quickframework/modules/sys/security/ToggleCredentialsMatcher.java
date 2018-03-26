package com.cnwanweb.quickframework.modules.sys.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToggleCredentialsMatcher implements CredentialsMatcher {
    private static final Logger logger = LoggerFactory.getLogger(ToggleCredentialsMatcher.class);
    private HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher("SHA-1");
    private SimpleCredentialsMatcher simpleCredentialsMatcher;

    public ToggleCredentialsMatcher() {
        this.hashedCredentialsMatcher.setHashIterations(1024);
        this.simpleCredentialsMatcher = new SimpleCredentialsMatcher();
    }

    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        if(token instanceof UsernamePasswordToken) {
            return this.hashedCredentialsMatcher.doCredentialsMatch(token, info);
        } else if(token instanceof SimpleAuthToken) {
            return this.simpleCredentialsMatcher.doCredentialsMatch(token, info);
        } else {
            logger.warn("[false] token class type: {}", token.getClass().getName());
            return false;
        }
    }
}
