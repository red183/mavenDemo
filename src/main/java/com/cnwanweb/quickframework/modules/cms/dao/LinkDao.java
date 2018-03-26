package com.cnwanweb.quickframework.modules.cms.dao;

import com.cnwanweb.quickframework.common.persistence.CrudDao;
import com.cnwanweb.quickframework.common.persistence.annotation.MyBatisDao;
import com.cnwanweb.quickframework.modules.cms.entity.Link;
import java.util.List;

@MyBatisDao
public interface LinkDao extends CrudDao<Link> {
    List<Link> findByIdIn(String[] var1);

    int updateExpiredWeight(Link var1);
}
