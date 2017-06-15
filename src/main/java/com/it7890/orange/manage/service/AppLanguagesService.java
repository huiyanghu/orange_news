package com.it7890.orange.manage.service;

import com.it7890.orange.manage.vo.AppLanguagesDTO;

import java.util.List;

/**
 * @author gg
 * @create 2017/6/15
 **/
public interface AppLanguagesService {
    public List<AppLanguagesDTO> getByCidAndHBlangId(String cid,String hblangId);
}
