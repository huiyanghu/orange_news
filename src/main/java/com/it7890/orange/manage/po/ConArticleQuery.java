package com.it7890.orange.manage.po;

/**
 * Created by Administrator on 2017/6/2.
 */
public class ConArticleQuery implements java.io.Serializable {
    private String objectId;
    private String countryCode;
    private String publicationObjectId;
    private String languageObjectId;
    private String channelObjectId;
    private Integer attr;
    private Integer status;
    private String keywords;
    private String topicObjectId;
    private String startTime;
    private String endTime;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPublicationObjectId() {
        return publicationObjectId;
    }

    public void setPublicationObjectId(String publicationObjectId) {
        this.publicationObjectId = publicationObjectId;
    }

    public String getLanguageObjectId() {
        return languageObjectId;
    }

    public void setLanguageObjectId(String languageObjectId) {
        this.languageObjectId = languageObjectId;
    }

    public String getChannelObjectId() {
        return channelObjectId;
    }

    public void setChannelObjectId(String channelObjectId) {
        this.channelObjectId = channelObjectId;
    }

    public Integer getAttr() {
        return attr;
    }

    public void setAttr(Integer attr) {
        this.attr = attr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTopicObjectId() {
        return topicObjectId;
    }

    public void setTopicObjectId(String topicObjectId) {
        this.topicObjectId = topicObjectId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    @Override
    public String toString() {
        return "ConArticleQuery{" +
            "objectId='" + objectId + '\'' +
            ", countryCode='" + countryCode + '\'' +
            ", publicationObjectId='" + publicationObjectId + '\'' +
            ", languageObjectId='" + languageObjectId + '\'' +
            ", channelObjectId='" + channelObjectId + '\'' +
            ", attr=" + attr +
            ", status=" + status +
            ", keywords='" + keywords + '\'' +
            ", topicObjectId='" + topicObjectId + '\'' +
            ", startTime='" + startTime + '\'' +
            ", endTime='" + endTime + '\'' +
            '}';
    }
}
