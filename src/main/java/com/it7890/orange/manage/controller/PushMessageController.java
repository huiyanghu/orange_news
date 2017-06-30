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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping(path="/pushArticle", method={RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> pushArticle(String articleId) throws AVException {
        int isSuccess = 1;
        String msg = "推送成功";
        if (StringUtil.isNotEmpty(articleId)) {
            ConArticle articleInfo = conArticleService.getById(articleId);
            if (null != articleInfo) {
                Map<String, Object> dataMap = buildPushData(articleInfo);

                AVPush push = new AVPush();
                push.setData(dataMap);
                push.sendInBackground(new SendCallback() {
                    @Override
                    public void done(AVException e) {
                        if (e == null) {
                            // 更新推送次数
                            articleInfo.increment("pushnum");
                            try {
                                conArticleService.updateArticleInfo(articleInfo);
                            } catch (AVException e1) {
                                e1.printStackTrace();
                                logger.info("update push article num fail, cause: {}", e1.getMessage());
                            }
                        } else {
                            e.printStackTrace();
                            logger.info("push article fail, cause: {}", e.getMessage());
                        }
                    }
                });
            } else {
                isSuccess = 0;
                msg = "未找到相应文章";
            }
        } else {
            isSuccess = 0;
            msg = "参数错误";
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("isSuccess", isSuccess);
        resultMap.put("msg", msg);
        return resultMap;
    }

    private Map<String, Object> buildPushData(ConArticle articleInfo) {
        Map<String, Object> articleMap = null;
        if (null != articleInfo) {
            articleMap = new HashMap<>();
            articleMap.put("alert", articleInfo.getAbstracts());
            articleMap.put("articleId", articleInfo.getObjectId());
            articleMap.put("title", articleInfo.getTitle());
            articleMap.put("abstracts", articleInfo.getAbstracts());
            articleMap.put("topicId", null != articleInfo.getAVObject("topicObj") ? articleInfo.getAVObject("topicObj").getObjectId() : "");
            articleMap.put("countryCode", StringUtil.isNotEmpty(articleInfo.getString("countrycode")) ? articleInfo.getString("countrycode") : "");
            articleMap.put("sourceUrl", StringUtil.isNotEmpty(articleInfo.getString("sourceurl")) ? articleInfo.getString("sourceurl") : "");
        }

        return articleMap;
    }
}
