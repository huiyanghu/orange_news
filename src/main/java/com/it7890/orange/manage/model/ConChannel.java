package com.it7890.orange.manage.model;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.HashMap;
import java.util.Map;

/**
 * The persistent class for the con_channel database table.
 */
@AVClassName("con_channel")
public class ConChannel extends AVObject {
    private static final long serialVersionUID = 1L;
    //	private int id;
//	private Date createtime;
    private String channelname;
    private int countryid;
    private int createuid;
    private String email;
    private String mobile;
    private String password;
    private int status;
    private String telphone;

    public ConChannel() {
        super();
    }

//    public int getId() {
//        return getString(""); this.put("", );id;
//    }
//
//    public void setId(int id) {
//        this.put("", );id = id;
//    }
//
//    public Date getCreatetime() {
//        return getString(""); createtime;
//    }
//
//    public void setCreatetime(Date createtime) {
//        this.put("", );createtime = createtime;
//    }

    public String getChannelname() {
        return getString("channelname");
    }

    public void setChannelname(String channelname) {
        this.put("channelname", channelname);
    }

    public int getCountryid() {
        return getInt("countryid");
    }

    public void setCountryid(int countryid) {
        this.put("countryid", countryid);
    }

    public int getCreateuid() {
        return getInt("createuid");
    }

    public void setCreateuid(int createuid) {
        this.put("createuid", createuid);
    }

    public String getEmail() {
        return getString("email");
    }

    public void setEmail(String email) {
        this.put("email", email);
    }

    public String getMobile() {
        return getString("mobile");
    }

    public void setMobile(String mobile) {
        this.put("mobile", mobile);
    }

    public String getPassword() {
        return getString("password");
    }

    public void setPassword(String password) {
        this.put("password", password);
    }

    public int getStatus() {
        return getInt("status");
    }

    public void setStatus(int status) {
        this.put("status", status);
    }

    public String getTelphone() {
        return getString("telphone");
    }

    public void setTelphone(String telphone) {
        this.put("telphone", telphone);
    }

    @Override
    public String toString() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("channelname", this.getString("channelname"));
        result.put("countryid", this.getInt("countryid"));
        result.put("createuid", this.getInt("createuid"));
        result.put("email", this.getString("email"));
        result.put("mobile", this.getString("mobile"));
        result.put("password", this.getString("password"));
        result.put("status", this.getInt("status"));
        result.put("telphone", this.getString("telphone"));
        result.put("objectId", this.getObjectId());
        result.put("createdAt", this.getCreatedAt());
        return JSON.toJSONString(result);
    }


}