package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.HbCountryDao;
import com.it7890.orange.manage.po.CountryQuery;
import com.it7890.orange.manage.po.RecommendQuery;
import com.it7890.orange.manage.service.*;
import com.it7890.orange.manage.utils.XlsUtil;
import com.it7890.orange.manage.vo.AppTopicsDTO;
import com.it7890.orange.manage.vo.HbCountrysDTO;
import com.it7890.orange.manage.vo.HbTopicsDTO;
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
    private static final Logger logger = LogManager.getLogger(RecommendArtControler.class);

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
    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public String topics( Model model, String countryId) {
        List<HbTopicsDTO> hbTopicsDTOs = hbTopicsService.getDtoList();
        List<AppTopicsDTO> apptopics = appTopicsService.getDtoList(countryId);
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
//    @RequestMapping(value = "/topicsUpdate", method = RequestMethod.POST)
//    public String topicsUpdate(HttpServletRequest request,
//                               HttpServletResponse response, int cid, int[] topics,
//                               String[] keywords, int[] ranks, Model model) {
//        SysUser sysuer = (SysUser) request.getSession().getAttribute("sysuser");
//        List<AppTopics> apptics = this.topcisService.getAppTopicsById(cid);
//        int result = 0;
//        if (topics != null && topics.length > 0) {
//            // 检测需要删除的
//            List<AppTopics> delapptics = new ArrayList<AppTopics>();
//            List<AppTopics> addapptics = new ArrayList<AppTopics>();
//            List<AppTopics> updateapptopics = new ArrayList<AppTopics>();
//            AppTopics apptopics;
//            HbTopics hbtopics;
//            for (AppTopics appTopics : apptics) {
//                boolean isdel = true;
//                for (int a = 0; a < topics.length; a++) {
//                    if (topics[a] == appTopics.getTopicid()) {
//                        if (keywords != null && keywords.length > 0) {
//                            if (keywords[a] != null && !"".equals(keywords[a])) {
//                                appTopics.setKeywords(keywords[a]);
//                            }
//                        }
//                        appTopics.setRank(ranks[a]);
//                        isdel = false;
//                    }
//                }
//                if (isdel) {
//                    delapptics.add(appTopics);
//                } else {
//                    updateapptopics.add(appTopics);
//                }
//            }
//            // 检测需要添加的
//            for (int a = 0; a < topics.length; a++) {
//                boolean isextis = false;
//                for (AppTopics appTopics : apptics) {
//                    if (topics[a] == appTopics.getTopicid()) {
//                        isextis = true;
//                    }
//                }
//                if (!isextis) {
//                    hbtopics = this.topcisService.getHbTopicsBytid(topics[a]);
//                    apptopics = new AppTopics();
//                    apptopics.setCountryid(cid);
//                    apptopics.setCreateuid(sysuer.getUserid());
//                    apptopics.setHubiiid(hbtopics.getID());
//                    apptopics.setKeywords(keywords[a]);
//                    apptopics.setRank(ranks[a]);
//                    apptopics.setTopicicon(hbtopics.getTopicicon());
//                    apptopics.setTopicid(hbtopics.getTid());
//                    apptopics.setTopicname(hbtopics.getName());
//                    apptopics.setTopictype(hbtopics.getTopictype());
//                    addapptics.add(apptopics);
//                }
//            }
//            result = this.topcisService.updateCountryTopics(cid, delapptics,
//                addapptics, updateapptopics);
//        }
//        request.getSession().setAttribute("message",
//            "更新国家话题:" + (result > 0 ? "成功" : "失败"));
//        request.getSession().setAttribute("url",
//            "country/topics?countryid=" + cid);
//        return String.format("redirect:/message");
//    }


    @RequestMapping(value = "exportCountry", method = RequestMethod.GET)
    public void exportcountry(HttpServletRequest request,
                              HttpServletResponse response, String[] countrys) throws IOException {
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
}
