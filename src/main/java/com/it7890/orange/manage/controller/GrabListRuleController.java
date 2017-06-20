package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.*;
import com.it7890.orange.manage.po.GrabListRuleQuery;
import com.it7890.orange.manage.service.*;
import com.it7890.orange.manage.utils.ConstantsUtil;
import com.it7890.orange.manage.utils.StringUtil;
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
    @Autowired
    LanguageService languageService;

    @RequestMapping(path = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    public String getList(Map map, GrabListRuleQuery grabListRuleQuery, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {
        List<Map> globalNodeList = globalNodeService.getGlobalNodeList();
        List<Map> appTopicsList = appTopicsService.getAppTopicsList();
        List<Map> publicationList = publicationService.getPublictionList();
        List<Map> channelList = conChannelService.getChannelList();
        List<Map> countryList = hbCountryService.getCountryList();
        Map m = grabListRuleService.getAll(grabListRuleQuery, page);
        map.putAll(m);
        map.put("globalNodeList", globalNodeList);
        map.put("appTopicsList", appTopicsList);
        map.put("publicationList", publicationList);
        map.put("channelList", channelList);
        map.put("countryList", countryList);
        map.put("grabListRuleQuery", grabListRuleQuery);
        map.remove("org.springframework.validation.BindingResult.grabListRuleQuery");
        System.out.println(JSON.toJSONString(map));

        //return "views/appTop/test1";
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
        List<Map> languageList = languageService.getLanguageList();
        map.put("globalNodeList", globalNodeList);
        map.put("appTopicsList", appTopicsList);
        map.put("publicationList", publicationList);
        map.put("channelList", channelList);
        map.put("countryList", countryList);
        map.put("languageList", languageList);
        map.put("grabListRuleStatusList", ConstantsUtil.getConstants("grabListRuleStatus"));//规则状态
        map.put("grabListRuleListStatusList", ConstantsUtil.getConstants("grabListRuleListStatus"));//列表文章状态
        map.put("constantList", ConstantsUtil.getConstants("grabListRuleConstant"));

        System.out.println(JSON.toJSON(map));
        return "views/grabListRule/edit";
    }

    /**
     * 修改
     *
     * @param grabListRuleQuery
     * @return
     * @throws AVException
     */
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public String update(GrabListRuleQuery grabListRuleQuery, RedirectAttributes attributes, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {
        System.out.println("========================");
        System.out.println(JSON.toJSONString(grabListRuleQuery));
        System.out.println("========================");
        GrabListRule grabListRule = new GrabListRule();
        grabListRule.setObjectId(grabListRuleQuery.getObjectId());
        grabListRule.setRuleName(grabListRuleQuery.getRuleName());
        grabListRule.setCssPath(grabListRuleQuery.getCssPath());
        grabListRule.setSiteUrl(grabListRuleQuery.getSiteUrl());
        grabListRule.setFindPre(grabListRuleQuery.getFindPre());
        grabListRule.setConstant(grabListRuleQuery.getConstant());
        grabListRule.setKeywords(grabListRuleQuery.getKeywords());
        grabListRule.setTitlePicCssPath(grabListRuleQuery.getTitlePicCssPath());
        grabListRule.setNextPageCssPath(grabListRuleQuery.getNextPageCssPath());
        grabListRule.setGrabTime(grabListRuleQuery.getGrabTime());

        if (StringUtil.isNotEmpty(grabListRuleQuery.getCountryObjectId())) {
            HbCountrys country = new HbCountrys();
            country.setObjectId(grabListRuleQuery.getCountryObjectId());
            grabListRule.setCountry(country);
        }else{
            grabListRule.setCountry(null);
        }

        if (StringUtil.isNotEmpty(grabListRuleQuery.getPublicationObjectId())) {
            ConPublication conPublication = new ConPublication();
            conPublication.setObjectId(grabListRuleQuery.getPublicationObjectId());
            grabListRule.setConPublication(conPublication);
        }else{
            grabListRule.setConPublication(null);
        }

        if (StringUtil.isNotEmpty(grabListRuleQuery.getNodeObjectId())) {
            GlobalNode globalNode = new GlobalNode();
            globalNode.setObjectId(grabListRuleQuery.getNodeObjectId());
            grabListRule.setGlobalNode(globalNode);
        }else{
            grabListRule.setGlobalNode(null);
        }

        if (StringUtil.isNotEmpty(grabListRuleQuery.getChannelObjectId())) {
            ConChannel conChannel = new ConChannel();
            conChannel.setObjectId(grabListRuleQuery.getChannelObjectId());
            grabListRule.setConChannel(conChannel);
        }else{
            grabListRule.setConChannel(null);
        }

        if (StringUtil.isNotEmpty(grabListRuleQuery.getLanguageObjectId())) {
            HbLanguage hbLanguage = new HbLanguage();
            hbLanguage.setObjectId(grabListRuleQuery.getLanguageObjectId());
            grabListRule.setHbLanguage(hbLanguage);
        }else{
            grabListRule.setHbLanguage(null);
        }

        if (StringUtil.isNotEmpty(grabListRuleQuery.getTopicObjectId())) {
            AppTopics topics = new AppTopics();
            topics.setObjectId(grabListRuleQuery.getTopicObjectId());
            grabListRule.setTopics(topics);
        }else{
            grabListRule.setTopics(null);
        }

        grabListRule.setStatus(grabListRuleQuery.getStatus());
        grabListRule.setListStatus(grabListRuleQuery.getListStatus());

        grabListRule.save();



        /*
        attributes.addAttribute("ruleName", grabListRuleQuery.getRuleName());
        attributes.addAttribute("publicationObjectId", grabListRuleQuery.getPublicationObjectId());
        attributes.addAttribute("nodeObjectId", grabListRuleQuery.getNodeObjectId());
        attributes.addAttribute("channelObjectId", grabListRuleQuery.getChannelObjectId());
        attributes.addAttribute("countryCode", grabListRuleQuery.getCountryCode());
        attributes.addAttribute("topicObjectId", grabListRuleQuery.getTopicObjectId());
        attributes.addAttribute("page", page);
        */
        attributes.addFlashAttribute("msg", "修改成功!");
        return "redirect:/grabListRule/list";
    }


    @RequestMapping("/toAdd")
    public String toAdd(Map map) throws AVException {
        List<Map> globalNodeList = globalNodeService.getGlobalNodeList();
        List<Map> appTopicsList = appTopicsService.getAppTopicsList();
        List<Map> publicationList = publicationService.getPublictionList();
        List<Map> channelList = conChannelService.getChannelList();
        List<Map> countryList = hbCountryService.getCountryList();
        List<Map> languageList = languageService.getLanguageList();
        map.put("globalNodeList", globalNodeList);
        map.put("appTopicsList", appTopicsList);
        map.put("publicationList", publicationList);
        map.put("channelList", channelList);
        map.put("countryList", countryList);
        map.put("languageList", languageList);
        map.put("grabListRuleStatusList", ConstantsUtil.getConstants("grabListRuleStatus"));//规则状态
        map.put("grabListRuleListStatusList", ConstantsUtil.getConstants("grabListRuleListStatus"));//列表文章状态
        map.put("constantList", ConstantsUtil.getConstants("grabListRuleConstant"));

        System.out.println(JSON.toJSONString(map));
        return "views/grabListRule/add";
    }

    /**
     * 修改
     *
     * @param grabListRuleQuery
     * @return
     * @throws AVException
     */
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(GrabListRuleQuery grabListRuleQuery, RedirectAttributes attributes) throws AVException {
        System.out.println("========================");
        System.out.println(JSON.toJSONString(grabListRuleQuery));
        System.out.println("========================");
        GrabListRule grabListRule = new GrabListRule();

        grabListRule.setRuleName(grabListRuleQuery.getRuleName());
        grabListRule.setCssPath(grabListRuleQuery.getCssPath());
        grabListRule.setSiteUrl(grabListRuleQuery.getSiteUrl());
        grabListRule.setFindPre(grabListRuleQuery.getFindPre());
        grabListRule.setConstant(grabListRuleQuery.getConstant());
        grabListRule.setKeywords(grabListRuleQuery.getKeywords());
        grabListRule.setTitlePicCssPath(grabListRuleQuery.getTitlePicCssPath());
        grabListRule.setNextPageCssPath(grabListRuleQuery.getNextPageCssPath());
        grabListRule.setGrabTime(grabListRuleQuery.getGrabTime());

        if (StringUtil.isNotEmpty(grabListRuleQuery.getCountryObjectId())) {
            HbCountrys country = new HbCountrys();
            country.setObjectId(grabListRuleQuery.getCountryObjectId());
            grabListRule.setCountry(country);
        }else{
            grabListRule.setCountry(null);
        }
        if (StringUtil.isNotEmpty(grabListRuleQuery.getPublicationObjectId())) {
            ConPublication conPublication = new ConPublication();
            conPublication.setObjectId(grabListRuleQuery.getPublicationObjectId());
            grabListRule.setConPublication(conPublication);
        }else{
            grabListRule.setConPublication(null);
        }

        if (StringUtil.isNotEmpty(grabListRuleQuery.getNodeObjectId())) {
            GlobalNode globalNode = new GlobalNode();
            globalNode.setObjectId(grabListRuleQuery.getNodeObjectId());
            grabListRule.setGlobalNode(globalNode);
        }else{
            grabListRule.setGlobalNode(null);
        }

        if (StringUtil.isNotEmpty(grabListRuleQuery.getChannelObjectId())) {
            ConChannel conChannel = new ConChannel();
            conChannel.setObjectId(grabListRuleQuery.getChannelObjectId());
            grabListRule.setConChannel(conChannel);
        }else{
            grabListRule.setConChannel(null);
        }

        if (StringUtil.isNotEmpty(grabListRuleQuery.getLanguageObjectId())) {
            HbLanguage hbLanguage = new HbLanguage();
            hbLanguage.setObjectId(grabListRuleQuery.getLanguageObjectId());
            grabListRule.setHbLanguage(hbLanguage);
        }else{
            grabListRule.setHbLanguage(null);
        }

        if (StringUtil.isNotEmpty(grabListRuleQuery.getTopicObjectId())) {
            AppTopics topics = new AppTopics();
            topics.setObjectId(grabListRuleQuery.getTopicObjectId());
            grabListRule.setTopics(topics);
        }else{
            grabListRule.setTopics(null);
        }


        grabListRule.setStatus(grabListRuleQuery.getStatus());
        grabListRule.setListStatus(grabListRuleQuery.getListStatus());

        grabListRule.save();


        attributes.addFlashAttribute("msg", "添加成功!");
        return "redirect:/grabListRule/list";
    }


    @RequestMapping("/delete")
    public String delete(GrabListRuleQuery grabListRuleQuery, RedirectAttributes attributes, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {

        GrabListRule grabListRule = new GrabListRule();
        grabListRule.setObjectId(grabListRuleQuery.getObjectId());
        grabListRule.setStatus(2);//删除
        grabListRule.save();

        /*
        attributes.addAttribute("ruleName", grabListRuleQuery.getRuleName());
        attributes.addAttribute("publicationObjectId", grabListRuleQuery.getPublicationObjectId());
        attributes.addAttribute("nodeObjectId", grabListRuleQuery.getNodeObjectId());
        attributes.addAttribute("channelObjectId", grabListRuleQuery.getChannelObjectId());
        attributes.addAttribute("countryCode", grabListRuleQuery.getCountryCode());
        attributes.addAttribute("topicObjectId", grabListRuleQuery.getTopicObjectId());
        attributes.addAttribute("page", page);
        */
        attributes.addFlashAttribute("msg", "删除成功!");
        return "redirect:/grabListRule/list";
    }

    @RequestMapping("/toTest")
    public String test(Map map, String objectId) throws AVException {
        /*Map grabListRule = grabListRuleService.get(objectId);
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

        System.out.println(JSON.toJSONString(map));*/
        return "views/appTop/test1";
    }

    @RequestMapping("/toTestResult")
    public String toTestResult(Map map, String flag, String dataJson) throws AVException {
        map.put("flag", flag);
        map.put("dataJson", dataJson);
        return "testResult";
    }
    @RequestMapping("/toViewUrl")
    public String toViewUrl(Map map, String flag, String dataJson) throws AVException {
        map.put("flag", flag);
        map.put("dataJson", dataJson);
        return "viewUrl";
    }
}
