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
        if (article != null) {
            map.put("objectId", article.getObjectId());
            map.put("title", article.getTitle());
            map.put("ctype", article.getCtype());
            map.put("ctypeStr", ConstantsUtil.getConstants("conArticleCtype", "" + article.getCtype()));
            map.put("attr", article.getAttr());
            map.put("attrStr", ConstantsUtil.getConstants("appTopArtitype", "" + article.getAttr()));
            map.put("languageObjectId", article.getLanguage() == null ? "" : article.getLanguage().getObjectId());
            map.put("countryCode", article.getCountryCode());
            map.put("topicsObjectId", article.getTopics() == null ? "" : article.getTopics().getObjectId());
            map.put("publicationObjectId", article.getPublication() == null ? "" : article.getPublication().getObjectId());
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
            String titlePicUrl = "";
            String titlePicId = "";
            if (article.getTitlePicArr() != null && !article.getTitlePicArr().isEmpty()) {
                List<AVFile> fileList = article.getTitlePicArr();
                for (AVFile file : fileList) {
                    if (file != null) {
                        titlePicUrl += file.getUrl() + ",";
                        titlePicId += file.getObjectId() + ",";
                    }
                }
            }
            map.put("titlePicUrl", "".equals(titlePicUrl) ? "" : titlePicUrl.substring(0, titlePicUrl.length() - 1));
            map.put("titlePicId", "".equals(titlePicId) ? "" : titlePicId.substring(0, titlePicId.length() - 1));
        }


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
        List<AVFile> list = new ArrayList();
        if (StringUtil.isNotEmpty(articleQuery.getTitlePicId())) {

            String[] titlePicIdArr = articleQuery.getTitlePicId().split(",");
            for (String titlePicId : titlePicIdArr) {
                /*AVFile file = new AVFile();
                file.setObjectId(titlePic);*/
                list.add(AVFile.withObjectId(titlePicId));
            }
        }
        article.setTitlePicArr(list);
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

    @Override
    public boolean updateArticleInfo(ConArticle articleInfo) throws AVException {
        boolean isSuccess = false;
        if (null != articleInfo && StringUtil.isNotEmpty(articleInfo.getObjectId())) {
            isSuccess = conArticleDao.updateArticleInfo(articleInfo);
        }
        return isSuccess;
    }

}
