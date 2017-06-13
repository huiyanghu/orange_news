package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.dao.SysUserDao;
import com.it7890.orange.manage.model.SysUser;
import com.it7890.orange.manage.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/13.
 */

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserDao sysUserDao;
    public Map getLoginUser(String userName, String password) throws AVException{
        return sysUserDao.getLoginUser(userName,password);
    }
    public SysUser findByUsername(String username){
        return sysUserDao.findByUsername(username);
    }
}
