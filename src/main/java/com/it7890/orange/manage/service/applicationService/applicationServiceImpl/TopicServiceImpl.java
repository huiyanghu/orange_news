package com.it7890.orange.manage.service.applicationService.applicationServiceImpl;

import com.it7890.orange.manage.dao.TopicDao;
import com.it7890.orange.manage.model.HbTopics;
import com.it7890.orange.manage.service.applicationService.TopicService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
@Component
public class TopicServiceImpl implements TopicService {

    @Resource TopicDao topicDao;
    public List<HbTopics> getAll(){
        return this.topicDao.getAll();
    }

}
