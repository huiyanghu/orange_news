package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.dao.AppPushInfoDao;
import com.it7890.orange.manage.model.AppPushInfo;
import com.it7890.orange.manage.po.AppPushInfoQuery;
import com.it7890.orange.manage.service.AppPushInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/5.
 */
@Service
public class AppPushInfoServiceImpl implements AppPushInfoService{
    @Autowired
    AppPushInfoDao appPushInfoDao;

    public String saveOrUpdate(AppPushInfo appPushInfo) throws AVException {
        return appPushInfoDao.saveOrUpdate(appPushInfo);
    }

    public List<AppPushInfo> get(AppPushInfoQuery appPushInfo) throws AVException {
        return appPushInfoDao.get(appPushInfo);
    }
}
