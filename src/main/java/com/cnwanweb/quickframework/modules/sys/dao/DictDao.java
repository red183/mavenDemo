package com.cnwanweb.quickframework.modules.sys.dao;

import com.cnwanweb.quickframework.common.persistence.CrudDao;
import com.cnwanweb.quickframework.common.persistence.annotation.MyBatisDao;
import com.cnwanweb.quickframework.modules.sys.entity.Dict;
import java.util.List;

@MyBatisDao
public interface DictDao extends CrudDao<Dict> {
    List<String> findTypeList(Dict var1);
}
