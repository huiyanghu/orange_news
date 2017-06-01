package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.base.dao.impl.BaseDaoImpl;
import com.it7890.orange.manage.dao.AppTopDao;
import com.it7890.orange.manage.model.AppTop;
import com.it7890.orange.manage.po.AppTopQuery;
import com.it7890.orange.manage.utils.ConstantsUtil;
import com.it7890.orange.manage.utils.DateUtil;
import com.it7890.orange.manage.utils.PageUtil;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Administrator on 2017/5/26.
 */
@Repository
public class AppTopDaoImpl extends BaseDaoImpl<AppTop> implements AppTopDao {
    @Override
    public Map getAll(AppTopQuery appTopQuery, Integer page) throws AVException {
        Map map = new HashMap();

        /*appTopList*/
        AVQuery<AVObject> query = new AVQuery<>("AppTop");
        if (appTopQuery.getCountryCode() != null && !"".equals(appTopQuery.getCountryCode())) {
            query.whereEqualTo("countryCode", appTopQuery.getCountryCode());
        }
        if (appTopQuery.getStartTime() != null && !"".equals(appTopQuery.getStartTime())) {
            query.whereGreaterThanOrEqualTo("createdAt", DateUtil.getDateByStr(appTopQuery.getStartTime()));
        }
        if (appTopQuery.getEndTime() != null && !"".equals(appTopQuery.getEndTime())) {
            query.whereLessThan("createdAt", DateUtil.addDay(DateUtil.getDateByStr(appTopQuery.getEndTime()), 1));
        }
        if (appTopQuery.getStatus() != null) {
            query.whereEqualTo("status", appTopQuery.getStatus());
        }
        if (appTopQuery.getItype() != null) {
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



        List<AVObject> avObjectList = query.find();
        List<Map> appTopList = new ArrayList<Map>();
        Map m;
        for (AVObject avObject : avObjectList) {
            m = new HashMap();
            m.put("objectId", avObject.getObjectId());

            if (avObject.get("createdAt") != null) {
                Date createdAt = (Date) avObject.get("createdAt");
                m.put("createdAt", DateUtil.getTimeStampStr(createdAt));

            }
            m.put("itype", ConstantsUtil.getAppTopItypeStr("" + avObject.get("iType")));
            if (avObject.getAVObject("languagesObj") != null) {
                m.put("languageRemark", avObject.getAVObject("languagesObj").get("remark"));
            }
            if (avObject.getAVObject("countryObj") != null) {
                m.put("countryCnName", avObject.getAVObject("countryObj").get("cnName"));
            }
            if (avObject.getAVObject("articleObj") != null) {
                m.put("articleTitle", avObject.getAVObject("articleObj").get("title"));
                m.put("articleType", ConstantsUtil.getAppTopArtitypeStr("" + avObject.getAVObject("articleObj").get("attr")));
                List<AVFile> avFileList = avObject.getAVObject("articleObj").getList("titlePicObjArr");
                if (!avFileList.isEmpty() && avFileList.size() > 0) {
                    m.put("picUrl", avFileList.get(0).getUrl());
                }
            }
            appTopList.add(m);
        }
        map.put("appTopList", appTopList);

        /*pageUtil*/
        Integer count = query.count();
        pageUtil.setCurrentPage(page);
        pageUtil.setRecordCount(count);
        pageUtil.setPagecount(pageUtil.getPagecount());
        map.put("pageUtil", pageUtil);
        return map;
    }

    public Map getAppTop(String objectId) throws AVException {
        AVQuery<AVObject> query = new AVQuery<>("AppTop");
        query.include("articleObj");
        query.include("articleObj.titlePicObjArr");

        AVObject avObject = query.get(objectId);

        Map map = new HashMap();
        map.put("objectId", avObject.getObjectId());
        map.put("countryObjectId", avObject.getAVObject("countryObj").getObjectId());
        map.put("languagesObjectId", avObject.getAVObject("languagesObj").getObjectId());
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

        }
        return map;
    }

    public void saveOrUpdate(AppTopQuery appTopQuery) throws AVException {
        if (appTopQuery.getObjectId() == null) {//save
            AppTop avObject = (AppTop)new AVObject("AppTop");
            avObject.put("countryObj", appTopQuery.getCountryObjectId());
            avObject.put("content", "每周工程师会议，周一下午2点");
            try {
                avObject.save();
                // 保存成功
            } catch (AVException e) {
                // 失败的话，请检查网络环境以及 SDK 配置是否正确
                e.printStackTrace();
            }
        } else {
            AVObject avObject = AVObject.createWithoutData("AppTop", appTopQuery.getObjectId());

        }


    }


}