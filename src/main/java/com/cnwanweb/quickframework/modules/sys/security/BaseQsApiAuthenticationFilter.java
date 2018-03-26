package com.cnwanweb.quickframework.modules.sys.security;

import com.cnwanweb.quickframework.common.config.Global;
import com.cnwanweb.quickframework.common.utils.SpringContextHolder;
import com.cnwanweb.quickframework.common.web.ResponseEntity;
import com.cnwanweb.quickframework.modules.sys.entity.User;
import com.cnwanweb.quickframework.modules.sys.service.SystemService;
import com.cnwanweb.quickframework.modules.sys.service.UserDeviceService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证过滤类
 * @author cnwanweb
 * @version 2017-10-10
 */
public abstract class BaseQsApiAuthenticationFilter extends AccessControlFilter {

    private static final Logger logger = LoggerFactory.getLogger(BaseQsApiAuthenticationFilter.class);
    private SystemService systemService;
    private UserDeviceService userDeviceService;

    public SystemService getSystemService() {
        if (systemService == null){
            systemService = SpringContextHolder.getBean(SystemService.class);
        }
        return systemService;
    }

    public UserDeviceService getUserDeviceService() {
        if (userDeviceService == null){
            userDeviceService = SpringContextHolder.getBean(UserDeviceService.class);
        }
        return userDeviceService;
    }

    protected boolean isAccessAllowed(
            ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return false;
    }

    protected boolean tryLogin(ServletRequest request, ServletResponse response,
                               AuthenticationToken authToken) throws IOException {
        try {
            getSubject(request, response).login(authToken);
        } catch(IncorrectCredentialsException e) {
            ResponseEntity responseEntity = new ResponseEntity();
            responseEntity.setTag("ACCOUNT_CREDENTIAL_ERROR");
            responseEntity.setMessage("账号密码错误");
//			responseEntity.setHead(e.getMessage());
            return renderSuccess(response, responseEntity);
        } catch(UnknownAccountException e) {
            ResponseEntity responseEntity = new ResponseEntity();
            responseEntity.setTag("ACCOUNT_UNKNOWN_ERROR");
            responseEntity.setMessage("账号未能识别");
//			responseEntity.setHead(e.getMessage());
            return renderSuccess(response, responseEntity);
        } catch(AuthenticationException e) {
            ResponseEntity responseEntity = new ResponseEntity();
            responseEntity.setTag("ACCOUNT_AUTH_ERROR");
            responseEntity.setMessage("身份验证失败");
//			responseEntity.setHead(e.getMessage());
            return renderSuccess(response, responseEntity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            ResponseEntity responseEntity = new ResponseEntity();
            responseEntity.setTag("SYSTEM_UNKNOWN_ERROR");
            responseEntity.setMessage("业务繁忙或网络错误");
//			responseEntity.setHead(e.getMessage());
            return renderSuccess(response, responseEntity);
        }
        return true;
    }

    protected boolean checkDbUser(User dbUser, ServletResponse response) throws IOException {
        if(dbUser == null) {
            ResponseEntity responseEntity = new ResponseEntity();
            responseEntity.setTag("ACCOUNT_IS_NOT_EXIST");
            responseEntity.setMessage("用户不存在！");
            return renderSuccess(response, responseEntity);
        }
        if(Global.NO.equals(dbUser.getLoginFlag())) {
            ResponseEntity responseEntity = new ResponseEntity();
            responseEntity.setTag("ACCOUNT_IS_DISABLED");
            responseEntity.setMessage("用户已经禁用！");
            return renderSuccess(response, responseEntity);
        }
        return true;
    }

//	//登录失败时默认返回 401 状态码
//	protected boolean renderFailed(ServletResponse response, ResponseEntity responseEntity) throws IOException {
//		HttpServletResponse httpResponse = (HttpServletResponse) response;
//		httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//		responseEntity.render(httpResponse);
//		logger.debug("responseEntity: {}", responseEntity.toJsonString());
//		return false;
//	}

    protected boolean renderSuccess(ServletResponse response, ResponseEntity responseEntity) throws IOException {
        render(response, responseEntity, HttpServletResponse.SC_OK);
        return false;

    }

    protected void render(ServletResponse response, ResponseEntity responseEntity, int sc) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(sc);
        responseEntity.render(httpResponse);
        logger.debug("responseEntity: {}", responseEntity.toJsonString());
    }

    protected void render(ServletResponse response, ResponseEntity responseEntity) throws IOException {
        render(response, responseEntity, HttpServletResponse.SC_OK);
    }
}