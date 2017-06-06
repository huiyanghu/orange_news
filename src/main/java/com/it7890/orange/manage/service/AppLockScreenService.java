package com.it7890.orange.manage.service;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.AppLockScreen;
import com.it7890.orange.manage.po.AppLockScreenQuery;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6.
 */
public interface AppLockScreenService {
    public String saveOrUpdate(AppLockScreen appLockScreen) throws AVException;

    public AppLockScreen get(String objectId) throws AVException;

    public List<AppLockScreen> get(AppLockScreenQuery appLockScreenQuery) throws AVException;
}
