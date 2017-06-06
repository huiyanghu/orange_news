package com.it7890.orange.manage.service;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.AppAdvert;
import com.it7890.orange.manage.po.AppAdvertQuery;

import java.util.List;

/**
 * Created by Administrator on 2017/6/5.
 */
public interface AppAdvertService {

    public String saveOrUpdate(AppAdvert appAdvert) throws AVException;

    public AppAdvert get(String objectId) throws AVException;

    public List<AppAdvert> get(AppAdvertQuery appAdvertQuery) throws AVException;
}
