package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.AppKeywords;
import com.it7890.orange.manage.po.AppKeywordsQuery;
import com.it7890.orange.manage.service.AppKeywordsService;
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
 * Created by Administrator on 2017/6/28.
 */
@Controller
@RequestMapping("/keywords")
public class AppKeywordsController {
    @Autowired
    AppKeywordsService appKeywordsService;


    @RequestMapping("/toCountryKeywordsList")
    public String toCountryKeywordsList(String countryObjectId, Map map) throws AVException {
        // 0=热词 1=敏感词
        AppKeywordsQuery appKeywordsQuery = new AppKeywordsQuery();
        appKeywordsQuery.setCountryObjectId(countryObjectId);
        appKeywordsQuery.setKeywordType(0);
        List<Map> list0 = appKeywordsService.getKeywordsList(appKeywordsQuery);
        appKeywordsQuery.setKeywordType(1);
        List<Map> list1 = appKeywordsService.getKeywordsList(appKeywordsQuery);
        System.out.println(map.keySet());
        map.put("list0", list0);
        map.put("list1", list1);
        System.out.println(JSON.toJSONString(map));
        return "views/keywords/list";
    }

    @RequestMapping("/toCountryKeywordsEdit")
    public String toCountryKeywordsEdit(String objectId, String countryObjectId, Map map) throws AVException {
        Map keywords = appKeywordsService.getKeywordsMap(objectId);
        map.put("keywords", keywords);
        map.put("countryObjectId", countryObjectId);
        System.out.println(JSON.toJSONString(map));
        return "views/keywords/edit";
    }

    @RequestMapping("/toCountryKeywordsAdd")
    public String toCountryKeywordsAdd(String countryObjectId, Map map) throws AVException {
        map.put("countryObjectId", countryObjectId);
        System.out.println(JSON.toJSONString(map));
        return "views/keywords/add";
    }


    @RequestMapping(value = "/editCountryKeywords", method = RequestMethod.POST)
    public String editCountryKeywords(@RequestParam(required = false, name = "objectId") String objectId, String keyword, Integer keywordType, String countryObjectId, RedirectAttributes attributes) throws AVException {
        String msg = "";

        AppKeywords appKeywords = appKeywordsService.getKeywords(objectId);
        appKeywords.setKeyword(keyword);
        appKeywords.setKeywordType(keywordType);
        try {
            appKeywords.save();
            if (StringUtil.isEmpty(objectId)) {//添加
                msg = "添加成功!";
            } else {
                msg = "修改成功!";
            }
        } catch (AVException e) {
            e.printStackTrace();
            if (StringUtil.isEmpty(objectId)) {//添加
                msg = "添加失败!";
            } else {
                msg = "修改失败!";
            }
        }
        attributes.addFlashAttribute("msg", msg);
        attributes.addAttribute("countryObjectId", countryObjectId);
        return "redirect:/keywords/toCountryKeywordsList";
    }


    @RequestMapping(value = "/deleteCountryKeywords", method = {RequestMethod.POST, RequestMethod.GET})
    public String deleteCountryKeywords(String objectId, String countryObjectId, RedirectAttributes attributes) throws AVException {
        String msg = "";
        AppKeywords appKeywords = appKeywordsService.getKeywords(objectId);
        try {
            appKeywords.delete();
            msg = "删除成功!";
        } catch (AVException e) {
            e.printStackTrace();
            msg = "删除失败!";
        }
        attributes.addFlashAttribute("msg", msg);
        attributes.addAttribute("countryObjectId", countryObjectId);
        return "redirect:/keywords/toCountryKeywordsList";
    }

}
