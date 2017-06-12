package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.model.HbLanguage;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/12.
 */
public interface LanguageDao {
    public List<HbLanguage> getAll();

    public List<AVObject> getLangList();

    public List<Map> getLanguageList() throws AVException;
}
