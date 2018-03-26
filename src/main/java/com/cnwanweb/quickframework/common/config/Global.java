package com.cnwanweb.quickframework.common.config;

import com.ckfinder.connector.ServletContextFactory;
import com.cnwanweb.quickframework.common.utils.PropertiesLoader;
import com.cnwanweb.quickframework.common.utils.StringUtils;
import com.google.common.collect.Maps;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.springframework.core.io.DefaultResourceLoader;

public class Global {
    private static Global global = new Global();
    private static Map<String, String> map = Maps.newHashMap();
    private static PropertiesLoader loader = new PropertiesLoader(new String[]{"application.properties"});
    /** @deprecated */
    public static final String API_SECURITY_1 = "cnwanweb/1.0";
    public static final String API_SECURITY_2 = "cnwanweb/2.0";
    public static final String API_SECURITY_3 = "cnwanweb/3.0";
    public static final String SHOW = "1";
    public static final String HIDE = "0";
    public static final String YES = "1";
    public static final String NO = "0";
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String USERFILES_BASE_URL = "/userfiles/";
    private static Map<String, Object> __kvMap = null;

    public Global() {
    }

    public static Global getInstance() {
        return global;
    }

    public static String getConfig(String key) {
        String value = (String)map.get(key);
        if(value == null) {
            value = loader.getProperty(key);
            map.put(key, value != null?value:"");
        }

        return value;
    }

    public static String getLicStrValue(String key) {
        return __kvMap.get(key).toString();
    }

    public static Integer getLicIntValue(String key) {
        return Integer.valueOf(Integer.parseInt(__kvMap.get(key).toString()));
    }

    public static Long getLicLongValue(String key) {
        return Long.valueOf(Long.parseLong(__kvMap.get(key).toString()));
    }

    public static void initKvMap(Map<String, Object> kvMap) {
        __kvMap = kvMap;
    }

    public static String getAdminPath() {
        return getConfig("adminPath");
    }

    public static String getFrontPath() {
        return getConfig("frontPath");
    }

    public static String getUrlSuffix() {
        return getConfig("urlSuffix");
    }

    public static Boolean isDemoMode() {
        String dm = getConfig("demoMode");
        return Boolean.valueOf("true".equals(dm) || "1".equals(dm));
    }

    public static Boolean isSynActivitiIndetity() {
        String dm = getConfig("activiti.isSynActivitiIndetity");
        return Boolean.valueOf("true".equals(dm) || "1".equals(dm));
    }

    public static Object getConst(String field) {
        try {
            return Global.class.getField(field).get((Object)null);
        } catch (Exception var2) {
            return null;
        }
    }

    public static String getUserfilesBaseDir() {
        String dir = getConfig("userfiles.basedir");
        if(StringUtils.isBlank(dir)) {
            try {
                dir = ServletContextFactory.getServletContext().getRealPath("/");
            } catch (Exception var2) {
                return "";
            }
        }

        if(!dir.endsWith("/")) {
            dir = dir + "/";
        }

        return dir;
    }

    public static String getProjectPath() {
        String projectPath = getConfig("projectPath");
        if(StringUtils.isNotBlank(projectPath)) {
            return projectPath;
        } else {
            try {
                File file = (new DefaultResourceLoader()).getResource("").getFile();
                if(file != null) {
                    while(true) {
                        File f = new File(file.getPath() + File.separator + "src" + File.separator + "main");
                        if(f == null || f.exists() || file.getParentFile() == null) {
                            projectPath = file.toString();
                            break;
                        }

                        file = file.getParentFile();
                    }
                }
            } catch (IOException var3) {
                var3.printStackTrace();
            }

            return projectPath;
        }
    }
}
