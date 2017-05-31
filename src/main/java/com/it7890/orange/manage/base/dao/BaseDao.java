package com.it7890.orange.manage.base.dao;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;

/**
 * Created by Administrator on 2017/5/31.
 */
public interface BaseDao {
    public void delete(String objectId) throws AVException;
    public AVObject getById(String objectId) throws AVException;
}
