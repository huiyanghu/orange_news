package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.Date;

/**
 * The persistent class for the con_channel database table.
 */
@AVClassName("ConChannel")
public class ConChannel extends AVObject {
    private static final long serialVersionUID = 1L;
    /*public ConChannel() {
        super();
    }*/
    private AppAplication aplication;
    private String channelName;
    private String channelCode;
    private String channelPass;
    private String channelDesc;
    private Date startTime;
    private Date endTime;
    private String contact;
    private String mobile;
    private String email;
    private Integer proportion;
    private Integer status;
    private SysUser creater;


    public AppAplication getAplication() {
        return getAVObject("applicationObj");
    }

    public void setAplication(AppAplication aplication) {
        this.put("applicationObj", aplication);
    }

    public String getChannelName() {
        return getString("channelName");
    }

    public void setChannelName(String channelName) {
        this.put("channelName", channelName);
    }

    public String getChannelCode() {
        return getString("channelCode");
    }

    public void setChannelCode(String channelCode) {
        this.put("channelCode", channelCode);
    }

    public String getChannelPass() {
        return getString("channelPass");
    }

    public void setChannelPass(String channelPass) {
        this.put("channelPass", channelPass);
    }

    public String getChannelDesc() {
        return getString("channelDesc");
    }

    public void setChannelDesc(String channelDesc) {
        this.put("channelDesc", channelDesc);
    }

    public Date getStartTime() {
        return getDate("startTime");
    }

    public void setStartTime(Date startTime) {
        this.put("startTime", startTime);
    }

    public Date getEndTime() {
        return getDate("endTime");
    }

    public void setEndTime(Date endTime) {
        this.put("endTime", endTime);
    }

    public String getContact() {
        return getString("contact");
    }

    public void setContact(String contact) {
        this.put("contact", contact);
    }

    public String getMobile() {
        return getString("mobile");
    }

    public void setMobile(String mobile) {
        this.put("mobile", mobile);
    }

    public String getEmail() {
        return getString("email");
    }

    public void setEmail(String email) {
        this.put("email", email);
    }

    public Integer getProportion() {
        return getInt("proportion");
    }

    public void setProportion(Integer proportion) {
        this.put("proportion", proportion);
    }

    public Integer getStatus() {
        return getInt("status");
    }

    public void setStatus(Integer status) {
        this.put("status", status);
    }

    public SysUser getCreater() {
        return getAVObject("createrObj");
    }

    public void setCreater(SysUser creater) {
        this.put("creater", creater);
    }
}