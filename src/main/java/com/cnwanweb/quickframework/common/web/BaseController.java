package com.cnwanweb.quickframework.common.web;

import com.cnwanweb.quickframework.common.beanvalidator.BeanValidators;
import com.cnwanweb.quickframework.common.mapper.JsonMapper;
import com.cnwanweb.quickframework.common.utils.DateUtils;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public abstract class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${adminPath}")
    protected String adminPath;
    @Value("${frontPath}")
    protected String frontPath;
    @Value("${urlSuffix}")
    protected String urlSuffix;
    @Autowired
    protected Validator validator;

    public BaseController() {
    }

    protected boolean beanValidator(Model model, Object object, Class... groups) {
        try {
            BeanValidators.validateWithException(this.validator, object, groups);
            return true;
        } catch (ConstraintViolationException var6) {
            List<String> list = BeanValidators.extractPropertyAndMessageAsList(var6, ": ");
            list.add(0, "数据验证失败：");
            this.addMessage(model, (String[])list.toArray(new String[0]));
            return false;
        }
    }

    protected boolean beanValidator(RedirectAttributes redirectAttributes, Object object, Class... groups) {
        try {
            BeanValidators.validateWithException(this.validator, object, groups);
            return true;
        } catch (ConstraintViolationException var6) {
            List<String> list = BeanValidators.extractPropertyAndMessageAsList(var6, ": ");
            list.add(0, "数据验证失败：");
            this.addMessage(redirectAttributes, (String[])list.toArray(new String[0]));
            return false;
        }
    }

    protected void beanValidator(Object object, Class... groups) {
        BeanValidators.validateWithException(this.validator, object, groups);
    }

    protected void addMessage(Model model, String... messages) {
        StringBuilder sb = new StringBuilder();
        String[] arr$ = messages;
        int len$ = messages.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String message = arr$[i$];
            sb.append(message).append(messages.length > 1?"<br/>":"");
        }

        model.addAttribute("message", sb.toString());
    }

    protected void addMessage(RedirectAttributes redirectAttributes, String... messages) {
        StringBuilder sb = new StringBuilder();
        String[] arr$ = messages;
        int len$ = messages.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String message = arr$[i$];
            sb.append(message).append(messages.length > 1?"<br/>":"");
        }

        redirectAttributes.addFlashAttribute("message", sb.toString());
    }

    protected String renderString(HttpServletResponse response, Object object) {
        return this.renderString(response, JsonMapper.toJsonString(object), "application/json");
    }

    protected String renderString(HttpServletResponse response, String string, String type) {
        try {
            response.reset();
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
            return null;
        } catch (IOException var5) {
            return null;
        }
    }

    @ExceptionHandler({BindException.class, ConstraintViolationException.class, ValidationException.class})
    public String bindException() {
        return "error/400";
    }

    @ExceptionHandler({AuthenticationException.class})
    public String authenticationException() {
        return "error/403";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            public void setAsText(String text) {
                this.setValue(text == null?null:StringEscapeUtils.escapeHtml4(text.trim()));
            }

            public String getAsText() {
                Object value = this.getValue();
                return value != null?value.toString():"";
            }
        });
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            public void setAsText(String text) {
                this.setValue(DateUtils.parseDate(text));
            }
        });
    }
}
