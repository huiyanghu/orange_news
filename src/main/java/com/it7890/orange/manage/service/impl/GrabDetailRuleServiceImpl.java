package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.dao.GrabDetailRuleDao;
import com.it7890.orange.manage.model.GrabDetailRule;
import com.it7890.orange.manage.po.GrabDetailRuleQuery;
import com.it7890.orange.manage.service.GrabDetailRuleService;
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
public class GrabDetailRuleServiceImpl implements GrabDetailRuleService {
    @Autowired
    private GrabDetailRuleDao grabDetailRuleDao;

    public Map getAll(GrabDetailRuleQuery grabDetailRuleQuery, Integer page) throws AVException {
        return grabDetailRuleDao.getAll(grabDetailRuleQuery, page);
    }

    public Map get(String objectId) throws AVException {
        GrabDetailRule grabDetailRule = grabDetailRuleDao.get(objectId);
        Map map = new HashMap();

        map.put("objectId", grabDetailRule.getObjectId());
        map.put("ruleName", grabDetailRule.getRuleName());
        map.put("grabListRuleObjectId", grabDetailRule.getGrabListRule()==null?"":grabDetailRule.getGrabListRule().getObjectId());
        map.put("grabListRuleRuleName", grabDetailRule.getGrabListRule()==null?"":grabDetailRule.getGrabListRule().getRuleName());
        map.put("globalNodeName", grabDetailRule.getGlobalNode()==null?"":grabDetailRule.getGlobalNode().getNodename());
        map.put("globalNodeObjectId", grabDetailRule.getGlobalNode()==null?"":grabDetailRule.getGlobalNode().getObjectId());
        map.put("titleCssPath", grabDetailRule.getTitleCssPath());
        map.put("descCssPath", grabDetailRule.getDescCssPath());
        map.put("keywordCssPath", grabDetailRule.getKeywordCssPath());
        map.put("conCssPath", grabDetailRule.getConCssPath());
        map.put("conCssPath1", grabDetailRule.getConCssPath1());
        map.put("conCssPath2", grabDetailRule.getConCssPath2());
        map.put("replaceCssPath", grabDetailRule.getReplaceCssPath());
        map.put("replaceRule", grabDetailRule.getReplaceRule());
        map.put("souCssPath", grabDetailRule.getSouCssPath());
        map.put("imgCssPath", grabDetailRule.getImgCssPath());
        map.put("videoCssPath", grabDetailRule.getVideoCssPath());
        map.put("authorCssPath", grabDetailRule.getAuthorCssPath());
        map.put("testUrl", grabDetailRule.getTestUrl());
        map.put("createdAt", DateUtil.getTimeStampStr(grabDetailRule.getCreatedAt()));
        map.put("status", grabDetailRule.getStatus());
        map.put("statusStr", ConstantsUtil.getConstants("grabDetailRuleStatus", "" + grabDetailRule.getStatus()));
        return map;
    }

    @Override
    public GrabDetailRule getGrabDetailRule(String objectId) throws AVException {
        return grabDetailRuleDao.get(objectId);
    }

    public List<GrabDetailRule> get(GrabDetailRuleQuery grabDetailRuleQuery) throws AVException {
        return null;
    }

}
