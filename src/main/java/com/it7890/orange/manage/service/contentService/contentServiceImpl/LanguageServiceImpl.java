package com.it7890.orange.manage.service.contentService.contentServiceImpl;

import com.it7890.orange.manage.dao.LanguageDao;
import com.it7890.orange.manage.model.HbLanguage;
import com.it7890.orange.manage.service.contentService.LanguageService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
}
