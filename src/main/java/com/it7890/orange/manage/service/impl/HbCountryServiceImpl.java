package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.dao.HbCountryDao;
import com.it7890.orange.manage.model.HbCountrys;
import com.it7890.orange.manage.po.HbCountryQuery;
import com.it7890.orange.manage.service.HbCountryService;
import com.it7890.orange.manage.utils.DateUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2017/5/12.
 */
@Component
public class HbCountryServiceImpl implements HbCountryService {

    @Resource
    HbCountryDao hbCountryDao;

    @Override
    public List<HbCountrys> getAll() {
        return hbCountryDao.getAll();
    }
    @Override
    public List<HbCountrys> get(HbCountryQuery hbCountryQuery) throws AVException{
        return hbCountryDao.get(hbCountryQuery);
    }

    @Override
    public Map getAvoList() {
        Map map = new HashMap();
        List<AVObject> ls = hbCountryDao.getAvoList();
        List<Map> countryList = new ArrayList<Map>();
        Map m;
        for (AVObject avObject : ls) {
            m = new HashMap();
            m.put("objectId", avObject.getObjectId());
//            m.put("status", avObject.getInt("status"));
            m.put("createdAt", DateUtil.getTimeStampStr(avObject.getCreatedAt()));
            m.put("cnName", avObject.getString("cnName"));
            m.put("countryCode",avObject.getString("countryCode"));
            countryList.add(m);
        }
        map.put("countryList", countryList);
        return map;
    }
}
