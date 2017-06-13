package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.dao.AppTopDao;
import com.it7890.orange.manage.po.AppTopQuery;
import com.it7890.orange.manage.service.AppTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/26.
 */
@Service
public class AppTopServiceImpl implements AppTopService {
    @Autowired
    AppTopDao appTopDao;



    public Map getAll(AppTopQuery appTopQuery, Integer page) throws AVException {
        return appTopDao.getAll(appTopQuery, page);
    }

    public Map getAppTop(String objectId) throws AVException {
        return appTopDao.getAppTop(objectId);
    }

    public void saveOrUpdate(AppTopQuery appTopQuery)throws AVException{
        appTopDao.saveOrUpdate(appTopQuery);
    }

}
