package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVObject;

import java.util.List;

/**
 * @author gg
 * @create 2017/6/7
 **/
public interface AppTopicsDao {
    public List<AVObject> getListByCId(String cid);
}
