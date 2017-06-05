package com.it7890.orange.manage.service;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.ConArticle;
import com.it7890.orange.manage.po.ConArticleQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/31.
 */
public interface ConArticleService {
    public Map getAll(ConArticleQuery conArticleQuery, Integer page) throws AVException;

    public List<ConArticle> get(ConArticleQuery conArticleQuery) throws AVException;

    public ConArticle getById(String objectId) throws AVException;

    public void deleteBatch(String ids) throws AVException;

    public void publishBatch(String ids) throws AVException;


}
