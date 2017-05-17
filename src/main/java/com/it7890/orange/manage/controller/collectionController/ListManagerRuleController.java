package com.it7890.orange.manage.controller.collectionController;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.Application;
import com.it7890.orange.manage.model.*;
import com.it7890.orange.manage.service.applicationService.ConChannelService;
import com.it7890.orange.manage.service.applicationService.HbCountryService;
import com.it7890.orange.manage.service.applicationService.TopicService;
import com.it7890.orange.manage.service.collectionService.ListManagerRuleService;
import com.it7890.orange.manage.service.contentService.LanguageService;
import com.it7890.orange.manage.service.contentService.PublicationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/listrule")
public class ListManagerRuleController {
    private static final Logger logger = LogManager.getLogger(Application.class);
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

    //列表规则展示
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String listTodo(ModelMap model) throws AVException {
        List<ConGrabLRule> rules = this.iConGrabRuleService.getAll();
        List<HbTopics> topics = this.topicService.getAll();
        List<ConPublication> publication = this.publicationService.getAll();
        List<ConChannel> conChannels = this.conChannelService.getAll();
        model.addAttribute("rules", rules);
        model.addAttribute("topics", topics);
        model.addAttribute("publication", publication);
        model.addAttribute("conChannels", conChannels);
//        model.addAttribute("aa", "bb");
//        System.out.println("eeeeeeeeee"+topics.get(1).getName());
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
        model.addAttribute("item", bean);
        return "views/listrule/details";
    }


    //增加或者修改的ti提交   String conconstant,
    @RequestMapping(value = "/saveorupdate", method = RequestMethod.POST)
    public String SaveOrUpdate(HttpServletRequest request, HttpServletResponse response, @ModelAttribute(value = "bean") ConGrabLRule bean, Model model) {
        List<ConGrabLRule> rules = this.iConGrabRuleService.getAll();
        List<HbTopics> topics = this.topicService.getAll();
        List<ConPublication> publications = this.publicationService.getAll();
        List<HbCountrys> hbCountrys = this.hbCountryService.getAll();
        List<HbLanguage> languages = this.languageService.getAll();
        List<ConChannel> conChannels = this.conChannelService.getAll();
        model.addAttribute("rules", rules);
        model.addAttribute("topics", topics);
        model.addAttribute("publications", publications);
        model.addAttribute("hbCountrys", hbCountrys);
        model.addAttribute("languages", languages);
        model.addAttribute("conChannels", conChannels);
        ConGrabLRule tem = null;
        if (bean.getObjectId() == null && "".equals(bean.getObjectId())) {
            String objectId = this.iConGrabRuleService.insert(bean);
            if (objectId == null && "".equals(objectId)) {
                request.getSession().setAttribute("message", "添加失败");
            } else {
                request.getSession().setAttribute("message", "添加成功");
            }
        } else {
            tem = this.iConGrabRuleService.getLRuleById(bean.getObjectId());
            tem.setId(bean.getId());
            tem.setChannelid(bean.getChannelid());//
            tem.setCode(bean.getCode());//
            tem.setCsspath(bean.getCsspath());//
            tem.setLangid(bean.getLangid());//
            tem.setNodeid(bean.getNodeid());//
            tem.setPid(bean.getPid());//
            tem.setRulename(bean.getRulename());//
            tem.setStatus(bean.getStatus());//
            tem.setUrl(bean.getUrl());
            tem.setTopic(bean.getTopic());//
            tem.setGrabtime(bean.getGrabtime());//
            tem.setConstant(bean.getConstant());//
            tem.setFindpre(bean.getFindpre());
            tem.setListstatus(bean.getListstatus());
            tem.setConstant(bean.getConstant());
            this.iConGrabRuleService.update(tem);
            request.getSession().setAttribute("message", "更新成功");
        }
//        return String.format("redirect:/message");
        return String.format("redirect:/listrule/list");
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(HttpServletRequest request, Model model, String objectId) {
        this.iConGrabRuleService.deleteRuleByObjectId(objectId);
//        request.getSession().setAttribute("message", "删除成功");
//        request.getSession().setAttribute("url", "/listrule/list");
//        return "views/message";
//        return "listrule/list";
        return String.format("redirect:/listrule/list");
    }
}