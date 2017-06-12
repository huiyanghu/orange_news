package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.PublicationDao;
import com.it7890.orange.manage.model.ConPublication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            result = AVQuery.doCloudQuery(cql, ConPublication.class);
            list = (List<ConPublication>) result.getResults();
        } catch (Exception e) {
        }
        return list;
    }

    public List<Map> getPublictionList() throws AVException {
        AVQuery<ConPublication> query = new AVQuery("con_publications");
        List<ConPublication> conPublicationList = query.find();
        List<Map> list = new ArrayList<>();
        Map map;
        for (ConPublication conPublication : conPublicationList) {
            map = new HashMap();
            map.put("objectId", conPublication.getObjectId());
            map.put("publictionName", conPublication.getName());
            list.add(map);
        }
        return list;
    }
}
