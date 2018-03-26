package com.cnwanweb.quickframework.modules.sys.dao;

import com.cnwanweb.quickframework.common.persistence.TreeDao;
import com.cnwanweb.quickframework.common.persistence.annotation.MyBatisDao;
import com.cnwanweb.quickframework.modules.sys.entity.Office;

@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {
}
