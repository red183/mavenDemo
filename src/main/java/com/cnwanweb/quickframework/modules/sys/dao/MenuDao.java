package com.cnwanweb.quickframework.modules.sys.dao;

import com.cnwanweb.quickframework.common.persistence.CrudDao;
import com.cnwanweb.quickframework.common.persistence.annotation.MyBatisDao;
import com.cnwanweb.quickframework.modules.sys.entity.Menu;
import java.util.List;

@MyBatisDao
public interface MenuDao extends CrudDao<Menu> {
    List<Menu> findByParentIdsLike(Menu var1);

    List<Menu> findByUserId(Menu var1);

    int updateParentIds(Menu var1);

    int updateSort(Menu var1);
}
