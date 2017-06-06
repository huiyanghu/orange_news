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

    private String codes;
    private String name;
    private String remark;
    private Integer status;


    public String getCodes() {
        return getString("codes");
    }

    public void setCodes(String codes) {
        this.put("codes", codes);
    }

    public String getName() {
        return getString("name");
    }

    public void setName(String name) {
        this.put("name", name);
    }

    public String getRemark() {
        return getString("remark");
    }

    public void setRemark(String remark) {
        this.put("remark", remark);
    }

    public Integer getStatus() {
        return getInt("status");
    }

    public void setStatus(Integer status) {
        this.put("status", status);
    }

    @Override
    public String toString() {
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("codes", getCodes());
        result.put("createdAt", getCreatedAt());
        result.put("name", getName());
        result.put("objectId", getObjectId());
        result.put("remark", getRemark());
        result.put("status", getStatus());
        result.put("updatedAt", getUpdatedAt());
        return JSON.toJSONString(result);
    }

}