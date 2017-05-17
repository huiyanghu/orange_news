package com.it7890.orange.manage.demo.todo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class IndexController {

  @GetMapping("/")
  public ModelAndView view() {
    return new ModelAndView("index", "time", new Date());
  }

//    @GetMapping("/")
//    public String view(Model model) {
//        model.addAttribute("aaa","bbb");
//        return "index";
//    }



}
