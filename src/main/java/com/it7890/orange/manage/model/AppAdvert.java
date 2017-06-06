package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/5.
 */
@AVClassName("AppAdvert")
public class AppAdvert extends AVObject {
    public AppAdvert() {
        super();
    }

    private String adApk;
    private Integer adApkSize;
    private String adContent;
    private String adDesc;
    private String adIcon;
    private String adImg;
    private String adName;
    private String adPackage;
    private String adTitle;
    private AVObject advertTypeObj;
    private String adUrl;
    private AVObject applicationObj;
    private ConArticle articleObj;
    private Integer conType;//内容类型0=广告、1=应用、2=游戏
    private String countryCode;
    private AVObject createUserObj;
    private Date createdAt;
    private Double dividePrice;//分成金额
    private Date endTime;
    private String jointCom;
    private String jointId;
    private Integer jointType;//合作类型0=CPA、1=CPC、2=CPM、3=CPD
    private HbLanguage languageObj;
    private String objectId;
    private Integer starlv;
    private Date startTime;
    private Integer status;
    private Date updatedAt;
    private Integer urlType;

    public String getAdApk() {
        return adApk;
    }

    public void setAdApk(String adApk) {
        this.adApk = adApk;
    }

    public Integer getAdApkSize() {
        return adApkSize;
    }

    public void setAdApkSize(Integer adApkSize) {
        this.adApkSize = adApkSize;
    }

    public String getAdContent() {
        return adContent;
    }

    public void setAdContent(String adContent) {
        this.adContent = adContent;
    }

    public String getAdDesc() {
        return adDesc;
    }

    public void setAdDesc(String adDesc) {
        this.adDesc = adDesc;
    }

    public String getAdIcon() {
        return adIcon;
    }

    public void setAdIcon(String adIcon) {
        this.adIcon = adIcon;
    }

    public String getAdImg() {
        return adImg;
    }

    public void setAdImg(String adImg) {
        this.adImg = adImg;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdPackage() {
        return adPackage;
    }

    public void setAdPackage(String adPackage) {
        this.adPackage = adPackage;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public AVObject getAdvertTypeObj() {
        return advertTypeObj;
    }

    public void setAdvertTypeObj(AVObject advertTypeObj) {
        this.advertTypeObj = advertTypeObj;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    public AVObject getApplicationObj() {
        return applicationObj;
    }

    public void setApplicationObj(AVObject applicationObj) {
        this.applicationObj = applicationObj;
    }

    public ConArticle getArticleObj() {
        return getAVObject("articleObj");
    }

    public void setArticleObj(ConArticle articleObj) {
        this.put("articleObj",articleObj);
    }

    public Integer getConType() {
        return conType;
    }

    public void setConType(Integer conType) {
        this.conType = conType;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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

    public Double getDividePrice() {
        return dividePrice;
    }

    public void setDividePrice(Double dividePrice) {
        this.dividePrice = dividePrice;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getJointCom() {
        return jointCom;
    }

    public void setJointCom(String jointCom) {
        this.jointCom = jointCom;
    }

    public String getJointId() {
        return jointId;
    }

    public void setJointId(String jointId) {
        this.jointId = jointId;
    }

    public Integer getJointType() {
        return jointType;
    }

    public void setJointType(Integer jointType) {
        this.jointType = jointType;
    }

    public HbLanguage getLanguageObj() {
        return getAVObject("languageObj");
    }

    public void setLanguageObj(HbLanguage languageObj) {
        this.put("languageObj", languageObj);
    }

    @Override
    public String getObjectId() {
        return objectId;
    }

    @Override
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Integer getStarlv() {
        return starlv;
    }

    public void setStarlv(Integer starlv) {
        this.starlv = starlv;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUrlType() {
        return urlType;
    }

    public void setUrlType(Integer urlType) {
        this.urlType = urlType;
    }
}
