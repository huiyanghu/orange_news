package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.GrabListRule;
import com.it7890.orange.manage.po.GrabListRuleQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/9.
 */
public interface GrabListRuleDao {
    public Map getAll(GrabListRuleQuery grabListRuleQuery, Integer page) throws AVException;

    public GrabListRule get(String objectId) throws AVException;

    public List<GrabListRule> get(GrabListRuleQuery grabListRuleQuery) throws AVException;
}
