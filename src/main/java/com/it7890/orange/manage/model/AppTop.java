package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * Created by Administrator on 2017/5/26.
 */
@AVClassName("AppTop")
public class AppTop extends AVObject {
    /*public AppTop() {
        super();
    }*/
  /*  private ConArticle article;
    private Integer ctype;
    private ConChannel channel;
    private HbCountrys country;
    private SysUser createUser;
    private Integer itype;
    private HbLanguage language;
    private Integer longitude;
    private Integer latitude;
    private ConPublication publication;
    private Integer pushNum;
    private Integer rank;
    private Integer status;
    private AppTopics topics;
*/
    public ConArticle getArticle() {
        return getAVObject("articleObj");
    }

    public void setArticle(ConArticle article) {
        this.put("articleObj", article);
    }

    public Integer getCtype() {
        return getInt("cType");
    }

    public void setCtype(Integer ctype) {
        this.put("cType", ctype);
    }

    public ConChannel getChannel() {
        return getAVObject("channelObj");
    }

    public void setChannel(ConChannel channel) {
        this.put("channelObj", channel);
    }

    public HbCountrys getCountry() {
        return getAVObject("countryObj");
    }

    public void setCountry(HbCountrys country) {
        this.put("countryObj", country);
    }

    public SysUser getCreateUser() {
        return getAVObject("createUserObj");
    }

    public void setCreateUser(SysUser createUser) {
        this.put("createUserObj", createUser);
    }

    public Integer getItype() {
        return getInt("iType");
    }

    public void setItype(Integer itype) {
        this.put("iType", itype);
    }

    public HbLanguage getLanguage() {
        return getAVObject("languagesObj");
    }

    public void setLanguage(HbLanguage language) {
        this.put("languagesObj", language);
    }

    public Integer getLongitude() {
        return getInt("longitude");
    }

    public void setLongitude(Integer longitude) {
        this.put("longitude", longitude);
    }

    public Integer getLatitude() {
        return getInt("latitude");
    }

    public void setLatitude(Integer latitude) {
        this.put("latitude", latitude);
    }

    public ConPublication getPublication() {
        return getAVObject("publicationObj");
    }

    public void setPublication(ConPublication publication) {
        this.put("publicationObj", publication);
    }

    public Integer getPushNum() {
        return getInt("pushNum");
    }

    public void setPushNum(Integer pushNum) {
        this.put("pushNum", pushNum);
    }

    public Integer getRank() {
        return getInt("rank");
    }

    public void setRank(Integer rank) {
        this.put("rank", rank);
    }

    public Integer getStatus() {
        return getInt("status");
    }

    public void setStatus(Integer status) {
        this.put("status", status);
    }

    public AppTopics getTopics() {
        return getAVObject("topicsObj");
    }

    public void setTopics(AppTopics topics) {
        this.put("topicsObj", topics);
    }
}
