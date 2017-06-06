package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/5.
 */
@AVClassName("AppLockScreen")
public class AppLockScreen extends AVObject {
    public AppLockScreen() {
        super();
    }

    private String abstracts;
    private Integer attr;
    private AVObject channelObj;
    private String countryCode;
    private AVObject countryObj;
    private AVObject createUserObj;
    private Date createdAt;
    private Date dataTime;
    private String img;
    private Double imgSize;
    private Integer isScroll;
    private Integer isShow;
    private AVObject languageObj;
    private String objectId;
    private Integer rank;
    private String sourceId;
    private String src;
    private String title;
    private AVObject topicsObj;
    private Integer type;
    private Date updatedAt;
    private String versionId;

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public Integer getAttr() {
        return attr;
    }

    public void setAttr(Integer attr) {
        this.attr = attr;
    }

    public AVObject getChannelObj() {
        return channelObj;
    }

    public void setChannelObj(AVObject channelObj) {
        this.channelObj = channelObj;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public AVObject getCountryObj() {
        return countryObj;
    }

    public void setCountryObj(AVObject countryObj) {
        this.countryObj = countryObj;
    }

    public AVObject getCreateUserObj() {
        return createUserObj;
    }

    public void setCreateUserObj(AVObject createUserObj) {
        this.createUserObj = createUserObj;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getImgSize() {
        return imgSize;
    }

    public void setImgSize(Double imgSize) {
        this.imgSize = imgSize;
    }

    public Integer getIsScroll() {
        return isScroll;
    }

    public void setIsScroll(Integer isScroll) {
        this.isScroll = isScroll;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public AVObject getLanguageObj() {
        return languageObj;
    }

    public void setLanguageObj(AVObject languageObj) {
        this.languageObj = languageObj;
    }

    @Override
    public String getObjectId() {
        return objectId;
    }

    @Override
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AVObject getTopicsObj() {
        return topicsObj;
    }

    public void setTopicsObj(AVObject topicsObj) {
        this.topicsObj = topicsObj;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }
}
