package com.cnwanweb.quickframework.common.web;

import com.cnwanweb.quickframework.common.security.shiro.Principal;
import com.cnwanweb.quickframework.modules.sys.utils.LogUtils;
import com.cnwanweb.quickframework.modules.sys.utils.UserUtils;
import org.apache.ibatis.exceptions.IbatisException;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.shiro.authz.UnauthorizedException;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by firecnwanweb on 2017/2/15.
 */
public class FireMappingExceptionResolver extends SimpleMappingExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response,
                                              Object handler, Exception ex) {
        Principal p = UserUtils.getPrincipal();
        String ctx = request.getContextPath();
        String uri = request.getRequestURI();
        if(uri.startsWith(ctx + "/api")) {
            ResponseEntity entity = new ResponseEntity();
            entity.setTag("SYSTEM_UNKNOWN_ERROR");
            entity.setMessage("系统执行异常");
            LogUtils.saveLog(request, handler, ex, null);
            if(ex instanceof RuntimeException) {
                if(ex instanceof UnauthorizedException) {
                    entity.setMessage("用户未被授权使用该资源");
                    entity.setTag("UN_AUTHORIZED_ERROR");
                    entity.render(response);
                    return null;
                } else if(ex instanceof IbatisException || ex instanceof MyBatisSystemException) {
                    if(ex instanceof TooManyResultsException) {
                        entity.setMessage("业务逻辑异常");
                        entity.setTag("TOO_MANY_RESULT_ERROR");
                        entity.render(response);
                        return null;
                    } else {
                        entity.setMessage("数据异常");
                        entity.setTag("DATA_ERROR");
                        entity.render(response);
                        return null;
                    }
                } else if (ex instanceof NullPointerException){
                    entity.setMessage("找不到引用的数据");
                    entity.setTag("OBJECT_IS_NULL");
                } else {
                    entity.setMessage(ex.getMessage());
                }
            }
            entity.render(response);
            return null;
        } else {
            return super.doResolveException(request,response,handler,ex);
        }
    }
}
