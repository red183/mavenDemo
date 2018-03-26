package com.cnwanweb.quickframework.modules.sys.security;

import com.cnwanweb.quickframework.common.utils.CacheUtils;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.RandomStringUtils;

public class TokenUtils {
    private static final String CACHE_NAME = "tokenCache";
    public static final String API_CTX_TOKEN_KEY = "API_CTX_TOKEN_KEY";
    private static ThreadLocal<Map<String, Object>> contextThreadLocal = new ThreadLocal();

    public TokenUtils() {
    }

    public static final String createToken(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    public static final void put(String key, Object value) {
        CacheUtils.put("tokenCache", key, value);
    }

    public static final Object get(String key) {
        return CacheUtils.get("tokenCache", key);
    }

    public static final void remove(String key) {
        CacheUtils.remove("tokenCache", key);
    }

    public static final String getString(String key) {
        Object obj = get(key);
        return obj == null?null:obj.toString();
    }

    public static final Integer getInteger(String key) {
        String value = getString(key);
        return value == null?null:Integer.valueOf(value);
    }

    public static final Map<String, Object> getMap(String key) {
        Object obj = get(key);
        return obj == null?null:(Map)obj;
    }

    public static final String getString(Map<String, Object> map, String key) {
        Object obj = map.get(key);
        return obj == null?null:obj.toString();
    }

    public static final Integer getInteger(Map<String, Object> map, String key) {
        String value = getString(map, key);
        return value == null?null:Integer.valueOf(value);
    }

    private static Map<String, Object> getContext() {
        Map<String, Object> tokenContext = (Map)contextThreadLocal.get();
        if(tokenContext == null) {
            tokenContext = new HashMap();
            contextThreadLocal.set(tokenContext);
        }

        return (Map)tokenContext;
    }

    public static Object getContextObjVal(String key) {
        Map<String, Object> tokenContext = getContext();
        return tokenContext.get(key);
    }

    public static String getContextStrVal(String key) {
        Object obj = getContextObjVal(key);
        return obj == null?null:obj.toString();
    }

    public static Integer getContextIntVal(String key) {
        Object obj = getContextObjVal(key);
        return obj == null?null:Integer.valueOf(obj.toString());
    }

    public static void putContextTokenVal(String value) {
        putContextVal("API_CTX_TOKEN_KEY", value);
    }

    public static void putContextVal(String key, String value) {
        Map<String, Object> tokenContext = getContext();
        tokenContext.put(key, value);
    }

    public static String getContextTokenVal() {
        return getContextStrVal("API_CTX_TOKEN_KEY");
    }
}
