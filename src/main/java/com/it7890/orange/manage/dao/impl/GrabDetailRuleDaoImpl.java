package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.GrabDetailRuleDao;
import com.it7890.orange.manage.model.GrabDetailRule;
import com.it7890.orange.manage.po.GrabDetailRuleQuery;
import com.it7890.orange.manage.utils.ConstantsUtil;
import com.it7890.orange.manage.utils.DateUtil;
import com.it7890.orange.manage.utils.PageUtil;
import com.it7890.orange.manage.utils.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */
@Repository
public class GrabDetailRuleDaoImpl implements GrabDetailRuleDao {

    @Override
    public Map getAll(GrabDetailRuleQuery grabDetailRuleQuery, Integer page) throws AVException {
        Map map = new HashMap();
        /*grabDetailRuleList*/
        AVQuery<GrabDetailRule> query = new AVQuery<>("GrabDetailRule");

        if (StringUtil.isNotEmpty(grabDetailRuleQuery.getRuleName())) {
            query.whereEqualTo("ruleName", grabDetailRuleQuery.getRuleName());
        }
        if (StringUtil.isNotEmpty(grabDetailRuleQuery.getStatus())) {
            query.whereEqualTo("status", grabDetailRuleQuery.getStatus());
        }
        query.orderByDescending("createdAt");

        PageUtil pageUtil = new PageUtil();
        Integer pageSize = pageUtil.getPageSize();
        query.skip((page - 1) * pageSize);
        query.limit(pageSize);
        query.include("grabListRuleObj");

        List<GrabDetailRule> grabDetailRuleList = query.find();
        List<Map> result = new ArrayList<Map>();
        Map m;
        for (GrabDetailRule grabDetailRule : grabDetailRuleList) {
            m = new HashMap();
            m.put("objectId", grabDetailRule.getObjectId());
            m.put("ruleName", grabDetailRule.getRuleName());
            m.put("createdAt", DateUtil.getTimeStampStr(grabDetailRule.getCreatedAt()));
            m.put("status", grabDetailRule.getStatus());
            m.put("statusStr", ConstantsUtil.getConstants("grabDetailRuleStatus", "" + grabDetailRule.getStatus()));
            result.add(m);
        }
        map.put("grabDetailRuleList", result);

        /*pageUtil*/
        Integer count = query.count();
        pageUtil.setRecordCount(count);
        pageUtil.setPagecount(pageUtil.getPagecount());
        pageUtil.setCurrentPage(page);
        map.put("pageUtil", pageUtil);
        return map;
    }



    public GrabDetailRule get(String objectId) throws AVException {
        AVQuery<GrabDetailRule> query = new AVQuery<>("GrabDetailRule");
        query.include("grabListRuleObj");
        query.include("nodeObj");
        GrabDetailRule grabDetailRule = query.get(objectId);
        return grabDetailRule;
    }

    public List<GrabDetailRule> get(GrabDetailRuleQuery grabDetailRuleQuery) throws AVException {
        AVQuery<GrabDetailRule> query = new AVQuery<>("GrabDetailRule");
        List<GrabDetailRule> grabDetailRuleList = query.find();
        return grabDetailRuleList;
    }

}
