package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.SysUser;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/13.
 */
public interface SysUserDao {
    public Map getLoginUser(String userName, String password) throws AVException;
    public SysUser findByUsername(String username);
}
