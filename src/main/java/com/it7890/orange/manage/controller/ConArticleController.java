package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.model.*;
import com.it7890.orange.manage.po.AppAdvertQuery;
import com.it7890.orange.manage.po.AppPushInfoQuery;
import com.it7890.orange.manage.po.ConArticleQuery;
import com.it7890.orange.manage.po.HbCountryQuery;
import com.it7890.orange.manage.service.*;
import com.it7890.orange.manage.utils.ConstantsUtil;
import com.it7890.orange.manage.utils.MD5;
import com.it7890.orange.manage.utils.StringUtil;
import com.it7890.orange.manage.vo.ConArticleDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/5/31.
 */
@Controller
@RequestMapping("/conArticle")
public class ConArticleController {
    @Autowired
    private ConArticleService conArticleService;
    @Autowired
    private PublicationService publicationService;
    @Autowired
    private ConChannelService conChannelService;
    @Autowired
    private AppTopicsService topicsService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private AppPushInfoService appPushInfoService;
    @Autowired
    private HbCountryService hbCountryService;
    @Autowired
    private AppAdvertService appAdvertService;
    @Autowired
    private AppLockScreenService appLockScreenService;


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

        map.remove("org.springframework.validation.BindingResult.conArticleQuery");
        map.put("appTopArtitypeList", ConstantsUtil.getConstants("appTopArtitype"));
        map.put("conArticleQuery", conArticleQuery);
        map.putAll(conArticleListAndPageUtilMap);


        map.put("countryList", hbCountryService.getCountryList());
        map.put("topicList", topicsService.getAppTopicsList());
        map.put("channelList", conChannelService.getChannelList());
        map.put("publicationList", publicationService.getPublictionList());
        map.put("languageList", languageService.getLanguageList());


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
            if (article.getCountryCode() != null) {
                HbCountryQuery hbCountryQuery = new HbCountryQuery();
                hbCountryQuery.setCountryCode(article.getCountryCode());
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

            if (article.getCountryCode() != null) {
                HbCountryQuery hbCountryQuery = new HbCountryQuery();
                hbCountryQuery.setCountryCode(article.getCountryCode());
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

            String cid = String.valueOf(appPushInfo2.getCountryObjectId());
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
            appPushInfoService.saveOrUpdate(appPushInfo2);
            /*model.addAttribute("appPushInfo",appPushInfo);*/
        }
        attributes.addFlashAttribute("msg", desc);
        return "redirect:conArticle/list";
    }

    @RequestMapping(value = "/importscreen", method = RequestMethod.GET)
    public String importscreen(HttpSession session, HttpServletResponse response,
                               @RequestParam(value = "screenstatus", required = false, defaultValue = "1") Integer screenstatus,
                               @RequestParam(value = "screenid", required = false) String screenid,
                               Model model) throws AVException {

        int result = 0;
        SysUser sysuer = (SysUser) session.getAttribute("sysuser");
        AppLockScreen lockscreen = null;
        Date d = new Date();
        Calendar ca = Calendar.getInstance();
        long current = d.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String d1 = sdf.format(d);
        if (d1.equals("00:00:00")) {
            current = current + 1000;
            ca.setTimeInMillis(current);
            d = ca.getTime();
        } else {
            ca.setTimeInMillis(current);
            d = ca.getTime();
        }

        if (screenstatus == 2) {//广告导入
            lockscreen = new AppLockScreen();
            AppAdvert advert = null;
            AppAdvertQuery appAdvertQuery = new AppAdvertQuery();
            appAdvertQuery.setArticleObjectId(screenid);
            List<AppAdvert> appAdvertList = appAdvertService.get(appAdvertQuery);
            if (appAdvertList != null && !appAdvertList.isEmpty()) {
                advert = appAdvertList.get(0);
            }

            if (advert != null) {
                lockscreen.setTitle(advert.getAdName());
                lockscreen.setAbstracts(advert.getAdDesc());
                if (StringUtil.isNotEmpty(advert.getCountryCode())) {
                    lockscreen.setCountryCode(advert.getCountryCode());
                } else {
                    lockscreen.setCountryCode("00");
                }
                System.out.println(advert.getLanguageObj());
                if (advert.getLanguageObj() != null) {
                    HbLanguage hbLanguage = new HbLanguage();
                    hbLanguage.setObjectId(advert.getLanguageObj().getObjectId());
                    lockscreen.setLanguageObj(hbLanguage);
                }
                lockscreen.setAttr(3);


                if (advert.getAdImg() != null && advert.getAdImg().indexOf("|") != -1) {
                    lockscreen.setImg(advert.getAdImg().split("\\|")[0]);
                } else {
                    lockscreen.setImg(advert.getAdImg());
                }
                lockscreen.setType(2);
                lockscreen.setDataTime(d);
                lockscreen.setIsShow(1);
                lockscreen.setSrc(advert.getAdUrl());
                lockscreen.setRank(0);
                lockscreen.setVersionId("0");
                if (sysuer != null) {
                    lockscreen.setCreateUserObj(AVObject.createWithoutData("SysUser", "" + sysuer.getObjectId()));
                }

                //lockscreen.setCreatetime(advert.getCreatetime());
                //lockscreen.setCountryid(0);
                lockscreen.setSourceId(screenid);
                lockscreen.setIsScroll(0);
                //lockscreen.setChannelid(0);
                //lockscreen.setTopicsid(0);
                //Map<String, String> map = upyunutil.getFileInfo(lockscreen.getImg());
                //lockscreen.setImgsize(map != null ? Integer.parseInt(map.get("size")) : 0);

                String lockScreenObjectId = appLockScreenService.saveOrUpdate(lockscreen);
                System.out.println(lockScreenObjectId);
            }


            /*request.getSession().setAttribute("message", "导入:" + (result > 0 ? "成功" : "失败"));
            request.getSession().setAttribute("url", "advert/list");*/
            return String.format("redirect:/message");

        } else {//文章导入


            /*lockscreen = new AppLockScreen();
            List<top.coolook.esmodel.ConArticle> list = conArticleService.getarticleByid(screenid);
            ConArticle article = list.get(0);

            lockscreen.setTitle(article.getTitle());
            lockscreen.setAbstracts(article.getAbstracts());
            lockscreen.setCountrycode(article.getCountrycode());
            if (article.getLangid() != null && !"".equals(article.getLangid())) {
                lockscreen.setLangid(Integer.parseInt(article.getLangid()));
            } else {
                lockscreen.setLangid(0);
            }
            lockscreen.setAttr(article.getAttr());
            if (article.getTitlepic() != null && !"".equals(article.getTitlepic())) {
                if (article.getTitlepic() != null && article.getTitlepic().indexOf("|") != -1) {
                    lockscreen.setImg(article.getTitlepic().split("\\|")[0]);
                } else {
                    lockscreen.setImg(article.getTitlepic());
                }
            }
            lockscreen.setType(1);
            lockscreen.setDatatime(article.getSubtime());
            lockscreen.setIsshow(1);
            lockscreen.setSrc("http://www.coolook.top/news/" + screenid + ".html");
            lockscreen.setRank(0);
            lockscreen.setVersionid(0);
            lockscreen.setCreateuid(sysuer.getUserid());
            lockscreen.setCreatetime(article.getCreatetime());
            lockscreen.setCountryid(0);
            lockscreen.setSourceid(screenid);
            lockscreen.setIsscroll(0);
            lockscreen.setChannelid(0);
            lockscreen.setTopicsid(0);
            Map<String, String> map = upyunutil.getFileInfo(lockscreen.getImg());
            lockscreen.setImgsize(map != null ? Integer.parseInt(map.get("size")) : 0);
            result = appLockScreenService.insertAppLockScreen(lockscreen);

            request.getSession().setAttribute("message", "导入:" + (result > 0 ? "成功" : "失败"));
            request.getSession().setAttribute("url", "article/list?" + str);*/
            return String.format("redirect:/message");
        }


    }

    @RequestMapping(value = "/preview", method = RequestMethod.GET)
    public String preview(Map map, String flag, String dataJson) {
        map.put("flag", flag);
        map.put("dataJson", dataJson);
        return "viewUrl";
    }


    @RequestMapping(value = "/getContent", method = RequestMethod.GET)
    @ResponseBody
    public void getContent(@RequestParam(value = "articleId", required = true) String articleId,
                           Model model, HttpServletResponse response) throws AVException, IOException {

        ConArticleDetailDTO resArtContentDTO = new ConArticleDetailDTO();
        resArtContentDTO = conArticleService.getContentByArtID(articleId);
        model.addAttribute("content", JSON.toJSONString(resArtContentDTO));
        if (resArtContentDTO != null) {
            resArtContentDTO.setMsg("成功");
            resArtContentDTO.setSuccess(1);
            resArtContentDTO.setStatus(200);
        } else {
            resArtContentDTO.setMsg("失败");
            resArtContentDTO.setSuccess(0);
            resArtContentDTO.setStatus(500);
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json");
        response.setDateHeader("Expires", 0);

        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                out.print(JSON.toJSONString(resArtContentDTO));
                out.flush();
                out.close();
            }
        }
//        return JSON.toJSONString(resArtContentDTO);
    }

    /**
     * 到添加页面
     */
    @RequestMapping("/toAddArticle")
    public String toAddArticle(Map map) throws Exception {
        map.put("ctypeList", ConstantsUtil.getConstants("conArticleCtype"));
        map.put("itypeList", ConstantsUtil.getConstants("appTopArtitype"));
        map.put("statusList", ConstantsUtil.getConstants("conArticleStatus"));
        map.put("countryList", hbCountryService.getCountryList());
        map.put("topicList", topicsService.getAppTopicsList());
        map.put("channelList", conChannelService.getChannelList());
        map.put("publicationList", publicationService.getPublictionList());
        map.put("languageList", languageService.getLanguageList());
        System.out.println(JSON.toJSONString(map));
        return "views/article/add";
    }

    /**
     * 到修改页面
     */
    @RequestMapping(path = "/toEditArticle")
    public String toEditArticle(String objectId, Map map) throws Exception {
        map.put("article", conArticleService.getConArticleMap(objectId));
        map.put("ctypeList", ConstantsUtil.getConstants("conArticleCtype"));
        map.put("itypeList", ConstantsUtil.getConstants("appTopArtitype"));
        map.put("statusList", ConstantsUtil.getConstants("conArticleStatus"));
        map.put("countryList", hbCountryService.getCountryList());
        map.put("topicList", topicsService.getAppTopicsList());
        map.put("channelList", conChannelService.getChannelList());
        map.put("publicationList", publicationService.getPublictionList());
        map.put("languageList", languageService.getLanguageList());
        System.out.println(JSON.toJSONString(map));
        return "views/article/edit";
    }

    /**
     * 添加,修改 文章
     */
    @RequestMapping(path = "/saveOrUpdateArticle", method = RequestMethod.POST)
    public String updateArticle(ConArticleQuery articleQuery, RedirectAttributes attributes) throws Exception {
        String msg = "";
        if (StringUtil.isEmpty(articleQuery.getObjectId())) {
            msg = "添加";
        } else {
            msg = "修改";
        }
        try {
            conArticleService.updateArticle(articleQuery);
            attributes.addFlashAttribute(msg + "成功");
        } catch (Exception e) {
            attributes.addFlashAttribute(msg + "失败");
            e.printStackTrace();
        }
        return "redirect:/conArticle/list";
    }

    /**
     * 到编辑 文章内容 页面
     */
    @RequestMapping("/toEditArticleContent")
    public String toEditArticleContent(String objectId, Map map) throws Exception {
        String content = conArticleService.getConArticleContent(objectId);
        map.put("content", content);
        map.put("articleObjectId", objectId);

        return "views/articlescontent/add";
    }

    /**
     * 编辑 文章内容
     */
    @RequestMapping(path = "/editArticleContent", method = RequestMethod.POST)
    public String editArticleContent(String objectId, String content, RedirectAttributes attributes) throws Exception {
        try {
            conArticleService.updateArticleContent(objectId, content);
            attributes.addFlashAttribute("编辑成功");
        } catch (Exception e) {
            attributes.addFlashAttribute("编辑失败");
            e.printStackTrace();
        }
        return "redirect:/conArticle/list";
    }

    /**
     * 添加到置顶图
     */
    @RequestMapping(value = "/addToAppTop", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object addToAppTop(String objectId) throws Exception {
        int isSuccess = 1;

        try {
            AppAdvertQuery appAdvertQuery = new AppAdvertQuery();
            appAdvertQuery.setArticleObjectId(objectId);
            AppAdvert appAdvert = null;
            List<AppAdvert> appAdvertList = appAdvertService.get(appAdvertQuery);
            if (appAdvertList != null && !appAdvertList.isEmpty()) {
                appAdvert = appAdvertList.get(0);
            }

            AppTop appTop = new AppTop();
            if (appAdvert != null) {
                appTop.setAdvert(appAdvert);
                appTop.setItype(3); //广告
                ConArticle article = new ConArticle();
                article.setObjectId(objectId);
                article.setAttr(7);//其他
                appTop.setArticle(article);

                //国家
                HbCountryQuery countryQuery = new HbCountryQuery();
                countryQuery.setCountryCode(article.getCountryCode());
                List<HbCountrys> countrysList = hbCountryService.get(countryQuery);
                if (countrysList != null && !countrysList.isEmpty()) {
                    appTop.setCountry(countrysList.get(0));
                }

                appTop.setLanguage(article.getLanguage()); //语言
                appTop.setRank(0); //排序
                appTop.setStatus(1);//禁用

                if (appAdvert.getAdTitle() != null && !appAdvert.getAdTitle().equals("")) {
                    appTop.setTitle(appAdvert.getAdTitle());
                } else if (appAdvert.getAdName() != null && !appAdvert.getAdName().equals("")) {
                    appTop.setTitle(appAdvert.getAdName());
                }
                appTop.setTitlePic(appAdvert.getAdImg());
                appTop.setUrl(appAdvert.getAdUrl());
                appTop.setSubTime(new Date());
                appTop.save();
            }
        } catch (AVException e) {
            isSuccess = 0;
            e.printStackTrace();
        }

        Map map = new HashMap();
        map.put("isSuccess", isSuccess);
        return JSON.toJSON(map);
    }

    @RequestMapping(value = "/uploadTitlePic")
    @ResponseBody
    public Object uploadTitlePic(MultipartFile file) {

        int isSuccess = 1;
        int code = -1;
        Map result = new HashMap();

        if (file != null) {
            String logImageName = null;
            String suffix = null;
            String imgSrc = "";
            try {
                suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String folder = df.format(new Date());
                logImageName = MD5.MD5(UUID.randomUUID().toString()) + suffix;
                String filename = "/" + folder + "/" + logImageName;

                AVFile uploadFile = new AVFile(filename, file.getBytes());
                uploadFile.save();

                if (StringUtil.isNotEmpty(uploadFile.getUrl())) {
                    imgSrc = uploadFile.getUrl();
                }

                result.put("title", logImageName);
                result.put("original", logImageName);
                result.put("type", suffix);
                result.put("url", imgSrc);
                result.put("title", logImageName);
                result.put("objectId", uploadFile.getObjectId());
            } catch (Exception e) {
                isSuccess = 0;
                e.printStackTrace();
            }
        } else {
            code = 1;//图片不能为空
        }

        Map map = new HashMap();
        result.put("code", code);
        map.put("isSuccess", isSuccess);
        map.put("result", result);
        return JSON.toJSON(map);
    }

}
