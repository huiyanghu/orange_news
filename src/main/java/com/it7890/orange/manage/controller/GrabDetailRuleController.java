package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.GlobalNode;
import com.it7890.orange.manage.model.GrabDetailRule;
import com.it7890.orange.manage.model.GrabListRule;
import com.it7890.orange.manage.po.GrabDetailRuleQuery;
import com.it7890.orange.manage.po.GrabListRuleQuery;
import com.it7890.orange.manage.service.GlobalNodeService;
import com.it7890.orange.manage.service.GrabDetailRuleService;
import com.it7890.orange.manage.service.GrabListRuleService;
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
@RequestMapping("/grabDetailRule")
public class GrabDetailRuleController {
    @Autowired
    GrabDetailRuleService grabDetailRuleService;
    @Autowired
    GrabListRuleService grabListRuleService;
    @Autowired
    GlobalNodeService globalNodeService;

    @RequestMapping("/list")
    public String getList(Map map, GrabDetailRuleQuery grabDetailRuleQuery, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {
        Map m = grabDetailRuleService.getAll(grabDetailRuleQuery, page);
        map.putAll(m);
        map.put("grabDetailRuleQuery", grabDetailRuleQuery);
        System.out.println(map.keySet());
        map.remove("org.springframework.validation.BindingResult.grabDetailRuleQuery");
        System.out.println(JSON.toJSONString(map));
        return "views/grabDetailRule/list";
    }

    @RequestMapping("/toDetail")
    public String detail(Map map, String objectId) throws AVException {
        Map grabDetailRule = grabDetailRuleService.get(objectId);
        map.put("grabDetailRule", grabDetailRule);
        System.out.println(JSON.toJSONString(grabDetailRule));
        return "views/grabDetailRule/detail";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Map map, String objectId) throws AVException {
        Map grabDetailRule = grabDetailRuleService.get(objectId);
        map.put("grabDetailRule", grabDetailRule);
        List<Map> grabListRuleList = grabListRuleService.get(new GrabListRuleQuery());
        map.put("grabListRuleList", grabListRuleList);
        List<Map> globalNodeList = globalNodeService.getGlobalNodeList();
        map.put("globalNodeList", globalNodeList);
        map.put("grabListRuleListStatusList", ConstantsUtil.getConstants("grabListRuleListStatus"));//列表文章状态
        System.out.println(JSON.toJSONString(map));
        return "views/grabDetailRule/edit";
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public String update(GrabDetailRuleQuery grabDetailRuleQuery, RedirectAttributes attributes, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {


        System.out.println("========================");
        System.out.println(JSON.toJSONString(grabDetailRuleQuery));
        System.out.println("========================");
        GrabDetailRule grabDetailRule = new GrabDetailRule();
        grabDetailRule.setObjectId(grabDetailRuleQuery.getObjectId());
        grabDetailRule.setRuleName(grabDetailRuleQuery.getRuleName());
        grabDetailRule.setTitleCssPath(grabDetailRuleQuery.getTitleCssPath());
        grabDetailRule.setStatus(grabDetailRuleQuery.getStatus());
        grabDetailRule.setKeywordCssPath(grabDetailRuleQuery.getKeywordCssPath());
        grabDetailRule.setDescCssPath(grabDetailRuleQuery.getDescCssPath());
        grabDetailRule.setConCssPath(grabDetailRuleQuery.getConCssPath());
        grabDetailRule.setConCssPath1(grabDetailRuleQuery.getConCssPath1());
        grabDetailRule.setConCssPath2(grabDetailRuleQuery.getConCssPath2());
        grabDetailRule.setReplaceCssPath(grabDetailRuleQuery.getReplaceCssPath());
        grabDetailRule.setReplaceRule(grabDetailRuleQuery.getReplaceRule());
        grabDetailRule.setSouCssPath(grabDetailRuleQuery.getSouCssPath());
        grabDetailRule.setImgCssPath(grabDetailRuleQuery.getImgCssPath());
        grabDetailRule.setVideoCssPath(grabDetailRuleQuery.getVideoCssPath());
        grabDetailRule.setAuthorCssPath(grabDetailRuleQuery.getAuthorCssPath());
        grabDetailRule.setTestUrl(grabDetailRuleQuery.getTestUrl());


        if (StringUtil.isNotEmpty(grabDetailRuleQuery.getGlobalNodeObjectId())) {
            GlobalNode globalNode = new GlobalNode();
            globalNode.setObjectId(grabDetailRuleQuery.getGlobalNodeObjectId());
            grabDetailRule.setGlobalNode(globalNode);
        } else {
            grabDetailRule.setGlobalNode(null);
        }


        if (StringUtil.isNotEmpty(grabDetailRuleQuery.getGrabListRuleObjectId())) {
            GrabListRule grabListRule = new GrabListRule();
            grabListRule.setObjectId(grabDetailRuleQuery.getGrabListRuleObjectId());
            grabDetailRule.setGrabListRule(grabListRule);
        } else {
            grabDetailRule.setGrabListRule(null);
        }
        grabDetailRule.save();


        /*
        attributes.addAttribute("ruleName", grabDetailRuleQuery.getRuleName());
        attributes.addAttribute("status", grabDetailRuleQuery.getStatus());
        attributes.addAttribute("page", page);
        */

        attributes.addFlashAttribute("msg", "修改成功!");
        return "redirect:/grabDetailRule/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(Map map) throws AVException {
        List<Map> grabListRuleList = grabListRuleService.get(new GrabListRuleQuery());
        map.put("grabListRuleList", grabListRuleList);//列表规则
        List<Map> globalNodeList = globalNodeService.getGlobalNodeList();
        map.put("globalNodeList", globalNodeList);
        map.put("grabListRuleListStatusList", ConstantsUtil.getConstants("grabListRuleListStatus"));//列表文章状态
        System.out.println(JSON.toJSONString(map));
        return "views/grabDetailRule/add";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(GrabDetailRuleQuery grabDetailRuleQuery, RedirectAttributes attributes) throws AVException {
        System.out.println("========================");
        System.out.println(JSON.toJSONString(grabDetailRuleQuery));
        System.out.println("========================");


        GrabDetailRule grabDetailRule = new GrabDetailRule();


        grabDetailRule.setRuleName(grabDetailRuleQuery.getRuleName());
        grabDetailRule.setTitleCssPath(grabDetailRuleQuery.getTitleCssPath());
        grabDetailRule.setStatus(grabDetailRuleQuery.getStatus());
        grabDetailRule.setKeywordCssPath(grabDetailRuleQuery.getKeywordCssPath());
        grabDetailRule.setDescCssPath(grabDetailRuleQuery.getDescCssPath());
        grabDetailRule.setConCssPath(grabDetailRuleQuery.getConCssPath());
        grabDetailRule.setConCssPath1(grabDetailRuleQuery.getConCssPath1());
        grabDetailRule.setConCssPath2(grabDetailRuleQuery.getConCssPath2());
        grabDetailRule.setReplaceCssPath(grabDetailRuleQuery.getReplaceCssPath());
        grabDetailRule.setReplaceRule(grabDetailRuleQuery.getReplaceRule());
        grabDetailRule.setSouCssPath(grabDetailRuleQuery.getSouCssPath());
        grabDetailRule.setImgCssPath(grabDetailRuleQuery.getImgCssPath());
        grabDetailRule.setVideoCssPath(grabDetailRuleQuery.getVideoCssPath());
        grabDetailRule.setAuthorCssPath(grabDetailRuleQuery.getAuthorCssPath());
        grabDetailRule.setTestUrl(grabDetailRuleQuery.getTestUrl());

        if (StringUtil.isNotEmpty(grabDetailRuleQuery.getGlobalNodeObjectId())) {
            GlobalNode globalNode = new GlobalNode();
            globalNode.setObjectId(grabDetailRuleQuery.getGlobalNodeObjectId());
            grabDetailRule.setGlobalNode(globalNode);
        } else {
            grabDetailRule.setGlobalNode(null);
        }


        if (StringUtil.isNotEmpty(grabDetailRuleQuery.getGrabListRuleObjectId())) {
            GrabListRule grabListRule = new GrabListRule();
            grabListRule.setObjectId(grabDetailRuleQuery.getGrabListRuleObjectId());
            grabDetailRule.setGrabListRule(grabListRule);
        } else {
            grabDetailRule.setGrabListRule(null);
        }
        grabDetailRule.save();

        attributes.addFlashAttribute("msg", "添加成功!");
        return "redirect:/grabDetailRule/list";
    }


    @RequestMapping("/delete")
    public String delete(GrabDetailRuleQuery grabDetailRuleQuery, RedirectAttributes attributes, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {

        GrabDetailRule grabDetailRule = new GrabDetailRule();
        grabDetailRule.setObjectId(grabDetailRuleQuery.getObjectId());
        grabDetailRule.setStatus(2);//删除
        grabDetailRule.save();
        /*
        attributes.addAttribute("ruleName", grabDetailRuleQuery.getRuleName());
        attributes.addAttribute("status", grabDetailRuleQuery.getStatus());
        attributes.addAttribute("page", page);
        */
        attributes.addFlashAttribute("msg", "删除成功!");
        return "redirect:/grabDetailRule/list";
    }

}
