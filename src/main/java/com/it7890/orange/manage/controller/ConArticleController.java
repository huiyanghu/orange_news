package com.it7890.orange.manage.controller;

import com.it7890.orange.manage.service.ConArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/5/31.
 */
@Controller
@RequestMapping("/conArticle")
public class ConArticleController {
    @Autowired
    private ConArticleService conArticleService;
    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteConArticle(String objectId) throws Exception {
        conArticleService.delete(objectId);
        System.out.println("ConArticleController----delete");

        return "redirect:/appTop/list";
    }
}
