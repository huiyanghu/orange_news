package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.model.AppTopics;
import com.it7890.orange.manage.po.AppTopicsQuery;

import java.util.List;
import java.util.Map;

/**
 * @author gg
 * @create 2017/6/7
 **/
public interface AppTopicsDao {
    public List<AVObject> getListByCId(String cid, String hid);

    public List<Map> getAppTopicsList() throws AVException;

    public void delByCidAndHid(String cid, String hid);

    public List<AppTopics> get(AppTopicsQuery appTopicsQuery) throws AVException;

}
