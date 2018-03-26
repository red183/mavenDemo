package com.cnwanweb.quickframework.modules.sys.entity;

import com.cnwanweb.quickframework.common.persistence.TreeEntity;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class Office extends TreeEntity<Office> {
    private static final long serialVersionUID = 1L;
    private Area area;
    private String code;
    private String type;
    private String grade;
    private String address;
    private String zipCode;
    private String master;
    private String phone;
    private String fax;
    private String email;
    private String useable;
    private User primaryPerson;
    private User deputyPerson;
    private List<String> childDeptList;

    public Office() {
        this.type = "2";
    }

    public Office(String id) {
        super(id);
    }

    public List<String> getChildDeptList() {
        return this.childDeptList;
    }

    public void setChildDeptList(List<String> childDeptList) {
        this.childDeptList = childDeptList;
    }

    public String getUseable() {
        return this.useable;
    }

    public void setUseable(String useable) {
        this.useable = useable;
    }

    public User getPrimaryPerson() {
        return this.primaryPerson;
    }

    public void setPrimaryPerson(User primaryPerson) {
        this.primaryPerson = primaryPerson;
    }

    public User getDeputyPerson() {
        return this.deputyPerson;
    }

    public void setDeputyPerson(User deputyPerson) {
        this.deputyPerson = deputyPerson;
    }

    public Office getParent() {
        return (Office)this.parent;
    }

    public void setParent(Office parent) {
        this.parent = parent;
    }

    @NotNull
    public Area getArea() {
        return this.area;
    }

    public void setArea(Area area) {
        this.area = area;
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
            min = 1,
            max = 1
    )
    public String getGrade() {
        return this.grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Length(
            min = 0,
            max = 255
    )
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Length(
            min = 0,
            max = 100
    )
    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Length(
            min = 0,
            max = 100
    )
    public String getMaster() {
        return this.master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    @Length(
            min = 0,
            max = 200
    )
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Length(
            min = 0,
            max = 200
    )
    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Length(
            min = 0,
            max = 200
    )
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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
