package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.*;
import com.it7890.orange.manage.po.GrabListRuleQuery;
import com.it7890.orange.manage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */
@Controller
@RequestMapping("/grabListRule")
public class GrabListRuleController {
    @Autowired
    GrabListRuleService grabListRuleService;
    @Autowired
    GlobalNodeService globalNodeService;
    @Autowired
    AppTopicsService appTopicsService;
    @Autowired
    PublicationService publicationService;
    @Autowired
    ConChannelService conChannelService;
    @Autowired
    HbCountryService hbCountryService;

    @RequestMapping("/list")
    public String getList(Map map, GrabListRuleQuery grabListRuleQuery, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {
        List<Map> globalNodeList = globalNodeService.getGlobalNodeList();
        List<Map> appTopicsList = appTopicsService.getAppTopicsList();
        List<Map> publicationList = publicationService.getPublictionList();
        List<Map> channelList = conChannelService.getChannelList();
        Map m = grabListRuleService.getAll(grabListRuleQuery, page);
        map.putAll(m);
        map.put("globalNodeList", globalNodeList);
        map.put("appTopicsList", appTopicsList);
        map.put("publicationList", publicationList);
        map.put("channelList", channelList);
        map.put("grabListRuleQuery", grabListRuleQuery);
        map.remove("org.springframework.validation.BindingResult.grabListRuleQuery");
        System.out.println(JSON.toJSONString(map));

        return "views/grabListRule/list";
    }

    @RequestMapping("/toDetail")
    public String detail(Map map, String objectId) throws AVException {
        Map grabListRule = grabListRuleService.get(objectId);
        map.put("grabListRule", grabListRule);
        System.out.println(JSON.toJSONString(map));
        return "views/grabListRule/detail";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Map map, String objectId) throws AVException {
        Map grabListRule = grabListRuleService.get(objectId);
        map.put("grabListRule", grabListRule);

        List<Map> globalNodeList = globalNodeService.getGlobalNodeList();
        List<Map> appTopicsList = appTopicsService.getAppTopicsList();
        List<Map> publicationList = publicationService.getPublictionList();
        List<Map> channelList = conChannelService.getChannelList();
        List<Map> countryList = hbCountryService.getCountryList();
        map.put("globalNodeList", globalNodeList);
        map.put("appTopicsList", appTopicsList);
        map.put("publicationList", publicationList);
        map.put("channelList", channelList);
        map.put("countryList", countryList);

        System.out.println(JSON.toJSONString(map));
        return "views/grabListRule/edit";
    }

    /**
     * 修改
     *
     * @param grabListRuleQuery
     * @return
     * @throws AVException
     */
    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public String update(GrabListRuleQuery grabListRuleQuery, RedirectAttributes attributes, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {
        System.out.println("========================");
        System.out.println(JSON.toJSONString(grabListRuleQuery));
        System.out.println("========================");
        GrabListRule grabListRule = new GrabListRule();
        grabListRule.setObjectId(grabListRuleQuery.getObjectId());
        grabListRule.setRuleName(grabListRuleQuery.getRuleName());
        grabListRule.setCssPath(grabListRuleQuery.getCssPath());
        grabListRule.setSiteUrl(grabListRuleQuery.getSiteUrl());
        grabListRule.setCountryCode(grabListRuleQuery.getCountryCode());
        grabListRule.setFindPre(grabListRuleQuery.getFindPre());
        grabListRule.setConstant(grabListRuleQuery.getConstant());
        grabListRule.setKeywords(grabListRuleQuery.getKeywords());
        grabListRule.setTitlePicCssPath(grabListRuleQuery.getTitlePicCssPath());
        grabListRule.setNextPageCssPath(grabListRuleQuery.getNextPageCssPath());
        grabListRule.setGrabTime(grabListRuleQuery.getGrabTime());

        ConPublication conPublication = new ConPublication();
        conPublication.setObjectId(grabListRuleQuery.getPublicationObjectId());
        grabListRule.setConPublication(conPublication);

        GlobalNode globalNode = new GlobalNode();
        globalNode.setObjectId(grabListRuleQuery.getNodeObjectId());
        grabListRule.setGlobalNode(globalNode);

        ConChannel conChannel = new ConChannel();
        conChannel.setObjectId(grabListRuleQuery.getChannelObjectId());
        grabListRule.setConChannel(conChannel);

        HbLanguage hbLanguage = new HbLanguage();
        hbLanguage.setObjectId(grabListRuleQuery.getLanguageObjectId());
        grabListRule.setHbLanguage(hbLanguage);

        HbTopics hbTopics = new HbTopics();
        hbTopics.setObjectId(grabListRuleQuery.getTopicObjectId());
        grabListRule.setHbTopics(hbTopics);

        grabListRule.setStatus(grabListRuleQuery.getStatus());
        grabListRule.setListStatus(grabListRuleQuery.getListStatus());

        grabListRule.save();


        attributes.addAttribute("ruleName", grabListRuleQuery.getRuleName());
        attributes.addAttribute("publicationObjectId", grabListRuleQuery.getPublicationObjectId());
        attributes.addAttribute("nodeObjectId", grabListRuleQuery.getNodeObjectId());
        attributes.addAttribute("channelObjectId", grabListRuleQuery.getChannelObjectId());
        attributes.addAttribute("countryCode", grabListRuleQuery.getCountryCode());
        attributes.addAttribute("topicObjectId", grabListRuleQuery.getTopicObjectId());
        attributes.addAttribute("page", page);
        attributes.addFlashAttribute("msg", "修改成功!");
        return "redirect:/grabListRule/list";
    }


    @RequestMapping("/delete")
    public String delete(GrabListRuleQuery grabListRuleQuery, RedirectAttributes attributes, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {

        GrabListRule grabListRule = new GrabListRule();
        grabListRule.setObjectId(grabListRuleQuery.getObjectId());
        grabListRule.setStatus(2);//删除
        grabListRule.save();

        attributes.addAttribute("ruleName", grabListRuleQuery.getRuleName());
        attributes.addAttribute("publicationObjectId", grabListRuleQuery.getPublicationObjectId());
        attributes.addAttribute("nodeObjectId", grabListRuleQuery.getNodeObjectId());
        attributes.addAttribute("channelObjectId", grabListRuleQuery.getChannelObjectId());
        attributes.addAttribute("countryCode", grabListRuleQuery.getCountryCode());
        attributes.addAttribute("topicObjectId", grabListRuleQuery.getTopicObjectId());
        attributes.addAttribute("page", page);
        attributes.addFlashAttribute("msg", "删除成功!");
        return "redirect:/grabListRule/list";
    }
}
