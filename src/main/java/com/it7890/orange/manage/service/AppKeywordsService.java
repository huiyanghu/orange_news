package com.it7890.orange.manage.service;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.AppKeywords;
import com.it7890.orange.manage.po.AppKeywordsQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/28.
 */
public interface AppKeywordsService {
    public List<Map> getKeywordsList(AppKeywordsQuery appKeywordsQuery) throws AVException;
    public Map getKeywordsMap(String objectId) throws AVException;
    public AppKeywords getKeywords(String objectId) throws AVException;
}
