package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.po.GrabDetailRuleQuery;
import com.it7890.orange.manage.service.GrabDetailRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */
@Controller
@RequestMapping("/grabDetailRule")
public class GrabDetailRuleController {
    @Autowired
    GrabDetailRuleService grabDetailRuleService;

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

}
