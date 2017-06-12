package com.it7890.orange.manage.service;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.GrabListRule;
import com.it7890.orange.manage.po.GrabListRuleQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */
public interface GrabListRuleService {
    public Map getAll(GrabListRuleQuery grabListRuleQuery, Integer page) throws AVException;

    public Map get(String objectId) throws AVException;

    public List<GrabListRule> get(GrabListRuleQuery grabListRuleQuery) throws AVException;

}
