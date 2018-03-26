
package com.cnwanweb.quickframework.modules.sys.dao;

import com.cnwanweb.quickframework.common.persistence.CrudDao;
import com.cnwanweb.quickframework.common.persistence.annotation.MyBatisDao;
import com.cnwanweb.quickframework.modules.sys.entity.Log;

/**
 * 日志DAO接口
 * @author cnwanweb
 * @version 2014-05-16
 */
@MyBatisDao
public interface LogDao extends CrudDao<Log> {

}
