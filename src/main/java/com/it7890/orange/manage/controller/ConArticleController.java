package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.po.ConArticleQuery;
import com.it7890.orange.manage.service.ConArticleService;
import com.it7890.orange.manage.service.articalService.IConChannelService;
import com.it7890.orange.manage.service.articalService.IConGrabRuleService;
import com.it7890.orange.manage.service.articalService.IConPublicationService;
import com.it7890.orange.manage.service.articalService.ITopicsService;
import com.it7890.orange.manage.service.contentService.LanguageService;
import com.it7890.orange.manage.utils.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/31.
 */
@Controller
@RequestMapping("/conArticle")
public class ConArticleController {
    @Autowired
    private ConArticleService conArticleService;
    @Autowired
    private IConPublicationService conpublicationService;
    @Autowired
    private IConChannelService conchannelService;
    @Autowired
    private ITopicsService topicsService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private IConGrabRuleService ruleService;


    /**
     * 按条件查询
     *
     * @param map
     * @param conArticleQuery
     * @param page
     * @return
     * @throws AVException
     */
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String getAll(Map map, ConArticleQuery conArticleQuery, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {
        Map conArticleListAndPageUtilMap = conArticleService.getAll(conArticleQuery, page);//置顶大图列表

        System.out.println(map.keySet());
        map.remove("org.springframework.validation.BindingResult.conArticleQuery");
        map.put("appTopArtitypeList", ConstantsUtil.getConstants("appTopArtitype"));
        map.put("conArticleQuery", conArticleQuery);
        map.putAll(conArticleListAndPageUtilMap);



        map.put("topicList", topicsService.getAllHbTopics());
        map.put("channelList", conchannelService.getAllConChannel());
        map.put("publicationList", conpublicationService.getAllConpublication());
        map.put("languageList", languageService.getAll());
        //map.put("channellist", ruleService.getChannellist());

        System.out.println(JSON.toJSON(map));
        return "views/appTop/list";
    }

}
