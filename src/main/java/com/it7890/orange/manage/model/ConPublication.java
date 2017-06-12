package com.it7890.orange.manage.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * The persistent class for the con_publications database table.
 */
@AVClassName("con_publications")
public class ConPublication extends AVObject {
    private static final long serialVersionUID = 1L;


   /* public ConPublication() {
        super();
    }*/
/*
    private ConChannel channel;
    private HbCountrys country;
    private SysUser sysUser;
    private String description;
    private String hbid;
    private Integer latitude;
    private String logourl;
    private Integer longitude;
    private String name;
    private Integer subCount;
    private String url;*/

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

    public SysUser getCreater() {
        return getAVObject("createrObj");
    }

    public void setCreater(SysUser sysUser) {
        this.put("createrObj", sysUser);
    }

    public String getDescription() {
        return getString("description");
    }

    public void setDescription(String description) {
        this.put("description", description);
    }

    public String getHbid() {
        return getString("hbid");
    }

    public void setHbid(String hbid) {
        this.put("hbid", hbid);
    }

    public Integer getLatitude() {
        return getInt("latitude");
    }

    public void setLatitude(Integer latitude) {
        this.put("latitude", latitude);
    }

    public String getLogourl() {
        return "";
    }

    public void setLogourl(String logourl) {

    }

    public Integer getLongitude() {
        return getInt("longitude");
    }

    public void setLongitude(Integer longitude) {
        this.put("longitude", longitude);
    }

    public String getName() {
        return getString("name");
    }

    public void setName(String name) {
        this.put("name", name);
    }

    public Integer getSubCount() {
        return getInt("subCount");
    }

    public void setSubCount(Integer subCount) {
        this.put("subCount", subCount);
    }

    public String getUrl() {
        return getString("url");
    }

    public void setUrl(String url) {
        this.put("url", url);
    }
}