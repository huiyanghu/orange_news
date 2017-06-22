package com.it7890.orange.manage.controller;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVPush;
import com.avos.avoscloud.SendCallback;
import com.it7890.orange.manage.po.RecommendQuery;
import com.it7890.orange.manage.service.ConArticleService;
import com.it7890.orange.manage.service.HbCountryService;
import com.it7890.orange.manage.service.RecommendArtService;
import com.it7890.orange.manage.vo.ConArticleDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Map;

/**
 * Created by wyq on 2017/6/6.
 */
@RestController
@RequestMapping("/pushMessage")
public class PushMessageControler {
    private static final Logger logger = LogManager.getLogger(PushMessageControler.class);
    @Autowired
    private ConArticleService conArticleService;

    @RequestMapping(path = "/push", method = RequestMethod.GET)
    public void pushArticle(@RequestParam(value = "articleId", required = false, defaultValue = "") String articleId) throws AVException {
        AVPush push = new AVPush();
        JSONObject object = new JSONObject();
        ConArticleDTO art = conArticleService.getConarticleById(articleId);
        object.put("alert", "推送的消息");
        object.put("article","666666");
//        object.put("article",JSON.toJSONString(art));
//        object.put("alert",JSON.toJSONString(art));
//        object.put("title", art.getTitle());
//        object.put("abstracts",art.getAbstracts());
//        object.put("articleId",art.getArticleId());
        push.setData(object);
        push.sendInBackground(new SendCallback() {
            @Override
            public void done(AVException e) {

                if (e == null) {
                    logger.info("ok");
                } else {
                    logger.info("erro:{}",e.getMessage());
                    e.printStackTrace();
                    // something wrong.
                }
            }
        });
    }
}
