package com.cnwanweb.quickframework.common.persistence;

import java.util.List;

public interface CrudDao<T> extends BaseDao {
    T get(String var1);

    T get(T var1);

    List<T> findList(T var1);

    List<T> findAllList(T var1);

    /** @deprecated */
    @Deprecated
    List<T> findAllList();

    int insert(T var1);

    int update(T var1);

    /** @deprecated */
    @Deprecated
    int delete(String var1);

    int delete(T var1);
}
