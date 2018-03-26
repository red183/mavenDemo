package com.cnwanweb.quickframework.common.security.shiro;

import java.io.Serializable;

public interface Principal extends Serializable {
    String getId();

    String getLoginName();

    String getName();

    boolean isMobileLogin();

    String getSessionId();
}
