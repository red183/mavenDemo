package com.cnwanweb.quickframework.modules.sys.dao;

import com.cnwanweb.quickframework.common.persistence.CrudDao;
import com.cnwanweb.quickframework.common.persistence.annotation.MyBatisDao;
import com.cnwanweb.quickframework.modules.sys.entity.Role;

@MyBatisDao
public interface RoleDao extends CrudDao<Role> {
    Role getByName(Role var1);

    Role getByEnname(Role var1);

    int deleteRoleMenu(Role var1);

    int insertRoleMenu(Role var1);

    int deleteRoleOffice(Role var1);

    int insertRoleOffice(Role var1);
}
