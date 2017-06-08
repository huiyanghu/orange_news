package com.it7890.orange.manage.service;

import com.it7890.orange.manage.model.HbLanguage;
import com.it7890.orange.manage.vo.HbLanguageDTO;

import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */
public interface LanguageService {
    public List<HbLanguage> getAll();
    public List<HbLanguageDTO> getDTOList();

}
