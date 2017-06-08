package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.model.HbLanguage;

import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */
public interface LanguageDao {
    public List<HbLanguage> getAll();

    public List<AVObject> getLangList();
}
