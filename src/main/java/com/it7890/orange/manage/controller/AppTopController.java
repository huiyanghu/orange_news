package com.it7890.orange.manage.controller;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.po.AppTopQuery;
import com.it7890.orange.manage.service.AppTopService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/26.
 */
@Controller
@RequestMapping("/appTop")
public class AppTopController {
    private static final Logger logger = LogManager.getLogger(AppTopController.class);

    @Autowired
    private AppTopService appTopService;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String getAll(Model model,@ModelAttribute AppTopQuery appTopQuery, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) throws AVException {



        List<Map> appTopList=appTopService.getAll(appTopQuery,page);
        model.addAttribute("appTopList",appTopList);




        return "views/appTop/list";
    }

}
