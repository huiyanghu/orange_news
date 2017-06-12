package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.GrabDetailRule;
import com.it7890.orange.manage.po.GrabDetailRuleQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/9.
 */
public interface GrabDetailRuleDao {
    public Map getAll(GrabDetailRuleQuery grabDetailRuleQuery, Integer page) throws AVException;

    public GrabDetailRule get(String objectId) throws AVException;

    public List<GrabDetailRule> get(GrabDetailRuleQuery grabDetailRuleQuery) throws AVException;

}
