package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.AppKeywordsDao;
import com.it7890.orange.manage.model.AppKeywords;
import com.it7890.orange.manage.model.HbCountrys;
import com.it7890.orange.manage.po.AppKeywordsQuery;
import com.it7890.orange.manage.utils.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
@Repository
public class AppKeywordsDaoImpl implements AppKeywordsDao {
    @Override
    public AppKeywords get(String objectId) throws AVException {
        AVQuery<AppKeywords> avQuery = new AVQuery<>("AppKeywords");
        AppKeywords appKeywords = avQuery.get(objectId);
        return appKeywords;
    }

    @Override
    public List<AppKeywords> get(AppKeywordsQuery appKeywordsQuery) throws AVException {
        AVQuery<AppKeywords> query = new AVQuery<>("AppKeywords");
        if (StringUtil.isNotEmpty(appKeywordsQuery.getObjectId())) {
            query.whereEqualTo("objectId", appKeywordsQuery.getObjectId());
        }if (StringUtil.isNotEmpty(appKeywordsQuery.getKeywordType())) {
            query.whereEqualTo("keywordType", appKeywordsQuery.getKeywordType());
        }
        if (StringUtil.isNotEmpty(appKeywordsQuery.getCountryObjectId())) {
            HbCountrys country = new HbCountrys();
            country.setObjectId(appKeywordsQuery.getCountryObjectId());
            query.whereEqualTo("countryObj", country);
        }

        //query.include("countryObj");
        List<AppKeywords> appKeywordsList = query.find();
        return appKeywordsList;
    }
}
