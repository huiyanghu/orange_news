package com.it7890.orange.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/13.
 */
@Controller
public class LoginController {
    @RequestMapping(path = "/toLogin")
    public String toLogin(Map map, HttpSession session) {
        return "login";
    }

    @RequestMapping(path = "/")
    public String toIndex(Map map, HttpSession session) {
        return "index";
    }


    @RequestMapping(path = "/toDefault")
    public String toDefault() {
        return "default";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String userName, String password, HttpSession session, RedirectAttributes attributes) {
        if ("admin".equals(userName) && "123456".equals(password)) {
            session.setAttribute("loginUser", "success");
            return "redirect:/";
        }
        attributes.addFlashAttribute("msg", "用户名或密码错误,请重新登录!");
        return "redirect:/toLogin";
    }

    @RequestMapping(path = "/logOut")
    public String logOut(Map map, HttpSession session) {
        session.removeAttribute("loginUser");
        return "redirect:/toLogin";
    }
}
