package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.ConArticlesContent;
import com.it7890.orange.manage.po.ConArticleContentQuery;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
public interface ConArticleContentDao  {
    public ConArticlesContent get(String objectId) throws AVException;
    public List<ConArticlesContent> get(ConArticleContentQuery  conArticleContentQuery) throws AVException;
}
