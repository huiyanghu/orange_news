package com.it7890.orange.manage.service;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.GrabDetailRule;
import com.it7890.orange.manage.po.GrabDetailRuleQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */
public interface GrabDetailRuleService {
    public Map getAll(GrabDetailRuleQuery grabDetailRuleQuery, Integer page) throws AVException;

    public Map get(String objectId) throws AVException;

    public GrabDetailRule getGrabDetailRule(String objectId)throws AVException;

    public List<GrabDetailRule> get(GrabDetailRuleQuery grabDetailRuleQuery) throws AVException;
}
