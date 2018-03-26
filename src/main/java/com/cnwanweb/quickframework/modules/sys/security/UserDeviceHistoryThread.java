package com.cnwanweb.quickframework.modules.sys.security;

import com.cnwanweb.quickframework.common.utils.SpringContextHolder;
import com.cnwanweb.quickframework.modules.sys.entity.UserDevice;
import com.cnwanweb.quickframework.modules.sys.entity.UserDeviceHistory;
import com.cnwanweb.quickframework.modules.sys.service.UserDeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by firecnwanweb on 2018/3/5.
 */
public class UserDeviceHistoryThread implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(UserDeviceHistoryThread.class);
    private UserDeviceHistory history;

    public UserDeviceHistoryThread(UserDevice userDevice) {
        this.history = new UserDeviceHistory(userDevice);
    }


    public void run() {
        try {
            UserDeviceService userDeviceService = SpringContextHolder.getBean(UserDeviceService.class);
            userDeviceService.insertHistory(this.history);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}