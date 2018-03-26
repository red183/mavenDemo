package com.cnwanweb.quickframework.modules.sys.web;

import com.cnwanweb.quickframework.common.config.Global;
import com.cnwanweb.quickframework.common.security.shiro.Principal;
import com.cnwanweb.quickframework.common.security.shiro.session.SessionDAO;
import com.cnwanweb.quickframework.common.utils.CacheUtils;
import com.cnwanweb.quickframework.common.utils.CookieUtils;
import com.cnwanweb.quickframework.common.utils.IdGen;
import com.cnwanweb.quickframework.common.utils.StringUtils;
import com.cnwanweb.quickframework.common.web.BaseController;
import com.cnwanweb.quickframework.common.web.ResponseEntity;
import com.cnwanweb.quickframework.modules.sys.entity.Role;
import com.cnwanweb.quickframework.modules.sys.entity.User;
import com.cnwanweb.quickframework.modules.sys.entity.UserDevice;
import com.cnwanweb.quickframework.modules.sys.service.UserDeviceService;
import com.cnwanweb.quickframework.modules.sys.utils.UserUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController extends BaseController {
    @Autowired
    private SessionDAO sessionDAO;
    @Autowired
    private UserDeviceService userDeviceServcie;

    public LoginController() {
    }

    @RequestMapping(
            value = {"${adminPath}/login"},
            method = {RequestMethod.GET}
    )
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        Principal principal = UserUtils.getPrincipal();
        if(this.logger.isDebugEnabled()) {
            this.logger.debug("login, active session size: {}", Integer.valueOf(this.sessionDAO.getActiveSessions(false).size()));
        }

        if("true".equals(Global.getConfig("notAllowRefreshIndex"))) {
            CookieUtils.setCookie(response, "LOGINED", "false");
        }

        return principal != null && !UserUtils.isAppLogin(request)?"redirect:" + this.adminPath:"modules/sys/sysLogin";
    }

    @RequestMapping({"${adminPath}/logout"})
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
        boolean isAppLogin = UserUtils.isAppLogin(request);
        UserUtils.getSubject().logout();
        if(isAppLogin) {
            ResponseEntity responseEntity = new ResponseEntity();
            return responseEntity.render(response);
        } else {
            return "modules/sys/sysLogin";
        }
    }

    @RequestMapping(
            value = {"${adminPath}/login"},
            method = {RequestMethod.POST}
    )
    public String loginFail(HttpServletRequest request, HttpServletResponse response, Model model) {
        Principal principal = UserUtils.getPrincipal();
        boolean isAppLogin = UserUtils.isAppLogin(request);
        if(principal != null) {
            if(isAppLogin) {
                ResponseEntity responseEntity = new ResponseEntity("LOGINED", "用户已登录");
                return responseEntity.render(response);
            } else {
                return "redirect:" + this.adminPath;
            }
        } else {
            String username = WebUtils.getCleanParam(request, "username");
            boolean rememberMe = WebUtils.isTrue(request, "rememberMe");
            boolean mobile = WebUtils.isTrue(request, "mobileLogin");
            String exception = (String)request.getAttribute("shiroLoginFailure");
            String message = (String)request.getAttribute("message");
            if(StringUtils.isBlank(message) || StringUtils.equals(message, "null")) {
                message = "用户或密码错误, 请重试.";
            }

            model.addAttribute("username", username);
            model.addAttribute("rememberMe", Boolean.valueOf(rememberMe));
            model.addAttribute("mobileLogin", Boolean.valueOf(mobile));
            model.addAttribute("shiroLoginFailure", exception);
            model.addAttribute("message", message);
            if(this.logger.isDebugEnabled()) {
                this.logger.debug("login fail, active session size: {}, message: {}, exception: {}", new Object[]{Integer.valueOf(this.sessionDAO.getActiveSessions(false).size()), message, exception});
            }

            if(!isAppLogin && !UnauthorizedException.class.getName().equals(exception)) {
                model.addAttribute("isValidateCodeLogin", Boolean.valueOf(isValidateCodeLogin(username, true, false)));
            }

            if(!isAppLogin) {
                request.getSession().setAttribute("validateCode", IdGen.uuid());
            }

            if(isAppLogin) {
                ResponseEntity responseEntity = new ResponseEntity("LOGIN_FAILED", message);
                return responseEntity.render(response);
            } else {
                return "modules/sys/sysLogin";
            }
        }
    }

    @RequiresPermissions({"user"})
    @RequestMapping({"${adminPath}"})
    public String index(HttpServletRequest request, HttpServletResponse response) {
        Principal principal = UserUtils.getPrincipal();
        isValidateCodeLogin(principal.getLoginName(), false, true);
        if(this.logger.isDebugEnabled()) {
            this.logger.debug("show index, active session size: {}", Integer.valueOf(this.sessionDAO.getActiveSessions(false).size()));
        }

        if("true".equals(Global.getConfig("notAllowRefreshIndex"))) {
            String logined = CookieUtils.getCookie(request, "LOGINED");
            if(!StringUtils.isBlank(logined) && !"false".equals(logined)) {
                if(StringUtils.equals(logined, "true")) {
                    UserUtils.getSubject().logout();
                    return "redirect:" + this.adminPath + "/login";
                }
            } else {
                CookieUtils.setCookie(response, "LOGINED", "true");
            }
        }

        UserDevice userDevice = UserUtils.convertToUserDevice(request);
        if(UserUtils.isAppLogin(userDevice) && UserUtils.isApiSecurity1(userDevice)) {
            if(request.getParameter("login") == null) {
                return request.getParameter("index") != null?"modules/sys/sysIndex":"redirect:" + this.adminPath + "/login";
            } else {
                UserDevice searchEntity = new UserDevice();
                searchEntity.setUser(UserUtils.getUser());
                this.logger.debug("deviceId: {}", userDevice.getDeviceId());
                searchEntity.setDeviceId(userDevice.getDeviceId());
                List<UserDevice> userDeviceList = this.userDeviceServcie.findList(searchEntity);
                if(userDeviceList != null && userDeviceList.size() != 0) {
                    UserDevice po = (UserDevice)userDeviceList.get(0);
                    po.setProtocol(userDevice.getProtocol());
                    po.setDeviceName(userDevice.getDeviceName());
                    po.setSoftVersion(userDevice.getSoftVersion());
                    po.setDeviceBrand(userDevice.getDeviceBrand());
                    po.setOsName(userDevice.getOsName());
                    po.setOsVersion(userDevice.getOsVersion());
                    this.userDeviceServcie.save(po);
                } else {
                    userDevice.setUser(UserUtils.getUser());
                    this.userDeviceServcie.save(userDevice);
                }

                Map<String, Object> resultMap = Maps.newHashMap();
                User user = UserUtils.getUser();
                if(StringUtils.isNotBlank(user.getPhoto())) {
                    int baseIndex = user.getPhoto().indexOf("/userfiles/");
                    resultMap.put("photo", user.getPhoto().substring(baseIndex));
                }

                List<Role> roles = user.getRoleList();
                List<String> roleCodes = Lists.newArrayList();
                Iterator var11 = roles.iterator();

                while(var11.hasNext()) {
                    Role role = (Role)var11.next();
                    roleCodes.add(role.getEnname());
                }

                resultMap.put("role_codes", roleCodes);
                resultMap.put("email", user.getEmail());
                resultMap.put("mobile", user.getMobile());
                resultMap.put("account", user.getLoginName());
                resultMap.put("name", user.getName());
                resultMap.put("no", user.getNo());
                ResponseEntity responseEntity = new ResponseEntity();
                responseEntity.setResult(resultMap);
                return responseEntity.render(response);
            }
        } else {
            return "modules/sys/sysIndex";
        }
    }

    @RequestMapping({"/theme/{theme}"})
    public String getThemeInCookie(@PathVariable String theme, HttpServletRequest request, HttpServletResponse response) {
        if(StringUtils.isNotBlank(theme)) {
            CookieUtils.setCookie(response, "theme", theme);
        } else {
            theme = CookieUtils.getCookie(request, "theme");
        }

        return "redirect:" + request.getParameter("url");
    }

    public static boolean isValidateCodeLogin(String username, boolean isFail, boolean clean) {
        Map<String, Integer> loginFailMap = (Map)CacheUtils.get("loginFailMap");
        if(loginFailMap == null) {
            loginFailMap = Maps.newHashMap();
            CacheUtils.put("loginFailMap", loginFailMap);
        }

        Integer loginFailNum = (Integer)((Map)loginFailMap).get(username);
        if(loginFailNum == null) {
            loginFailNum = Integer.valueOf(0);
        }

        if(isFail) {
            loginFailNum = Integer.valueOf(loginFailNum.intValue() + 1);
            ((Map)loginFailMap).put(username, loginFailNum);
        }

        if(clean) {
            ((Map)loginFailMap).remove(username);
        }

        return loginFailNum.intValue() >= 3;
    }
}
