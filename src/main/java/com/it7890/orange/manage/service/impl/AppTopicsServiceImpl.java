package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.dao.AppTopicsDao;
import com.it7890.orange.manage.service.AppTopicsService;
import com.it7890.orange.manage.vo.AppTopicsDTO;
import com.it7890.orange.manage.vo.HbCountrysDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */
@Service
public class AppTopicsServiceImpl implements AppTopicsService {
    @Autowired
    AppTopicsDao appTopicsDao;

    public List<Map> getAppTopicsList() throws AVException {
        return appTopicsDao.getAppTopicsList();
    }

    @Override
    public List<AppTopicsDTO> getDtoList(String cid,String hid) {
        List<AVObject> ls = appTopicsDao.getListByCId(cid,null);
        return buildDto(ls);
    }

    @Override
    public int updateAppTopics(String countryId, List<AppTopicsDTO> delapptics, List<AVObject> addapptics, List<AppTopicsDTO> updateapptopics) {
        int result = 0;
        try{
            for (AppTopicsDTO appTopics : delapptics) {
                this.appTopicsDao.delByCidAndHid(countryId,appTopics.getHid());
            }
            for (AVObject appTopics : addapptics) {
                this.appTopicsDao.saveOrUpdate(appTopics);
            }
            for (AppTopicsDTO appTopics : updateapptopics) {
                List<AVObject> ls = this.appTopicsDao.getListByCId(countryId,appTopics.getHid());
                AVObject updateAvo = new AVObject("AppTopics");
                updateAvo.setObjectId(ls.get(0).getObjectId());
                updateAvo.put("keyWords",appTopics.getKeyWords());
                updateAvo.put("rank",appTopics.getRank());
                this.appTopicsDao.saveOrUpdate(updateAvo);
            }
            result = 1;
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public List<AppTopicsDTO> buildDto(List<AVObject> ls){
        List<AppTopicsDTO> dtols = null;
        if (ls!=null){
            dtols = new ArrayList<>();
            for (AVObject avo : ls){
                AppTopicsDTO dto = AppTopicsDTO.avo2dto(avo);
                dtols.add(dto);
            }
        }
        return dtols;
    }

}
