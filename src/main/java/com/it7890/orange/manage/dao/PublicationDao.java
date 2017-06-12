package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.ConPublication;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/11.
 */
public interface PublicationDao {
    public List<ConPublication> getAll();

    public List<Map> getPublictionList() throws AVException;
}
