package com.it7890.orange.manage.model;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.HashMap;
import java.util.Map;


/**
 * @author zhoujie@7890it.com
 * @ClassName: HbTopics
 * @Description:
 * @date 2015年10月15日 下午3:54:39
 */
@AVClassName("hb_topics")
public class HbTopics extends AVObject {
//    private int tid;
//    private int topictype;
//    private String ID;
//    private String Name;
//    private String topicicon;
//    private int status;
    public HbTopics() {
    super();
}

    public int getStatus() {
        return getInt("status");
    }

    public void setStatus(int status) {
        this.put("status", status);
    }

    public int getTopictype() {
        return getInt("topictype");
    }

    public void setTopictype(int topictype) {
        this.put("topictype", topictype);
    }

    public String getTopicicon() {
        return getString("topicicon");
    }

    public void setTopicicon(String topicicon) {
        this.put("topicicon", topicicon);
    }

    public int getTid() {
        return getInt("tid");
    }

    public void setTid(int tid) {
        this.put("tid", tid);
    }

    public String getID() {
        return getString("ID");
    }

    public void setID(String iD) {
        this.put("ID", iD);
    }

    public String getName() {
        return getString("Name");
    }

    public void setName(String name) {
        this.put("Name", name);
    }

    @Override
    public String toString() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", this.getInt("status"));
        result.put("topictype", this.getInt("topictype"));
        result.put("tid", this.getInt("tid"));
        result.put("Name", this.getString("Name"));
        result.put("topicicon", this.getString("topicicon"));
        result.put("ID", this.getString("ID"));
        result.put("objectId", this.getObjectId());
        result.put("createdAt", this.getCreatedAt());
        return JSON.toJSONString(result);
    }
}
