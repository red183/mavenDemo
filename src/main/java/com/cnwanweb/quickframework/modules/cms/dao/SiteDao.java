package com.cnwanweb.quickframework.modules.cms.dao;

import com.cnwanweb.quickframework.common.persistence.CrudDao;
import com.cnwanweb.quickframework.common.persistence.annotation.MyBatisDao;
import com.cnwanweb.quickframework.modules.cms.entity.Site;

@MyBatisDao
public interface SiteDao extends CrudDao<Site> {
}
