package com.it7890.orange.manage.model;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.HashMap;
import java.util.Map;

//列表规则
@AVClassName("con_grab_lrule")
public class ConGrabLRule extends AVObject {

    public ConGrabLRule() {
        super();
    }

  /*  //规则ID
    private Integer id;
    //媒体ID(下拉选择)
    private int pid;
    //规则名称
    private String rulename;
    //节点ID
    private int nodeid;
    //渠道ID
    private int channelid;
    //规则
    private String csspath;
    //创建时间
    private Date createtime;
    //url
    private String url;
    //国家码
    private String code;
    //语言码
    private int langid;
    //抓取间隔时间
    private int grabtime;
    //分类
    private int topic;
    //状态
    private int status;//0正常 1禁用
    //字符集
    private String constant;
    //匹配url
    private String mistakeurl;

    private int liststatus;//-1审核 0待发布 1已发布
    //href
    private String findpre;
*/


//    public Date getCreatetime() {
//        return getString("createtime");
//    }
//
//    public void setCreatetime(Date createtime) {
//        this.put("", );createtime = createtime;
//    }


//    public String getMistakeurl() {
//        return getString("mistakeurl");
//    }
//
//    public void setMistakeurl(String mistakeurl) {
//        this.put("mistakeurl", mistakeurl);
//    }


    public Integer getId() {
        return getInt("id");
    }

    public void setId(Integer id) {
        this.put("id", id);
    }

    public int getPid() {
        return getInt("pid");
    }

    public void setPid(int pid) {
        this.put("pid", pid);
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

    public int getChannelid() {
        return getInt("channelid");
    }

    public void setChannelid(int channelid) {
        this.put("channelid", channelid);
    }

    public String getCsspath() {
        return getString("csspath");
    }

    public void setCsspath(String csspath) {
        this.put("csspath", csspath);
    }

    public String getUrl() {
        return getString("url");
    }

    public void setUrl(String url) {
        this.put("url", url);
    }

    public String getCountryCode() {
        return getString("countryCode");
    }

    public void setCountryCode(String countryCode) {
        this.put("countryCode", countryCode);
    }

    public int getLangid() {
        return getInt("langid");
    }

    public void setLangid(int langid) {
        this.put("langid", langid);
    }

    public int getGrabtime() {
        return getInt("grabtime");
    }

    public void setGrabtime(int grabtime) {
        this.put("grabtime", grabtime);
    }

    public int getTopic() {
        return getInt("topic");
    }

    public void setTopic(int topic) {
        this.put("topic", topic);
    }

    public int getStatus() {
        return getInt("status");
    }

    public void setStatus(int status) {
        this.put("status", status);
    }

    public String getConstant() {
        return getString("constant");
    }

    public void setConstant(String constant) {
        this.put("constant", constant);
    }

    public int getListstatus() {
        return getInt("liststatus");
    }

    public void setListstatus(int liststatus) {
        this.put("liststatus", liststatus);
    }

    public String getFindpre() {
        return getString("findpre");
    }

    public void setFindpre(String findpre) {
        this.put("findpre", findpre);
    }

    @Override
    public String toString() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("id", this.getInt("id"));
        result.put("pid", this.getInt("pid"));
        result.put("rulename", this.getString("rulename"));
        result.put("nodeid", this.getInt("nodeid"));
        result.put("channelid", this.getInt("channelid"));
        result.put("csspath", this.getString("csspath"));
        result.put("url", this.getString("url"));
        result.put("countryCode", this.getString("countryCode"));
        result.put("langid", this.getInt("langid"));
        result.put("grabtime", this.getInt("grabtime"));
        result.put("topic", this.getInt("topic"));
        result.put("status", this.getInt("status"));
        result.put("constant", this.getString("constant"));
        //TODO 不一样的字段
//        result.put("mistakeurl", this.getString("mistakeurl"));
        result.put("liststatus", this.getInt("liststatus"));
        result.put("findpre", this.getString("findpre"));
        result.put("objectId", this.getObjectId());
        result.put("createdAt", this.getCreatedAt());
        return JSON.toJSONString(result);
    }

}
