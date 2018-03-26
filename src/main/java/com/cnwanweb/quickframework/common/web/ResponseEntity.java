package com.cnwanweb.quickframework.common.web;

import com.cnwanweb.quickframework.common.utils.DateUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import org.codehaus.jackson.annotate.JsonIgnore;

public class ResponseEntity {
    public String message;
    public Object head;
    public String tag;
    public Object result;

    public ResponseEntity() {
        this.tag = "SUCCESS";
        this.message = "请求成功";
    }

    public ResponseEntity(String tag, String message) {
        this.tag = tag;
        this.message = message;
    }

    public ResponseEntity(String message) {
        this.tag = "SUCCESS";
        this.message = message;
    }

    public ResponseEntity(String tag, String message, Object result) {
        this.tag = tag;
        this.message = message;
        this.result = result;
    }

    public Object getHead() {
        return this.head;
    }

    public void setHead(Object head) {
        this.head = head;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Object getResult() {
        return this.result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    private String render(HttpServletResponse response, String jsonData) {
        try {
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.print(jsonData);
            printWriter.flush();
            printWriter.close();
            return null;
        } catch (IOException var4) {
            return null;
        }
    }

    public String render(HttpServletResponse response, JsonConfig config) {
        String jsonData = this.toJsonString(config);
        return this.render(response, jsonData);
    }

    public String render(HttpServletResponse response) {
        String jsonData = this.toJsonString();
        return this.render(response, jsonData);
    }

    public String render(HttpServletResponse response, boolean initConfig) {
        String jsonData = this.toJsonString(initConfig);
        return this.render(response, jsonData);
    }

    public String toJsonString() {
        return JSONObject.fromObject(this).toString();
    }

    public String toJsonString(boolean initConfig) {
        if(initConfig) {
            JsonConfig config = new JsonConfig();
            config.addIgnoreFieldAnnotation(JsonIgnore.class);
            config.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
                public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
                    return value == null?null:DateUtils.formatDateTime((Date)value);
                }

                public Object processArrayValue(Object value, JsonConfig jsonConfig) {
                    return null;
                }
            });
            config.registerJsonValueProcessor(Timestamp.class, new JsonValueProcessor() {
                public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
                    if(value == null) {
                        return null;
                    } else {
                        Timestamp t = (Timestamp)value;
                        return DateUtils.formatDateTime(new Date(t.getTime()));
                    }
                }

                public Object processArrayValue(Object value, JsonConfig jsonConfig) {
                    return null;
                }
            });
            return this.toJsonString(config);
        } else {
            return this.toJsonString();
        }
    }

    public String toJsonString(JsonConfig config) {
        return JSONObject.fromObject(this, config).toString();
    }
}
