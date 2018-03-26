package com.cnwanweb.quickframework.modules.sys.entity;

import com.cnwanweb.quickframework.common.persistence.DataEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class Menu extends DataEntity<Menu> {
    private static final long serialVersionUID = 1L;
    private Menu parent;
    private String parentIds;
    private String name;
    private String href;
    private String target;
    private String icon;
    private Integer sort;
    private String isShow;
    private String permission;
    private String userId;

    public Menu() {
        this.sort = Integer.valueOf(30);
        this.isShow = "1";
    }

    public Menu(String id) {
        super(id);
    }

    @JsonBackReference
    @NotNull
    public Menu getParent() {
        return this.parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

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

    @Length(
            min = 0,
            max = 2000
    )
    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Length(
            min = 0,
            max = 20
    )
    public String getTarget() {
        return this.target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Length(
            min = 0,
            max = 100
    )
    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @NotNull
    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Length(
            min = 1,
            max = 1
    )
    public String getIsShow() {
        return this.isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    @Length(
            min = 0,
            max = 200
    )
    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getParentId() {
        return this.parent != null && this.parent.getId() != null?this.parent.getId():"0";
    }

    @JsonIgnore
    public static void sortList(List<Menu> list, List<Menu> sourcelist, String parentId, boolean cascade) {
        for(int i = 0; i < sourcelist.size(); ++i) {
            Menu e = (Menu)sourcelist.get(i);
            if(e.getParent() != null && e.getParent().getId() != null && e.getParent().getId().equals(parentId)) {
                list.add(e);
                if(cascade) {
                    for(int j = 0; j < sourcelist.size(); ++j) {
                        Menu child = (Menu)sourcelist.get(j);
                        if(child.getParent() != null && child.getParent().getId() != null && child.getParent().getId().equals(e.getId())) {
                            sortList(list, sourcelist, e.getId(), true);
                            break;
                        }
                    }
                }
            }
        }

    }

    @JsonIgnore
    public static String getRootId() {
        return "1";
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String toString() {
        return this.name;
    }
}
