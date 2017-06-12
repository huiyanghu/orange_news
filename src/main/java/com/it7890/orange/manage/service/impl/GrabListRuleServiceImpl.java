package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.dao.GrabListRuleDao;
import com.it7890.orange.manage.model.GrabListRule;
import com.it7890.orange.manage.po.GrabListRuleQuery;
import com.it7890.orange.manage.service.GrabListRuleService;
import com.it7890.orange.manage.utils.ConstantsUtil;
import com.it7890.orange.manage.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */
@Service
public class GrabListRuleServiceImpl implements GrabListRuleService {
    @Autowired
    GrabListRuleDao grabListRuleDao;

    public Map getAll(GrabListRuleQuery grabListRuleQuery, Integer page) throws AVException {
        return grabListRuleDao.getAll(grabListRuleQuery, page);
    }

    public Map get(String objectId) throws AVException {
        GrabListRule grabListRule = grabListRuleDao.get(objectId);
        Map map = new HashMap();
        map.put("ruleName", grabListRule.getRuleName());
        map.put("publicationObjectId", grabListRule.getConPublication() == null ? "" : grabListRule.getConPublication().getObjectId());
        map.put("publicationName", grabListRule.getConPublication() == null ? "" : grabListRule.getConPublication().getName());
        map.put("nodeObjectId", grabListRule.getGlobalNode() == null ? "" : grabListRule.getGlobalNode().getObjectId());
        map.put("nodeName", grabListRule.getGlobalNode() == null ? "" : grabListRule.getGlobalNode().getNodename());
        map.put("channelObjectId", grabListRule.getConChannel() == null ? "" : grabListRule.getConChannel().getObjectId());
        map.put("channelName", grabListRule.getConChannel() == null ? "" : grabListRule.getConChannel().getChannelName());
        map.put("createdAt", DateUtil.getTimeStampStr(grabListRule.getCreatedAt()));
        map.put("zifu", grabListRule.getSiteUrl());
        map.put("countryCode", grabListRule.getCountryCode());
        map.put("languageObjectId", grabListRule.getHbLanguage() == null ? "" : grabListRule.getHbLanguage().getObjectId());
        map.put("languageCode", grabListRule.getHbLanguage() == null ? "" : grabListRule.getHbLanguage().getCodes());

        map.put("countryObjectId", grabListRule.getCountry() == null ? "" : grabListRule.getCountry().getObjectId());
        map.put("countryCnName", grabListRule.getCountry() == null ? "" : grabListRule.getCountry().getCnName());

        map.put("topicObjectId", grabListRule.getHbTopics() == null ? "" : grabListRule.getHbTopics().getObjectId());
        map.put("topicName", grabListRule.getHbTopics() == null ? "" : grabListRule.getHbTopics().getName());
        map.put("cssPath", grabListRule.getCssPath());
        map.put("findPre", grabListRule.getFindPre());

        map.put("status", grabListRule.getStatus());
        map.put("listStatus", grabListRule.getListStatus());
        map.put("statusStr", ConstantsUtil.getConstants("grabListRuleStatus", "" + grabListRule.getStatus()));
        map.put("listStatusStr", ConstantsUtil.getConstants("grabListRuleListStatus", "" + grabListRule.getListStatus()));
        map.put("grabTime", grabListRule.getGrabTime());

        return map;
    }

    public List<GrabListRule> get(GrabListRuleQuery grabListRuleQuery) throws AVException {
        return grabListRuleDao.get(grabListRuleQuery);
    }
}
