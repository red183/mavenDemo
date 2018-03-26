package com.cnwanweb.quickframework.modules.sys.security;

import com.cnwanweb.quickframework.common.utils.SpringContextHolder;
import com.cnwanweb.quickframework.common.utils.StringUtils;
import com.cnwanweb.quickframework.common.web.ResponseEntity;
import com.cnwanweb.quickframework.modules.sys.entity.User;
import com.cnwanweb.quickframework.modules.sys.service.SystemService;
import com.cnwanweb.quickframework.modules.sys.utils.DictUtils;
import com.cnwanweb.quickframework.modules.sys.utils.UserUtils;
import com.google.common.collect.Maps;
import net.sf.json.JSONObject;
import org.apache.shiro.authc.AuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 表单验证（包含验证码）过滤类
 * @author cnwanweb
 * @version 2014-5-19
 */
@Service
public class WxWareAuthenticationFilter extends BaseQsApiAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(WxWareAuthenticationFilter.class);

    /** 获取登录凭证 */
    private static final String GET_AUTHORIZE_CODE_PATH = "/wx/ware/authorize";
    private static final String GET_AUTHORIZE_CHECK_PATH = "/wx/ware/check";
    private static final String GET_AUTHORIZE_LOGIN_PATH = "/wx/ware/login";
    private static final String BASE_PATH = "/wx/ware";
//	private static final String LOGOUT_PATH = "";

    protected boolean onAccessAuthorized(
            ServletRequest request, ServletResponse response,
            String ctx, String uri, HttpServletRequest req) throws Exception {
        //获取登录凭证进而换取用户登录态信息
        String code = req.getParameter("code");
        if (StringUtils.isBlank(code)) {
            ResponseEntity responseEntity = new ResponseEntity();
            responseEntity.setTag("WX_WARE_AUTHORIZE_CODE_EMPTY");
            responseEntity.setMessage("缺少 code 值");
            return renderSuccess(response, responseEntity);
        }
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> uriVariables = Maps.newHashMap();
        uriVariables.put("appid", getWxWareAppId());
        uriVariables.put("secret", getWxWareSecret());
//			uriVariables.put("js_code", code);
        uriVariables.put("code", code);
        uriVariables.put("grant_type", "authorization_code");
        //restTemplate.getForEntity("https://api.weixin.qq.com/sns/jscode2session",
        String codeUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid={appid}&secret={secret}&code={code}&grant_type={grant_type}";
        org.springframework.http.ResponseEntity<String> resultEntity =
                restTemplate.getForEntity(codeUrl, String.class, uriVariables);
        HttpStatus httpStatus = resultEntity.getStatusCode();
        if(!httpStatus.toString().equals("200")) {
            ResponseEntity responseEntity = new ResponseEntity();
            responseEntity.setTag("WX_WARE_GET_ACCESS_TOKEN_BUSY");
            responseEntity.setMessage("业务繁忙或网络错误");
            return renderSuccess(response, responseEntity);
        }
        String result = resultEntity.getBody();
        JSONObject jsonObject = JSONObject.fromObject(result);
        logger.debug("{}", jsonObject.toString());
        if(jsonObject.has("errcode") || jsonObject.has("errmsg")) {
            ResponseEntity responseEntity = new ResponseEntity();
            responseEntity.setMessage(jsonObject.getString("errmsg"));
            responseEntity.setTag(jsonObject.getString("errcode"));
            return renderSuccess(response, responseEntity);
        } else if(jsonObject.has("openid") && jsonObject.has("access_token")) {
            // && jsonObject.has("session_key")
            String openid = jsonObject.getString("openid");
            String refresh_token = jsonObject.getString("refresh_token");
            String scope = jsonObject.getString("scope");
            String expires_in = jsonObject.getString("expires_in");
//				String session_key = jsonObject.getString("session_key");
            String access_token = jsonObject.getString("access_token");
//				String unionid = null;
//				if(jsonObject.has("unionid")) {
//					unionid = jsonObject.getString("unionid");
//				}
            ResponseEntity responseEntity = new ResponseEntity();
            Map<String,Object> resultMap = new HashMap<String,Object>();
            resultMap.put("access_token", access_token);
            resultMap.put("refresh_token", refresh_token);
            resultMap.put("openid", openid);
            resultMap.put("scope", scope);
            resultMap.put("expires_in", expires_in);
//				resultMap.put("session_key", session_key);//官方声明不应该传输到客户端
//				resultMap.put("unionid", unionid);
            //TODO 存储到数据库或缓存中
//				final String thirdSessionId = RandomStringUtils.random(168);
//				putObjectInCache(thirdSessionId, resultMap);
            TokenUtils.put(access_token, resultMap);
            responseEntity.setResult(access_token);
            User dbUser = getSystemService().getByWxWareOpenId(openid);
            if(dbUser != null) {
                if(!checkDbUser(dbUser, response)) {
                    return false;
                }
                AuthenticationToken authToken = new SimpleAuthToken(dbUser);
                boolean loginResult = tryLogin(request, response, authToken);
                if(loginResult) {
                    //该TAG用来标识小程序该TOKEN已经识别出 user 和 openid 的关联，不用登录界面！
                    responseEntity.setTag("SUCCESS_LOGIN");
                    return renderSuccess(response, responseEntity);
                }
//					else {
//						//TODO 该失败好像不影响重新登录！因为本接口只是用来声明获取token
//						return renderSuccess(response, responseEntity);
//					}
            }
            return renderSuccess(response, responseEntity);
        } else {
            ResponseEntity responseEntity = new ResponseEntity();
            responseEntity.setMessage("接口无法识别");
            responseEntity.setTag("WX_WARE_GET_ACCESS_TOKEN_UNKNOWN");
            return renderSuccess(response, responseEntity);
        }
    }

    protected boolean onAccessDenied(
            ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        String ctx = req.getContextPath();
        String uri = req.getRequestURI();
        logger.debug("接口处理: {}", uri);

        if(!uri.startsWith(ctx + BASE_PATH)) {
            return false;
        }

        if(uri.startsWith(ctx + GET_AUTHORIZE_CODE_PATH)) {
            return onAccessAuthorized(request, response, ctx, uri, req);
        } else {
            //			String thirdSessionId = req.getParameter("thirdSessionId");
            String access_token = req.getParameter("access_token");
            if (StringUtils.isBlank(access_token)) {
                ResponseEntity responseEntity = new ResponseEntity();
                responseEntity.setTag("WX_WARE_AUTHORIZE_ACCESS_TOKEN_EMPTY");
                responseEntity.setMessage("缺少令牌");
                return renderSuccess(response, responseEntity);
            }

            Map<String, Object> cacheMap = TokenUtils.getMap(access_token);
            if (cacheMap == null) {
                ResponseEntity responseEntity = new ResponseEntity();
                responseEntity.setTag("WX_WARE_AUTHORIZE_ACCESS_TOKEN_EXPIRED");
                responseEntity.setMessage("令牌已过期");
                return renderSuccess(response, responseEntity);
            }

            String username = null;
            AuthenticationToken authToken = null;
            boolean isLoginPath = uri.startsWith(ctx + GET_AUTHORIZE_LOGIN_PATH);
            if(isLoginPath) {
                username = req.getParameter("username");
                String password = req.getParameter("password");
                if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
                    ResponseEntity responseEntity = new ResponseEntity();
                    responseEntity.setTag("WX_WARE_LOGIN_PARAM_EMPTY");
                    responseEntity.setMessage("缺少参数");
                    return renderSuccess(response, responseEntity);
                }

                //MD5值强制转SHA1
                SystemService systemService = SpringContextHolder.getBean(SystemService.class);
                systemService.migratePasswordMd5ToLocal(username, password);

                authToken = new org.apache.shiro.authc.UsernamePasswordToken(username, password);
            } else {
                //TODO 需要编写过期时间判断
                String openid = TokenUtils.getString(cacheMap, "openid");
                User dbUser = getSystemService().getByWxWareOpenId(openid);
                if(dbUser == null) {
                    return renderUserUnbound(response);
                }
                if(!checkDbUser(dbUser, response)) {
                    return false;
                }
                username = dbUser.getLoginName();
                authToken = new SimpleAuthToken(dbUser);
            }
            boolean result = tryLogin(request, response, authToken);
            User dbUser = UserUtils.getByLoginName(username);
            String openid = TokenUtils.getString(cacheMap, "openid");
            if(isLoginPath) {
                boolean toBindOpenId = false;
                if(StringUtils.isBlank(dbUser.getOpenId())) {
                    toBindOpenId = true;
                } else {
                    if(StringUtils.equals(openid, dbUser.getOpenId())) {
                        toBindOpenId = true;
                    } else {
                        return renderUserBound(response);
                    }
                }
                if(toBindOpenId) {
                    User user = new User();
                    user.setOpenId(openid);
                    user.setLoginName(username);
                    getSystemService().updateOpenId(user);
                }
            } else {
                if(StringUtils.isBlank(dbUser.getOpenId())) {
                    return renderUserUnbound(response);
                } else {
                    if(!StringUtils.equals(openid, dbUser.getOpenId())) {
                        return renderUserBound(response);
                    }
                }

                if(uri.startsWith(ctx + GET_AUTHORIZE_CHECK_PATH)) {
                    ResponseEntity responseEntity = new ResponseEntity();
                    return renderSuccess(response, responseEntity);
                }
            }
            return result;
        }
//		ResponseEntity responseEntity = new ResponseEntity();
//		responseEntity.setMessage("接口未能识别的处理");
//		responseEntity.setTag("WX_WARE_RESOLVE_END");
//		return renderSuccess(response, responseEntity);
    }

//	private boolean renderUserUnlogin(ServletResponse response) throws IOException {
//		ResponseEntity responseEntity = new ResponseEntity();
//		responseEntity.setTag("WX_WARE_USER_UNLOGIN");
//		responseEntity.setMessage("用户未登录");
//		return renderSuccess(response, responseEntity);
//	}

    private boolean renderUserUnbound(ServletResponse response) throws IOException {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setTag("WX_WARE_USER_UNBOUND");
        responseEntity.setMessage("用户未绑定");
        return renderSuccess(response, responseEntity);
    }

    private boolean renderUserBound(ServletResponse response) throws IOException {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setTag("WX_WARE_USER_BOUND");
        responseEntity.setMessage("用户已绑定");
        return renderSuccess(response, responseEntity);
    }

    public String getWxWareAppId() {
//		return wxWareAppId;
        return DictUtils.getValueByUnionType("wx_ware_appid");
    }

    public String getWxWareSecret() {
//		return wxWareSecret;
        return DictUtils.getValueByUnionType("wx_ware_secret");
    }
}