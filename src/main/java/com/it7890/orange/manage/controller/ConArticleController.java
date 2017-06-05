package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.AppPushInfo;
import com.it7890.orange.manage.model.ConArticle;
import com.it7890.orange.manage.model.HbCountrys;
import com.it7890.orange.manage.po.AppPushInfoQuery;
import com.it7890.orange.manage.po.ConArticleQuery;
import com.it7890.orange.manage.po.HbCountryQuery;
import com.it7890.orange.manage.service.AppPushInfoService;
import com.it7890.orange.manage.service.ConArticleService;
import com.it7890.orange.manage.service.applicationService.HbCountryService;
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

import java.util.List;
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
    @Autowired
    private AppPushInfoService appPushInfoService;
    @Autowired
    private HbCountryService hbCountryService;


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
        return "views/article/list";
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
        attributes.addAttribute("countryCode", conArticleQuery.getCountryCode());
        attributes.addAttribute("publicationObjectId", conArticleQuery.getPublicationObjectId());
        attributes.addAttribute("languageObjectId", conArticleQuery.getLanguageObjectId());
        attributes.addAttribute("channelObjectId", conArticleQuery.getChannelObjectId());
        attributes.addAttribute("attr", conArticleQuery.getAttr());
        attributes.addAttribute("status", conArticleQuery.getStatus());
        attributes.addAttribute("keywords", conArticleQuery.getKeywords());
        attributes.addAttribute("topicObjectId", conArticleQuery.getTopicObjectId());
        attributes.addAttribute("startTime", conArticleQuery.getStartTime());
        attributes.addAttribute("endTime", conArticleQuery.getEndTime());
        attributes.addAttribute("page", page);

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
        attributes.addAttribute("countryCode", conArticleQuery.getCountryCode());
        attributes.addAttribute("publicationObjectId", conArticleQuery.getPublicationObjectId());
        attributes.addAttribute("languageObjectId", conArticleQuery.getLanguageObjectId());
        attributes.addAttribute("channelObjectId", conArticleQuery.getChannelObjectId());
        attributes.addAttribute("attr", conArticleQuery.getAttr());
        attributes.addAttribute("status", conArticleQuery.getStatus());
        attributes.addAttribute("keywords", conArticleQuery.getKeywords());
        attributes.addAttribute("topicObjectId", conArticleQuery.getTopicObjectId());
        attributes.addAttribute("startTime", conArticleQuery.getStartTime());
        attributes.addAttribute("endTime", conArticleQuery.getEndTime());
        attributes.addAttribute("page", page);

        return "redirect:/conArticle/list";
    }

    public String importScreen() {
        return "";
    }

    @RequestMapping(value = "/pushadd", method = RequestMethod.GET)
    public String pushadd(String objectId, RedirectAttributes attributes, ConArticleQuery conArticleQuery, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {
        attributes.addAttribute("countryCode", conArticleQuery.getCountryCode());
        attributes.addAttribute("publicationObjectId", conArticleQuery.getPublicationObjectId());
        attributes.addAttribute("languageObjectId", conArticleQuery.getLanguageObjectId());
        attributes.addAttribute("channelObjectId", conArticleQuery.getChannelObjectId());
        attributes.addAttribute("attr", conArticleQuery.getAttr());
        attributes.addAttribute("status", conArticleQuery.getStatus());
        attributes.addAttribute("keywords", conArticleQuery.getKeywords());
        attributes.addAttribute("topicObjectId", conArticleQuery.getTopicObjectId());
        attributes.addAttribute("startTime", conArticleQuery.getStartTime());
        attributes.addAttribute("endTime", conArticleQuery.getEndTime());
        attributes.addAttribute("page", page);

        ConArticle article = conArticleService.getById(objectId);
        AppPushInfo appPushInfo = null;
        String desc = "推送结果:";

        AppPushInfoQuery appPushInfoQuery = new AppPushInfoQuery();
        appPushInfoQuery.setArticleObjectId(objectId);
        List<AppPushInfo> appPushInfoList = appPushInfoService.get(appPushInfoQuery);
        if (!appPushInfoList.isEmpty()) {
            appPushInfo = appPushInfoList.get(0);
        }

        if (appPushInfo == null) {
            HbCountrys hbc = null;
            List<HbCountrys> hbCountrysList = null;
            if (article.getCountrycode() != null) {
                HbCountryQuery hbCountryQuery = new HbCountryQuery();
                hbCountryQuery.setCountryCode(article.getCountrycode());
                hbCountrysList = hbCountryService.get(hbCountryQuery);
                if (hbCountrysList.isEmpty()) {
                    attributes.addFlashAttribute("msg", "推送失败");
                    return "redirect:conArticle/list";
                } else {
                    hbc = hbCountrysList.get(0);
                }
            } else {
                attributes.addFlashAttribute("msg", "推送失败");
                return "redirect:conArticle/list";
            }

            appPushInfo = new AppPushInfo();
            appPushInfo.setCountryObjectId(hbc.getObjectId());
            appPushInfo.setArticleObjectId(article.getObjectId());
            appPushInfo.setTitle(article.getTitle());
            appPushInfo.setPushNum(0);
            appPushInfo.setStatus(0);


            String countryObjectId = String.valueOf(hbc.getObjectId());
            String codeAnd = "";
            String codeIos = "";
            //PushMessage pushMessage = new PushMessage(appkey,appMasterSecret,iosappkey,iosappMasterSecret);
            try {
                /*旧版代码
                codeAnd = pushMessage.sendAndroidGroupcast(cid,con.getTitle(),con.getTitle(),con.getAbstracts(),tojson(upyunutil,con));
                codeIos = pushMessage.sendIOSGroupcast(cid,con.getTitle(),con.getTitle(),con.getAbstracts(),tojson(upyunutil,con));*/

                //codeAnd = pushMessage.sendAndroidGroupcast(cid,article.getTitle(),article.getTitle(),article.getAbstracts(),tojson(upyunutil,article));
                //codeIos = pushMessage.sendIOSGroupcast(cid,article.getTitle(),article.getTitle(),article.getAbstracts(),tojson(upyunutil,article));
            } catch (Exception e) {
                e.printStackTrace();
            }
            //插入记录
            String appPushInfoObjectId = appPushInfoService.saveOrUpdate(appPushInfo);
            appPushInfo.setObjectId(appPushInfoObjectId);
            int failcode = 0;
            //推送后更新状态
            if (codeAnd.equals("200") && codeIos.equals("200")) {
                appPushInfo.setStatus(2);
                desc = desc + "成功 ";
            } else {
                if (!codeAnd.equals("200")) {
                    failcode = failcode + 3;
                    desc = desc + "android失败 ";
                }
                if (!codeIos.equals("200")) {
                    failcode = failcode + 4;
                    desc = desc + "ios失败 ";
                }
                appPushInfo.setStatus(failcode);
            }
            appPushInfoService.saveOrUpdate(appPushInfo);
            /*model.addAttribute("appPushInfo",conarticleService.getAppPushInfoByArticleid(con.getArticleid()));*/
        } else if (appPushInfo != null && appPushInfo.getStatus() != 2) {
            String cid = String.valueOf(appPushInfo.getCountryObjectId());
            String codeAnd = "200";
            String codeIos = "200";
            //PushMessage pushMessage = new PushMessage(appkey,appMasterSecret,iosappkey,iosappMasterSecret);
            try {
                if (appPushInfo.getStatus() == 3 || appPushInfo.getStatus() == 7) {
                    //codeAnd = pushMessage.sendAndroidGroupcast(cid,con.getTitle(),con.getTitle(),con.getAbstracts(),tojson(upyunutil,con));
                }
                if (appPushInfo.getStatus() == 4 || appPushInfo.getStatus() == 7) {
                    //codeIos = pushMessage.sendIOSGroupcast(cid,con.getTitle(),con.getTitle(),con.getAbstracts(),tojson(upyunutil,con));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            int failcode = 0;
            //推送后更新状态
            if (codeAnd.equals("200") && codeIos.equals("200")) {
                appPushInfo.setStatus(2);
                desc = desc + "成功 ";
            } else {
                if (!codeAnd.equals("200")) {
                    failcode = failcode + 3;
                    desc = desc + "android失败 ";
                }
                if (!codeIos.equals("200")) {
                    failcode = failcode + 4;
                    desc = desc + "ios失败 ";
                }
                appPushInfo.setStatus(failcode);
            }
            appPushInfoService.saveOrUpdate(appPushInfo);
        }

        attributes.addFlashAttribute("msg", desc);
        return "redirect:conArticle/list";
    }

    @RequestMapping(value = "/pushadd2", method = RequestMethod.GET)
    public String pushadd2(String objectId, RedirectAttributes attributes, ConArticleQuery conArticleQuery, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {
        int result = 0;
        ConArticle article = conArticleService.getById(objectId);

        AppPushInfo appPushInfo2 = null;
        String desc = "推送结果:";

        AppPushInfoQuery appPushInfoQuery = new AppPushInfoQuery();
        appPushInfoQuery.setArticleObjectId("v2" + objectId);
        List<AppPushInfo> appPushInfoList = appPushInfoService.get(appPushInfoQuery);
        if (!appPushInfoList.isEmpty()) {
            appPushInfo2 = appPushInfoList.get(0);
        }


        if (appPushInfo2 == null) {
            HbCountrys hbc = null;

            if (article.getCountrycode() != null) {
                HbCountryQuery hbCountryQuery = new HbCountryQuery();
                hbCountryQuery.setCountryCode(article.getCountrycode());
                List<HbCountrys> hbCountrysList = hbCountryService.get(hbCountryQuery);
                if (hbCountrysList.isEmpty()) {
                    attributes.addFlashAttribute("msg", "推送失败");
                    return "redirect:conArticle/list";
                } else {
                    hbc = hbCountrysList.get(0);
                }
            } else {
                attributes.addFlashAttribute("msg", "推送失败");
                return "redirect:conArticle/list";
            }

            AppPushInfo pushinfo2 = new AppPushInfo();
            pushinfo2.setCountryObjectId(hbc.getObjectId());
            pushinfo2.setArticleObjectId("v2" + article.getObjectId());
            pushinfo2.setTitle(article.getTitle());
            pushinfo2.setPushNum(0);
            pushinfo2.setStatus(0);


            String cid = String.valueOf(hbc.getObjectId());

            String codeAnd2 = "";
            //PushMessage pushMessage2 = new PushMessage(appkey2, appMasterSecret2, null, null);
            try {
                //codeAnd2 = pushMessage2.sendAndroidGroupcast(cid, con.getTitle(), con.getTitle(), con.getAbstracts(), tojson(upyunutil, con));
            } catch (Exception e) {
                e.printStackTrace();
            }
            //插入记录
            String appPushInfoObjectId = appPushInfoService.saveOrUpdate(pushinfo2);
            pushinfo2.setObjectId(appPushInfoObjectId);

            int failcode = 0;
            //推送后更新状态
            if (codeAnd2.equals("200")) {
                pushinfo2.setStatus(2);
                desc = desc + "成功 ";
            } else {
                if (!codeAnd2.equals("200")) {
                    failcode = failcode + 5;
                    desc = desc + "android新渠道失败 ";
                }
//				if(!codeAnd2.equals("200")){
//					failcode=failcode+5;
//					desc=desc+"android新渠道失败 ";
//				}
                // 2表示成功  3表示安卓失败   4表示ios失败  5表示新渠道安卓失败  7表示安卓ios失败

                pushinfo2.setStatus(failcode);
            }
            appPushInfoService.saveOrUpdate(pushinfo2);
            /*model.addAttribute("appPushInfo",conarticleService.getAppPushInfoByArticleid(con.getArticleid()));*/
        } else if (appPushInfo2 != null && appPushInfo2.getStatus() != 2) {//推送过但没有成功的情况下可以再次推送

            //String cid = String.valueOf(appPushInfo2.getCid());
            String codeAnd = "200";
            //PushMessage pushMessage = new PushMessage(appkey2, appMasterSecret2, iosappkey, iosappMasterSecret);
            try {
                if (appPushInfo2.getStatus() == 5) {
                    //codeAnd = pushMessage.sendAndroidGroupcast(cid, con.getTitle(), con.getTitle(), con.getAbstracts(), tojson(upyunutil, con));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            int failcode = 0;
            //推送后更新状态
            if (codeAnd.equals("200")) {
                appPushInfo2.setStatus(2);
                desc = desc + "成功 ";
            } else {
                if (!codeAnd.equals("200")) {
                    failcode = failcode + 5;
                    desc = desc + "android新渠道失败 ";
                }

                appPushInfo2.setStatus(failcode);
            }
            //result = conArticleService.updateAppPushInfo(appPushInfo2);
            /*model.addAttribute("appPushInfo",appPushInfo);*/
        }
		/*else{
			model.addAttribute("appPushInfo",appPushInfo);
		}*/
		/*model.addAttribute("countrys",countrysService.getAllHbCountrys());
		return "recommend/pushlist";*/


        //request.getSession().setAttribute("message",desc);
        //request.getSession().setAttribute("url", "article/list?" + str);
        return String.format("redirect:/message");
    }
}
