package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.ConArticleContentDao;
import com.it7890.orange.manage.model.ConArticle;
import com.it7890.orange.manage.model.ConArticlesContent;
import com.it7890.orange.manage.po.ConArticleContentQuery;
import com.it7890.orange.manage.utils.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
@Repository
public class ConArticleContentDaoImpl implements ConArticleContentDao {
    @Override
    public ConArticlesContent get(String objectId) throws AVException {
        AVQuery<ConArticlesContent> query = new AVQuery<>("con_articles_content");
        ConArticlesContent articlesContent = query.get(objectId);
        return articlesContent;
    }

    @Override
    public List<ConArticlesContent> get(ConArticleContentQuery conArticleContentQuery) throws AVException {
        AVQuery<ConArticlesContent> query = new AVQuery<>("con_articles_content");

        if (StringUtil.isNotEmpty(conArticleContentQuery.getArticleObjectId())) {
            ConArticle article=new ConArticle();
            article.setObjectId(conArticleContentQuery.getArticleObjectId());
            query.whereEqualTo("articleObj", article);
        }
        List<ConArticlesContent> list = query.find();

        return list;
    }
}
