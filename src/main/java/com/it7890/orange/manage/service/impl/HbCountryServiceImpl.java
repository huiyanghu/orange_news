package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.dao.AppTopicsDao;
import com.it7890.orange.manage.dao.HbCountryDao;
import com.it7890.orange.manage.model.HbCountrys;
import com.it7890.orange.manage.po.HbCountryQuery;
import com.it7890.orange.manage.service.HbCountryService;
import com.it7890.orange.manage.utils.DateUtil;
import com.it7890.orange.manage.vo.HbCountrysDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/12.
 */
@Component
public class HbCountryServiceImpl implements HbCountryService {
    private static final Logger logger = LogManager.getLogger(HbCountryServiceImpl.class);

    @Resource
    HbCountryDao hbCountryDao;
    @Resource
    AppTopicsDao appTopicsDao;

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
            if (avObject.getAVFile("iconFileObj")!=null){
                m.put("countryIcon",avObject.getAVFile("iconFileObj").getUrl());
            }
            m.put("cnName", avObject.getString("cnName"));
            m.put("countryCode",avObject.getString("countryCode"));
            m.put("shortName",avObject.getString("shortName"));
            m.put("continent",avObject.getString("continent"));
            List<AVObject> topicLs = appTopicsDao.getListByCId(avObject.getObjectId(),null);
            logger.info(":::>>>>>>>>>>"+avObject.getString("cnName")+topicLs.size());
            List<String> topicList = new ArrayList<>();
            for(AVObject obj:topicLs) {
                topicList.add(obj.getString("topicName"));
            }
            m.put("topicList",topicList);
//            m.put("status", avObject.getInt("status"));
            m.put("createdAt", DateUtil.getTimeStampStr(avObject.getCreatedAt()));
            countryList.add(m);
        }
        map.put("countryList", countryList);
        return map;
    }

    public List<Map> getCountryList() throws AVException{
        List<HbCountrys> hbCountrysList= hbCountryDao.get(new HbCountryQuery());
        List<Map> list = new ArrayList<>();
        Map map ;
        for (HbCountrys hbCountrys : hbCountrysList) {
            map = new HashMap();
            map.put("objectId", hbCountrys.getObjectId());
            map.put("cnName", hbCountrys.getCnName());
            map.put("continent", hbCountrys.getContinent());
            map.put("countryCode", hbCountrys.getCountryCode());
            map.put("shortName", hbCountrys.getShortName());
            list.add(map);
        }
        return list;
    }

    @Override
    public List<HbCountrysDTO> getDtoList() {
        List<AVObject> ls = hbCountryDao.getAvoList();
        return buildDtoList(ls);
    }

    @Override
    public HbCountrysDTO getByCid(String cId) {
        AVObject avo = hbCountryDao.getByCid(cId);
        return HbCountrysDTO.avo2dto(avo);
    }

    public List<HbCountrysDTO> buildDtoList(List<AVObject> ls){
        List<HbCountrysDTO> dtols = null;
        if (ls!=null){
            dtols = new ArrayList<>();
            for (AVObject avo : ls){
                HbCountrysDTO dto = HbCountrysDTO.avo2dto(avo);
                dtols.add(dto);
            }
        }
        return dtols;
    }
}
