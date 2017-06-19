package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.GrabListRuleDao;
import com.it7890.orange.manage.model.GrabListRule;
import com.it7890.orange.manage.po.GrabListRuleQuery;
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
 * Created by Administrator on 2017/6/9.
 */
@Repository
public class GrabListRuleDaoImpl implements GrabListRuleDao {
    @Override
    public Map getAll(GrabListRuleQuery grabListRuleQuery, Integer page) throws AVException {
        Map map = new HashMap();

        /*grabListRuleList*/
        AVQuery<GrabListRule> query = new AVQuery<>("GrabListRule");

        if (StringUtil.isNotEmpty(grabListRuleQuery.getRuleName())) {
            query.whereEqualTo("ruleName", grabListRuleQuery.getRuleName());
        }
        if (StringUtil.isNotEmpty(grabListRuleQuery.getCountryCode())) {
            query.whereEqualTo("countryCode", grabListRuleQuery.getCountryCode());
        }
        if (StringUtil.isNotEmpty(grabListRuleQuery.getNodeObjectId())) {
            query.whereEqualTo("nodeObj", AVObject.createWithoutData("GlobalNode", grabListRuleQuery.getNodeObjectId()));
        }
        if (StringUtil.isNotEmpty(grabListRuleQuery.getTopicObjectId())) {
            query.whereEqualTo("topicObj", AVObject.createWithoutData("hb_topics", grabListRuleQuery.getTopicObjectId()));
        }
        if (StringUtil.isNotEmpty(grabListRuleQuery.getPublicationObjectId())) {
            query.whereEqualTo("publicationObj", AVObject.createWithoutData("con_publications", grabListRuleQuery.getPublicationObjectId()));
        }
        if (StringUtil.isNotEmpty(grabListRuleQuery.getChannelObjectId())) {
            query.whereEqualTo("channelObj", AVObject.createWithoutData("con_channel", grabListRuleQuery.getChannelObjectId()));
        }
        query.orderByDescending("createdAt");

        PageUtil pageUtil = new PageUtil();
        Integer pageSize = pageUtil.getPageSize();

        query.skip((page - 1) * pageSize);
        query.limit(pageSize);

        query.include("publicationObj");
        query.include("topicObj");
        query.include("nodeObj");
        query.include("countryObj");


        List<GrabListRule> grabListRuleList = query.find();
        List<Map> result = new ArrayList<Map>();
        Map m;
        for (GrabListRule grabListRule : grabListRuleList) {
            m = new HashMap();
            m.put("objectId", grabListRule.getObjectId());
            m.put("ruleName", grabListRule.getRuleName());
            m.put("publicationName", grabListRule.getConPublication() == null ? "" : grabListRule.getConPublication().getName());
            m.put("topicName", grabListRule.getTopics() == null ? "" : grabListRule.getTopics().getTopicName());
            m.put("nodeName", grabListRule.getGlobalNode() == null ? "" : grabListRule.getGlobalNode().getNodename());
            m.put("countryCode", grabListRule.getCountry()==null?"":grabListRule.getCountry().getCountryCode());
            m.put("createdAt", DateUtil.getTimeStampStr(grabListRule.getCreatedAt()));
            m.put("status", grabListRule.getStatus());
            m.put("listStatus", grabListRule.getListStatus());
            m.put("statusStr", ConstantsUtil.getConstants("grabListRuleStatus", "" + grabListRule.getStatus()));
            m.put("listStatusStr", ConstantsUtil.getConstants("grabListRuleListStatus", "" + grabListRule.getListStatus()));
            result.add(m);
        }
        map.put("grabListRuleList", result);

        /*pageUtil*/
        Integer count = query.count();
        pageUtil.setRecordCount(count);
        pageUtil.setPagecount(pageUtil.getPagecount());
        pageUtil.setCurrentPage(page);
        map.put("pageUtil", pageUtil);
        return map;
    }


    public GrabListRule get(String objectId) throws AVException {
        AVQuery<GrabListRule> query = new AVQuery<>("GrabListRule");
        query.include("languageObj");
        query.include("publicationObj");
        query.include("topicObj");
        query.include("nodeObj");
        query.include("channelObj");
        query.include("countryObj");
        GrabListRule grabListRule = query.get(objectId);
        return grabListRule;
    }

    public List<GrabListRule> get(GrabListRuleQuery grabListRuleQuery) throws AVException {
        AVQuery<GrabListRule> query = new AVQuery<>("GrabListRule");
        query.limit(1000);
        if (StringUtil.isNotEmpty(grabListRuleQuery.getChannelObjectId())) {
            query.whereEqualTo("channelObj", AVObject.createWithoutData("con_channel", grabListRuleQuery.getChannelObjectId()));
        }
        List<GrabListRule> grabListRuleList = query.find();
        return grabListRuleList;
    }
}
