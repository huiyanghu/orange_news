package com.it7890.orange.manage.dao.impl;

import com.it7890.orange.manage.dao.PublicationDao;
import com.it7890.orange.manage.model.ConPublication;
import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVQuery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
@Component
public class PublicationDaoImpl implements PublicationDao {
    @Override
    public List<ConPublication> getAll() {
        List<ConPublication> list = new ArrayList<>();
        AVCloudQueryResult result;
        try {
            String cql = "select * from con_publications";
            result =  AVQuery.doCloudQuery(cql, ConPublication.class);
            list = (List<ConPublication>) result.getResults();
        } catch (Exception e) {
        }
        return   list;
    }
}
