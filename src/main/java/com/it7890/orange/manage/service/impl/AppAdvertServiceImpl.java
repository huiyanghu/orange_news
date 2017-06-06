package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.dao.AppAdvertDao;
import com.it7890.orange.manage.model.AppAdvert;
import com.it7890.orange.manage.po.AppAdvertQuery;
import com.it7890.orange.manage.service.AppAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/5.
 */
@Service
public class AppAdvertServiceImpl implements AppAdvertService {
    @Autowired
    AppAdvertDao appAdvertDao;

    public String saveOrUpdate(AppAdvert appAdvert) throws AVException {
        return appAdvertDao.saveOrUpdate(appAdvert);
    }

    public AppAdvert get(String objectId) throws AVException {
        return appAdvertDao.get(objectId);
    }

    public List<AppAdvert> get(AppAdvertQuery appAdvertQuery) throws AVException {
        return appAdvertDao.get(appAdvertQuery);
    }
}
