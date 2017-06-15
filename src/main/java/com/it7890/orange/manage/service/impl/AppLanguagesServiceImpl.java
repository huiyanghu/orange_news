package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.dao.AppLanguagesDao;
import com.it7890.orange.manage.service.AppLanguagesService;
import com.it7890.orange.manage.vo.AppLanguagesDTO;
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
