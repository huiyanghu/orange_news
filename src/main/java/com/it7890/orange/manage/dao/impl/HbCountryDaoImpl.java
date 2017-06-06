package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.HbCountryDao;
import com.it7890.orange.manage.model.HbCountrys;
import com.it7890.orange.manage.po.HbCountryQuery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */
@Component
public class HbCountryDaoImpl implements HbCountryDao {
    @Override
    public List<HbCountrys> getAll() {
        List<HbCountrys> list = new ArrayList<>();
        AVCloudQueryResult result;
        try {
            String cql = "select * from hb_countrys where status = 0";
            result = AVQuery.doCloudQuery(cql, HbCountrys.class);
            list = (List<HbCountrys>) result.getResults();
        } catch (Exception e) {
        }
        return list;
    }

    public List<HbCountrys> get(HbCountryQuery hbCountryQuery) throws AVException {
        AVQuery<HbCountrys> query = new AVQuery<>("hb_countrys");
        query.whereEqualTo("countryCode", hbCountryQuery.getCountryCode());
        List<HbCountrys> avObjectList = query.find();
        if (!avObjectList.isEmpty()) {
            return avObjectList;
        }
        return null;
    }

    @Override
    public List<AVObject> getAvoList() {
        AVQuery query = new AVQuery("hb_countrys");
        query.whereEqualTo("status",0);
        List<AVObject> ls = new ArrayList<>();
        try {
           ls =  query.find();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return ls;
    }

}
