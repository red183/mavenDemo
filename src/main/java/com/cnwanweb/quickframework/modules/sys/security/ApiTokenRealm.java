/**
 * Copyright &copy; 2012-2014 <a href="#">b2b</a> All rights reserved.
 */
package com.cnwanweb.quickframework.modules.sys.security;

import com.cnwanweb.quickframework.common.utils.Encodes;
import com.cnwanweb.quickframework.modules.sys.entity.User;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 系统安全认证实现类
 * @author cnwanweb
 * @version 2014-7-5
 */
@Service
public class ApiTokenRealm extends BaseQsRealm {

    private static final Logger logger = LoggerFactory.getLogger(ApiTokenRealm.class);

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof org.apache.shiro.authc.UsernamePasswordToken ||
                token instanceof SimpleAuthToken;
    }

    /**
     * 认证回调函数, 登录时调用
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {
        if(authcToken instanceof SimpleAuthToken) {
            SimpleAuthToken wxWareToken = (SimpleAuthToken) authcToken;
            User dbUser = getSystemService().getUserByLoginName(wxWareToken.getUsername());
            return new SimpleAuthenticationInfo(
                    new SimplePrincipalCollection(new SystemAuthorizingPrincipal(dbUser, true), getName()),
                    dbUser.getPassword());
        } else {
            org.apache.shiro.authc.UsernamePasswordToken usernamePasswordToken =
                    (org.apache.shiro.authc.UsernamePasswordToken) authcToken;

            User dbUser = getSystemService().getUserByLoginName(usernamePasswordToken.getUsername());
            byte[] salt = Encodes.decodeHex(dbUser.getPassword().substring(0,16));
            return new SimpleAuthenticationInfo(new SystemAuthorizingPrincipal(dbUser, true),
                    dbUser.getPassword().substring(16), ByteSource.Util.bytes(salt), getName());
        }
    }

}
