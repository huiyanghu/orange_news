package com.it7890.orange.manage.dao.impl;

import com.it7890.orange.manage.dao.ConChannelDao;
import com.it7890.orange.manage.model.ConChannel;
import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVQuery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */
@Component
public class ConChannelDaoImpl implements ConChannelDao {
    @Override
    public List<ConChannel> getAll() {
        List<ConChannel> list = new ArrayList<>();
        AVCloudQueryResult result;
        try {
            String cql = "select * from con_channel";
            result =  AVQuery.doCloudQuery(cql, ConChannel.class);
            list = (List<ConChannel>) result.getResults();
        } catch (Exception e) {
        }
        return   list;
    }
}
