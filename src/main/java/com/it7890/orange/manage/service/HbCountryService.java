package com.it7890.orange.manage.service;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.model.HbCountrys;
import com.it7890.orange.manage.po.HbCountryQuery;
import com.it7890.orange.manage.vo.HbCountrysDTO;
import com.it7890.orange.manage.vo.HbLanguageDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/12.
 */
public interface HbCountryService {

    public List<HbCountrys> getAll();

    public List<HbCountrys> get(HbCountryQuery hbCountryQuery) throws AVException;

    public Map getAvoList();

    public List<Map> getCountryList() throws AVException;

    public List<HbCountrysDTO> getDtoList();

    public HbCountrysDTO getByCid(String cId);
}
