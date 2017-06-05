package com.it7890.orange.manage.service;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.AppPushInfo;
import com.it7890.orange.manage.po.AppPushInfoQuery;

import java.util.List;

/**
 * Created by Administrator on 2017/6/5.
 */
public interface AppPushInfoService {
    public String saveOrUpdate(AppPushInfo appPushInfo) throws AVException;
    public List<AppPushInfo> get(AppPushInfoQuery appPushInfo) throws AVException;
}
