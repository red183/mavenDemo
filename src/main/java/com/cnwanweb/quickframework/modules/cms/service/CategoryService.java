package com.cnwanweb.quickframework.modules.cms.service;

import com.cnwanweb.quickframework.common.persistence.Page;
import com.cnwanweb.quickframework.common.service.TreeService;
import com.cnwanweb.quickframework.modules.cms.dao.CategoryDao;
import com.cnwanweb.quickframework.modules.cms.entity.Category;
import com.cnwanweb.quickframework.modules.cms.entity.Site;
import com.cnwanweb.quickframework.modules.cms.utils.CmsUtils;
import com.cnwanweb.quickframework.modules.sys.entity.Office;
import com.cnwanweb.quickframework.modules.sys.entity.User;
import com.cnwanweb.quickframework.modules.sys.utils.UserUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(
        readOnly = true
)
public class CategoryService extends TreeService<CategoryDao, Category> {
    public static final String CACHE_CATEGORY_LIST = "categoryList";
    private Category entity = new Category();

    public CategoryService() {
    }

    @SuppressWarnings("unchecked")
    public List<Category> findByUser(boolean isCurrentSite, String module){

        List<Category> list = (List<Category>)UserUtils.getCache(CACHE_CATEGORY_LIST);
        if (list == null){
            User user = UserUtils.getUser();
            Category category = new Category();
            category.setOffice(new Office());
            category.getSqlMap().put("dsf", dataScopeFilter(user, "o", "u"));
            category.setSite(new Site());
            category.setParent(new Category());
            list = dao.findList(category);
            // 将没有父节点的节点，找到父节点
            Set<String> parentIdSet = Sets.newHashSet();
            for (Category e : list){
                if (e.getParent()!=null && StringUtils.isNotBlank(e.getParent().getId())){
                    boolean isExistParent = false;
                    for (Category e2 : list){
                        if (e.getParent().getId().equals(e2.getId())){
                            isExistParent = true;
                            break;
                        }
                    }
                    if (!isExistParent){
                        parentIdSet.add(e.getParent().getId());
                    }
                }
            }
            if (parentIdSet.size() > 0){
                //FIXME 暂且注释，用于测试
//				dc = dao.createDetachedCriteria();
//				dc.add(Restrictions.in("id", parentIdSet));
//				dc.add(Restrictions.eq("delFlag", Category.DEL_FLAG_NORMAL));
//				dc.addOrder(Order.asc("site.id")).addOrder(Order.asc("sort"));
//				list.addAll(0, dao.find(dc));
            }
            UserUtils.putCache(CACHE_CATEGORY_LIST, list);
        }

        if (isCurrentSite){
            List<Category> categoryList = Lists.newArrayList();
            for (Category e : list){
                if (Category.isRoot(e.getId()) || (e.getSite()!=null && e.getSite().getId() !=null
                        && e.getSite().getId().equals(Site.getCurrentSiteId()))){
                    if (StringUtils.isNotEmpty(module)){
                        if (module.equals(e.getModule()) || "".equals(e.getModule())){
                            categoryList.add(e);
                        }
                    }else{
                        categoryList.add(e);
                    }
                }
            }
            return categoryList;
        }
        return list;
    }

    public List<Category> findByParentId(String parentId, String siteId) {
        Category parent = new Category();
        parent.setId(parentId);
        this.entity.setParent(parent);
        Site site = new Site();
        site.setId(siteId);
        this.entity.setSite(site);
        return ((CategoryDao)this.dao).findByParentIdAndSiteId(this.entity);
    }

    public Page<Category> find(Page<Category> page, Category category) {
        category.setPage(page);
        category.setInMenu("1");
        page.setList(((CategoryDao)this.dao).findModule(category));
        return page;
    }

    @Transactional(
            readOnly = false
    )
    public void save(Category category) {
        category.setSite(new Site(Site.getCurrentSiteId()));
        if(StringUtils.isNotBlank(category.getViewConfig())) {
            category.setViewConfig(StringEscapeUtils.unescapeHtml4(category.getViewConfig()));
        }

        super.save(category);
        UserUtils.removeCache("categoryList");
        CmsUtils.removeCache("mainNavList_" + category.getSite().getId());
    }

    @Transactional(
            readOnly = false
    )
    public void delete(Category category) {
        super.delete(category);
        UserUtils.removeCache("categoryList");
        CmsUtils.removeCache("mainNavList_" + category.getSite().getId());
    }

    @Transactional(
            readOnly = false
    )
    public List<Category> fetchList(Category category) {
        return ((CategoryDao)this.dao).fetchList(category);
    }

    public List<Category> findByIds(String ids) {
        List<Category> list = Lists.newArrayList();
        String[] idss = StringUtils.split(ids, ",");
        if(idss.length > 0) {
            String[] arr$ = idss;
            int len$ = idss.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String id = arr$[i$];
                Category e = (Category)((CategoryDao)this.dao).get(id);
                if(null != e) {
                    list.add(e);
                }
            }
        }

        return list;
    }
}
