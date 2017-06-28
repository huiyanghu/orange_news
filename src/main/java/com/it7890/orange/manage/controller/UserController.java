package com.it7890.orange.manage.controller;

import com.avos.avoscloud.AVException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Astro on 17/6/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/toreset")
    public String toreset() throws AVException {
        return "modify-password";
    }
}
