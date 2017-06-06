package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.dao.RecommendArtDao;
import com.it7890.orange.manage.service.RecommendArtService;
import com.it7890.orange.manage.utils.ConstantsUtil;
import com.it7890.orange.manage.utils.DateUtil;
import com.it7890.orange.manage.utils.PageUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.*;

/**
 * Created by wyq on 2017/6/6.
 */
@Component
public class RecommendArtServiceImpl implements RecommendArtService {
    @Resource
    RecommendArtDao recommendArtDao;
    @Override
    public Map getList(int pushNum, String countryCode, String startDate, String endDate, int page) throws AVException, ParseException {
        PageUtil pageUtil = new PageUtil();
        Map map = new HashMap();
        int count = recommendArtDao.getCount();
        List<AVObject> ls = recommendArtDao.getList(pushNum, countryCode, startDate, endDate,page);
        List<Map> artList = new ArrayList<Map>();
        Map m;
        for (AVObject avObject : ls) {
            m = new HashMap();
            m.put("objectId", avObject.getObjectId());
            m.put("status", avObject.getString("status"));
            m.put("artType", ConstantsUtil.getConstants("appTopArtitype",""+Integer.valueOf(avObject.getInt("attr"))));
            m.put("createdAt", DateUtil.getTimeStampStr(avObject.getCreatedAt()));
//            m.put("abstracts", avObject.getString("abstracts"));
            m.put("title",avObject.getString("title"));
            m.put("pushNum",avObject.getInt("pushnum"));
            m.put("countryCode",avObject.getString("countrycode"));
            artList.add(m);
        }
        map.put("artList", artList);
        pageUtil.setCurrentPage(page);
        pageUtil.setRecordCount(count);
        pageUtil.setPagecount(pageUtil.getPagecount());
        map.put("pageUtil", pageUtil);
        return map;
    }
}
