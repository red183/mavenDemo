package com.cnwanweb.quickframework.modules.sys.security;

import com.cnwanweb.quickframework.common.utils.Encodes;
import com.cnwanweb.quickframework.modules.sys.entity.User;
import com.cnwanweb.quickframework.modules.sys.utils.UserUtils;
import com.cnwanweb.quickframework.modules.sys.web.LoginController;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.session.Session;
import org.apache.shiro.util.ByteSource.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SystemAuthorizingRealm extends BaseQsRealm {
    private static final Logger logger = LoggerFactory.getLogger(SystemAuthorizingRealm.class);

    public SystemAuthorizingRealm() {
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {
        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
        int activeSessionSize = getSystemService().getSessionDao().getActiveSessions(false).size();
        if(logger.isDebugEnabled()) {
            logger.debug("login submit, active session size: {}, username: {}", Integer.valueOf(activeSessionSize), token.getUsername());
        }

        boolean ingoreCheckCode = token.getCaptcha() != null && token.getCaptcha().equals("IS_APP_LOGIN");
        if(!ingoreCheckCode && LoginController.isValidateCodeLogin(token.getUsername(), false, false)) {
            Session session = UserUtils.getSession();
            String code = (String)session.getAttribute("validateCode");
            if(token.getCaptcha() == null || !token.getCaptcha().toUpperCase().equals(code)) {
                throw new AuthenticationException("msg:验证码错误, 请重试.");
            }
        }

        User user = getSystemService().getUserByLoginName(token.getUsername());
        if(user != null) {
            if("0".equals(user.getLoginFlag())) {
                throw new AuthenticationException("msg:该已帐号禁止登录.");
            } else {
                byte[] salt = Encodes.decodeHex(user.getPassword().substring(0, 16));
                return new SimpleAuthenticationInfo(new SystemAuthorizingPrincipal(user, token.isMobileLogin()), user.getPassword().substring(16), Util.bytes(salt), this.getName());
            }
        } else {
            return null;
        }
    }
}
