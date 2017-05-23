package com.it7890.orange.manage.model;

import java.io.Serializable;
import java.util.Date;


public class SysUser implements Serializable {
	
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
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(Integer createuserid) {
		this.createuserid = createuserid;
	}

	public String getAllowip() {
		return allowip;
	}

	public void setAllowip(String allowip) {
		this.allowip = allowip;
	}

	public String getLastlogintime() {
		return lastlogintime;
	}

	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public Integer getIsstate() {
		return isstate;
	}

	public void setIsstate(Integer isstate) {
		this.isstate = isstate;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
    
   

    public String[] getSonroles() {
		return sonroles;
	}

	public void setSonroles(String[] sonroles) {
		this.sonroles = sonroles;
	}
}