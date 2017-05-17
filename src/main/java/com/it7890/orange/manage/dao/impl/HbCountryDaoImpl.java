package com.it7890.orange.manage.dao.impl;

import com.it7890.orange.manage.dao.HbCountryDao;
import com.it7890.orange.manage.model.HbCountrys;
import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVQuery;
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
            result =  AVQuery.doCloudQuery(cql, HbCountrys.class);
            list = (List<HbCountrys>) result.getResults();
        } catch (Exception e) {
        }
        return   list;
    }

}
