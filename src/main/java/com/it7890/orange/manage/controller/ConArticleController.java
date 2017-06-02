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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    /**
     * 批量删除
     *
     * @param ids
     * @param attributes
     * @return
     * @throws AVException
     */
    @RequestMapping(path = "/deleteBatch", method = RequestMethod.GET)
    public String deleteBatch(String ids, RedirectAttributes attributes, ConArticleQuery conArticleQuery, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {
        ModelAndView mv = new ModelAndView();
        conArticleService.deleteBatch(ids);
        attributes.addFlashAttribute("msg", "删除成功!");
        attributes.addAttribute("countryCode",conArticleQuery.getCountryCode());
        attributes.addAttribute("publicationObjectId",conArticleQuery.getPublicationObjectId());
        attributes.addAttribute("languageObjectId",conArticleQuery.getLanguageObjectId());
        attributes.addAttribute("channelObjectId",conArticleQuery.getChannelObjectId());
        attributes.addAttribute("attr",conArticleQuery.getAttr());
        attributes.addAttribute("status",conArticleQuery.getStatus());
        attributes.addAttribute("keywords",conArticleQuery.getKeywords());
        attributes.addAttribute("topicObjectId",conArticleQuery.getTopicObjectId());
        attributes.addAttribute("startTime",conArticleQuery.getStartTime());
        attributes.addAttribute("endTime",conArticleQuery.getEndTime());
        attributes.addAttribute("page",page);

        return "redirect:/conArticle/list";
    }

    /**
     * 批量发布
     *
     * @param ids
     * @param attributes
     * @return
     * @throws AVException
     */
    @RequestMapping(path = "/publishBatch", method = RequestMethod.GET)
    public String publishBatch(String ids, RedirectAttributes attributes, ConArticleQuery conArticleQuery, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {
        ModelAndView mv = new ModelAndView();
        conArticleService.publishBatch(ids);
        attributes.addFlashAttribute("msg", "发布成功!");
        attributes.addAttribute("countryCode",conArticleQuery.getCountryCode());
        attributes.addAttribute("publicationObjectId",conArticleQuery.getPublicationObjectId());
        attributes.addAttribute("languageObjectId",conArticleQuery.getLanguageObjectId());
        attributes.addAttribute("channelObjectId",conArticleQuery.getChannelObjectId());
        attributes.addAttribute("attr",conArticleQuery.getAttr());
        attributes.addAttribute("status",conArticleQuery.getStatus());
        attributes.addAttribute("keywords",conArticleQuery.getKeywords());
        attributes.addAttribute("topicObjectId",conArticleQuery.getTopicObjectId());
        attributes.addAttribute("startTime",conArticleQuery.getStartTime());
        attributes.addAttribute("endTime",conArticleQuery.getEndTime());
        attributes.addAttribute("page",page);

        return "redirect:/conArticle/list";
    }
}
