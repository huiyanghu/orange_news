package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;

import java.util.List;
import java.util.Map;

/**
 * @author gg
 * @create 2017/6/7
 **/
public interface AppTopicsDao {
    public List<AVObject> getListByCId(String cid);
    public List<Map> getAppTopicsList() throws AVException;
}
