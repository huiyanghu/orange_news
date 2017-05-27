package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.AppTopDao;
import com.it7890.orange.manage.po.AppTopQuery;
import com.it7890.orange.manage.utils.PageUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */
@Repository
public class AppTopDaoImpl implements AppTopDao {


    @Override
    public List<AVObject> getAll(AppTopQuery appTopQuery, Integer page) throws AVException {
        AVQuery<AVObject> query = new AVQuery<>("AppTop");

        if (appTopQuery.getcType() != null) {
            query.whereEqualTo("cType", appTopQuery.getcType());
        }


        PageUtil pageUtil = new PageUtil();
        query.orderByDescending("createdAt");//按创建时间降序
        Integer pageSize = pageUtil.getPageSize();
        query.skip((page - 1) * pageSize);
        query.limit(pageSize);
        query.include("languagesObj");
        List<AVObject> appTopList = query.find();
        /*for (AVObject avObject:appTopList){
            System.out.println(avObject.getObjectId());
            System.out.println(avObject.get("cType"));
        }*/
        return appTopList;
    }
}
