package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.dao.AppLockScreenDao;
import com.it7890.orange.manage.model.AppLockScreen;
import com.it7890.orange.manage.po.AppLockScreenQuery;
import com.it7890.orange.manage.service.AppLockScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6.
 */
@Service
public class AppLockScreenServiceImpl implements AppLockScreenService {
    @Autowired
    private AppLockScreenDao appLockScreenDao;

    public String saveOrUpdate(AppLockScreen appLockScreen) throws AVException {
        return appLockScreenDao.saveOrUpdate(appLockScreen);
    }

    public AppLockScreen get(String objectId) throws AVException {
        return appLockScreenDao.get(objectId);
    }

    public List<AppLockScreen> get(AppLockScreenQuery appLockScreenQuery) throws AVException {
        return appLockScreenDao.get(appLockScreenQuery);
    }
}
