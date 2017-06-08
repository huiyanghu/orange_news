package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
import com.it7890.orange.manage.service.impl.LanguageServiceImpl;
import com.it7890.orange.manage.vo.HbLanguageDTO;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gg
 * @create 2017/6/7
 **/
@Controller
@RequestMapping("/hb")
public class HbLanguageContrler {

    @Resource
    LanguageServiceImpl languageService;

    @RequestMapping("get")
    @ResponseBody
    public String getAll(){
        Map<String, Object> resultMap = new HashMap<>();
        List<HbLanguageDTO> ls =  languageService.getDTOList();
        System.out.println(ls.size());
        resultMap.put("res",ls);
        resultMap.put("code",1);
        System.out.println("::::::::>>>>>>>>>"+JSON.toJSONString(resultMap));
        return JSON.toJSONString(resultMap);
    }
}
