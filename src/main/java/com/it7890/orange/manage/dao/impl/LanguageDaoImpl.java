package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.LanguageDao;
import com.it7890.orange.manage.model.HbLanguage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/12.
 */
@Component
public class LanguageDaoImpl implements LanguageDao {
    @Override
    public List<HbLanguage> getAll() {
        List<HbLanguage> list = new ArrayList<>();
        AVCloudQueryResult result;
        try {
            String cql = "select * from hb_languages";
            result =  AVQuery.doCloudQuery(cql, HbLanguage.class);
            list = (List<HbLanguage>) result.getResults();
        } catch (Exception e) {
        }
        return   list;
    }

    @Override
    public List<AVObject> getLangList() {
        AVQuery avQuery = new AVQuery("hb_languages");
        List<AVObject> ls = new ArrayList<>();
        try {
           ls = avQuery.find();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return ls;
    }

    @Override
    public List<Map> getLanguageList() throws AVException {
        AVQuery query = new AVQuery("hb_languages");
        List<HbLanguage> languageList = query.find();
        List<Map> list = new ArrayList<>();
        Map map;
        for (HbLanguage language : languageList) {
            map = new HashMap();
            map.put("objectId", language.getObjectId());
            map.put("languageName", language.getName());
            list.add(map);
        }
        return list;
    }

    @Override
    public AVObject getById(String objId) {
        AVObject avObject = new AVObject();
        AVQuery avQuery = new AVQuery("hb_languages");
        try {
            avObject = avQuery.get(objId);
        } catch (AVException e) {
            e.printStackTrace();
        }
        return avObject;
    }
}
