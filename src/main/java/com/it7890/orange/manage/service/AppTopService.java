package com.it7890.orange.manage.service;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.po.AppTopQuery;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/26.
 */
public interface AppTopService {
    public void delete(String objectId) throws AVException;

    public Map getAll(AppTopQuery appTopQuery, Integer page) throws AVException;
}
