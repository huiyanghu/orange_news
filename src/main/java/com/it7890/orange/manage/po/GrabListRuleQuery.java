package com.it7890.orange.manage.po;

/**
 * Created by Administrator on 2017/6/9.
 */
public class GrabListRuleQuery {
    private String objectId;
    private String ruleName;     //规则名称
    private String publicationObjectId;//媒体id
    private String nodeObjectId;      //节点id
    private String channelObjectId;   //渠道id
    private String topicObjectId;     //话题id
    private String languageObjectId;
    private String countryObjectId;
    private String cssPath;
    private String siteUrl;
    private String countryCode;
    private String findPre;
    private String constant;
    private String keywords;
    private String titlePicCssPath;
    private String nextPageCssPath;
    private Integer grabTime;
    private Integer status;
    private Integer listStatus;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getPublicationObjectId() {
        return publicationObjectId;
    }

    public void setPublicationObjectId(String publicationObjectId) {
        this.publicationObjectId = publicationObjectId;
    }

    public String getNodeObjectId() {
        return nodeObjectId;
    }

    public void setNodeObjectId(String nodeObjectId) {
        this.nodeObjectId = nodeObjectId;
    }

    public String getChannelObjectId() {
        return channelObjectId;
    }

    public void setChannelObjectId(String channelObjectId) {
        this.channelObjectId = channelObjectId;
    }

    public String getTopicObjectId() {
        return topicObjectId;
    }

    public void setTopicObjectId(String topicObjectId) {
        this.topicObjectId = topicObjectId;
    }

    public String getLanguageObjectId() {
        return languageObjectId;
    }

    public void setLanguageObjectId(String languageObjectId) {
        this.languageObjectId = languageObjectId;
    }

    public String getCountryObjectId() {
        return countryObjectId;
    }

    public void setCountryObjectId(String countryObjectId) {
        this.countryObjectId = countryObjectId;
    }

    public String getCssPath() {
        return cssPath;
    }

    public void setCssPath(String cssPath) {
        this.cssPath = cssPath;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getFindPre() {
        return findPre;
    }

    public void setFindPre(String findPre) {
        this.findPre = findPre;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTitlePicCssPath() {
        return titlePicCssPath;
    }

    public void setTitlePicCssPath(String titlePicCssPath) {
        this.titlePicCssPath = titlePicCssPath;
    }

    public String getNextPageCssPath() {
        return nextPageCssPath;
    }

    public void setNextPageCssPath(String nextPageCssPath) {
        this.nextPageCssPath = nextPageCssPath;
    }

    public Integer getGrabTime() {
        return grabTime;
    }

    public void setGrabTime(Integer grabTime) {
        this.grabTime = grabTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getListStatus() {
        return listStatus;
    }

    public void setListStatus(Integer listStatus) {
        this.listStatus = listStatus;
    }
}
