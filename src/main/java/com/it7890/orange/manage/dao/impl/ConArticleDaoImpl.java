package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.ConArticleDao;
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
        AVQuery<AVObject> query = new AVQuery<>("conarticle");
        query.whereNotEqualTo("status", -1);
        if (StringUtil.isNotEmpty(conArticleQuery.getObjectId())) {
            query.whereEqualTo("objectId", conArticleQuery.getObjectId());
        }
        if (StringUtil.isNotEmpty(conArticleQuery.getCountryCode())) {
            query.whereEqualTo("countrycode", conArticleQuery.getCountryCode());
        }
        if (StringUtil.isNotEmpty(conArticleQuery.getPublicationObjectId())) {
            query.whereEqualTo("publicationObj", AVObject.createWithoutData("con_publications", conArticleQuery.getPublicationObjectId()));
        }
        if (StringUtil.isNotEmpty(conArticleQuery.getChannelObjectId())) {
            query.whereEqualTo("channelObj", AVObject.createWithoutData("con_channel", conArticleQuery.getChannelObjectId()));
        }
        if (StringUtil.isNotEmpty(conArticleQuery.getLanguageObjectId())) {
            query.whereEqualTo("languageObj", AVObject.createWithoutData("hb_languages", conArticleQuery.getChannelObjectId()));
        }
        if (StringUtil.isNotEmpty(conArticleQuery.getAttr())) {
            query.whereEqualTo("attr", conArticleQuery.getAttr());
        }
        if (StringUtil.isNotEmpty(conArticleQuery.getStatus())) {
            query.whereEqualTo("status", conArticleQuery.getStatus());
        }
        if (StringUtil.isNotEmpty(conArticleQuery.getKeywords())) {
            query.whereEqualTo("keywords", conArticleQuery.getKeywords());
        }
        if (StringUtil.isNotEmpty(conArticleQuery.getTopicObjectId())) {
            query.whereEqualTo("topicObj", AVObject.createWithoutData("AppTopics", conArticleQuery.getChannelObjectId()));
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


        List<AVObject> avObjectList = query.find();
        List<Map> conArticleList = new ArrayList<Map>();
        Map m;
        for (AVObject avObject : avObjectList) {
            m = new HashMap();
            m.put("objectId", avObject.getObjectId());
            m.put("title", avObject.get("title"));
            m.put("ctype", ConstantsUtil.getConstants("conArticleCtype", "" + avObject.get("ctype")));
            m.put("countrycode", avObject.get("countrycode"));
            if (avObject.getAVObject("topicObj") != null) {
                m.put("topicName", avObject.getAVObject("topicObj").get("topicName"));
            }
            if (avObject.getAVObject("publicationObj") != null) {
                m.put("publicationName", avObject.getAVObject("publicationObj").get("name"));
            }
            m.put("status", ConstantsUtil.getConstants("conArticleStatus", "" + avObject.get("status")));

            if (avObject.get("publishtime") != null) {
                Date publishtime = (Date) avObject.get("publishtime");
                m.put("publishtime", DateUtil.getTimeStampStr(publishtime));
            }
            if (avObject.get("createdAt") != null) {
                Date createdAt = (Date) avObject.get("createdAt");
                m.put("createdAt", DateUtil.getTimeStampStr(createdAt));
            }
            conArticleList.add(m);
        }
        map.put("conArticleList", conArticleList);

        /*pageUtil*/
        Integer count = query.count();
        pageUtil.setCurrentPage(page);
        pageUtil.setRecordCount(count);
        pageUtil.setPagecount(pageUtil.getPagecount());
        map.put("pageUtil", pageUtil);
        return map;
    }


    public Map getById(String objectId) throws AVException {
        AVQuery<AVObject> query = new AVQuery<>("conarticle");
        Map map = new HashMap();
        /*query.include("articleObj");
        query.include("articleObj.titlePicObjArr");

        AVObject avObject = query.get(objectId);


        map.put("objectId", avObject.getObjectId());
        map.put("countryObjectId", avObject.getAVObject("countryObj") == null ? "" : avObject.getAVObject("countryObj").getObjectId());
        map.put("languagesObjectId", avObject.getAVObject("languagesObj") == null ? "" : avObject.getAVObject("languagesObj").getObjectId());
        map.put("itype", ConstantsUtil.getAppTopItypeStr("" + avObject.get("iType")));
        if (avObject.getAVObject("articleObj") != null) {
            map.put("articleTitle", avObject.getAVObject("articleObj").get("title"));
            map.put("articleType", ConstantsUtil.getAppTopArtitypeStr("" + avObject.getAVObject("articleObj").get("attr")));
            List<AVFile> avFileList = avObject.getAVObject("articleObj").getList("titlePicObjArr");
            if (!avFileList.isEmpty() && avFileList.size() > 0) {
                map.put("picUrl", avFileList.get(0).getUrl());
            }
        }

        if (avObject.get("status") != null) {
            Date createdAt = (Date) avObject.get("createdAt");
            map.put("status", avObject.getString("status"));

        }
        if (avObject.get("createdAt") != null) {
            Date createdAt = (Date) avObject.get("createdAt");
            map.put("createdAt", DateUtil.getTimeStampStr(createdAt));

        }*/
        return map;
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
        if(subtime==null){
            avObject.put("status", 2);
        }else{
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

}
