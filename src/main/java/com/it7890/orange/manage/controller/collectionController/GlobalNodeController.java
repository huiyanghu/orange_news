package com.it7890.orange.manage.controller.collectionController;

import com.it7890.orange.manage.service.collectionService.GlobalNodeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/5/19.
 */
@Controller
@RequestMapping("/globalnode")
public class GlobalNodeController {
    @Resource
    private GlobalNodeService nodeService;
}
