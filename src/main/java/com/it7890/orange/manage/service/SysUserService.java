package com.it7890.orange.manage.service;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.SysUser;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/13.
 */
public interface SysUserService {
    public Map getLoginUser(String userName, String password) throws AVException;
    public SysUser findByUsername(String username);
}
