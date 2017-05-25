package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.io.Serializable;
import java.util.Date;

@AVClassName("hb_topics")
public class SysUser extends AVObject {

    private Integer userid;
    private String username;
    private String password;
    private String truename;
    private String identity;
    private Integer sex;
    private Date createtime;
    private Integer createuserid;
    private String allowip;
    private String lastlogintime;
    private String email;
    private String mobilephone;
    private Integer isstate;
    private Integer roleid;
    private String qq;
    private String telphone;
    private String fax;
    private String[] sonroles;


    public Integer getUserid() {
        return getInt("userid");
    }

    public String getUsername() {
        return getString("username");
    }

    public String getPassword() {
        return getString("password");
    }

    public String getTruename() {
        return getString("truename");
    }

    public String getIdentity() {
        return getString("identity");
    }

    public Integer getSex() {
        return getInt("sex");
    }

    public Date getCreatetime() {
        return getDate("createtime");
    }

    public Integer getCreateuserid() {
        return getInt("createuserid");
    }

    public String getAllowip() {
        return getString("allowip");
    }

    public String getLastlogintime() {
        return getString("lastlogintime");
    }

    public String getEmail() {
        return getString("email");
    }

    public String getMobilephone() {
        return getString("mobilephone");
    }

    public Integer getIsstate() {
        return getInt("isstate");
    }

    public Integer getRoleid() {
        return getInt("roleid");
    }

    public String getQq() {
        return getString("qq");
    }

    public String getTelphone() {
        return getString("telphone");
    }

    public String getFax() {
        return getString("fax");
    }

    public String[] getSonroles() {
        return getString("sonroles").split("");
    }
}