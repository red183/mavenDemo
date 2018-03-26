package com.cnwanweb.quickframework.modules.cms.service;

import com.cnwanweb.quickframework.common.persistence.Page;
import com.cnwanweb.quickframework.common.service.CrudService;
import com.cnwanweb.quickframework.modules.cms.dao.SiteDao;
import com.cnwanweb.quickframework.modules.cms.entity.Site;
import com.cnwanweb.quickframework.modules.cms.utils.CmsUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(
        readOnly = true
)
public class SiteService extends CrudService<SiteDao, Site> {
    public SiteService() {
    }

    public Page<Site> findPage(Page<Site> page, Site site) {
        site.getSqlMap().put("site", dataScopeFilter(site.getCurrentUser(), "o", "u"));
        return super.findPage(page, site);
    }

    @Transactional(
            readOnly = false
    )
    public void save(Site site) {
        if(site.getCopyright() != null) {
            site.setCopyright(StringEscapeUtils.unescapeHtml4(site.getCopyright()));
        }

        super.save(site);
        CmsUtils.removeCache("site_" + site.getId());
        CmsUtils.removeCache("siteList");
    }

    @Transactional(
            readOnly = false
    )
    public void delete(Site site, Boolean isRe) {
        site.setDelFlag(isRe != null && isRe.booleanValue()?"0":"1");
        super.delete(site);
        CmsUtils.removeCache("site_" + site.getId());
        CmsUtils.removeCache("siteList");
    }
}
