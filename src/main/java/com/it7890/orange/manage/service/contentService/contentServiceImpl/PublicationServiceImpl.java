package com.it7890.orange.manage.service.contentService.contentServiceImpl;

import com.it7890.orange.manage.dao.PublicationDao;
import com.it7890.orange.manage.model.ConPublication;
import com.it7890.orange.manage.service.contentService.PublicationService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
@Component
public class PublicationServiceImpl implements PublicationService {
    @Resource
    PublicationDao publicationDao;

    @Override
    public List<ConPublication> getAll() {
        return  this.publicationDao.getAll();
    }
}
