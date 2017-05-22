package com.it7890.orange.manage.controller.collectionController;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.model.*;
import com.it7890.orange.manage.service.applicationService.ConChannelService;
import com.it7890.orange.manage.service.applicationService.HbCountryService;
import com.it7890.orange.manage.service.applicationService.TopicService;
import com.it7890.orange.manage.service.collectionService.ArticleManagerRuleService;
import com.it7890.orange.manage.service.collectionService.GlobalNodeService;
import com.it7890.orange.manage.service.collectionService.ListManagerRuleService;
import com.it7890.orange.manage.service.contentService.LanguageService;
import com.it7890.orange.manage.service.contentService.PublicationService;
import com.it7890.orange.manage.utils.Constant;
import com.it7890.orange.manage.utils.JsoupUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/listrule")
public class ListManagerRuleController {
    private static final Logger logger = LogManager.getLogger(ListManagerRuleController.class);
    @Resource
    ListManagerRuleService iConGrabRuleService;
    @Resource
    TopicService topicService;
    @Resource
    PublicationService publicationService;
    @Resource
    HbCountryService hbCountryService;
    @Resource
    LanguageService languageService;
    @Resource
    ConChannelService conChannelService;
    @Resource
    private GlobalNodeService nodeService;
    @Resource
    ArticleManagerRuleService articleManagerRuleService;

    //列表规则展示
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String listTodo(ModelMap model) throws AVException {
        List<ConGrabLRule> rules = this.iConGrabRuleService.getAll();
        List<HbTopics> topics = this.topicService.getAll();
        List<ConPublication> publication = this.publicationService.getAll();
        List<ConChannel> conChannels = this.conChannelService.getAll();
        List<GlobalNode> nodeList = this.nodeService.getAll();
        model.addAttribute("nodeList", nodeList);
        model.addAttribute("rules", rules);
        model.addAttribute("topics", topics);
        model.addAttribute("publication", publication);
        model.addAttribute("conChannels", conChannels);
        model.addAttribute("bean", new ConGrabLRule());
        return "views/listrule/list";
    }
    //查询
    @RequestMapping(path = "/select", method = RequestMethod.GET)
    public String getSelect(ModelMap model, ConGrabLRule bean) throws AVException {
        List<ConGrabLRule> rules = this.iConGrabRuleService.getSelect(bean);
        List<HbTopics> topics = this.topicService.getAll();
        List<ConPublication> publication = this.publicationService.getAll();
        List<ConChannel> conChannels = this.conChannelService.getAll();
        List<GlobalNode> nodeList = this.nodeService.getAll();
        model.addAttribute("nodeList", nodeList);
        model.addAttribute("rules", rules);
        model.addAttribute("topics", topics);
        model.addAttribute("publication", publication);
        model.addAttribute("conChannels", conChannels);
        model.addAttribute("bean", bean);
//        logger.info("ssssssssssss" + topics.get(1).getName());
        return "views/listrule/list";
    }

    //到添加页面   修改回显页  TODO 两个更新未完成
    @RequestMapping(path = "/toadd", method = RequestMethod.GET)
    public String toAdd(Model model, String objectId) throws AVException {
        List<ConGrabLRule> rules = this.iConGrabRuleService.getAll();
        List<HbTopics> topics = this.topicService.getAll();
        List<ConPublication> publications = this.publicationService.getAll();
        List<HbCountrys> hbCountrys = this.hbCountryService.getAll();
        List<HbLanguage> languages = this.languageService.getAll();
        List<ConChannel> conChannels = this.conChannelService.getAll();
        List<GlobalNode> nodeList = this.nodeService.getAll();
        model.addAttribute("nodeList", nodeList);
        model.addAttribute("rules", rules);
        model.addAttribute("topics", topics);
        model.addAttribute("publications", publications);
        model.addAttribute("hbCountrys", hbCountrys);
        model.addAttribute("languages", languages);
        model.addAttribute("conChannels", conChannels);
        ConGrabLRule bean = null;
        if (null == objectId || "".equals(objectId)) {
            bean = new ConGrabLRule();
        } else {
            bean = this.iConGrabRuleService.getLRuleById(objectId);
        }
        model.addAttribute("bean", bean);
        return "views/listrule/add";
    }

    //查看单个规则详情
    ///listrules/details?objectId=59140a34c228850065c61340
    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String showdetailsById(HttpServletRequest request, Model model, String objectId) {
        ConGrabLRule bean = this.iConGrabRuleService.getLRuleById(objectId);
        List<ConPublication> publications = this.publicationService.getAll();
        List<ConChannel> conChannels = this.conChannelService.getAll();
        List<GlobalNode> nodeList = this.nodeService.getAll();
        model.addAttribute("nodeList", nodeList);
        model.addAttribute("item", bean);
        model.addAttribute("publications", publications);
        model.addAttribute("conChannels", conChannels);
        return "views/listrule/details";
    }


    //增加或者修改的ti提交   String conconstant,
    @RequestMapping(value = "/saveorupdate", method = RequestMethod.POST)
    public String SaveOrUpdate(HttpServletRequest request, HttpServletResponse response, ConGrabLRule bean, Model model) {
        List<HbLanguage> languages = this.languageService.getAll();
        model.addAttribute("languages", languages);
        if (bean.getObjectId() == null || "".equals(bean.getObjectId())) {
            String objectId = this.iConGrabRuleService.insert(bean);
        } else {
            this.iConGrabRuleService.update(bean);
        }
        return String.format("redirect:/listrule/list");
    }


    //        List<ConGrabLRule> rules = this.iConGrabRuleService.getAll();
//        List<HbTopics> topics = this.topicService.getAll();
//        List<ConPublication> publications = this.publicationService.getAll();
//        List<HbCountrys> hbCountrys = this.hbCountryService.getAll();
//        List<HbLanguage> languages = this.languageService.getAll();
//        List<ConChannel> conChannels = this.conChannelService.getAll();
//        model.addAttribute("rules", rules);
//        model.addAttribute("topics", topics);
//        model.addAttribute("publications", publications);
//        model.addAttribute("hbCountrys", hbCountrys);
//        model.addAttribute("languages", languages);
//        model.addAttribute("conChannels", conChannels);
//        ConGrabLRule tem = null;
    //            if (objectId == null && "".equals(objectId)) {
//                request.getSession().setAttribute("message", "添加失败");
//            } else {
//                request.getSession().setAttribute("message", "添加成功");
//            }
    //            request.getSession().setAttribute("message", "更新成功");
    //        return String.format("redirect:/message");
    //            tem = this.iConGrabRuleService.getLRuleById(bean.getObjectId());
//            tem.setId(bean.getId());
//            tem.setChannelid(bean.getChannelid());
//            tem.setCode(bean.getCode());
//            tem.setCsspath(bean.getCsspath());
//            tem.setLangid(bean.getLangid());
//            tem.setNodeid(bean.getNodeid());
//            tem.setPid(bean.getPid());
//            tem.setRulename(bean.getRulename());
//            tem.setStatus(bean.getStatus());
//            tem.setUrl(bean.getUrl());
//            tem.setTopic(bean.getTopic());
//            tem.setGrabtime(bean.getGrabtime());
//            tem.setConstant(bean.getConstant());
//            tem.setFindpre(bean.getFindpre());
//            tem.setListstatus(bean.getListstatus());
//            tem.setConstant(bean.getConstant());

    //        request.getSession().setAttribute("message", "删除成功");
//        request.getSession().setAttribute("url", "/listrule/list");
//        return "views/message";
//        return "listrule/list";


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(HttpServletRequest request, Model model, String objectId) {
        this.iConGrabRuleService.deleteRuleByObjectId(objectId);
        return String.format("redirect:/listrule/list");
    }

    @RequestMapping(value = "/getconnect",method = RequestMethod.GET)
    public String getConnectList( Model model,Integer id){
        ConGrabCRule bean = new ConGrabCRule();
        bean.setStatus(-1);
        List<ConGrabCRule> list = articleManagerRuleService.getAllConByLid(id);
//        List<HbTopics> topics = this.topicService.getAll();
//        List<ConPublication> publication = this.publicationService.getAll();
//        List<ConChannel> conChannels = this.conChannelService.getAll();
//        List<GlobalNode> nodeList = this.nodeService.getAll();
//        model.addAttribute("nodeList", nodeList);
//        model.addAttribute("topics", topics);
//        model.addAttribute("publication", publication);
//        model.addAttribute("conChannels", conChannels);
        model.addAttribute("list",list);
        model.addAttribute("bean", bean);
        return "views/conrule/list";
    }



    @RequestMapping( value = "/test", method = RequestMethod.POST)
    public String Test(
        HttpServletRequest request,
        Integer id,
        String url,
        ConGrabLRule bean,
        ModelMap model,
        String csspath,
        String findpre) {
//		System.out.println(request.getParameter("url"));
//		System.out.println(request.getParameter("csspath"));
        int status=-1;String content="";
        if(url!=null&&!"".equals(url)){
            Document doc= JsoupUtil.getDocument(url, Constant.AUTO);
            if(doc!=null){
                if(csspath!=null&&!"".equals(csspath)){
                    Elements area = doc.select(csspath);
//					content=JsoupUtil.genTextOrHTMLByCssPath(doc, csspath, false);
                    Elements pageEls = area.select("a[href~="+findpre+"]");
                    for (int i = 0; i < pageEls.size(); i++) {
                        Element e = pageEls.get(i);
                        String hrefurl = e.attr("href");
                        System.out.println(hrefurl);
                        //hrefurl =URLTransUtil.relAdrToAbsAdr(initBaseUrl(url), e.attr("href"));
                        hrefurl=getUrlList(hrefurl, url);
                        content=content+hrefurl+"\n";
                    }
                }
                status=0;
            }else{
                status=1;
            }
        }
        model.addAttribute("content",content);
        model.addAttribute("status",status);
        model.addAttribute("id",id);
//		List<ContentGather> list=new ArrayList<ContentGather>();
        return "views/listrule/test";

    }


    public static String getUrlList(String lacturls,String aMainUrl){
        String lacturl="";
        //特殊处理
        if(aMainUrl.trim().contains("http://www.folhadoes.com/categoria/")){
            lacturl="http://www.folhadoes.com/"+lacturls;
            return lacturl;
        }
        if(lacturls.contains("#")){
            lacturls = lacturls.substring(0, lacturls.indexOf("#"));
        }
        if(lacturls.startsWith("//")){
            lacturls="http:"+lacturls;
        }
        if(!lacturls.startsWith("http://") && !lacturls.startsWith("https://")){
            String listbaseurl = getBaseUrl(aMainUrl);
            String headbaseurl=getHeadBaseUrl(aMainUrl);
            if(lacturls.startsWith("/")){
                lacturl=headbaseurl+lacturls;
            }else{
                lacturl=listbaseurl+"/"+lacturls;
            }
        }else{
            lacturl=lacturls;
        }
        return lacturl;
    }

    public static String getBaseUrl(String url) {
        return url.substring(0, url.lastIndexOf("/"));
    }

    public static String getHeadBaseUrl(String url) {
        if(url.startsWith("//")){
            url="http:"+url;
        }
        if( !url.startsWith("http://") && !url.startsWith("https://")){
            url="http://"+url;
        }
        if(url.indexOf("/", 8)==-1){
            //log.info("error  getHeadBaseUrl url="+url);
        }else{
            url=url.substring(0, url.indexOf("/", 8));
        }
        return url;
    }

}