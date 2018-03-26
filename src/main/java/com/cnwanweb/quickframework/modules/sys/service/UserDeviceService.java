
package com.cnwanweb.quickframework.modules.sys.service;

import com.cnwanweb.quickframework.common.service.CrudService;
import com.cnwanweb.quickframework.modules.sys.dao.UserDeviceDao;
import com.cnwanweb.quickframework.modules.sys.entity.UserDevice;
import com.cnwanweb.quickframework.modules.sys.entity.UserDeviceHistory;
import com.cnwanweb.quickframework.modules.sys.utils.DictUtils;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户设备Service
 * @author chenwy
 * @version 2017-02-17
 */
@Service
@Transactional(readOnly = true)
public class UserDeviceService extends CrudService<UserDeviceDao, UserDevice> {

//	public UserDevice get(String id) {
//		return super.get(id);
//	}

//	public List<UserDevice> findList(UserDevice sysUserDevice) {
//		return super.findList(sysUserDevice);
//	}

//	public Page<UserDevice> findPage(Page<UserDevice> page, UserDevice sysUserDevice) {
//		return super.findPage(page, sysUserDevice);
//	}
//
//	@Transactional(readOnly = false)
//	public void save(UserDevice sysUserDevice) {
//		super.save(sysUserDevice);
//	}
//
//	@Transactional(readOnly = false)
//	public void delete(UserDevice sysUserDevice) {
//		super.delete(sysUserDevice);
//	}

    @Deprecated
    @Transactional(readOnly = false)
    public int deleteUserDeviceExceptForId(UserDevice userDevice){
        return dao.deleteUserDeviceExceptForId(userDevice);
    }

    @Transactional(readOnly = false)
    public int insertHistory(UserDeviceHistory bean) {
        return dao.insertHistory(bean);
    }

    /**
     *
     * @param deviceList
     * @return true: do delete last device, login denied
     */
    @Transactional(readOnly = false)
    public boolean updateUserDeviceBinds(List<UserDevice> deviceList){
        final int length = deviceList.size();
        String userServiceBinds = DictUtils.getValueByUnionType("user_service_binds");
        int bindNumber = 0;
        if(StringUtils.isNotBlank(userServiceBinds) && StringUtils.isNumeric(userServiceBinds)) {
            bindNumber = Integer.parseInt(userServiceBinds);
        }
        if(bindNumber <= 1) bindNumber = 1;
        if(bindNumber < length) {
            //按照创建时间倒序选中删除
            List<String> toDelList = Lists.newArrayList();
            for(int i = length - 1; i >= bindNumber; i--) {
                UserDevice bean = deviceList.get(i);
                if(bean == null || StringUtils.isBlank(bean.getId())) {
                    continue;
                }
                toDelList.add(bean.getId());
            }
            dao.updateUserDeviceBinds(toDelList);
            return true;
        }
        return false;
    }

    @Transactional(readOnly = false)
    public int deleteTheUserDevice(UserDevice userDevice){
        return dao.deleteTheUserDevice(userDevice);
    }

}