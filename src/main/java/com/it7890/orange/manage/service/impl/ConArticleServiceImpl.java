package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.dao.ConArticleContentDao;
import com.it7890.orange.manage.dao.ConArticleDao;
import com.it7890.orange.manage.model.*;
import com.it7890.orange.manage.po.ConArticleContentQuery;
import com.it7890.orange.manage.po.ConArticleQuery;
import com.it7890.orange.manage.service.ConArticleService;
import com.it7890.orange.manage.utils.ConstantsUtil;
import com.it7890.orange.manage.utils.DateUtil;
import com.it7890.orange.manage.utils.StringUtil;
import com.it7890.orange.manage.vo.ConArticleDTO;
import com.it7890.orange.manage.vo.ConArticleDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/31.
 */
@Service
public class ConArticleServiceImpl implements ConArticleService {
    @Autowired
    private ConArticleDao conArticleDao;
    @Autowired
    private ConArticleContentDao conArticleContentDao;

    public Map getAll(ConArticleQuery conArticleQuery, Integer page) throws AVException {
        return conArticleDao.getAll(conArticleQuery, page);
    }

    public List<ConArticle> get(ConArticleQuery conArticleQuery) throws AVException {
        return conArticleDao.get(conArticleQuery);
    }

    public ConArticle getById(String objectId) throws AVException {
        return conArticleDao.get(objectId);
    }

    public Map getConArticleMap(String objectId) throws Exception {
        ConArticle article = conArticleDao.get(objectId);
        Map map = new HashMap();
        map.put("objectId", article.getObjectId());
        map.put("title", article.getTitle());
        map.put("ctype", article.getCtype());
        map.put("ctypeStr", ConstantsUtil.getConstants("conArticleCtype", "" + article.getCtype()));
        map.put("attr", article.getAttr());
        map.put("attrStr", ConstantsUtil.getConstants("appTopArtitype", "" + article.getAttr()));
        map.put("languageObjectId", article.getLanguage().getObjectId());
        map.put("countryCode", article.getCountryCode());
        map.put("topicsObjectId", article.getTopics().getObjectId());
        map.put("publicationObjectId", article.getPublication().getObjectId());
        map.put("abstracts", article.getAbstracts());
        map.put("keywords", article.getKeywords());
        map.put("author", article.getAuthor());
        map.put("source", article.getSource());
        map.put("sourceUrl", article.getSourceurl());
        map.put("linkUrl", article.getLinkurl());
        map.put("mediaLink", article.getMedialink());
        //map.put("pushTime", DateUtil.formatDate(article.getPushtime()));
        map.put("subTime", DateUtil.formatDate(article.getSubtime()));
        map.put("status", article.getStatus());
        map.put("statusStr", ConstantsUtil.getConstants("conArticleStatus", "" + article.getStatus()));
        String titlePic = "";
        if (article.getTitlePicArr() != null && !article.getTitlePicArr().isEmpty()) {
            for (AVFile file : article.getTitlePicArr()) {
                titlePic += file.getUrl() + ",";
            }
        }
        map.put("titlePic", "".equals(titlePic) ? "" : titlePic.substring(0, titlePic.length() - 1));

        return map;
    }

    @Override
    public void updateArticle(ConArticleQuery articleQuery) throws Exception {
        ConArticle article;
        if (StringUtil.isEmpty(articleQuery.getObjectId())) {
            article = new ConArticle();
        } else {
            article = conArticleDao.get(articleQuery.getObjectId());
        }


        article.setStatus(articleQuery.getStatus());
        article.setTitle(articleQuery.getTitle());
        article.setCtype(articleQuery.getCtype());
        article.setAttr(articleQuery.getAttr());
        article.setCountryCode(articleQuery.getCountryCode());

        article.setLanguage(null);
        if (StringUtil.isNotEmpty(articleQuery.getLanguageObjectId())) {
            HbLanguage language = new HbLanguage();
            language.setObjectId(articleQuery.getLanguageObjectId());
            article.setLanguage(language);
        }

        article.setTopics(null);
        if (StringUtil.isNotEmpty(articleQuery.getTopicObjectId())) {
            AppTopics topics = new AppTopics();
            topics.setObjectId(articleQuery.getTopicObjectId());
            article.setTopics(topics);
        }

        article.setPublication(null);
        if (StringUtil.isNotEmpty(articleQuery.getPublicationObjectId())) {
            ConPublication publication = new ConPublication();
            publication.setObjectId(articleQuery.getPublicationObjectId());
            article.setPublication(publication);
        }

        article.setAbstracts(articleQuery.getAbstracts());
        article.setKeywords(articleQuery.getKeywords());
        article.setAuthor(articleQuery.getAuthor());
        article.setSource(articleQuery.getSource());
        article.setSourceurl(articleQuery.getSourceUrl());
        article.setLinkurl(articleQuery.getLinkUrl());
        article.setMedialink(articleQuery.getMediaLink());
        if (StringUtil.isNotEmpty(articleQuery.getSubTime())) {
            article.setSubtime(DateUtil.getDateByStr(articleQuery.getSubTime()));
        }

        article.setStatus(articleQuery.getStatus());
        if (StringUtil.isNotEmpty(articleQuery.getTitlePic())) {
            List<AVFile> list = new ArrayList();
            String[] titlePicArr = articleQuery.getTitlePic().split(",");
            for (String titlePic : titlePicArr) {
                AVFile file = new AVFile("image/jpeg", titlePic, null);
                list.add(file);
            }
            article.setTitlePicArr(list);
        }

        article.save();
    }

    @Override
    public void updateArticleContent(String objectId, String content) throws AVException {
        ConArticleContentQuery articleContentQuery = new ConArticleContentQuery();
        articleContentQuery.setArticleObjectId(objectId);
        List<ConArticlesContent> articlesContentList = conArticleContentDao.get(articleContentQuery);
        if (articlesContentList != null && !articlesContentList.isEmpty()) {
            ConArticlesContent articlesContent = articlesContentList.get(0);
            articlesContent.setContent(content);
            articlesContent.save();
        }
    }

    @Override
    public String getConArticleContent(String articleObjectId) throws AVException {
        ConArticleContentQuery articleContentQuery = new ConArticleContentQuery();
        articleContentQuery.setArticleObjectId(articleObjectId);
        List<ConArticlesContent> articlesContentList = conArticleContentDao.get(articleContentQuery);
        String content = "";
        if (articlesContentList != null && !articlesContentList.isEmpty()) {
            ConArticlesContent articlesContent = articlesContentList.get(0);
            content = articlesContent.getContent();
        }
        return content;
    }

    public void deleteBatch(String ids) throws AVException {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            ConArticle article = conArticleDao.get(id);
            article.setStatus(-1);
            article.save();
        }

    }

    public void publishBatch(String ids) throws AVException {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            conArticleDao.publish(id);
        }
    }

    @Override
    public ConArticleDetailDTO getContentByArtID(String artId) throws IOException, AVException {
        AVObject avo = conArticleDao.getByArtid(artId);
        return ConArticleDetailDTO.objectToDto(avo);
    }

    @Override
    public ConArticleDTO getConarticleById(String artid) throws AVException {
        return ConArticleDTO.avobjectToDto(conArticleDao.getConarticleByid(artid));
    }


}
