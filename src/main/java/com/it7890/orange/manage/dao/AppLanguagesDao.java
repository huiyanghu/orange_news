package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVObject;

import java.util.List;

/**
 * @author gg
 * @create 2017/6/15
 **/
public interface AppLanguagesDao {
    public List<AVObject> getByCidAndLangId(String cid,String HBlangId);
}
