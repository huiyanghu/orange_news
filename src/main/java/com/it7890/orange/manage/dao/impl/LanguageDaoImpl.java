package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.dao.LanguageDao;
import com.it7890.orange.manage.model.HbLanguage;
import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVQuery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
}
