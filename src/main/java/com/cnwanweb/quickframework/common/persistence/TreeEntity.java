package com.cnwanweb.quickframework.common.persistence;

import com.cnwanweb.quickframework.common.utils.Reflections;
import com.cnwanweb.quickframework.common.utils.StringUtils;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public abstract class TreeEntity<T> extends DataEntity<T> {
    private static final long serialVersionUID = 1L;
    protected T parent;
    protected String parentIds;
    protected String name;
    protected Integer sort;

    public TreeEntity() {
        this.sort = Integer.valueOf(30);
    }

    public TreeEntity(String id) {
        super(id);
    }

    @JsonBackReference
    @NotNull
    public abstract T getParent();

    public abstract void setParent(T var1);

    @Length(
            min = 1,
            max = 2000
    )
    public String getParentIds() {
        return this.parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    @Length(
            min = 1,
            max = 100
    )
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentId() {
        String id = null;
        if(this.parent != null) {
            id = (String)Reflections.getFieldValue(this.parent, "id");
        }

        return StringUtils.isNotBlank(id)?id:"0";
    }
}
