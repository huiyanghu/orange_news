package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.PublicationDao;
import com.it7890.orange.manage.model.ConPublication;
import com.it7890.orange.manage.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */
@Service
public class PublicationServiceImpl implements PublicationService {
    @Autowired
    PublicationDao publicationDao;

    public List<Map> getPublictionList() throws AVException {
        AVQuery<ConPublication> query = new AVQuery("con_publications");
        List<ConPublication> publicationList = query.find();
        List<Map> list = new ArrayList<>();
        Map map ;
        for (ConPublication publication : publicationList) {
            map = new HashMap();
            map.put("objectId", publication.getObjectId());
            map.put("publicationName", publication.getName());
            list.add(map);
        }
        return list;
    }
}
