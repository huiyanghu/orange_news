package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.AppKeywords;
import com.it7890.orange.manage.po.AppKeywordsQuery;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
public interface AppKeywordsDao {
    public AppKeywords get(String objectId) throws AVException;

    public List<AppKeywords> get(AppKeywordsQuery appKeywordsQuery) throws AVException;
}
