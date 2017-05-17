package com.it7890.orange.manage.controller.contentController;

import com.it7890.orange.manage.service.contentService.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/5/12.
 */
@Controller
@RequestMapping("/language")
public class LanguageController {

    @Resource
    LanguageService languageService;



}
