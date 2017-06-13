package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.SysUserDao;
import com.it7890.orange.manage.model.SysUser;
import com.it7890.orange.manage.utils.MD5;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/13.
 */
@Repository
public class SysUserDaoImpl implements SysUserDao {
    public Map getLoginUser(String userName, String password) throws AVException {
        AVQuery<SysUser> query = new AVQuery("SysUser");
        query.whereEqualTo("userName", userName);
        query.whereEqualTo("password", MD5.MD5(password).toUpperCase());
        List<SysUser> userList = query.find();

        Map map = new HashMap();
        if (userList != null && !userList.isEmpty()) {
            SysUser user = userList.get(0);
            map.put("lastLoginTime", user.getLastLoginTime());
            map.put("trueName", user.getTrueName());
            map.put("userName", user.getUserName());

            user.setLastLoginTime(new Date());
            user.save();
            return map;
        }
        return null;
    }
}
