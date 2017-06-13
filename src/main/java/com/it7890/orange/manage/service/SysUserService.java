package com.it7890.orange.manage.service;

import com.avos.avoscloud.AVException;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/13.
 */
public interface SysUserService {
    public Map getLoginUser(String userName, String password) throws AVException;
}
