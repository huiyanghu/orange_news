package com.it7890.orange.manage.service.applicationService;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.HbCountrys;
import com.it7890.orange.manage.po.HbCountryQuery;

import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */
public interface HbCountryService {

    public List<HbCountrys> getAll();

    public List<HbCountrys> get(HbCountryQuery hbCountryQuery) throws AVException;
}
