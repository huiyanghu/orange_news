package com.it7890.orange.manage.controller.collectionController;

import com.it7890.orange.manage.model.ConGrabCRule;
import com.it7890.orange.manage.model.ConGrabLRule;
import com.it7890.orange.manage.model.GlobalNode;
import com.it7890.orange.manage.service.collectionService.ArticleManagerRuleService;
import com.it7890.orange.manage.service.collectionService.GlobalNodeService;
import com.it7890.orange.manage.service.collectionService.ListManagerRuleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */
@Controller
@RequestMapping("/conrule")
public class ArticleManagerRuleController {

    @Resource
    ArticleManagerRuleService articleManagerRuleService;

    @Resource
    ListManagerRuleService listManagerRuleService;

    @Resource
    private GlobalNodeService nodeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<ConGrabCRule> list = this.articleManagerRuleService.getAll();
        ConGrabCRule bean = new ConGrabCRule();
        bean.setStatus(-1);
        model.addAttribute("list", list);
        model.addAttribute("bean", bean);
        return "views/conrule/list";
    }

    //查询
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String getSelect(Model model,ConGrabCRule bean) {
        List<ConGrabCRule> list = this.articleManagerRuleService.getSelect(bean);
        model.addAttribute("list", list);
        model.addAttribute("bean", bean);
        return "views/conrule/list";
    }

    //toadd
    @RequestMapping(value = "/toadd", method = RequestMethod.GET)
    public String toAdd(String objectId, Model model, ConGrabCRule con) {
        List<ConGrabCRule> list = this.articleManagerRuleService.getAll();
        List<GlobalNode> nodeList = this.nodeService.getAll();
        model.addAttribute("nodeList", nodeList);
        ConGrabCRule bean = null;
        if (null == objectId || "".equals(objectId)) {
            bean = new ConGrabCRule();
        } else {
            bean = this.articleManagerRuleService.getContentById(con.getObjectId());
        }
        model.addAttribute("bean", bean);
        model.addAttribute("listlist", list);
        return "views/conrule/add";
    }

    @RequestMapping(value = "/saveorupdate", method = RequestMethod.POST)
    public String saveorupdate(HttpServletRequest request, ConGrabCRule bean, Model model) {
        if (bean.getObjectId() == null || "".equals(bean.getObjectId())) {
            String objectId = articleManagerRuleService.insertConRule(bean);
        } else {
            String objectId = articleManagerRuleService.updateConRule(bean);
        }
        return String.format("redirect:/conrule/list");
    }

//        ConGrabCRule tem = null;
//        if(bean1.getId()==null||bean1.getId()==0){
//            tem=bean1;
//            String  objectId = articleManagerRuleService.insertConRule(tem);
//            request.getSession().setAttribute("message", "添加成功");
//        }else{
//            tem = new ConGrabCRule();
//            tem.setId(bean1.getId());
//            tem.setAuthorcsspath(bean1.getAuthorcsspath());
//            tem.setConcsspath(bean1.getConcsspath().trim());
//            tem.setConcsspath1(bean1.getConcsspath1());
//            tem.setConcsspath2(bean1.getConcsspath2());
//            tem.setDescsspath(bean1.getDescsspath());
//            tem.setImgcsspath(bean1.getImgcsspath());
//            tem.setKeycsspath(bean1.getKeycsspath());
//            tem.setLid(bean1.getLid());
//            tem.setRulename(bean1.getRulename());
//            tem.setSoucsspath(bean1.getSoucsspath());
//            tem.setStatus(bean1.getStatus());
//            tem.setTesturl(bean1.getTesturl().trim());
//            tem.setTitlecsspath(bean1.getTitlecsspath());
//            tem.setNodeid(bean1.getNodeid());
//            tem.setReplacecsspath(bean1.getReplacecsspath());
//            tem.setReplacerule(bean1.getReplacerule());
//            tem.setTopic(bean1.getTopic());
//            tem.setVideocsspath(bean1.getVideocsspath());
//            tem.setNodeid(bean1.getNodeid());
//            String objectId = articleManagerRuleService.updateConRule(tem);
//            request.getSession().setAttribute("message", "更新成功");
//        }
//        model.addAttribute("bean1",bean1);
//        return String.format("redirect:/message");


    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String show(Model model, String objectId) {
        List<ConGrabLRule> findAllList = listManagerRuleService.getAll();
        ConGrabCRule item = articleManagerRuleService.getContentById(objectId);
        model.addAttribute("item1", item);
        model.addAttribute("listlist", findAllList);
        return "views/conrule/details";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(HttpServletRequest request, String objectId) {
        this.articleManagerRuleService.deleteRuleByObjectId(objectId);
        request.getSession().setAttribute("message", "删除成功");
//        return String.format("redirect:/message");
        return "redirect:/conrule/list";
    }


}
