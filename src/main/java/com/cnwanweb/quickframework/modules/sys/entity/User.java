package com.cnwanweb.quickframework.modules.sys.entity;

import com.cnwanweb.quickframework.common.persistence.DataEntity;
import com.cnwanweb.quickframework.common.supcan.annotation.treelist.cols.SupCol;
import com.cnwanweb.quickframework.common.utils.Collections3;
import com.cnwanweb.quickframework.common.utils.excel.annotation.ExcelField;
import com.cnwanweb.quickframework.common.utils.excel.fieldtype.RoleListType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class User extends DataEntity<User> {
    private static final long serialVersionUID = 1L;
    private Office company;
    private Office office;
    private String loginName;
    private String password;
    private String no;
    private String name;
    private String email;
    private String phone;
    private String mobile;
    private String userType;
    private String loginIp;
    private Date loginDate;
    private String loginFlag;
    private String photo;
    private String oldLoginName;
    private String newPassword;
    private String oldLoginIp;
    private Date oldLoginDate;
    private Role role;
    private List<Role> roleList = Lists.newArrayList();

    private String openId;

    public User() {
        this.loginFlag = "1";
    }

    public User(String id) {
        super(id);
    }

    public User(String id, String loginName) {
        super(id);
        this.loginName = loginName;
    }

    public User(Role role) {
        this.role = role;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLoginFlag() {
        return this.loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }

    @SupCol(
            isUnique = "true",
            isHide = "true"
    )
    @ExcelField(
            title = "ID",
            type = 1,
            align = 2,
            sort = 1
    )
    public String getId() {
        return this.id;
    }

    @JsonIgnore
    @NotNull(
            message = "归属公司不能为空"
    )
    @ExcelField(
            title = "归属公司",
            align = 2,
            sort = 20
    )
    public Office getCompany() {
        return this.company;
    }

    public void setCompany(Office company) {
        this.company = company;
    }

    @JsonIgnore
    @NotNull(
            message = "归属部门不能为空"
    )
    @ExcelField(
            title = "归属部门",
            align = 2,
            sort = 25
    )
    public Office getOffice() {
        return this.office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Length(
            min = 1,
            max = 100,
            message = "登录名长度必须介于 1 和 100 之间"
    )
    @ExcelField(
            title = "登录名",
            align = 2,
            sort = 30
    )
    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @JsonIgnore
    @Length(
            min = 1,
            max = 100,
            message = "密码长度必须介于 1 和 100 之间"
    )
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Length(
            min = 1,
            max = 100,
            message = "姓名长度必须介于 1 和 100 之间"
    )
    @ExcelField(
            title = "姓名",
            align = 2,
            sort = 40
    )
    public String getName() {
        return this.name;
    }

    @Length(
            min = 1,
            max = 100,
            message = "工号长度必须介于 1 和 100 之间"
    )
    @ExcelField(
            title = "工号",
            align = 2,
            sort = 45
    )
    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Email(
            message = "邮箱格式不正确"
    )
    @Length(
            min = 0,
            max = 200,
            message = "邮箱长度必须介于 1 和 200 之间"
    )
    @ExcelField(
            title = "邮箱",
            align = 1,
            sort = 50
    )
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Length(
            min = 0,
            max = 200,
            message = "电话长度必须介于 1 和 200 之间"
    )
    @ExcelField(
            title = "电话",
            align = 2,
            sort = 60
    )
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Length(
            min = 0,
            max = 200,
            message = "手机长度必须介于 1 和 200 之间"
    )
    @ExcelField(
            title = "手机",
            align = 2,
            sort = 70
    )
    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @ExcelField(
            title = "备注",
            align = 1,
            sort = 900
    )
    public String getRemarks() {
        return this.remarks;
    }

    @Length(
            min = 0,
            max = 100,
            message = "用户类型长度必须介于 1 和 100 之间"
    )
    @ExcelField(
            title = "用户类型",
            align = 2,
            sort = 80,
            dictType = "sys_user_type"
    )
    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @ExcelField(
            title = "创建时间",
            type = 0,
            align = 1,
            sort = 90
    )
    public Date getCreateDate() {
        return this.createDate;
    }

    @ExcelField(
            title = "最后登录IP",
            type = 1,
            align = 1,
            sort = 100
    )
    public String getLoginIp() {
        return this.loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @ExcelField(
            title = "最后登录日期",
            type = 1,
            align = 1,
            sort = 110
    )
    public Date getLoginDate() {
        return this.loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getOldLoginName() {
        return this.oldLoginName;
    }

    public void setOldLoginName(String oldLoginName) {
        this.oldLoginName = oldLoginName;
    }

    public String getNewPassword() {
        return this.newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldLoginIp() {
        return this.oldLoginIp == null?this.loginIp:this.oldLoginIp;
    }

    public void setOldLoginIp(String oldLoginIp) {
        this.oldLoginIp = oldLoginIp;
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public Date getOldLoginDate() {
        return this.oldLoginDate == null?this.loginDate:this.oldLoginDate;
    }

    public void setOldLoginDate(Date oldLoginDate) {
        this.oldLoginDate = oldLoginDate;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @JsonIgnore
    @ExcelField(
            title = "拥有角色",
            align = 1,
            sort = 800,
            fieldType = RoleListType.class
    )
    public List<Role> getRoleList() {
        return this.roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @JsonIgnore
    public List<String> getRoleIdList() {
        List<String> roleIdList = Lists.newArrayList();
        Iterator i$ = this.roleList.iterator();

        while(i$.hasNext()) {
            Role role = (Role)i$.next();
            roleIdList.add(role.getId());
        }

        return roleIdList;
    }

    public void setRoleIdList(List<String> roleIdList) {
        this.roleList = Lists.newArrayList();
        Iterator i$ = roleIdList.iterator();

        while(i$.hasNext()) {
            String roleId = (String)i$.next();
            Role role = new Role();
            role.setId(roleId);
            this.roleList.add(role);
        }

    }

    public String getRoleNames() {
        return Collections3.extractToString(this.roleList, "name", ",");
    }

    public boolean isAdmin() {
        return isAdmin(this.id) && "root".equals(this.loginName);
    }

    public static boolean isAdmin(String id) {
        return id != null && "1".equals(id);
    }

    public String toString() {
        return this.id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
