package com.it7890.orange.manage.controller.applicationController;

import com.it7890.orange.manage.service.applicationService.HbCountryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/5/12.
 */
@Controller
@RequestMapping("/hbCountry")
public class HbCountryController {
    @Resource
    HbCountryService hbCountryService;
}
