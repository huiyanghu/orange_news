package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.dao.ConChannelDao;
import com.it7890.orange.manage.service.ConChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */
@Service
public class ConChannelServiceImpl implements ConChannelService {
    @Autowired
    ConChannelDao conChannelDao;

    public List<Map> getChannelList() throws AVException {
        return conChannelDao.getChannelList();
    }
}
