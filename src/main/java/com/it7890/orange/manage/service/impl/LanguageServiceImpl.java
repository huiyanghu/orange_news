package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.dao.LanguageDao;
import com.it7890.orange.manage.model.HbLanguage;
import com.it7890.orange.manage.service.LanguageService;
import com.it7890.orange.manage.vo.HbLanguageDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */
@Component
public class LanguageServiceImpl implements LanguageService {
    @Resource
    LanguageDao languageDao;

    @Override
    public List<HbLanguage> getAll() {
        return this.languageDao.getAll();
    }

    @Override
    public List<HbLanguageDTO> getDTOList() {
        List<AVObject> ls = languageDao.getLangList();
        return avo2dto(ls);
    }

    public List<HbLanguageDTO> avo2dto(List<AVObject> ls){
        HbLanguageDTO hbLanguageDTO;
        List<HbLanguageDTO> dtoList = new ArrayList<>();
        for (AVObject avo : ls){
            hbLanguageDTO = HbLanguageDTO.avo2Dto(avo);
            if (null!=hbLanguageDTO){
                dtoList.add(hbLanguageDTO);
            }
        }
        return dtoList;
    }

}
