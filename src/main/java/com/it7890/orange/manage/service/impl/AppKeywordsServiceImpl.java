package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.dao.AppKeywordsDao;
import com.it7890.orange.manage.model.AppKeywords;
import com.it7890.orange.manage.po.AppKeywordsQuery;
import com.it7890.orange.manage.service.AppKeywordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/28.
 */
@Service
public class AppKeywordsServiceImpl implements AppKeywordsService {
    @Autowired
    AppKeywordsDao appKeywordsDao;

    @Override
    public List<Map> getKeywordsList(AppKeywordsQuery appKeywordsQuery) throws AVException {
        List<AppKeywords> appKeywordsList = appKeywordsDao.get(appKeywordsQuery);
        List<Map> list = new ArrayList();
        Map map;
        for (AppKeywords appKeywords : appKeywordsList) {
            map = new HashMap();
            map.put("objectId", appKeywords.getObjectId());
            map.put("keywordType", appKeywords.getKeywordType());
            map.put("keyword", appKeywords.getKeyword());
            list.add(map);
        }
        return list;
    }

    @Override
    public Map getKeywordsMap(String objectId) throws AVException {
        AppKeywords appKeywords=appKeywordsDao.get(objectId);
        Map map=new HashMap();
        map.put("objectId", appKeywords.getObjectId());
        map.put("keywordType", appKeywords.getKeywordType());
        map.put("keyword", appKeywords.getKeyword());
        return map;
    }

    @Override
    public AppKeywords getKeywords(String objectId) throws AVException {
        return appKeywordsDao.get(objectId);
    }
}
