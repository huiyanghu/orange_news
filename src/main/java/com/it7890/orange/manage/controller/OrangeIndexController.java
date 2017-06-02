package com.it7890.orange.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/6/2.
 */
@RequestMapping("/orangeIndex")
@Controller
public class OrangeIndexController {
    @RequestMapping(path = "/toDefault")
    public String toDefault(){
        return "default";
    }
}
