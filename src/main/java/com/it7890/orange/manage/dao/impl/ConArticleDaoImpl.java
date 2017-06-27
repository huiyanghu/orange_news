package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.ConArticleDao;
import com.it7890.orange.manage.model.ConArticle;
import com.it7890.orange.manage.po.ConArticleQuery;
import com.it7890.orange.manage.utils.ConstantsUtil;
import com.it7890.orange.manage.utils.DateUtil;
import com.it7890.orange.manage.utils.PageUtil;
import com.it7890.orange.manage.utils.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Administrator on 2017/5/31.
 */
@Repository
public class ConArticleDaoImpl implements ConArticleDao {
    @Override
    public Map getAll(ConArticleQuery conArticleQuery, Integer page) throws AVException {
        Map map = new HashMap();

        /*conArticleList*/
        AVQuery<ConArticle> query = new AVQuery<>("conarticle");
        query.whereNotEqualTo("status", -1);
        if (StringUtil.isNotEmpty(conArticleQuery.getObjectId())) {
            query.whereContains("objectId", conArticleQuery.getObjectId());

        }
        if (StringUtil.isNotEmpty(conArticleQuery.getCountryCode())) {
            //query.whereEqualTo("countrycode", conArticleQuery.getCountryCode());
            query.whereContains("countrycode", conArticleQuery.getCountryCode().toUpperCase());
        }
        if (StringUtil.isNotEmpty(conArticleQuery.getPublicationObjectId())) {
            query.whereEqualTo("publicationObj", AVObject.createWithoutData("con_publications", conArticleQuery.getPublicationObjectId()));
        }
        if (StringUtil.isNotEmpty(conArticleQuery.getChannelObjectId())) {
            query.whereEqualTo("channelObj", AVObject.createWithoutData("con_channel", conArticleQuery.getChannelObjectId()));
        }
        if (StringUtil.isNotEmpty(conArticleQuery.getLanguageObjectId())) {
            query.whereEqualTo("languageObj", AVObject.createWithoutData("hb_languages", conArticleQuery.getLanguageObjectId()));
        }
        if (StringUtil.isNotEmpty(conArticleQuery.getAttr())) {
            query.whereEqualTo("attr", conArticleQuery.getAttr());
        }
        if (StringUtil.isNotEmpty(conArticleQuery.getStatus())) {
            query.whereEqualTo("status", conArticleQuery.getStatus());
        }
        if (StringUtil.isNotEmpty(conArticleQuery.getKeywords())) {
            query.whereContains("keywords", conArticleQuery.getKeywords());
        }
        if (StringUtil.isNotEmpty(conArticleQuery.getTopicObjectId())) {
            query.whereEqualTo("topicObj", AVObject.createWithoutData("AppTopics", conArticleQuery.getTopicObjectId()));
        }
        if (conArticleQuery.getStartTime() != null && !"".equals(conArticleQuery.getStartTime())) {
            query.whereGreaterThanOrEqualTo("createdAt", DateUtil.getDateByStr(conArticleQuery.getStartTime()));
        }
        if (conArticleQuery.getEndTime() != null && !"".equals(conArticleQuery.getEndTime())) {
            query.whereLessThan("createdAt", DateUtil.addDay(DateUtil.getDateByStr(conArticleQuery.getEndTime()), 1));
        }
        query.orderByDescending("createdAt");

        PageUtil pageUtil = new PageUtil();
        Integer pageSize = pageUtil.getPageSize();
        query.skip((page - 1) * pageSize);
        query.limit(pageSize);
        query.include("topicObj");
        query.include("publicationObj");
        query.include("channelObj");


        List<ConArticle> articleList = query.find();
        List<Map> conArticleList = new ArrayList<Map>();
        Map m;
        for (ConArticle article : articleList) {
            m = new HashMap();
            m.put("objectId", article.getObjectId());
            m.put("title", article.getTitle());
            m.put("sourceUrl", article.getSourceurl());
            m.put("attr", article.getAttr());
            m.put("attrStr", ConstantsUtil.getConstants("conArticleAttr", "" + article.getAttr()));
            m.put("ctype", article.getCtype());
            m.put("ctypeStr", ConstantsUtil.getConstants("conArticleCtype", "" + article.getCtype()));
            m.put("countrycode", article.getCountryCode());
            m.put("topicName", article.getTopics() == null ? "" : article.getTopics().getTopicName());
            m.put("publicationName", article.getPublication() == null ? "" : article.getPublication().getName());
            m.put("channelObjectId", article.getChannel() == null ? "" : article.getChannel().getObjectId());
            m.put("channelName", article.getChannel() == null ? "" : article.getChannel().getChannelName());
            m.put("status", article.getStatus());
            m.put("statusStr", ConstantsUtil.getConstants("conArticleStatus", "" + article.getStatus()));
            m.put("publishtime", StringUtil.isEmpty(article.getPushtime()) ? "" : DateUtil.getTimeStampStr(article.getPushtime()));
            m.put("createdAt", DateUtil.getTimeStampStr(article.getCreatedAt()));

            conArticleList.add(m);
        }
        map.put("conArticleList", conArticleList);

        /*pageUtil*/
        Integer count = query.count();
        pageUtil.setRecordCount(count);
        pageUtil.setPagecount(pageUtil.getPagecount());
        pageUtil.setCurrentPage(page);
        map.put("pageUtil", pageUtil);
        return map;
    }


    public List<ConArticle> get(ConArticleQuery conArticleQuery) throws AVException {
        AVQuery<ConArticle> query = new AVQuery<>("conarticle");
        query.whereEqualTo("objectId", conArticleQuery.getObjectId());
        List<ConArticle> avObjectList = query.find();
        if (!avObjectList.isEmpty()) {
            return avObjectList;
        }
        return null;
    }

    public ConArticle getById(String objectId) throws AVException {
        AVQuery<ConArticle> query = new AVQuery<>("conarticle");
        query.whereEqualTo("objectId", objectId);
        List<ConArticle> avObjectList = query.find();
        if (!avObjectList.isEmpty()) {
            ConArticle conArticle = avObjectList.get(0);
            return conArticle;
        }
        return null;
    }


    public void delete(String id) throws AVException {
        AVObject avObject = AVObject.createWithoutData("conarticle", id);
        avObject.put("status", -1);
        try {
            avObject.save();
        } catch (AVException e) {
            e.printStackTrace();
        }
    }

    public void publish(String id) throws AVException {
        AVQuery<AVObject> query = new AVQuery<>("conarticle");
        AVObject avObject = query.get(id);
        Date now = new Date();
        Date subtime = (Date) avObject.get("subtime");//subtime 提交时间
        if (subtime == null) {
            avObject.put("status", 2);
        } else {
            if (subtime.before(now)) {//在当前时间前为0=正常
                avObject.put("status", 0);
            } else if (subtime.after(now)) {//在当前时间后为2=预发布
                avObject.put("status", 2);
            }
        }

        try {
            avObject.save();
        } catch (AVException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AVObject getByArtid(String artId) {
        AVObject avObject = new AVObject();
        AVQuery avQuery = new AVQuery("con_articles_content");
        avQuery.include("articleObj");
        avQuery.include("articleObj.topicObj");
        avQuery.include("articleObj.publicationObj");
        avQuery.include("articleObj.titlePicObjArr");
        avQuery.whereEqualTo("articleObj", AVObject.createWithoutData("conarticle", artId));
        try {
            List<AVObject> ls = avQuery.find();
            avObject = ls.get(0);
        } catch (AVException e) {
            e.printStackTrace();
        }
        return avObject;
    }

    @Override
    public AVObject getConarticleByid(String artid) {
        AVObject avObject = new AVObject();
        AVQuery avQuery = new AVQuery("conarticle");
        avQuery.include("topicObj");
        avQuery.include("publicationObj");
        avQuery.include("titlePicObjArr");
        try {
            avObject = avQuery.get(artid);
        } catch (AVException e) {
            e.printStackTrace();
        }
        return avObject;
    }

}
