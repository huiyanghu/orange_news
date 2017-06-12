package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.ConChannelDao;
import com.it7890.orange.manage.model.ConChannel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/12.
 */
@Repository
public class ConChannelDaoImpl implements ConChannelDao {
    @Override
    public List<ConChannel> getAll() {
        List<ConChannel> list = new ArrayList<>();
        AVCloudQueryResult result;
        try {
            String cql = "select * from con_channel";
            result = AVQuery.doCloudQuery(cql, ConChannel.class);
            list = (List<ConChannel>) result.getResults();
        } catch (Exception e) {
        }
        return list;
    }

    public List<Map> getChannelList() throws AVException {
        AVQuery<ConChannel> query = new AVQuery("ConChannel");
        List<ConChannel> channelList = query.find();
        List<Map> list = new ArrayList<>();
        Map map;
        for (ConChannel channel : channelList) {
            map = new HashMap();
            map.put("objectId", channel.getObjectId());
            map.put("channelName", channel.getChannelName());
            list.add(map);
        }
        return list;
    }
}
