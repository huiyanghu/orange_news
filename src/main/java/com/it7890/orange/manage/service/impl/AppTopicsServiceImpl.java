package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.dao.AppTopicsDao;
import com.it7890.orange.manage.service.AppTopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */
@Service
public class AppTopicsServiceImpl implements AppTopicsService {
    @Autowired
    AppTopicsDao appTopicsDao;

    public List<Map> getAppTopicsList() throws AVException {
        return appTopicsDao.getAppTopicsList();
    }

}
