package com.it7890.orange.manage.model;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Astro on 17/5/16.
 */
@AVClassName("GrabDetailRule")
public class GrabDetailRule extends AVObject {
    /*public GrabDetailRule() {
        super();
    }*/


    /*private String objectId;
    private String titleCssPath;    //文章标题区域规则
    private String descCssPath;     //文章描述区域规则
    private String conCssPath;      //文章内容区域规则
    private String conCssPath1;      //文章内容区域规则1
    private String conCssPath2;      //文章内容区域规则2
    private String replaceCssPath;  //剔除内容区域规则
    private String souCssPath;      //来源区域规则
    private String imgCssPath;      //图片规则
    private String videoCssPath;    //媒体规则
    private String authorCssPath;   //作者规则
    private String keywordCssPath;  //关键字规则
    private String testUrl;         //测试url
    private Integer status;
    private GrabListRule grabListRule;
    private String ruleName;//规则名称
    private GlobalNode globalNode;
    private String replaceRule;//正则剔除规则
    */


    public String getReplaceRule() {
        return this.getString("replaceRule");
    }

    public void setReplaceRule(String replaceRule) {
        this.put("replaceRule",replaceRule);
    }

    public String getTitleCssPath() {
        return this.getString("titleCssPath");
    }

    public void setTitleCssPath(String titleCssPath) {
        this.put("titleCssPath", titleCssPath);
    }


    public String getDescCssPath() {
        return this.getString("descCssPath");
    }

    public void setDescCssPath(String descCssPath) {
        this.put("descCssPath", descCssPath);
    }

    public String getConCssPath() {
        return this.getString("conCssPath");
    }

    public void setConCssPath(String conCssPath) {
        this.put("conCssPath", conCssPath);
    }

    public String getConCssPath1() {
        return this.getString("conCssPath1");
    }

    public void setConCssPath1(String conCssPath1) {
        this.put("conCssPath1", conCssPath1);
    }

    public String getConCssPath2() {
        return this.getString("conCssPath2");
    }

    public void setConCssPath2(String conCssPath2) {
        this.put("conCssPath2", conCssPath2);
    }

    public String getReplaceCssPath() {
        return this.getString("replaceCssPath");
    }

    public void setReplaceCssPath(String replaceCssPath) {
        this.put("replaceCssPath", replaceCssPath);
    }

    public String getSouCssPath() {
        return this.getString("souCssPath");
    }

    public void setSouCssPath(String souCssPath) {
        this.put("souCssPath", souCssPath);
    }

    public String getImgCssPath() {
        return this.getString("imgCssPath");
    }

    public void setImgCssPath(String imgCssPath) {
        this.put("imgCssPath", imgCssPath);
    }

    public String getVideoCssPath() {
        return this.getString("videoCssPath");
    }

    public void setVideoCssPath(String videoCssPath) {
        this.put("videoCssPath", videoCssPath);
    }

    public String getAuthorCssPath() {
        return this.getString("authorCssPath");
    }

    public void setAuthorCssPath(String authorCssPath) {
        this.put("authorCssPath", authorCssPath);
    }

    public String getKeywordCssPath() {
        return this.getString("keywordCssPath");
    }

    public void setKeywordCssPath(String keywordCssPath) {
        this.put("keywordCssPath", keywordCssPath);
    }

    public String getTestUrl() {
        return this.getString("testUrl");
    }

    public void setTestUrl(String testUrl) {
        this.put("testUrl", testUrl);
    }

    public Integer getStatus() {
        return this.getInt("status");
    }

    public void setStatus(Integer status) {
        this.put("status", status);
    }

    public GrabListRule getGrabListRule() {
        return getAVObject("grabListRuleObj");
    }

    public void setGrabListRule(GrabListRule grabListRule) {
        this.put("grabListRuleObj", grabListRule);
    }

    public String getRuleName() {
        return this.getString("ruleName");
    }

    public void setRuleName(String ruleName) {
        this.put("ruleName", ruleName);
    }

    public GlobalNode getGlobalNode() {
        return this.getAVObject("nodeObj");
    }

    public void setGlobalNode(GlobalNode globalNode) {
        this.put("nodeObj",globalNode);
    }



    @Override
    public String toString() {
        Map result = new HashMap();
        result.put("objectId", getObjectId());
        result.put("titleCssPath", getTitleCssPath());
        result.put("descCssPath", getDescCssPath());
        result.put("conCssPath", getConCssPath());
        result.put("replaceCssPath", getReplaceCssPath());
        result.put("souCssPath", getSouCssPath());
        result.put("imgCssPath", getImgCssPath());
        result.put("videoCssPath", getVideoCssPath());
        result.put("imgCssPath", getImgCssPath());
        result.put("authorCssPath", getAuthorCssPath());
        result.put("keywordCssPath", getKeywordCssPath());
        result.put("testUrl", getTestUrl());
        result.put("status", getStatus());
        return JSON.toJSONString(result);
    }
}
