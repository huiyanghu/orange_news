package com.it7890.orange.manage.model;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.HashMap;
import java.util.Map;

/**
 * The persistent class for the hb_languages database table.
 */
@AVClassName("hb_languages")
public class HbLanguage extends AVObject {
    private static final long serialVersionUID = 1L;

    public HbLanguage() {
        super();
    }

   /* private int id;
    private String hbcode;
    private String hbid;
    private String hbname;
    //语言的本地名称
    private String localname;
    //语言的中文名称
    private String cnname;
    private int status;*/
    //TODO 不一样的字段
//    private int isopen;

//    public int getIsopen() {
//        return getString(""); isopen;
//    }
//    public void setIsopen(int isopen) {
//        this.put("", );isopen = isopen;
//    }

    public int getStatus() {
        return getInt("status");
    }

    public void setStatus(int status) {
        this.put("status", status);
    }

    public String getLocalname() {
        return getString("localname");
    }

    public void setLocalname(String localname) {
        this.put("localname", localname);
    }

    public String getCnname() {
        return getString("cnname");
    }

    public void setCnname(String cnname) {
        this.put("cnname", cnname);
    }

    public int getId() {
        return getInt("id");
    }

    public void setId(int id) {
        this.put("id", id);
    }

    public String getHbcode() {
        return getString("hbcode");
    }

    public void setHbcode(String hbcode) {
        this.put("hbcode", hbcode);
    }

    public String getHbid() {
        return getString("hbid");
    }

    public void setHbid(String hbid) {
        this.put("hbid", hbid);
    }

    public String getHbname() {
        return getString("hbname");
    }

    public void setHbname(String hbname) {
        this.put("hbname", hbname);
    }

    @Override
    public String toString() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("id", this.getInt("id"));
        result.put("hbcode", this.getString("hbcode"));
        result.put("hbid", this.getString("hbid"));
        result.put("hbname", this.getString("hbname"));
        result.put("localname", this.getString("localname"));
        result.put("cnname", this.getString("cnname"));
        result.put("status", this.getInt("status"));
        result.put("objectId", this.getObjectId());
        result.put("createdAt", this.getCreatedAt());
        return JSON.toJSONString(result);
    }

}