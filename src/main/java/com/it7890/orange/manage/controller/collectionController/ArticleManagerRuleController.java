package com.it7890.orange.manage.controller.collectionController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/5/15.
 */
@Controller
@RequestMapping("/conrule")
public class ArticleManagerRuleController {
/*

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

*/

}
