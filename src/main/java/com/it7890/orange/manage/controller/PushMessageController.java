package com.it7890.orange.manage.controller;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVPush;
import com.avos.avoscloud.SendCallback;
import com.it7890.orange.manage.model.ConArticle;
import com.it7890.orange.manage.service.ConArticleService;
import com.it7890.orange.manage.utils.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wyq on 2017/6/6.
 */
@RestController
@RequestMapping("/pushMessage")
public class PushMessageController {
    private static final Logger logger = LogManager.getLogger(PushMessageController.class);
    @Autowired
    private ConArticleService conArticleService;

    @RequestMapping(path = "/push", method = RequestMethod.GET)
    public void pushArticle(@RequestParam(value="articleId", defaultValue="") String articleId) throws AVException {
        if (StringUtil.isNotEmpty(articleId)) {
            ConArticle articleInfo = conArticleService.getById(articleId);
            if (null != articleInfo) {
                AVPush push = new AVPush();
                push.setPushToIOS(true);
                push.setPushToAndroid(true);
                Map<String, Object> articleMap = new HashMap<>();
                articleMap.put("articleId", articleInfo.getObjectId());
                articleMap.put("topicId", null != articleInfo.getAVObject("topicObj") ? articleInfo.getAVObject("topicObj").getObjectId() : "");
                articleMap.put("countryCode", StringUtil.isNotEmpty(articleInfo.getString("countrycode")) ? articleInfo.getString("countrycode") : "");
                articleMap.put("sourceUrl", StringUtil.isNotEmpty(articleInfo.getString("sourceurl")) ? articleInfo.getString("sourceurl") : "");

                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("alert", articleMap);

                push.setData(dataMap);

                push.sendInBackground(new SendCallback() {
                    @Override
                    public void done(AVException e) {

                        if (e == null) {
                            logger.info("ok");
                        } else {
                            e.printStackTrace();
                            logger.info("erro:{}", e.getMessage());
                        }
                    }
                });
            }
        }
    }
}
