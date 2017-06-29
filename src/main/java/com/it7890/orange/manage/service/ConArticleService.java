package com.it7890.orange.manage.service;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.ConArticle;
import com.it7890.orange.manage.po.ConArticleQuery;
import com.it7890.orange.manage.vo.ConArticleDTO;
import com.it7890.orange.manage.vo.ConArticleDetailDTO;

import java.io.IOException;
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

    public ConArticleDetailDTO getContentByArtID(String artId) throws IOException, AVException;

    public ConArticleDTO getConarticleById(String artid) throws AVException;

    public Map getConArticleMap(String objectId) throws Exception;

    void updateArticle(ConArticleQuery articleQuery) throws Exception;

    void updateArticleContent(String objectId, String content) throws Exception;

    public String getConArticleContent(String articleObjectId) throws AVException;
}
