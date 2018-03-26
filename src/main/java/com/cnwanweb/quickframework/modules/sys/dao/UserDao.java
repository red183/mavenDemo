package com.cnwanweb.quickframework.modules.sys.dao;

import com.cnwanweb.quickframework.common.persistence.CrudDao;
import com.cnwanweb.quickframework.common.persistence.annotation.MyBatisDao;
import com.cnwanweb.quickframework.modules.sys.entity.User;
import java.util.List;

@MyBatisDao
public interface UserDao extends CrudDao<User> {
    User getByLoginName(User var1);

    List<User> findUserByOfficeId(User var1);

    long findAllCount(User var1);

    int updatePasswordById(User var1);

    int updateLoginInfo(User var1);

    int deleteUserRole(User var1);

    int insertUserRole(User var1);

    int updateUserInfo(User var1);

    public User getByWxWareOpenId(User user);

    public void updateOpenId(User user);
}
