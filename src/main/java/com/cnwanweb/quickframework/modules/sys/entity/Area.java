package com.cnwanweb.quickframework.modules.sys.entity;

import com.cnwanweb.quickframework.common.persistence.TreeEntity;
import org.hibernate.validator.constraints.Length;

public class Area extends TreeEntity<Area> {
    private static final long serialVersionUID = 1L;
    private String code;
    private String type;

    public Area() {
        this.sort = Integer.valueOf(30);
    }

    public Area(String id) {
        super(id);
    }

    public Area getParent() {
        return (Area)this.parent;
    }

    public void setParent(Area parent) {
        this.parent = parent;
    }

    @Length(
            min = 1,
            max = 1
    )
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Length(
            min = 0,
            max = 100
    )
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String toString() {
        return this.name;
    }
}
