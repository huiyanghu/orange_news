package com.it7890.orange.manage.model;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoujie@7890it.com
 * @ClassName: HbCountrys
 * @Description: 国家相关对象
 * @date 2015年10月15日 下午5:13:02
 */
@AVClassName("hb_countrys")
public class HbCountrys extends AVObject {

    public HbCountrys(){
        super();
    }

    //TODO 不一样的字段
    //    private int cid;
    //    private String topics;
    /*private String cnname;
    private String enname;
    private String shortname;
    private String countryicon;
    private String code;
    private String continentid;
    private String continent;
    private int isopen;
    private int langid;
    private int status;*/


    //    public String getTopics() {
//        return getString("topics");
//    }
//
//    public void setTopics(String topics) {
//        this.put("", );topics = topics;
//    }
    //    public int getCid() {
//        return getInt("cid");
//    }
//
//    public void setCid(int cid) {
//        this.put("", );cid = cid;
//    }


    public int getStatus() {
        return getInt("status");
    }

    public void setStatus(int status) {
        this.put("status", status);
    }

    public int getLangid() {
        return getInt("langid");
    }

    public void setLangid(int langid) {
        this.put("langid", langid);
    }

    public String getCountryicon() {
        return getString("countryicon");
    }

    public void setCountryicon(String countryicon) {
        this.put("countryicon", countryicon);
    }

    public String getShortname() {
        return getString("shortname");
    }

    public void setShortname(String shortname) {
        this.put("shortname", shortname);
    }

    public String getCnname() {
        return getString("cnname");
    }

    public void setCnname(String cnname) {
        this.put("cnname", cnname);
    }

    public String getEnname() {
        return getString("enname");
    }

    public void setEnname(String enname) {
        this.put("enname", enname);
    }

    public String getCountryCode() {
        return getString("countryCode");
    }

    public void setCountryCode(String countryCode) {
        this.put("countryCode", countryCode);
    }

    public String getContinentid() {
        return getString("continentid");
    }

    public void setContinentid(String continentid) {
        this.put("continentid", continentid);
    }

    public String getContinent() {
        return getString("continent");
    }

    public void setContinent(String continent) {
        this.put("continent", continent);
    }

    public int getIsopen() {
        return getInt("isopen");
    }

    public void setIsopen(int isopen) {
        this.put("isopen", isopen);
    }

    @Override
    public String toString() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("cnname", this.getString("cnname"));
        result.put("enname", this.getString("enname"));
        result.put("shortname", this.getString("shortname"));
        result.put("countryicon", this.getString("countryicon"));
        result.put("countryCode", this.getString("countryCode"));
        result.put("continentid", this.getString("continentid"));
        result.put("continent", this.getString("continent"));
        result.put("isopen", this.getInt("isopen"));
        result.put("langid", this.getInt("langid"));
        result.put("status", this.getInt("status"));
        result.put("objectId", this.getObjectId());
        result.put("createdAt", this.getCreatedAt());
        return JSON.toJSONString(result);
    }


}
