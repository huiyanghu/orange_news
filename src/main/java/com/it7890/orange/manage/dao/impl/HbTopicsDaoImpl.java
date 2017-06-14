package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.HbTopicsDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gg
 * @create 2017/6/13
 **/
@Component
public class HbTopicsDaoImpl implements HbTopicsDao {
    @Override
    public List<AVObject> getList() {
        AVQuery avQuery = new AVQuery("hb_topics");
        avQuery.include("topicIconFile");
        List<AVObject> ls = new ArrayList<>();
        try {
            ls = avQuery.find();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return ls;
    }

    @Override
    public AVObject getById(String hid) {
        AVObject avObject = new AVObject();
        AVQuery avQuery = new AVQuery("hb_topics");
        avQuery.include("topicIconFile");
        try {
            avObject = avQuery.get(hid);
        } catch (AVException e) {
            e.printStackTrace();
        }
        return avObject;
    }
}
