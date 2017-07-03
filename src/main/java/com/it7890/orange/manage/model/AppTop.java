package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.Date;

/**
 * Created by Administrator on 2017/5/26.
 */
@AVClassName("AppTop")
public class AppTop extends AVObject {
    /*public AppTop() {
        super();
    }*/
  /*  private ConArticle article;//
    private Integer ctype;//
    private ConChannel channel;
    private HbCountrys country;
    private SysUser createUser;
    private Integer itype;//
    private HbLanguage language;//
    private Integer longitude;
    private Integer latitude;
    private ConPublication publication;
    private Integer pushNum;
    private Integer rank;
    private Integer status;
    private AppTopics topics;
    private AppAdvert advert;
    private String title;
    private String url;
    private Date subTime;
    private String titlePic;
    private String countryCode;
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

    public AppAdvert getAdvert() {
        return getAVObject("advertObj");
    }

    public void setAdvert(AppAdvert advert) {
        this.put("advertObj", advert);
    }

    public String getTitle() {
        return getString("title");
    }

    public void setTitle(String title) {
        this.put("title", title);
    }

    public String getUrl() {
        return getString("url");
    }

    public void setUrl(String url) {
        this.put("url", url);
    }

    public Date getSubTime() {
        return getDate("subTime");
    }

    public void setSubTime(Date subTime) {
        this.put("subTime", subTime);
    }

    public String getTitlePic() {
        return getString("titlePic");
    }

    public void setTitlePic(String titlePic) {
        this.put("titlePic", titlePic);
    }

    public String getCountryCode() {
        return getString("countryCode");
    }

    public void setCountryCode(String countryCode) {
        this.put("countryCode",countryCode);
    }
}
