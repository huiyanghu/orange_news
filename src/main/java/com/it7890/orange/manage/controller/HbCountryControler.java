package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.AppLanguagesDao;
import com.it7890.orange.manage.dao.HbCountryDao;
import com.it7890.orange.manage.model.HbLanguage;
import com.it7890.orange.manage.po.CountryQuery;
import com.it7890.orange.manage.po.RecommendQuery;
import com.it7890.orange.manage.service.*;
import com.it7890.orange.manage.utils.XlsUtil;
import com.it7890.orange.manage.vo.*;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    private static final Logger logger = LogManager.getLogger(HbCountryControler.class);

    @Resource
    HbCountryService hbCountryService;
    @Resource
    LanguageService languageService;
    @Resource
    HbCountryDao hbCountryDao;
    @Resource
    AppTopicsService appTopicsService;
    @Resource
    HbTopicsService hbTopicsService;
    @Resource
    AppLanguagesService appLanguagesService;

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

    /**
     * 话题管理页面
     * @param model
     * @param countryId
     * @return
     */
    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public String topics( Model model, String countryId) {
        List<HbTopicsDTO> hbTopicsDTOs = hbTopicsService.getDtoList();//获取所有话题
        List<AppTopicsDTO> apptopics = appTopicsService.getDtoList(countryId,null);//获取国家关联话题
        List<AppTopicsDTO> resTopics = new ArrayList<>();
        AppTopicsDTO appTopic;
        for (HbTopicsDTO hbTopicsDTO:hbTopicsDTOs){
            appTopic = new AppTopicsDTO();
            BeanUtils.copyProperties(hbTopicsDTO, appTopic);
            appTopic.setChecked(0);
            appTopic.setTopicType(hbTopicsDTO.getTopicType());
            for (AppTopicsDTO appTopicsDTO : apptopics){
                if (null!=appTopicsDTO.getHid()&&appTopicsDTO.getHid().equals(hbTopicsDTO.getHid())){
                    appTopic.setChecked(1);
                    appTopic.setTid(appTopicsDTO.getTid());
                    appTopic.setRank(appTopicsDTO.getRank());
                    appTopic.setKeyWords(appTopicsDTO.getKeyWords());
                    break;
                }
            }
            resTopics.add(appTopic);
        }
        model.addAttribute("country",hbCountryService.getByCid(countryId));
        model.addAttribute("apptopics", resTopics);
        logger.info("country::>>>{}",JSON.toJSONString(hbCountryService.getByCid(countryId)));
        logger.info("appss::>>{}",JSON.toJSONString(resTopics));
        return "country/topics";
    }


    @RequestMapping(value = "/topicsUpdate", method = RequestMethod.GET)
    public String topicsUpdate(HttpServletRequest request,String countryId,String[] hIds,
                               String[] keyWords, int[] ranks, Model model) {
        List<AppTopicsDTO> apptics = appTopicsService.getDtoList(countryId,null);
        int result = 0;
        List<AppTopicsDTO> delapptics = new ArrayList<AppTopicsDTO>();
        List<AVObject> addapptics = new ArrayList<AVObject>();
        List<AppTopicsDTO> updateapptopics = new ArrayList<AppTopicsDTO>();
        if (hIds != null && hIds.length > 0) {
            for (AppTopicsDTO appTopics : apptics) {
                boolean isdel = true;
                for (int a = 0; a < hIds.length; a++) {
                    if (hIds[a].equals(appTopics.getHid())) {//hid存在 更新绑定信息
                        if (keyWords != null && keyWords.length > 0) {
                            if (keyWords[a] != null && !"".equals(keyWords[a])) {
                                appTopics.setKeyWords(keyWords[a]);
                            }
                        }
                        appTopics.setRank(ranks[a]);
                        isdel = false;
                        logger.info("字段更新的hid::>>>{}",hIds[a]);
                    }else {
                        logger.info("要删除hid::>>>{}",hIds[a]);
                    }
                }
                if (isdel) {
                    delapptics.add(appTopics);
                } else {
                    updateapptopics.add(appTopics);
                }
            }
            AVObject apptopics;
            HbTopicsDTO hbtopics;
            // 检测需要添加的
            for (int a = 0; a < hIds.length; a++) {
                boolean isextis = false;
                for (AppTopicsDTO appTopics : apptics) {
                    if (hIds[a].equals(appTopics.getHid())) {
                        isextis = true;
                    }
                }
                if (!isextis) {
                    logger.info("需要绑定的hid::>>>{}",hIds[a]);
                    hbtopics = hbTopicsService.getById(hIds[a]);
                    apptopics = new AVObject("AppTopics");
                    apptopics.put("countryObj",AVObject.createWithoutData("hb_countrys",countryId));
                    apptopics.put("HbTopicsObj",AVObject.createWithoutData("hb_topics",hIds[a]));
//                    apptopics.setCreateuid(sysuer.getUserid());
                    apptopics.put("keyWords",keyWords[a]);
                    apptopics.put("rank",ranks[a]);
//                    apptopics.put("topicIcon",hbtopics.getTopicIcon());
                    apptopics.put("topicIconFile",hbtopics.getTopicIconId());
                    apptopics.put("topicName",hbtopics.getTopicName());
                    apptopics.put("topicType",hbtopics.getTopicType());
                    addapptics.add(apptopics);
                }
            }
            result = this.appTopicsService.updateAppTopics(countryId, delapptics,
                addapptics, updateapptopics);
        }
        request.getSession().setAttribute("message",
            "更新国家话题:" + (result > 0 ? "成功" : "失败"));
        request.getSession().setAttribute("url",
            "country/topics?countryid=" + countryId);
        return String.format("redirect:/message");
    }


    @RequestMapping(value = "exportCountry", method = RequestMethod.GET)
    public void exportcountry( HttpServletResponse response) throws IOException {
        response.setHeader("content-disposition",
            "attachment;filename=exportcountry.xls");
        String[] title = { "国家ID", "国家名称", "国家代码" };
        List<String[]> list = new ArrayList<String[]>();
        List<HbCountrysDTO> countrylist = hbCountryService.getDtoList();
        for (HbCountrysDTO hb : countrylist) {
            String[] str = new String[4];
            str[0] = String.valueOf(hb.getCountryId());
            str[1] = hb.getCnName();
            str[2] = hb.getCountryCode();
            list.add(str);
        }
        XlsUtil.excelExport(list, title, response);
    }

    @RequestMapping("/languages")
    @ResponseBody
    public String countryLang(ModelMap modelMap,String countryId){
        List<HbLanguageVO> resList = new ArrayList<>();
        HbLanguageVO hbLanguageVO;
        List<AppLanguagesDTO> appLanguagesDTOs = appLanguagesService.getByCidAndHBlangId(countryId,null);
        List<HbLanguageDTO> ls = languageService.getDTOList();
        for (HbLanguageDTO hbLanguageDTO:ls){
            hbLanguageVO = new HbLanguageVO();
            BeanUtils.copyProperties(hbLanguageDTO,hbLanguageVO);
            hbLanguageVO.setChecked(0);
            for (AppLanguagesDTO appLanguagesDTO : appLanguagesDTOs){
                if (hbLanguageDTO.getHbId().equals(appLanguagesDTO.getHbLangId())){
                    hbLanguageVO.setChecked(1);
                }
            }
            resList.add(hbLanguageVO);
        }
        modelMap.addAttribute("langList",resList);
//        logger.info("res::>>{}",JSON.toJSONString(resList));
        logger.info("map::>>>{}",modelMap);
        return "country/language";
    }
}
