package com.it7890.orange.manage.controller.collectionController;

import com.it7890.orange.manage.model.ConPublication;
import com.it7890.orange.manage.model.GlobalNode;
import com.it7890.orange.manage.model.GlobalRule;
import com.it7890.orange.manage.service.collectionService.GlobalNodeService;
import com.it7890.orange.manage.service.collectionService.RuleManagerService;
import com.it7890.orange.manage.service.contentService.PublicationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@RequestMapping("/globalrule")
public class RuleManagerController {
    @Resource
    RuleManagerService ruleManagerService;

    @Resource
    private GlobalNodeService nodeService;

    @Resource
    PublicationService publicationService;

    private final static Logger logger = LogManager.getLogger(RuleManagerController.class);

    //列表显示
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<GlobalRule> list = ruleManagerService.getAll();
        List<GlobalNode> nodeList = this.nodeService.getAll();
        List<ConPublication> publication = this.publicationService.getAll();
        model.addAttribute("publication", publication);
        model.addAttribute("nodeList", nodeList);
        model.addAttribute("list", list);
        GlobalRule bean = new GlobalRule();
        bean.setPid(0);
        model.addAttribute("bean", new GlobalRule());
        return "views/globalrule/list";
    }
    //查询
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String getByRuleNameAndPid(Model model, GlobalRule bean) {
        List<GlobalRule> list = ruleManagerService.getByRuleNameAndPid(bean);
        List<GlobalNode> nodeList = this.nodeService.getAll();
        List<ConPublication> publication = this.publicationService.getAll();
        model.addAttribute("publication", publication);
        model.addAttribute("nodeList", nodeList);
        model.addAttribute("list", list);
        model.addAttribute("bean", bean);
        return "views/globalrule/list";
    }

    //到添加编辑页面
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addAdvertType(Model model, String objectId) {
        GlobalRule bean = null;
        if (null == objectId || "".equals(objectId)) {
            bean = new GlobalRule();
        } else {
            bean = ruleManagerService.getById(objectId);
        }
        List<GlobalNode> nodeList = this.nodeService.getAll();
        model.addAttribute("nodeList", nodeList);
        model.addAttribute("bean", bean);
        return "views/globalrule/add";
    }

    //添加或更新
    @RequestMapping(value = "/saveorupdate", method = RequestMethod.POST)
    public String saveorupdate(HttpServletRequest request, GlobalRule bean, Model model) {
        logger.info("saveOrUpdate:====================>>>");
        String result = "";
        if (bean.getObjectId()==null || "".equals(bean.getObjectId())) {
            result = ruleManagerService.insert(bean);
//            request.getSession().setAttribute("message", "添加成功");
        } else {
            GlobalRule tmp = ruleManagerService.getById(bean.getObjectId());
            tmp.setNodeid(bean.getNodeid());
            tmp.setPid(bean.getPid());
            tmp.setRulename(bean.getRulename());
            tmp.setConcsspath(bean.getConcsspath());
            tmp.setConcsspath1(bean.getConcsspath1());
            tmp.setConcsspath2(bean.getConcsspath2());
            tmp.setAuthorcsspath(bean.getAuthorcsspath());
            tmp.setCommentcssapth(bean.getCommentcssapth());
            tmp.setKeycsspath(bean.getKeycsspath());
            tmp.setRank(bean.getRank());
            tmp.setReplacerule(bean.getReplacerule());
            tmp.setTesturl(bean.getTesturl());
            tmp.setVideocsspath(bean.getVideocsspath());
            tmp.setReplacecsspath(bean.getReplacecsspath());
            result = ruleManagerService.update(tmp);
//            request.getSession().setAttribute("message", "更新成功");
        }
//        request.getSession().setAttribute("url", "@{/globalrule/list}");
        return "redirect:/globalrule/list";
    }

    //删除
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteAdvertType(HttpServletRequest request, Model model,String objectId){
//        GlobalRule bean=ruleManagerService.getById(id);
//        int result = 0;
//        request.getSession().setAttribute("message", "删除:"+(result>0?"成功":"失败"));
        ruleManagerService.deleteRuleByObjectId(objectId);
        request.getSession().setAttribute("url", "globalrule/list");
        return "redirect:/globalrule/list";
    }

}
