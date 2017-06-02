package com.it7890.orange.manage.service;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.po.ConArticleQuery;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/31.
 */
public interface ConArticleService {
    public Map getAll(ConArticleQuery conArticleQuery, Integer page) throws AVException;
}
