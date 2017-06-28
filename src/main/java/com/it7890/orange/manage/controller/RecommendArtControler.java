package com.it7890.orange.manage.controller;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.po.RecommendQuery;
import com.it7890.orange.manage.service.HbCountryService;
import com.it7890.orange.manage.service.RecommendArtService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Map;

/**
 * Created by wyq on 2017/6/6.
 */
@Controller
@RequestMapping("/applicationRecommedArt")
public class RecommendArtControler {
    private static final Logger logger = LogManager.getLogger(RecommendArtControler.class);

    @Resource
    RecommendArtService recommendArtService;
    @Resource
    HbCountryService hbCountryService;

    /**
     * 列表
     *
     * @param map
     * @param page
     * @return
     * @throws AVException
     */
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String getRecommendList(ModelMap map,RecommendQuery query,
                                   @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                   @RequestParam(value = "pushNum", required = false, defaultValue = "0") Integer pushNum,
                                   @RequestParam(value = "countryCode", required = false, defaultValue = "") String countryCode,
                                   @RequestParam(value = "startTime", required = false, defaultValue = "") String startTime,
                                   @RequestParam(value = "endTime", required = false, defaultValue = "") String endTime) throws AVException, ParseException {

        Map listAndPageUtilMap = recommendArtService.getList(pushNum, countryCode, startTime, endTime, page);
        map.remove("org.springframework.validation.BindingResult.recommendQuery");
//        map.put("pushNum", pushNum);
//        map.put("countryCode", countryCode);
//        map.put("startTime", startTime);
//        map.put("endTime", endTime);
//        map.put("queryParams",query);
        map.putAll(listAndPageUtilMap);
        map.put("countryList",hbCountryService.getCountryList());
        //System.out.println(JSON.toJSONString(map));
        return "views/recommend/list";

    }
}
