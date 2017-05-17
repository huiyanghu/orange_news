package com.it7890.orange.manage.controller.applicationController;

import com.it7890.orange.manage.service.applicationService.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Resource TopicService topicService;


}