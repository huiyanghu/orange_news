package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.dao.GrabDetailRuleDao;
import com.it7890.orange.manage.model.GrabDetailRule;
import com.it7890.orange.manage.po.GrabDetailRuleQuery;
import com.it7890.orange.manage.service.GrabDetailRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */
@Service
public class GrabDetailRuleServiceImpl implements GrabDetailRuleService {
    @Autowired
    private GrabDetailRuleDao grabDetailRuleDao;

    public Map getAll(GrabDetailRuleQuery grabDetailRuleQuery, Integer page) throws AVException {
        return grabDetailRuleDao.getAll(grabDetailRuleQuery, page);
    }

    public Map get(String objectId) throws AVException {
        GrabDetailRule grabDetailRule=grabDetailRuleDao.get(objectId);
        return null;
    }

    public List<GrabDetailRule> get(GrabDetailRuleQuery grabDetailRuleQuery) throws AVException {
        return null;
    }

}
