package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.AppAdvertDao;
import com.it7890.orange.manage.model.AppAdvert;
import com.it7890.orange.manage.po.AppAdvertQuery;
import com.it7890.orange.manage.utils.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/5.
 */
@Repository
public class AppAdvertDaoImpl implements AppAdvertDao {
    public String saveOrUpdate(AppAdvert appAdvert) throws AVException {
        AVObject avObject;
        if (StringUtil.isNotEmpty(appAdvert.getObjectId())) {//update
            avObject = AVObject.createWithoutData("AppAdvert", appAdvert.getObjectId());
        } else {
            avObject = new AVObject("AppPushInfo");
        }
        /*avObject.put("title", appPushInfo.getTitle());
        avObject.put("pushNum", appPushInfo.getPushNum());
        avObject.put("pushTime", appPushInfo.getPushTime());
        avObject.put("status", appPushInfo.getStatus());
        avObject.put("articleObj", AVObject.createWithoutData("conarticle", appPushInfo.getArticleObjectId()));
        avObject.put("countryObj", AVObject.createWithoutData("hb_countrys", appPushInfo.getCountryObjectId()));*/

        avObject.save();// 保存到服务端
        return avObject.getObjectId();
    }

    public AppAdvert get(String objectId) throws AVException {
        AVQuery<AppAdvert> avQuery = new AVQuery<>("AppAdvert");
        AppAdvert appAdvert = avQuery.get(objectId);
        return appAdvert;
    }

    public List<AppAdvert> get(AppAdvertQuery appAdvertQuery) throws AVException {
        AVQuery<AppAdvert> query = new AVQuery<>("AppAdvert");
        if (StringUtil.isNotEmpty(appAdvertQuery.getObjectId())) {
            query.whereEqualTo("objectId", appAdvertQuery.getObjectId());
        }
        if (StringUtil.isNotEmpty(appAdvertQuery.getArticleObjectId())) {
            query.whereEqualTo("articleObj", AVObject.createWithoutData("conarticle", appAdvertQuery.getArticleObjectId()));
        }

        query.include("languageObj");
        List<AppAdvert> appAdvertList = query.find();

        return appAdvertList;
    }
}
