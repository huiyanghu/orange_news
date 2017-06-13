package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * Created by Astro on 17/5/16.
 */
@AVClassName("GrabListRule")
public class GrabListRule extends AVObject {
    /*
    public GrabListRule(){
        super();
    }
    private String objectId;
    private String ruleName;     //规则名称
    private String publicationId;//媒体id
    private String nodeId;      //节点id
    private String channelId;   //渠道id
    private String cssPath;     //目标区域规则
    private String siteUrl;     //源url
    private String languageId;  //语言id
    private String topicId;     //话题id
    private String findPre;     //目标文章url规则
    private String constant;    //编码
    private String keywords;    //关键字
    private String titlePicCssPath;//标题图片规则
    private String nextPageCssPath;//下一页规则
    private Integer grabTime;       //抓取周期秒

    private ConPublication conPublication;
    private GlobalNode globalNode;
    private ConChannel conChannel;
    private HbLanguage hbLanguage;




    private Integer status;//规则状态
    private Integer listStatus;//列表文章状态
    private AppTopics topics;
    private HbCountrys country;
     */


    public AppTopics getTopics() {
        return getAVObject("topicObj");
    }

    public void setTopics(AppTopics topics) {
        this.put("topicObj",topics);
    }

    public String getRuleName() {
        return this.getString("ruleName");
    }

    public void setRuleName(String ruleName) {
        this.put("ruleName", ruleName);
    }


    public String getCssPath() {
        return this.getString("cssPath");
    }

    public void setCssPath(String cssPath) {
        this.put("cssPath", cssPath);
    }

    public String getSiteUrl() {
        return this.getString("siteUrl");
    }

    public void setSiteUrl(String siteUrl) {
        this.put("siteUrl", siteUrl);
    }


    public String getFindPre() {
        return this.getString("findPre");
    }

    public void setFindPre(String findPre) {
        this.put("findPre", findPre);
    }

    public String getConstant() {
        return this.getString("constant");
    }

    public void setConstant(String constant) {
        this.put("constant", constant);
    }

    public String getKeywords() {
        return this.getString("keywords");
    }

    public void setKeywords(String keywords) {
        this.put("keywords", keywords);
    }

    public String getTitlePicCssPath() {
        return this.getString("titlePicCssPath");
    }

    public void setTitlePicCssPath(String titlePicCssPath) {
        this.put("titlePicCssPath", titlePicCssPath);
    }

    public String getNextPageCssPath() {
        return this.getString("nextPageCssPath");
    }

    public void setNextPageCssPath(String nextPageCssPath) {
        this.put("nextPageCssPath", nextPageCssPath);
    }

    public Integer getGrabTime() {
        return this.getInt("grabTime");
    }

    public void setGrabTime(Integer grabTime) {
        this.put("grabTime", grabTime);
    }

    public ConPublication getConPublication() {
        return this.getAVObject("publicationObj");
    }

    public void setConPublication(ConPublication conPublication) {
        this.put("publicationObj", conPublication);
    }

    public GlobalNode getGlobalNode() {
        return this.getAVObject("nodeObj");
    }

    public void setGlobalNode(GlobalNode globalNode) {
        this.put("nodeObj", globalNode);
    }

    public ConChannel getConChannel() {
        return this.getAVObject("channelObj");
    }

    public void setConChannel(ConChannel conChannel) {
        this.put("channelObj", conChannel);
    }

    public HbLanguage getHbLanguage() {
        return this.getAVObject("languageObj");
    }

    public void setHbLanguage(HbLanguage hbLanguage) {
        this.put("languageObj", hbLanguage);
    }



    public Integer getStatus() {
        return getInt("status");
    }

    public void setStatus(Integer status) {
        this.put("status", status);
    }

    public Integer getListStatus() {
        return getInt("listStatus");
    }

    public void setListStatus(Integer listStatus) {
        this.put("listStatus", listStatus);
    }

    public HbCountrys getCountry() {
        return getAVObject("countryObj");
    }

    public void setCountry(HbCountrys country) {
        this.put("countryObj",country);
    }
}
