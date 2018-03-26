package com.cnwanweb.quickframework.modules.sys.security;

import com.cnwanweb.quickframework.common.utils.SpringContextHolder;
import com.cnwanweb.quickframework.common.utils.StringUtils;
import com.cnwanweb.quickframework.common.web.ResponseEntity;
import com.cnwanweb.quickframework.common.web.Servlets;
import com.cnwanweb.quickframework.modules.sys.entity.User;
import com.cnwanweb.quickframework.modules.sys.entity.UserDevice;
import com.cnwanweb.quickframework.modules.sys.service.SystemService;
import com.cnwanweb.quickframework.modules.sys.utils.LogUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 表单验证（包含验证码）过滤类
 * @author cnwanweb
 * @version 2014-5-19
 */
@Service
public class ApiTokenAuthenticationFilter extends BaseQsApiAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(ApiTokenAuthenticationFilter.class);
    private static final String LOGIN_PATH = "/api/sys/token/login";
    private static final String LOGOUT_PATH = "/api/sys/token/logout";

    private void saveUserDeviceOnLogin(UserDevice userDevice, User user) {
        UserDevice target = null;
        try {
            UserDevice searchEntity = new UserDevice();
            searchEntity.setUser(user);
            logger.debug("deviceId: {}", userDevice.getDeviceId());
            searchEntity.setDeviceId(userDevice.getDeviceId());
            List<UserDevice> userDeviceList = getUserDeviceService().findList(searchEntity);
            Date now = new Date();
            String userDeviceId = null;
            if(userDeviceList == null || userDeviceList.size() == 0) {
                userDevice.setUser(user);
                userDevice.setCreateBy(user);
                userDevice.setCreateDate(now);
                userDevice.setUpdateBy(user);
                userDevice.setUpdateDate(now);
                getUserDeviceService().save(userDevice);
                userDeviceId = userDevice.getId();
                target = userDevice;
            } else {
                UserDevice po = userDeviceList.get(0);
                po.setUser(user);
                po.setUpdateBy(user);
                po.setUpdateDate(now);
                po.setProtocol(userDevice.getProtocol());
                po.setDeviceName(userDevice.getDeviceName());
                po.setSoftVersion(userDevice.getSoftVersion());
                po.setDeviceBrand(userDevice.getDeviceBrand());
                po.setOsName(userDevice.getOsName());
                po.setOsVersion(userDevice.getOsVersion());
                getUserDeviceService().save(po);
                userDeviceId = po.getId();
                target = po;
            }
            String token = TokenUtils.getContextTokenVal();
            TokenUtils.putContextVal(token, userDeviceId);
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        }

        try {
            target.setCreateDate(target.getUpdateDate());
            TaskExecutor taskExecutor = SpringContextHolder.getBean("executor");
            taskExecutor.execute(new UserDeviceHistoryThread(target));
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        }
    }

    protected boolean onAccessDenied(
            ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        String ctx = req.getContextPath();
        String uri = req.getRequestURI();
//		logger.debug("default login url is ", getLoginUrl());
        String userAgentString = req.getHeader("CNWANWEB-SECURITY");
        if(StringUtils.isBlank(userAgentString)) {
            ResponseEntity responseEntity = new ResponseEntity();
            responseEntity.setMessage("缺少API请求头信息");
            responseEntity.setTag("API_REQUEST_HEAD_ABSENCE");
            return renderSuccess(response, responseEntity);
        }
        UserDevice userDevice = new UserDevice();
        ResponseEntity responseEntityByConvert = convertUserAgent(userAgentString, userDevice);
        if(responseEntityByConvert != null) {
            return renderSuccess(response, responseEntityByConvert);
        }

        if(uri.startsWith(ctx + LOGIN_PATH)) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
                ResponseEntity responseEntity = new ResponseEntity();
                responseEntity.setTag("ACCOUNT_PARAMS_IS_EMPTY");
                responseEntity.setMessage("用户名或密码不能为空！");
                return renderSuccess(response, responseEntity);
            }

            //MD5值强制转SHA1
            SystemService systemService = SpringContextHolder.getBean(SystemService.class);
            systemService.migratePasswordMd5ToLocal(username, password);

            User dbUser = getSystemService().getUserByLoginName(username);
            if(!checkDbUser(dbUser, response)) {
                return false;
            }
            AuthenticationToken authToken = new org.apache.shiro.authc.UsernamePasswordToken(
                    username, password);
            boolean loginResult = tryLogin(request, response, authToken);
            if(loginResult) {
//				String token = StringUtils.createShort(username + System.currentTimeMillis());
                String token = TokenUtils.createToken(128);
                TokenUtils.put(token, username);
                TokenUtils.putContextTokenVal(token);
                saveUserDeviceOnLogin(userDevice, dbUser);
                LogUtils.saveLog(Servlets.getRequest(), "API登录");
                return true;
            } else {
                return false;
            }
        } else if(uri.startsWith(ctx + LOGOUT_PATH)) {
            TokenUtils.remove(userDevice.getToken());
            LogUtils.saveLog(Servlets.getRequest(), "API注销");
        } else {
//			Object unObj = CacheUtils.get("tokenCache", "un:" + userDevice.getToken());
//			Object psObj = CacheUtils.get("tokenCache", "ps:" + userDevice.getToken());
//			if(unObj == null || psObj == null) {
//				ResponseEntity responseEntity = new ResponseEntity();
//				responseEntity.setMessage("令牌已失效");
//				responseEntity.setTag("API_TOKEN_IS_EXPIRED");
//				return renderSuccess(response, responseEntity);
//			}
//			String username = unObj.toString();
            String username = TokenUtils.getString(userDevice.getToken());
            if(StringUtils.isBlank(username)) {
                ResponseEntity responseEntity = new ResponseEntity();
                responseEntity.setMessage("令牌已失效");
                responseEntity.setTag("API_TOKEN_IS_EXPIRED");
                return renderSuccess(response, responseEntity);
            }
            User dbUser = getSystemService().getUserByLoginName(username);
            if(!checkDbUser(dbUser, response)) {
                return false;
            }
//			AuthenticationToken authToken = new org.apache.shiro.authc.UsernamePasswordToken(
//					username, psObj.toString());
            AuthenticationToken authToken = new SimpleAuthToken(dbUser);
            boolean loginResult = tryLogin(request, response, authToken);
            if(!loginResult) {
                return false;
            }
        }
        return true;
    }

    private ResponseEntity convertUserAgent(String userAgentString, UserDevice entity) {
        ResponseEntity responseEntity = new ResponseEntity();
        Pattern pattern = Pattern.compile("(.*):(.*):(.*)");
        Matcher matcher = pattern.matcher(userAgentString);
        if(matcher.find()) {
            String protocol = matcher.group(1);
            entity.setProtocol(protocol);
            int dataLength = Integer.parseInt(matcher.group(2));
            String clientInfo = matcher.group(3);
            if(clientInfo.length() != dataLength) {
                responseEntity.setMessage("API请求头信息大小有误");
                responseEntity.setTag("API_REQUEST_DATA_SIZE_ERROR");
                logger.warn("{}->{}", responseEntity.getTag(), userAgentString);
                return responseEntity;
            } else {
                String[] clientInfos = clientInfo.split(";");
                entity.setDeviceId(clientInfos[0]);
                entity.setDeviceName(clientInfos[1]);
                String[] osInfo = clientInfos[2].split(" ");
                entity.setOsName(osInfo[0]);
                entity.setOsVersion(osInfo[1]);
                entity.setDeviceBrand(clientInfos[3]);
                entity.setSoftVersion(clientInfos[4]);
                if(StringUtils.isBlank(entity.getDeviceId())
                        || StringUtils.isBlank(entity.getDeviceName())
                        || StringUtils.isBlank(entity.getOsName())
                        || StringUtils.isBlank(entity.getOsVersion())
                        || StringUtils.isBlank(entity.getDeviceBrand())
                        || StringUtils.isBlank(entity.getSoftVersion())) {
                    responseEntity.setMessage("API请求头信息元数据错误");
                    responseEntity.setTag("API_REQUEST_HEAD_META_ERROR");
                    return responseEntity;
                }

                //protocol.equals("cnwanweb/1.0") 不再支持！
                if(!protocol.equals("cnwanweb/2.0")) {
                    responseEntity.setMessage("API请求头信息不支持");
                    responseEntity.setTag("API_REQUEST_HEAD_NOT_SUPPORT");
                    logger.warn("{}->{}", responseEntity.getTag(), userAgentString);
                    return responseEntity;
                }

                entity.setToken(clientInfos[5]);
            }
        } else {
            responseEntity.setMessage("API请求头信息格式有误");
            responseEntity.setTag("API_REQUEST_DATA_FMT_ERROR");
            logger.warn("{}->{}", responseEntity.getTag(), userAgentString);
            return responseEntity;
        }
        return null;
    }
}