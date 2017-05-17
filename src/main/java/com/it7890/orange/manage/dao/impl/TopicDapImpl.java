package com.it7890.orange.manage.dao.impl;

import com.it7890.orange.manage.dao.TopicDao;
import com.it7890.orange.manage.model.HbTopics;
import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVQuery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
@Component
public class TopicDapImpl implements TopicDao {

    @Override
    public List<HbTopics> getAll() {
        List<HbTopics> list = new ArrayList<HbTopics>();
        AVCloudQueryResult result;
        try {
            String cql = "SELECT * FROM hb_topics where status !=-1";
            result =  AVQuery.doCloudQuery(cql, HbTopics.class);
            list = (List<HbTopics>) result.getResults();
        } catch (Exception e) {
        }
//        System.out.println(list.get(1).getName());
        return   list;
    }
}
