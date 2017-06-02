package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.base.dao.BaseDao;
import com.it7890.orange.manage.po.AppTopQuery;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/26.
 */
public interface AppTopDao extends BaseDao {
    public Map getAll(AppTopQuery appTopQuery, Integer page) throws AVException;

    public Map getAppTop(String objectId) throws AVException;

    public void saveOrUpdate(AppTopQuery appTopQuery) throws AVException;
}
