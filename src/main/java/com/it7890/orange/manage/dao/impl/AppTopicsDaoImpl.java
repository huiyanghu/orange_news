package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.AppTopicsDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gg
 * @create 2017/6/7
 **/
@Component
public class AppTopicsDaoImpl implements AppTopicsDao {
    @Override
    public List<AVObject> getListByCId(String cid) {
        AVQuery avQuery = new AVQuery("AppTopics");
        List<AVObject> ls = new ArrayList<>();
        avQuery.whereEqualTo("countryObj",AVObject.createWithoutData("hb_countrys",cid));
        try {
            ls = avQuery.find();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return ls;
    }
}
