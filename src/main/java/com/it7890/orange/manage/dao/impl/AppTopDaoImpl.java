package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.AppTopDao;
import com.it7890.orange.manage.model.AppTop;
import com.it7890.orange.manage.model.HbCountrys;
import com.it7890.orange.manage.po.AppTopQuery;
import com.it7890.orange.manage.utils.ConstantsUtil;
import com.it7890.orange.manage.utils.DateUtil;
import com.it7890.orange.manage.utils.PageUtil;
import com.it7890.orange.manage.utils.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Administrator on 2017/5/26.
 */
@Repository
public class AppTopDaoImpl implements AppTopDao {
    @Override
    public Map getAll(AppTopQuery appTopQuery, Integer page) throws AVException {
        Map map = new HashMap();

        /*appTopList*/
        AVQuery<AppTop> query = new AVQuery("AppTop");
        if (StringUtil.isNotEmpty(appTopQuery.getCountryCode())) {
            query.whereEqualTo("countryCode", appTopQuery.getCountryCode());
        }
        if (StringUtil.isNotEmpty(appTopQuery.getCountryObjectId())) {
            HbCountrys countrys=new HbCountrys();
            countrys.setObjectId(appTopQuery.getCountryObjectId());
            query.whereEqualTo("countryObj",countrys);
        }
        if (StringUtil.isNotEmpty(appTopQuery.getCtype())) {
            query.whereEqualTo("cType", appTopQuery.getCtype());
        }
        if (StringUtil.isNotEmpty(appTopQuery.getStartTime())) {
            query.whereGreaterThanOrEqualTo("createdAt", DateUtil.getDateByStr(appTopQuery.getStartTime()));
        }
        if (StringUtil.isNotEmpty(appTopQuery.getEndTime())) {
            query.whereLessThan("createdAt", DateUtil.addDay(DateUtil.getDateByStr(appTopQuery.getEndTime()), 1));
        }
        if (StringUtil.isNotEmpty(appTopQuery.getStatus())) {
            query.whereEqualTo("status", appTopQuery.getStatus());
        }
        if (StringUtil.isNotEmpty(appTopQuery.getItype())) {
            query.whereEqualTo("iType", appTopQuery.getItype());
        }
        query.orderByDescending("createdAt");

        PageUtil pageUtil = new PageUtil();
        Integer pageSize = pageUtil.getPageSize();
        query.skip((page - 1) * pageSize);
        query.limit(pageSize);
        query.include("languagesObj");
        query.include("countryObj");
        query.include("articleObj");
        query.include("articleObj.titlePicObjArr");


        List<AppTop> appTopList = query.find();
        List<Map> list = new ArrayList();
        Map m;
        for (AppTop appTop : appTopList) {
            m = new HashMap();
            m.put("objectId", appTop.getObjectId());
            m.put("status", appTop.getStatus());
            m.put("statusStr", ConstantsUtil.getConstants("appTopStatus", "" + appTop.getStatus()));
            m.put("createdAt", DateUtil.getTimeStampStr(appTop.getCreatedAt()));
            m.put("updatedAt", DateUtil.getTimeStampStr(appTop.getUpdatedAt()));

            m.put("itype", appTop.getItype());
            m.put("itypeStr", ConstantsUtil.getConstants("appTopItype", "" + appTop.getItype()));
            m.put("languageRemark", appTop.getLanguage() == null ? "" : appTop.getLanguage().getRemark());
            m.put("countryCnName", appTop.getCountry() == null ? "" : appTop.getCountry().getCnName());


            if (appTop.getArticle() != null) {
                m.put("articleTitle", appTop.getArticle().getTitle());
                m.put("articleType", appTop.getArticle().getAttr());
                m.put("articleTypeStr", ConstantsUtil.getConstants("appTopArtitype", "" + appTop.getArticle().getAttr()));
                List<AVFile> avFileList = appTop.getArticle().getTitlePicArr();
                if (avFileList!=null&&!avFileList.isEmpty()) {
                    m.put("picUrl", avFileList.get(0).getUrl());
                }
            }

            list.add(m);
        }
        map.put("appTopList", list);

        /*pageUtil*/
        Integer count = query.count();
        pageUtil.setRecordCount(count);
        pageUtil.setPagecount(pageUtil.getPagecount());
        pageUtil.setCurrentPage(page);
        map.put("pageUtil", pageUtil);
        return map;
    }

    public Map getAppTop(String objectId) throws AVException {
        AVQuery<AppTop> query = new AVQuery<>("AppTop");
        query.include("articleObj");
        query.include("articleObj.titlePicObjArr");

        AppTop appTop = query.get(objectId);

        Map map = new HashMap();
        map.put("objectId", appTop.getObjectId());
        map.put("countryObjectId", appTop.getCountry() == null ? "" : appTop.getCountry().getObjectId());
        map.put("languagesObjectId", appTop.getLanguage() == null ? "" : appTop.getLanguage().getObjectId());
        map.put("itype", appTop.getItype());
        map.put("itypeStr", ConstantsUtil.getConstants("appTopItype", "" + appTop.getItype()));
        if (appTop.getArticle() != null) {
            map.put("articleTitle", appTop.getArticle().getTitle());
            map.put("articleType", appTop.getArticle().getAttr());
            map.put("articleTypeStr", ConstantsUtil.getConstants("appTopArtitype", "" + appTop.getArticle().getAttr()));
            List<AVFile> avFileList = appTop.getArticle().getTitlePicArr();
            if (avFileList!=null&&!avFileList.isEmpty()) {
                map.put("picUrl", avFileList.get(0).getUrl());
            }
        }
        map.put("status", appTop.getStatus());
        map.put("statusStr", ConstantsUtil.getConstants("appTopStatus", "" + appTop.getStatus()));
        map.put("createdAt", DateUtil.getTimeStampStr(appTop.getCreatedAt()));

        return map;
    }

    public void saveOrUpdate(AppTopQuery appTopQuery) throws AVException {
        AVObject avObject = AVObject.createWithoutData("AppTop", appTopQuery.getObjectId());
        if (StringUtil.isNotEmpty(appTopQuery.getCountryObjectId())) {
            avObject.put("countryObj", AVObject.createWithoutData("hb_countrys", appTopQuery.getCountryObjectId()));
        }
        if (StringUtil.isNotEmpty(appTopQuery.getLanguagesObjectId())) {
            avObject.put("languagesObj", AVObject.createWithoutData("hb_languages", appTopQuery.getLanguagesObjectId()));
        }


        if (appTopQuery.getStatus() != null) {
            avObject.put("status", appTopQuery.getStatus());//1正常 0禁用 -1删除
        }
        //avObject.put("iType", 1);//1文章 2竞猜 3广告
        //avObject.put("longitude", appTopQuery.getLongitude());
        //avObject.put("latitude", appTopQuery.getLatitude());
        try {
            avObject.save();
            // 保存成功
        } catch (AVException e) {
            // 失败的话，请检查网络环境以及 SDK 配置是否正确
            e.printStackTrace();
        }


    }


}
