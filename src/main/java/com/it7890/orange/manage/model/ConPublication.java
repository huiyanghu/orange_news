package com.it7890.orange.manage.model;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.HashMap;
import java.util.Map;

/**
 * The persistent class for the con_publications database table.
 */
@AVClassName("con_publications")
public class ConPublication extends AVObject {
    private static final long serialVersionUID = 1L;

    //TODO 不一样的字段
    //	private String country;
    //	private int id;
    //	private String createtime;

   /* private String name;
    private String url;
    private String hbid;
    private String description;
    private int createuid;
    private float latitude;
    private float longitude;
    private int channelid;
    private int countryid;
    private String logourl;*/

//    public String getCountry() {
//        return getString(""); country;
//    }
//
//    public void setCountry(String country) {
//        this.put("", );country = country;
//    }
//    public int getId() {
//        return getString(""); this.put("", );id;
//    }
//
//    public void setId(int id) {
//        this.put("", );id = id;
//    }
//    public String getCreatetime() {
//        return getString(""); createtime;
//    }
//
//    public void setCreatetime(String createtime) {
//        this.put("", );createtime = createtime;
//    }


    public ConPublication() {
        super();
    }


    public int getId() {
        return getInt("id");
    }

    public void setId(int id) {
        this.put("id", id);
    }


    public int getChannelid() {
        return getInt("channelid");
    }

    public void setChannelid(int channelid) {
        this.put("channelid", channelid);
    }

    public int getCountryid() {
        return getInt("countryid");
    }

    public void setCountryid(int countryid) {
        this.put("countryid", countryid);
    }

    public int getCreateuid() {
        return getInt("createuid");
    }

    public void setCreateuid(int createuid) {
        this.put("createuid", createuid);
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

    //TODO float类型的获取方法
    public float getLatitude() {
        return getInt("latitude");
    }

    public void setLatitude(float latitude) {
        this.put("latitude", latitude);
    }

    public String getLogourl() {
        return getString("logourl");
    }

    public void setLogourl(String logourl) {
        this.put("logourl", logourl);
    }

    public float getLongitude() {
        return getInt("longitude");
    }

    public void setLongitude(float longitude) {
        this.put("longitude", longitude);
    }

    public String getName() {
        return getString("name");
    }

    public void setName(String name) {
        this.put("name", name);
    }

    public String getUrl() {
        return getString("url");
    }

    public void setUrl(String url) {
        this.put("url", url);
    }

    @Override
    public String toString() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("name", this.getString("name"));
        result.put("url", this.getString("url"));
        result.put("hbid", this.getString("hbid"));
        result.put("description", this.getString("description"));
        result.put("createuid", this.getInt("createuid"));
        result.put("id", this.getInt("id"));
        result.put("latitude", this.getInt("latitude"));
        result.put("longitude", this.getInt("longitude"));
        result.put("channelid", this.getInt("channelid"));
        result.put("countryid", this.getInt("countryid"));
        result.put("logourl", this.getString("logourl"));
        result.put("objectId", this.getObjectId());
        result.put("createdAt", this.getCreatedAt());
        return JSON.toJSONString(result);
    }

}