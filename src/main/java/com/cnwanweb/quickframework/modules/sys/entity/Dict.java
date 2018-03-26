package com.cnwanweb.quickframework.modules.sys.entity;

import com.cnwanweb.quickframework.common.persistence.DataEntity;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import org.hibernate.validator.constraints.Length;

public class Dict extends DataEntity<Dict> {
    private static final long serialVersionUID = 1L;
    private String value;
    private String label;
    private String type;
    private String description;
    private Integer sort;
    private String parentId;

    public Dict() {
    }

    public Dict(String id) {
        super(id);
    }

    public Dict(String value, String label) {
        this.value = value;
        this.label = label;
    }

    @XmlAttribute
    @Length(
            min = 1,
            max = 100
    )
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @XmlAttribute
    @Length(
            min = 1,
            max = 100
    )
    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Length(
            min = 1,
            max = 100
    )
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlAttribute
    @Length(
            min = 0,
            max = 100
    )
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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
            max = 100
    )
    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String toString() {
        return this.label;
    }
}
