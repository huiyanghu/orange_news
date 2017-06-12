package com.it7890.orange.manage.model;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Astro on 17/5/16.
 */
public class GrabDetailRule extends AVObject {
    /*public GrabDetailRule() {
        super();
    }*/


    /*private String objectId;
    private String titleCssPath;    //文章标题区域规则
    private String descCssPath;     //文章描述区域规则
    private String conCssPath;      //文章内容区域规则
    private String replaceCssPath;  //剔除内容区域规则
    private String souCssPath;      //来源区域规则
    private String imgCssPath;      //图片规则
    private String videoCssPath;    //媒体规则
    private String authorCssPath;   //作者规则
    private String keywordCssPath;  //关键字规则
    private String testUrl;         //测试url
    private GrabListRule grabListRule;*/


    public String getTitleCssPath() {
        return getString("titleCssPath");
    }

    public void setTitleCssPath(String titleCssPath) {
        this.put("titleCssPath", titleCssPath);
    }


    public String getDescCssPath() {
        return getString("descCssPath");
    }

    public void setDescCssPath(String descCssPath) {
        this.put("descCssPath", descCssPath);
    }

    public String getConCssPath() {
        return getString("conCssPath");
    }

    public void setConCssPath(String conCssPath) {
        this.put("conCssPath", conCssPath);
    }

    public String getReplaceCssPath() {
        return getString("replaceCssPath");
    }

    public void setReplaceCssPath(String replaceCssPath) {
        this.put("replaceCssPath", replaceCssPath);
    }

    public String getSouCssPath() {
        return getString("souCssPath");
    }

    public void setSouCssPath(String souCssPath) {
        this.put("souCssPath", souCssPath);
    }

    public String getImgCssPath() {
        return getString("imgCssPath");
    }

    public void setImgCssPath(String imgCssPath) {
        this.put("imgCssPath", imgCssPath);
    }

    public String getVideoCssPath() {
        return getString("videoCssPath");
    }

    public void setVideoCssPath(String videoCssPath) {
        this.put("videoCssPath", videoCssPath);
    }

    public String getAuthorCssPath() {
        return getString("authorCssPath");
    }

    public void setAuthorCssPath(String authorCssPath) {
        this.put("authorCssPath", authorCssPath);
    }

    public String getKeywordCssPath() {
        return getString("keywordCssPath");
    }

    public void setKeywordCssPath(String keywordCssPath) {
        this.put("keywordCssPath", keywordCssPath);
    }

    public String getTestUrl() {
        return getString("testUrl");
    }

    public void setTestUrl(String testUrl) {
        this.put("testUrl", testUrl);
    }

    public Integer getStatus() {
        return getInt("status");
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
        return JSON.toJSONString(result);
    }
}
