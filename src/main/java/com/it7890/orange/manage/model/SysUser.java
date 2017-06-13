package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.Date;

@AVClassName("SysUser")
public class SysUser extends AVObject {
    /*public SysUser() {
        super();
    }*/

    /*private String allowIp;
    private SysUser createUser;
    private String email;
    private String fax;
    private String identityCode;
    private Date lastLoginTime;
    private String mobilephone;
    private String password;
    private String qq;
    private String roleId;
    private Integer sex;
    private Integer state;
    private String telphone;
    private String trueName;
    private Date updatedAt;
    private String userName;*/

    public String getAllowIp() {
        return getString("allowIp");
    }

    public void setAllowIp(String allowIp) {
        this.put("allowIp", allowIp);
    }

    public SysUser getCreateUser() {
        return getAVObject("createUserObj");
    }

    public void setCreateUser(SysUser createUser) {
        this.put("createUserObj", createUser);
    }

    public String getEmail() {
        return getString("email");
    }

    public void setEmail(String email) {
        this.put("email", email);
    }

    public String getFax() {
        return getString("fax");
    }

    public void setFax(String fax) {
        this.put("fax", fax);
    }

    public String getIdentityCode() {
        return getString("identityCode");
    }

    public void setIdentityCode(String identityCode) {
        this.put("identityCode", identityCode);
    }

    public Date getLastLoginTime() {
        return getDate("lastLoginTime");
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.put("lastLoginTime", lastLoginTime);
    }

    public String getMobilephone() {
        return getString("mobilephone");
    }

    public void setMobilephone(String mobilephone) {
        this.put("mobilephone", mobilephone);
    }

    public String getPassword() {
        return getString("password");
    }

    public void setPassword(String password) {
        this.put("password", password);
    }

    public String getQq() {
        return getString("qq");
    }

    public void setQq(String qq) {
        this.put("qq", qq);
    }

    public String getRoleId() {
        return getString("roleId");
    }

    public void setRoleId(String roleId) {
        this.put("roleId", roleId);
    }

    public Integer getSex() {
        return getInt("sex");
    }

    public void setSex(Integer sex) {
        this.put("sex", sex);
    }

    public Integer getState() {
        return getInt("state");
    }

    public void setState(Integer state) {
        this.put("state", state);
    }

    public String getTelphone() {
        return getString("telphone");
    }

    public void setTelphone(String telphone) {
        this.put("telphone", telphone);
    }

    public String getTrueName() {
        return getString("trueName");
    }

    public void setTrueName(String trueName) {
        this.put("trueName", trueName);
    }


    public String getUserName() {
        return getString("userName");
    }

    public void setUserName(String userName) {
        this.put("userName", userName);
    }
}