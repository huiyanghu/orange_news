package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.dao.ConArticleDao;
import com.it7890.orange.manage.service.ConArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/31.
 */
@Service
public class ConArticleServiceImpl implements ConArticleService {
    @Autowired
    private ConArticleDao conArticleDao;

    public void delete(String objectId) throws AVException {
        conArticleDao.delete(objectId);
    }
}
