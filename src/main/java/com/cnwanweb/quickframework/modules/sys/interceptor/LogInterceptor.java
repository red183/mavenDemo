
package com.cnwanweb.quickframework.modules.sys.interceptor;

import com.cnwanweb.quickframework.common.service.BaseService;
import com.cnwanweb.quickframework.modules.sys.utils.LogUtils;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 日志拦截器
 * @author cnwanweb
 * @version 2014-8-19
 */
public class LogInterceptor extends BaseService implements HandlerInterceptor {

    private static final ThreadLocal<Long> startTimeThreadLocal =
            new NamedThreadLocal<Long>("ThreadLocal StartTime");

//	protected boolean afterIsAppLogin(HttpServletRequest request, HttpServletResponse response, UserDevice userDevice) {
//		return true;
//	}

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
//		String ctx = request.getContextPath();
//		String uri = request.getRequestURI();
//		if(uri.startsWith(ctx + "/api")) {
//			logger.debug("uri: {}", uri);
//			UserDevice userDevice = UserUtils.convertToUserDevice(request);
//			if(UserUtils.isAppLogin(userDevice)) {
////				Principal principal = UserUtils.getPrincipal();
//				boolean unlogin = false;
//				if(userDevice.getProtocol().equals(Global.API_SECURITY_1)) {
//					if(UserUtils.getUser() == null) {
//						unlogin = true;
//					}
//				} else if(userDevice.getProtocol().equals(Global.API_SECURITY_2)) {
//					User user = userDevice.getUser();
//					if(user == null && !(uri.startsWith(ctx + "/api/sys/token"))) {
//						unlogin = true;
//					}
//				}
//				if(unlogin) {
//					ResponseEntity responseEntity = new ResponseEntity();
//					responseEntity.setMessage("用户未登录");
//					responseEntity.setTag("11001");
////					responseEntity.setTag("USER_UNLOGIN");
//					responseEntity.render(response);
//					return false;
//				}
//				boolean afterBusyLogin = afterIsAppLogin(request, response, userDevice);
//				if(!afterBusyLogin) return false;
//			} else {
//				ResponseEntity responseEntity = new ResponseEntity();
//				responseEntity.setMessage("API请求信息不规范");
////				responseEntity.setTag("API_REQUEST_ERROR");
//				responseEntity.setTag("10001");
//				responseEntity.render(response);
//				return false;
//			}
//		}
//		if (logger.isDebugEnabled()){
//			long beginTime = System.currentTimeMillis();//1、开始时间
//	        startTimeThreadLocal.set(beginTime);		//线程绑定变量（该数据只有当前请求的线程可见）
//	        logger.debug("开始计时: {}  URI: {}", new SimpleDateFormat("hh:mm:ss.SSS")
//	        	.format(beginTime), request.getRequestURI());
//		}
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if (modelAndView != null){
            logger.info("ViewName: " + modelAndView.getViewName());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

//		// 保存日志
        LogUtils.saveLog(request, handler, ex, null);

//		// 打印JVM信息。
//		if (logger.isDebugEnabled()){
//			long beginTime = startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）
//			long endTime = System.currentTimeMillis(); 	//2、结束时间
//	        logger.debug("计时结束：{}  耗时：{}  URI: {}  最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
//	        		new SimpleDateFormat("hh:mm:ss.SSS").format(endTime), DateUtils.formatDateTime(endTime - beginTime),
//					request.getRequestURI(), Runtime.getRuntime().maxMemory()/1024/1024, Runtime.getRuntime().totalMemory()/1024/1024, Runtime.getRuntime().freeMemory()/1024/1024,
//					(Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024);
//		}

    }

}
