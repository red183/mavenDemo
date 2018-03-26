package com.cnwanweb.quickframework.modules.cms.dao;

import com.cnwanweb.quickframework.common.persistence.TreeDao;
import com.cnwanweb.quickframework.common.persistence.annotation.MyBatisDao;
import com.cnwanweb.quickframework.modules.cms.entity.Category;
import java.util.List;
import java.util.Map;

@MyBatisDao
public interface CategoryDao extends TreeDao<Category> {
    List<Category> findModule(Category var1);

    List<Category> fetchList(Category var1);

    List<Category> findByModule(String var1);

    List<Category> findByParentId(String var1, String var2);

    List<Category> findByParentIdAndSiteId(Category var1);

    List<Map<String, Object>> findStats(String var1);
}
