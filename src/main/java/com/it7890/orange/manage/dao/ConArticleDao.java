package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.ConArticle;
import com.it7890.orange.manage.po.ConArticleQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/31.
 */
public interface ConArticleDao {
    public Map getAll(ConArticleQuery conArticleQuery, Integer page) throws AVException;

    public List<ConArticle> get(ConArticleQuery conArticleQuery) throws AVException;

    public ConArticle getById(String objectId) throws AVException;

    public void delete(String id) throws AVException;

    public void publish(String id) throws AVException;
}
