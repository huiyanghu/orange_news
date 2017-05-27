package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.dao.AppTopDao;
import com.it7890.orange.manage.po.AppTopQuery;
import com.it7890.orange.manage.service.AppTopService;
import com.it7890.orange.manage.utils.ConstantsUtil;
import com.it7890.orange.manage.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2017/5/26.
 */
@Service
public class AppTopServiceImpl implements AppTopService {
    @Autowired
    AppTopDao appTopDao;

    public List<Map> getAll(AppTopQuery appTopQuery, Integer page) throws AVException{
        List<AVObject> avObjectList=appTopDao.getAll(appTopQuery,page);
        List<Map> appTopList=new ArrayList<Map>();
        Map map;
        for (AVObject avObject:avObjectList) {
            map=new HashMap();
            map.put("objectId",avObject.getObjectId());
            if(avObject.get("createdAt")!=null){
                Date createdAt=(Date)avObject.get("createdAt");
                map.put("createdAt", StringUtil.formatDateYYYYMMDDHHMMSS(createdAt));
            }

            map.put("iType", ConstantsUtil.getAppTopItypeStr(""+avObject.get("iType")));

            if(avObject.getAVObject("languagesObj")!=null){
                map.put("languageRemark",avObject.getAVObject("languagesObj").get("remark"));
            }
            appTopList.add(map);
        }
        return appTopList;
    }

}
