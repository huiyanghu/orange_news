package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.AppTopicsDao;
import com.it7890.orange.manage.model.AppTopics;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gg
 * @create 2017/6/7
 **/
@Component
public class AppTopicsDaoImpl implements AppTopicsDao {
    @Override
    public List<AVObject> getListByCId(String cid,String hid) {
        AVQuery avQuery = new AVQuery("AppTopics");
        avQuery.include("topicIconFile");
        avQuery.include("HbTopicsObj");
        List<AVObject> ls = new ArrayList<>();
        if (StringUtils.isNotBlank(hid)){
            avQuery.whereEqualTo("HbTopicsObj",AVObject.createWithoutData("hb_topics",hid));
        }
        if (StringUtils.isNotBlank(cid)){
            avQuery.whereEqualTo("countryObj", AVObject.createWithoutData("hb_countrys", cid));
        }
        try {
            ls = avQuery.find();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return ls;
    }

    public List<Map> getAppTopicsList() throws AVException {
        AVQuery<AppTopics> query = new AVQuery("AppTopics");
        List<AppTopics> appTopicsList = query.find();
        List<Map> list = new ArrayList<>();
        Map map;
        for (AppTopics appTopics : appTopicsList) {
            map=new HashMap();
            map.put("objectId", appTopics.getObjectId());
            map.put("topicName", appTopics.getTopicName());
            list.add(map);
        }
        return list;
    }

    @Override
    public void delByCidAndHid(String cid, String hid) {
        AVQuery query = new AVQuery("AppTopics");
        query.whereEqualTo("countryObj",AVObject.createWithoutData("hb_countrys",cid));
        query.whereEqualTo("HbTopicsObj",AVObject.createWithoutData("hb_topics",hid));
        try {
            List<AVObject> ls =  query.find();
            ls.get(0).delete();
        } catch (AVException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveOrUpdate(AVObject avObject) {
        try {
            avObject.save();
        } catch (AVException e) {
            e.printStackTrace();
        }
    }

}
