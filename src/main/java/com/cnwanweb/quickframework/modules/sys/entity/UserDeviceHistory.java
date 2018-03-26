
package com.cnwanweb.quickframework.modules.sys.entity;

import com.cnwanweb.quickframework.common.utils.IdGen;

import java.util.Date;

/**
 * 用户设备
 * @author chenwy
 * @version 2017-02-17
 */
public class UserDeviceHistory {

    private String id;
    private User user;		// user_id
    private Office office;		// user_id
    private String deviceId;		// device_id

    private String deviceName;
    private String deviceBrand;

    private String protocol;
    private String osName;
    private String osVersion;
    private String softVersion;

    private Date createDate;

    public UserDeviceHistory(UserDevice userDevice) {
        this.id = IdGen.uuid();
        this.user = userDevice.getUser();
        this.deviceId = userDevice.getDeviceId();
        this.deviceName = userDevice.getDeviceName();
        this.deviceBrand = userDevice.getDeviceBrand();
        this.protocol = userDevice.getProtocol();
        this.osName = userDevice.getOsName();
        this.osVersion = userDevice.getOsVersion();
        this.softVersion = userDevice.getSoftVersion();
        this.createDate = userDevice.getCreateDate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getSoftVersion() {
        return softVersion;
    }

    public void setSoftVersion(String softVersion) {
        this.softVersion = softVersion;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}