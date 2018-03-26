package com.cnwanweb.quickframework.modules.sys.dao;

import com.cnwanweb.quickframework.common.persistence.TreeDao;
import com.cnwanweb.quickframework.common.persistence.annotation.MyBatisDao;
import com.cnwanweb.quickframework.modules.sys.entity.Area;
import java.util.List;
import java.util.Map;

@MyBatisDao
public interface AreaDao extends TreeDao<Area> {
    List<Map<String, Object>> findByPid(String var1);

    List<Map<String, Object>> findByCode(String var1);
}
