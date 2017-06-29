package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
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

    public ConArticle get(String objectId) throws AVException;

    public void delete(String id) throws AVException;

    public void publish(String id) throws AVException;

    public AVObject getByArtid(String artId);

    public AVObject getConarticleByid(String artid);

    boolean updateArticleInfo(ConArticle articleInfo) throws AVException;
}
