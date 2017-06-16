package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.dao.AppLanguagesDao;
import com.it7890.orange.manage.service.AppLanguagesService;
import com.it7890.orange.manage.vo.AppLanguagesDTO;
import com.it7890.orange.manage.vo.AppTopicsDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gg
 * @create 2017/6/15
 **/
@Component
public class AppLanguagesServiceImpl implements AppLanguagesService {
    @Resource
    AppLanguagesDao appLanguagesDao;
    @Override
    public List<AppLanguagesDTO> getByCidAndHBlangId(String cid, String hblangId) {
        List<AVObject> ls = appLanguagesDao.getByCidAndLangId(cid,hblangId);
        return buileDtoList(ls);
    }

    @Override
    public int updateAppLang(String countryId, List<AppLanguagesDTO> delapplangs, List<AVObject> addapplangs) {
        int result = 0;
        try{
            for (AppLanguagesDTO appLanguagesDTO : delapplangs) {
                this.appLanguagesDao.delLangByCidAndHbid(countryId,appLanguagesDTO.getHbLangId());
            }
            for (AVObject appTopics : addapplangs) {
                this.appLanguagesDao.saveOrUpdate(appTopics);
            }
            result = 1;
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static List<AppLanguagesDTO> buileDtoList(List<AVObject> ls){
        List<AppLanguagesDTO> dtoList = new ArrayList<>();
        AppLanguagesDTO appLanguagesDTO = null;
        if (ls!=null){
            appLanguagesDTO = new AppLanguagesDTO();
            for (AVObject avObject:ls){
                appLanguagesDTO = AppLanguagesDTO.avo2dto(avObject);
                dtoList.add(appLanguagesDTO);
            }
        }
        return dtoList;
    }
}
