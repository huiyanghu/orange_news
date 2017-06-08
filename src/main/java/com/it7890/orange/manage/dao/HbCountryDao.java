package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.model.HbCountrys;
import com.it7890.orange.manage.po.HbCountryQuery;

import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */
public interface HbCountryDao {

    public List<HbCountrys> getAll();
    public List<HbCountrys> get(HbCountryQuery hbCountryQuery) throws AVException;
    public List<AVObject> getAvoList();
    public String saveHbAvo(AVObject avObject);

}
