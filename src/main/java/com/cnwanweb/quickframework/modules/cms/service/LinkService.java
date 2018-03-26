//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cnwanweb.quickframework.modules.cms.service;

import com.cnwanweb.quickframework.common.persistence.Page;
import com.cnwanweb.quickframework.common.service.CrudService;
import com.cnwanweb.quickframework.common.utils.CacheUtils;
import com.cnwanweb.quickframework.common.utils.StringUtils;
import com.cnwanweb.quickframework.modules.cms.dao.LinkDao;
import com.cnwanweb.quickframework.modules.cms.entity.Link;
import com.google.common.collect.Lists;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(
        readOnly = true
)
public class LinkService extends CrudService<LinkDao, Link> {
    public LinkService() {
    }

    @Transactional(
            readOnly = false
    )
    public Page<Link> findPage(Page<Link> page, Link link, boolean isDataScopeFilter) {
        Date updateExpiredWeightDate = (Date)CacheUtils.get("updateExpiredWeightDateByLink");
        if(updateExpiredWeightDate == null || updateExpiredWeightDate != null && updateExpiredWeightDate.getTime() < (new Date()).getTime()) {
            ((LinkDao)this.dao).updateExpiredWeight(link);
            CacheUtils.put("updateExpiredWeightDateByLink", DateUtils.addHours(new Date(), 6));
        }

        link.getSqlMap().put("dsf", dataScopeFilter(link.getCurrentUser(), "o", "u"));
        return super.findPage(page, link);
    }

    @Transactional(
            readOnly = false
    )
    public void delete(Link link, Boolean isRe) {
        link.setDelFlag(isRe != null && isRe.booleanValue()?"0":"1");
        ((LinkDao)this.dao).delete(link);
    }

    public List<Object[]> findByIds(String ids) {
        List<Object[]> list = Lists.newArrayList();
        String[] idss = StringUtils.split(ids, ",");
        if(idss.length > 0) {
            List<Link> l = ((LinkDao)this.dao).findByIdIn(idss);
            Iterator i$ = l.iterator();

            while(i$.hasNext()) {
                Link e = (Link)i$.next();
                list.add(new Object[]{e.getId(), StringUtils.abbr(e.getTitle(), 50)});
            }
        }

        return list;
    }
}
