package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.HbCountrys;
import com.it7890.orange.manage.po.AppTopQuery;
import com.it7890.orange.manage.service.AppTopService;
import com.it7890.orange.manage.service.applicationService.HbCountryService;
import com.it7890.orange.manage.utils.ConstantsUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/26.
 */
@Controller
@RequestMapping("/appTop")
public class AppTopController {
    private static final Logger logger = LogManager.getLogger(AppTopController.class);

    @Autowired
    private AppTopService appTopService;
    @Autowired
    private HbCountryService hbCountryService;

    /**
     * 按条件查询
     * @param map
     * @param appTopQuery
     * @param page
     * @return
     * @throws AVException
     */
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String getAll(Map map, AppTopQuery appTopQuery, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {
        Map appTopListAndPageUtilMap = appTopService.getAll(appTopQuery, page);//置顶大图列表
        List<HbCountrys> countryList = hbCountryService.getAll();//国家列表
        map.remove("org.springframework.validation.BindingResult.appTopQuery");
        map.put("countryList", countryList);
        map.put("appTopCtypeList", ConstantsUtil.getAppTopCtypeAll());//类型列表
        map.put("appTopQuery",appTopQuery);
        map.putAll(appTopListAndPageUtilMap);


        Object o= JSON.toJSON(map);
        System.out.println(o);



        return "views/appTop/list";
    }
    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteAppTop(AppTopQuery appTopQuery, Integer page, RedirectAttributes attributes) throws AVException {
        appTopService.delete(appTopQuery.getObjectId());
        attributes.addFlashAttribute("success", "删除成功!");

        attributes.addAttribute("page",page);

        attributes.addAttribute("countryCode",appTopQuery.getCountryCode());
        attributes.addAttribute("ctype",appTopQuery.getCtype());
        attributes.addAttribute("startTime",appTopQuery.getStartTime());
        attributes.addAttribute("endTime",appTopQuery.getEndTime());

        System.out.println(appTopQuery);
        //attributes.addAttribute("appTopQuery",new HashMap());
        //System.out.println("++++++++++++++++++++++++++++");

        return "redirect:/appTop/list";
    }

}
