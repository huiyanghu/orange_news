package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.ConChannel;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/12.
 */
public interface ConChannelDao {
    public List<ConChannel> getAll();

    public List<Map> getChannelList() throws AVException;
}
