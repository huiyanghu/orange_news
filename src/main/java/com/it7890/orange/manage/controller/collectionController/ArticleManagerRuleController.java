package com.it7890.orange.manage.controller.collectionController;

import com.it7890.orange.manage.model.ConGrabCRule;
import com.it7890.orange.manage.model.ConGrabLRule;
import com.it7890.orange.manage.service.collectionService.ArticleManagerRuleService;
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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listTodo(Model model) {
        List<ConGrabCRule> list = this.articleManagerRuleService.getAll();
        model.addAttribute("list", list);
        return "views/conrule/list";
    }

    //toadd
    @RequestMapping(value = "/toadd", method = RequestMethod.GET)
    public String toAdd(String objectId, Model model,ConGrabCRule con){
        List<ConGrabCRule> list = this.articleManagerRuleService.getAll();
        ConGrabCRule bean = null;
        if (null == objectId || "".equals(objectId)) {
            bean=new ConGrabCRule();
        } else {
            bean = this.articleManagerRuleService.getContentById(con.getObjectId());
        }
        model.addAttribute("bean1",bean);
        model.addAttribute("listlist",list);
        return "views/conrule/add";
    }

    @RequestMapping(value = "/details",method = RequestMethod.GET)
    public String show(Model model,String objectId){
        List<ConGrabLRule> findAllList = listManagerRuleService.getAll();
        ConGrabCRule item = articleManagerRuleService.getContentById(objectId);
        model.addAttribute("item1",item);
        model.addAttribute("listlist",findAllList);
        return "views/conrule/details";
    }


    @RequestMapping(value = "/saveorupdate", method = RequestMethod.POST)
    public String saveorupdate(HttpServletRequest request, ConGrabCRule bean1, Integer id, Model model){
        ConGrabCRule tem = null;
        if(bean1.getId()==null||bean1.getId()==0){
            tem=bean1;
            String  objectId = articleManagerRuleService.insertConRule(tem);
            request.getSession().setAttribute("message", "添加成功");
        }else{
            tem = new ConGrabCRule();
            tem.setId(bean1.getId());
            tem.setAuthorcsspath(bean1.getAuthorcsspath());
            tem.setConcsspath(bean1.getConcsspath().trim());
            tem.setConcsspath1(bean1.getConcsspath1());
            tem.setConcsspath2(bean1.getConcsspath2());
            tem.setDescsspath(bean1.getDescsspath());
            tem.setImgcsspath(bean1.getImgcsspath());
            tem.setKeycsspath(bean1.getKeycsspath());
            tem.setLid(bean1.getLid());
            tem.setRulename(bean1.getRulename());
            tem.setSoucsspath(bean1.getSoucsspath());
            tem.setStatus(bean1.getStatus());
            tem.setTesturl(bean1.getTesturl().trim());
            tem.setTitlecsspath(bean1.getTitlecsspath());
            tem.setNodeid(bean1.getNodeid());
            tem.setReplacecsspath(bean1.getReplacecsspath());
            tem.setReplacerule(bean1.getReplacerule());
            tem.setTopic(bean1.getTopic());
            tem.setVideocsspath(bean1.getVideocsspath());
            tem.setNodeid(bean1.getNodeid());
            String objectId = articleManagerRuleService.updateConRule(tem);
            request.getSession().setAttribute("message", "更新成功");
        }
        model.addAttribute("bean1",bean1);
        return String.format("redirect:/message");
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(HttpServletRequest request, String objectId) {
        this.articleManagerRuleService.deleteRuleByObjectId(objectId);
        request.getSession().setAttribute("message", "删除成功");
//        return String.format("redirect:/message");
        return "redirect:/conrule/list";
    }

}
