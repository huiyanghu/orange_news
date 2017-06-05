package com.it7890.orange.manage.service.articalService;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.HbCountrys;
import com.it7890.orange.manage.po.HbCountryQuery;

import java.util.List;

/**
 * HbCountrys service层接口
 *
 * @author lihaiguang
 */
public interface IHbCountrysService {

    /**
     * 获取HbCountrys集合
     */
    public List<HbCountrys> getHbCountrysAll();

    /**
     * 获取HbCountrys集合,并按国家码排序
     */
    public List<HbCountrys> getHbCountrysAllOrderByCode();


}
