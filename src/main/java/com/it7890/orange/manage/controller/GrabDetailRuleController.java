package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.*;
import com.it7890.orange.manage.po.GrabDetailRuleQuery;
import com.it7890.orange.manage.po.GrabListRuleQuery;
import com.it7890.orange.manage.service.GrabDetailRuleService;
import com.it7890.orange.manage.service.GrabListRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/list")
    public String getList(Map map, GrabDetailRuleQuery grabDetailRuleQuery, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {
        Map m = grabDetailRuleService.getAll(grabDetailRuleQuery, page);
        map.putAll(m);
        map.put("grabListRuleQuery", grabDetailRuleQuery);
        map.remove("org.springframework.validation.BindingResult.grabDetailRuleQuery");
        System.out.println(JSON.toJSONString(map));
        return "views/grabDetailRule/list";
    }

    @RequestMapping("/toDetail")
    public String detail(Map map, String objectId) throws AVException {
        Map grabDetailRule = grabDetailRuleService.get(objectId);
        map.put("grabDetailRule", grabDetailRule);
        return "views/grabDetailRule/detail";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Map map, String objectId) throws AVException {
        Map grabDetailRule = grabDetailRuleService.get(objectId);
        map.put("grabDetailRule", grabDetailRule);
        List<GrabListRule> grabListRuleList=grabListRuleService.get(new GrabListRuleQuery());
        map.put("grabListRuleList", grabListRuleList);
        System.out.println(JSON.toJSONString(map));
        return "views/grabListRule/edit";
    }

    @RequestMapping("/update")
    public String update(GrabDetailRuleQuery grabDetailRuleQuery, RedirectAttributes attributes, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {


        System.out.println("========================");
        System.out.println(JSON.toJSONString(grabDetailRuleQuery));
        System.out.println("========================");
        GrabDetailRule grabDetailRule = new GrabDetailRule();
        grabDetailRule.setObjectId(grabDetailRuleQuery.getObjectId());

        GrabListRule grabListRule=new GrabListRule();
        grabListRule.setObjectId(grabDetailRuleQuery.getGrabDetailRuleObjectId());
        grabDetailRule.setGrabListRule(grabListRule);

        grabDetailRule.setTitleCssPath(grabDetailRuleQuery.getTitleCssPath());
        grabDetailRule.setStatus(grabDetailRuleQuery.getStatus());
        grabDetailRule.setKeywordCssPath(grabDetailRuleQuery.getKeywordCssPath());
        grabDetailRule.setDescCssPath(grabDetailRuleQuery.getDescCssPath());
        grabDetailRule.setConCssPath(grabDetailRuleQuery.getConCssPath());
        grabDetailRule.setReplaceCssPath(grabDetailRuleQuery.getReplaceCssPath());
        grabDetailRule.setSouCssPath(grabDetailRuleQuery.getSouCssPath());
        grabDetailRule.setImgCssPath(grabDetailRuleQuery.getImgCssPath());
        grabDetailRule.setVideoCssPath(grabDetailRuleQuery.getVideoCssPath());
        grabDetailRule.setAuthorCssPath(grabDetailRuleQuery.getAuthorCssPath());
        grabDetailRule.setTestUrl(grabDetailRuleQuery.getTestUrl());


        grabDetailRule.save();


        attributes.addAttribute("ruleName", grabDetailRuleQuery.getRuleName());
        attributes.addAttribute("status", grabDetailRuleQuery.getStatus());
        attributes.addAttribute("page", page);
        attributes.addFlashAttribute("msg", "修改成功!");
        return "redirect:/grabDetailRule/list";
    }


    @RequestMapping("/delete")
    public String delete(GrabDetailRuleQuery grabDetailRuleQuery, RedirectAttributes attributes, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {

        GrabDetailRule grabDetailRule = new GrabDetailRule();
        grabDetailRule.setObjectId(grabDetailRuleQuery.getObjectId());
        grabDetailRule.setStatus(2);//删除
        grabDetailRule.save();

        attributes.addAttribute("ruleName", grabDetailRuleQuery.getRuleName());
        attributes.addAttribute("status", grabDetailRuleQuery.getStatus());
        attributes.addAttribute("page", page);
        attributes.addFlashAttribute("msg", "修改成功!");
        return "redirect:/grabDetailRule/list";
    }

}
