package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
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
 * @author gg
 * @create 2017/6/7
 **/
@Controller
@RequestMapping("/countrys")
public class HbCountryControler {
    private static final Logger logger = LogManager.getLogger(RecommendArtControler.class);

    @Resource
    HbCountryService hbCountryService;
    /**
     * 列表
     *
     * @param map
     * @param
     * @return
     * @throws AVException
     */
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String getRecommendList(ModelMap map) throws AVException, ParseException {
        logger.info("method name=countrys/list;param={");
        Map mp =  hbCountryService.getAvoList();
        map.putAll(mp);
        logger.info("map数据::::::===>>"+ JSON.toJSON(map));
        return null;
    }
}
