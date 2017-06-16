package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.AppLanguagesDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gg
 * @create 2017/6/15
 **/
@Component
public class AppLanguagesDaoImpl implements AppLanguagesDao {
    @Override
    public List<AVObject> getByCidAndLangId(String cid, String HBlangId) {
        AVQuery avQuery = new AVQuery("AppLanguages");
        avQuery.include("CountryObj");
        avQuery.include("HbLanguageObj");
        List<AVObject> ls = new ArrayList<>();
        if (StringUtils.isNotBlank(cid)){
            avQuery.whereEqualTo("CountryObj",AVObject.createWithoutData("hb_countrys",cid));
        }
        if (StringUtils.isNotBlank(HBlangId)){
            avQuery.whereEqualTo("HbLanguageObj",AVObject.createWithoutData("hb_languages",HBlangId));
        }
        try {
            ls = avQuery.find();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return ls;
    }

    @Override
    public void delLangByCidAndHbid(String cid, String hid) {
        AVQuery avQuery = new AVQuery("AppLanguages");
        avQuery.whereEqualTo("CountryObj",AVObject.createWithoutData("hb_countrys",cid));
        avQuery.whereEqualTo("HbLanguageObj",AVObject.createWithoutData("hb_languages",hid));
        try {
            List<AVObject> ls = avQuery.find();
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
