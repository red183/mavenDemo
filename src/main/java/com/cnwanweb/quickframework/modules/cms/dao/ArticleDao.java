package com.cnwanweb.quickframework.modules.cms.dao;

import com.cnwanweb.quickframework.common.persistence.CrudDao;
import com.cnwanweb.quickframework.common.persistence.annotation.MyBatisDao;
import com.cnwanweb.quickframework.modules.cms.entity.Article;
import com.cnwanweb.quickframework.modules.cms.entity.Category;
import java.util.List;

@MyBatisDao
public interface ArticleDao extends CrudDao<Article> {
    List<Article> findByIdIn(String[] var1);

    int updateHitsAddOne(String var1);

    int updateExpiredWeight(Article var1);

    List<Category> findStats(Category var1);
}
