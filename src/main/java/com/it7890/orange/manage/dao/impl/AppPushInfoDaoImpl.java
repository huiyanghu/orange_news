package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.AppPushInfoDao;
import com.it7890.orange.manage.model.AppPushInfo;
import com.it7890.orange.manage.po.AppPushInfoQuery;
import com.it7890.orange.manage.utils.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/5.
 */
@Repository
public class AppPushInfoDaoImpl implements AppPushInfoDao {

    public String saveOrUpdate(AppPushInfo appPushInfo) throws AVException {
        AVObject avObject;
        if (StringUtil.isNotEmpty(appPushInfo.getObjectId())) {//update
            avObject = AVObject.createWithoutData("AppPushInfo", appPushInfo.getObjectId());
        } else {
            avObject = new AVObject("AppPushInfo");
        }
        avObject.put("title", appPushInfo.getTitle());
        avObject.put("pushNum", appPushInfo.getPushNum());
        avObject.put("pushTime", appPushInfo.getPushTime());
        avObject.put("status", appPushInfo.getStatus());
        avObject.put("articleObj", AVObject.createWithoutData("conarticle", appPushInfo.getArticleObjectId()));
        avObject.put("countryObj", AVObject.createWithoutData("hb_countrys", appPushInfo.getCountryObjectId()));


        avObject.save();// 保存到服务端
        return avObject.getObjectId();
    }

    public List<AppPushInfo> get(AppPushInfoQuery appPushInfoQuery) throws AVException {
        AVQuery<AppPushInfo> query = new AVQuery<>("AppPushInfo");
        if (StringUtil.isNotEmpty(appPushInfoQuery.getObjectId())) {
            query.whereEqualTo("objectId", appPushInfoQuery.getObjectId());
        }
        if (StringUtil.isNotEmpty(appPushInfoQuery.getCountryObjectId())) {
            query.whereEqualTo("countryObj", AVObject.createWithoutData("hb_countrys", appPushInfoQuery.getCountryObjectId()));
        }
        if (StringUtil.isNotEmpty(appPushInfoQuery.getArticleObjectId())) {
            query.whereEqualTo("articleObj", AVObject.createWithoutData("conarticle", appPushInfoQuery.getArticleObjectId()));
        }
        query.include("articleObj");
        List<AppPushInfo> avObjectList = query.find();
        return avObjectList;
    }


}
