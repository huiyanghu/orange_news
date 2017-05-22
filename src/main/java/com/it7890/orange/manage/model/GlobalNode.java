package com.it7890.orange.manage.model;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/19.
 */
@AVClassName("GlobalNode")
public class GlobalNode extends AVObject {

    public GlobalNode() {
        super();
    }

//    private int id;
//    private String nodecode;
//    private String nodename;

    public String getNodecode() {
        return getString("nodecode");
    }

    public void setNodecode(String nodecode) {
        this.put("nodecode", nodecode);
    }

    public String getNodename() {
        return getString("nodename");
    }

    public void setNodename(String nodename) {
        this.put("nodename", nodename);
    }

    public int getId() {
        return getInt("id");
    }

    public void setId(int id) {
        this.put("id", id);
    }

    @Override
    public String toString() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("id", this.getInt("id"));
        result.put("nodecode", this.getString("nodecode"));
        result.put("nodename", this.getString("nodename"));
        result.put("objectId", this.getObjectId());
        result.put("createdAt", this.getCreatedAt());
        return JSON.toJSONString(result);
    }
}
