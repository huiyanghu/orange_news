package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.HbCountryDao;
import com.it7890.orange.manage.po.CountryQuery;
import com.it7890.orange.manage.po.RecommendQuery;
import com.it7890.orange.manage.service.HbCountryService;
import com.it7890.orange.manage.service.LanguageService;
import com.it7890.orange.manage.service.RecommendArtService;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    @Resource
    LanguageService languageService;
    @Resource
    HbCountryDao hbCountryDao;

    /**
     * 列表
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
        return "/views/country/list";
    }

    /**
     * 转到添加或修改页面
     * @param map
     * @return
     */
    @RequestMapping("/edit")
    public String addOrEdit(ModelMap map){
        // 区域名称
        String[] str = { "亚洲AS", "欧洲EU", "非洲AF", "北美洲NA", "南美洲SA", "大洋洲OA" };
        List<String> continenList = new ArrayList<String>();
        for (int i = 0; i < str.length; i++) {
            continenList.add(str[i]);
        }
        map.put("langList",languageService.getDTOList());
        map.put("continentList",continenList);
        logger.info("map数据::::::===>>"+JSON.toJSON(map));
        return "/views/country/edit";
    }

    /**
     * 添加或修改
     * @param map
     * @param params
     * @param cnName
     * @param countryCode
     * @param shortName
     * @param langId
     * @param status
     * @param continent
     * @return
     */
    @RequestMapping("/addOrEdit")
    public String addOrEdit(ModelMap map, CountryQuery params,
                            @RequestParam(value = "cnName", required = false, defaultValue = "") String cnName,
                            @RequestParam(value = "cid", required = false, defaultValue = "") String cid,
                            @RequestParam(value = "countryCode", required = false, defaultValue = "") String countryCode,
                            @RequestParam(value = "shortName", required = false, defaultValue = "") String shortName,
                            @RequestParam(value = "langId", required = false, defaultValue = "") String langId,
                            @RequestParam(value = "picId", required = false, defaultValue = "") String picId,
                            @RequestParam(value = "status", required = false, defaultValue = "1") int status,
                            @RequestParam(value = "continent", required = false, defaultValue = "") String continent){
        map.remove("org.springframework.validation.BindingResult.countryQuery");
        boolean tmp = false;
        if(StringUtils.isNotBlank(cid)){
            AVQuery avQuery = new AVQuery("hb_countrys");
            try {
                AVObject avo = avQuery.get(cid);
                buildAvoObj(avo, cnName, countryCode, shortName, langId,picId, status, continent);
                hbCountryDao.saveHbAvo(avo);
                tmp = true;
            } catch (AVException e) {
                logger.info(e.getMessage());
            }
        }else {
           AVObject avObject = buildAvoObj(null, cnName, countryCode, shortName, langId,picId, status, continent);
           hbCountryDao.saveHbAvo(avObject);
            tmp = true;
        }
        map.addAttribute("tmp",tmp);
        return "redirect:/views/country/edit";
    }

    public static AVObject buildAvoObj(AVObject avObject,String cnName,String countryCode,String shortName,String langId,String picId,int status,String continent){
        if(avObject==null){
            avObject = new AVObject("hb_countrys");
        }
        if(StringUtils.isNotBlank(cnName)){
            avObject.put("cnName",cnName);
        }
        if(StringUtils.isNotBlank(countryCode)){
            avObject.put("countryCode",countryCode);
        }
        if(StringUtils.isNotBlank(shortName)){
            avObject.put("shortName",shortName);
        }
        if(StringUtils.isNotBlank(langId)){
            avObject.put("langId",langId);
        }
        if(StringUtils.isNotBlank(picId)){
            avObject.put("iconFileObj",picId);
        }
        avObject.put("status",status);
        if(StringUtils.isNotBlank(continent)){
            avObject.put("continent",continent);
        }
        return avObject;
    }
}
