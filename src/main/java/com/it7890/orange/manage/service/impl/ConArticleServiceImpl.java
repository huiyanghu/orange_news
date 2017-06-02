package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.dao.ConArticleDao;
import com.it7890.orange.manage.po.ConArticleQuery;
import com.it7890.orange.manage.service.ConArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/31.
 */
@Service
public class ConArticleServiceImpl implements ConArticleService {
    @Autowired
    private ConArticleDao conArticleDao;

    public Map getAll(ConArticleQuery conArticleQuery, Integer page) throws AVException {
        return conArticleDao.getAll(conArticleQuery, page);
    }

    public void deleteBatch(String ids) throws AVException {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            conArticleDao.delete(id);
        }

    }

    public void publishBatch(String ids) throws AVException {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            conArticleDao.publish(id);
        }

    }
}
