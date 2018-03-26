
package com.cnwanweb.quickframework.modules.sys.dao;

import com.cnwanweb.quickframework.common.persistence.CrudDao;
import com.cnwanweb.quickframework.common.persistence.annotation.MyBatisDao;
import com.cnwanweb.quickframework.modules.sys.entity.UserDevice;
import com.cnwanweb.quickframework.modules.sys.entity.UserDeviceHistory;

import java.util.List;

/**
 * 用户设备DAO接口
 * @author chenwy
 * @version 2017-02-17
 */
@MyBatisDao
public interface UserDeviceDao extends CrudDao<UserDevice> {
    /*删除第一次登录以后的设备信息*/
    public int deleteUserDeviceExceptForId(UserDevice userDevice);
    /*删除该设备信息 真删*/
    public int deleteTheUserDevice(UserDevice userDevice);

    public int updateUserDeviceBinds(List<String> deviceIds);

    public int insertHistory(UserDeviceHistory bean);
}