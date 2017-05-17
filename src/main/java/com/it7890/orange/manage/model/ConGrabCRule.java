package com.it7890.orange.manage.model;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.HashMap;
import java.util.Map;

@AVClassName("con_grab_crule")
public class ConGrabCRule extends AVObject {
    private static final long serialVersionUID = 1L;

    public ConGrabCRule() {
        super();
    }

  /*  private Integer id;
    private int status;//0正常 禁用
    private String rulename;
    private String descsspath;
    private String keycsspath;
    private String concsspath;
    private String concsspath1;
    private String concsspath2;
    private String soucsspath;
    private String imgcsspath;
    private String videocsspath;
    private String authorcsspath;
    private Integer lid;
    private int nodeid;
    private String testurl;
    private int constatus;//-1审核 0待发布 1已发布
    private String topic;//分类
    private String replacerule;
    private String replacecsspath;
    private String titlecsspath;
    private int channelid;*/


    //TODO 不一样的字段,与数据库有一个channelid对应不上
//	private String constant;//字符集
    //	private Date createtime;
//    public Date getCreatetime() {
//        return getString("");createtime;
//    }
//
//    public void setCreatetime(Date createtime) {
//        this.put("", );createtime = createtime;
//    }

    //	public String getConstant() {
//		return getString("");constant;
//	}
//	public void setConstant(String constant) {
//		this.put("", );constant = constant;
//	}

    public int getChannelid() {
        return getInt("channelid");
    }

    public void setChannelid(int channelid) {
        this.put("channelid", channelid);
    }

    public String getReplacerule() {
        return getString("replacerule");
    }

    public void setReplacerule(String replacerule) {
        this.put("replacerule", replacerule);
    }

    public String getReplacecsspath() {
        return getString("replacecsspath");
    }

    public void setReplacecsspath(String replacecsspath) {
        this.put("replacecsspath", replacecsspath);
    }

    public String getTopic() {
        return getString("topic");
    }

    public void setTopic(String topic) {
        this.put("topic", topic);
    }

    public int getConstatus() {
        return getInt("constatus");
    }

    public void setConstatus(int constatus) {
        this.put("constatus", constatus);
    }

    public String getRulename() {
        return getString("rulename");
    }

    public void setRulename(String rulename) {
        this.put("rulename", rulename);
    }

    public int getNodeid() {
        return getInt("nodeid");
    }

    public void setNodeid(int nodeid) {
        this.put("nodeid", nodeid);
    }


    public String getTesturl() {
        return getString("testurl");
    }

    public void setTesturl(String testurl) {
        this.put("testurl", testurl);
    }

    public Integer getId() {
        return getInt("id");
    }

    public void setId(Integer id) {
        this.put("id", id);
    }

    public int getStatus() {
        return getInt("status");
    }

    public void setStatus(int status) {
        this.put("status", status);
    }

    public String getTitlecsspath() {
        return getString("titlecsspath");
    }

    public void setTitlecsspath(String titlecsspath) {
        this.put("titlecsspath", titlecsspath);
    }

    public String getDescsspath() {
        return getString("descsspath");
    }

    public void setDescsspath(String descsspath) {
        this.put("descsspath", descsspath);
    }

    public String getKeycsspath() {
        return getString("keycsspath");
    }

    public void setKeycsspath(String keycsspath) {
        this.put("keycsspath", keycsspath);
    }

    public String getConcsspath() {
        return getString("concsspath");
    }

    public void setConcsspath(String concsspath) {
        this.put("concsspath", concsspath);
    }

    public String getConcsspath1() {
        return getString("concsspath1");
    }

    public void setConcsspath1(String concsspath1) {
        this.put("concsspath1", concsspath1);
    }

    public String getConcsspath2() {
        return getString("concsspath2");
    }

    public void setConcsspath2(String concsspath2) {
        this.put("concsspath2", concsspath2);
    }

    public String getSoucsspath() {
        return getString("soucsspath");
    }

    public void setSoucsspath(String soucsspath) {
        this.put("soucsspath", soucsspath);
    }

    public String getImgcsspath() {
        return getString("imgcsspath");
    }

    public void setImgcsspath(String imgcsspath) {
        this.put("imgcsspath", imgcsspath);
    }

    public String getVideocsspath() {
        return getString("videocsspath");
    }

    public void setVideocsspath(String videocsspath) {
        this.put("videocsspath", videocsspath);
    }

    public String getAuthorcsspath() {
        return getString("authorcsspath");
    }

    public void setAuthorcsspath(String authorcsspath) {
        this.put("authorcsspath", authorcsspath);
    }

    public Integer getLid() {
        return getInt("lid");
    }

    public void setLid(Integer lid) {
        this.put("lid", lid);
    }


    @Override
    public String toString() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("id", this.getInt("id"));
        result.put("status", this.getInt("status"));
        result.put("rulename", this.getString("rulename"));
        result.put("descsspath", this.getString("descsspath"));
        result.put("keycsspath", this.getString("keycsspath"));
        result.put("concsspath", this.getString("concsspath"));
        result.put("concsspath1", this.getString("concsspath1"));
        result.put("concsspath2", this.getString("concsspath2"));
        result.put("soucsspath", this.getString("soucsspath"));
        result.put("imgcsspath", this.getString("imgcsspath"));
        result.put("videocsspath", this.getString("videocsspath"));
        result.put("authorcsspath", this.getString("authorcsspath"));
        result.put("lid", this.getInt("lid"));
        result.put("nodeid", this.getInt("nodeid"));
        result.put("testurl", this.getString("testurl"));
        result.put("constatus", this.getInt("constatus"));
        result.put("topic", this.getString("topic"));
        result.put("replacerule", this.getString("replacerule"));
        result.put("replacecsspath", this.getString("replacecsspath"));
        result.put("titlecsspath", this.getString("titlecsspath"));
        result.put("channelid", this.getInt("channelid"));
        result.put("objectId", this.getObjectId());
        result.put("createdAt", this.getCreatedAt());
        return JSON.toJSONString(result);
    }


}
