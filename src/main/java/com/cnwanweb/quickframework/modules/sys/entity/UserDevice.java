package com.cnwanweb.quickframework.modules.sys.entity;

import com.cnwanweb.quickframework.common.persistence.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class UserDevice extends DataEntity<UserDevice> {
    private static final long serialVersionUID = 1L;
    private User user;
    private String deviceId;
    private String deviceName;
    private String deviceBrand;
    private String protocol;
    private String osName;
    private String osVersion;
    private String softVersion;
    private String token;

    public UserDevice() {
    }

    public UserDevice(String id) {
        super(id);
    }

    @NotNull(
            message = "用户不能为空"
    )
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Length(
            min = 1,
            max = 64,
            message = "设备ID长度必须介于 1 和 64 之间"
    )
    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Length(
            min = 1,
            max = 20,
            message = "设备名称长度必须介于 1 和 20 之间"
    )
    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Length(
            min = 1,
            max = 20,
            message = "设备品牌长度必须介于 1 和 20 之间"
    )
    public String getDeviceBrand() {
        return this.deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    @Length(
            min = 1,
            max = 20,
            message = "操作系统长度必须介于 1 和 20 之间"
    )
    public String getOsName() {
        return this.osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    @Length(
            min = 1,
            max = 20,
            message = "系统版本长度必须介于 1 和 20 之间"
    )
    public String getOsVersion() {
        return this.osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    @Length(
            min = 1,
            max = 20,
            message = "软件版本长度必须介于 1 和 20 之间"
    )
    public String getSoftVersion() {
        return this.softVersion;
    }

    public void setSoftVersion(String softVersion) {
        this.softVersion = softVersion;
    }

    @Length(
            min = 1,
            max = 20,
            message = "通信协议长度必须介于 1 和 20 之间"
    )
    public String getProtocol() {
        return this.protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @JsonIgnore
    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
