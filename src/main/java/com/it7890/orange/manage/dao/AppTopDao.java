package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.po.AppTopQuery;

import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */
public interface AppTopDao {
    public List<AVObject> getAll(AppTopQuery appTopQuery, Integer page) throws AVException;
}
