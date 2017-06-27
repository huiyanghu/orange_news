package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.HbCountryDao;
import com.it7890.orange.manage.model.HbCountrys;
import com.it7890.orange.manage.po.HbCountryQuery;
import com.it7890.orange.manage.utils.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */
@Component
public class HbCountryDaoImpl implements HbCountryDao {
    private static final Logger logger = LogManager.getLogger(HbCountryDaoImpl.class);

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
        query.include("iconFileObj");
        if (StringUtil.isNotEmpty(hbCountryQuery.getCountryCode())) {
            query.whereEqualTo("countryCode", hbCountryQuery.getCountryCode());
        }
        if (StringUtil.isNotEmpty(hbCountryQuery.getStatus())) {
            query.whereEqualTo("status", hbCountryQuery.getStatus());
        }

        List<HbCountrys> hbCountrysList = query.find();
        return hbCountrysList;
    }

    @Override
    public List<AVObject> getAvoList() {
        AVQuery query = new AVQuery("hb_countrys");
        query.include("iconFileObj");
        query.whereEqualTo("status", 1);
        List<AVObject> ls = new ArrayList<>();
        try {
            ls = query.find();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return ls;
    }

    @Override
    public String saveHbAvo(AVObject avObject) {
        String cid = "0";
        try {
            avObject.save();
            cid = avObject.getObjectId();
        } catch (AVException e) {
            e.printStackTrace();
        }
        logger.info("操作成功,国家id:::>>>>" + cid);
        return cid;
    }

    @Override
    public AVObject getByCid(String cId) {
        AVQuery avQuery = new AVQuery("hb_countrys");
        AVObject avObject = null;
        try {
            avObject = avQuery.get(cId);
        } catch (AVException e) {
            e.printStackTrace();
        }
        return avObject;
    }

}
