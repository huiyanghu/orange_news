package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.RecommendArtDao;
import com.it7890.orange.manage.utils.DateUtil;
import com.it7890.orange.manage.utils.PageUtil;
import com.it7890.orange.manage.utils.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyq on 2017/6/6.
 */
@Component
public class RecommendArtDaoImpl implements RecommendArtDao {
    private static final Logger logger = LogManager.getLogger(RecommendArtDaoImpl.class);
    @Override
    public List<AVObject> getList(int pushNum, String countryCode, String startDate, String endDate,int page) throws AVException, ParseException {
        PageUtil pageUtil = new PageUtil();
        int pageSize = pageUtil.getPageSize();
        int skip = (page-1)*pageSize;
        AVQuery avQueryArt = new AVQuery("conarticle");
        avQueryArt.orderByDescending("createdAt");
        avQueryArt.whereEqualTo("status",0);
        avQueryArt.whereEqualTo("ctype",0);
        List<AVObject> ls = new ArrayList<>();
        if(pushNum!=0){
            avQueryArt.whereEqualTo("pushnum",pushNum);
        }
        if (StringUtil.isNotEmpty(countryCode)){
            avQueryArt.whereEqualTo("countrycode",countryCode);
        }
        if(StringUtil.isNotEmpty(startDate)){
            avQueryArt.whereGreaterThanOrEqualTo("createdAt", DateUtil.getDateByStr(startDate));
        }
        if (StringUtil.isNotEmpty(endDate)){
            avQueryArt.whereLessThan("createdAt",DateUtil.addDay(DateUtil.getDateByStr(endDate), 1));
        }





        avQueryArt.limit(pageSize);
        avQueryArt.skip(skip);
        try {
            ls = avQueryArt.find();
        }catch (Exception e){
            logger.info(e.getMessage());
        }
        return ls;
    }

    @Override
    public int getCount() {
        int count = 0;
        AVQuery avQuery = new AVQuery("conarticle");
        try {
            count = avQuery.count();
        }catch (Exception e){
            logger.info(e.getMessage());
        }
        return count;
    }
}
