package com.it7890.orange.manage.service.collectionService.collectionServiceImpl;

import com.it7890.orange.manage.dao.ArticleManagerRuleDao;
import com.it7890.orange.manage.model.ConGrabCRule;
import com.it7890.orange.manage.service.collectionService.ArticleManagerRuleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */
@Component
public class ArticleManagerRuleServiceImpl implements ArticleManagerRuleService {

    @Resource
    ArticleManagerRuleDao articleManagerRuleDao;

    @Override
    public List<ConGrabCRule> getAll() {

        return this.articleManagerRuleDao.getAll();
    }

    @Override
    public ConGrabCRule getContentById(String id) {
        return this.articleManagerRuleDao.getContentById(id);
    }

    @Override
    public String insertConRule(ConGrabCRule tem) {
        return articleManagerRuleDao.insertConRule(tem);
    }

    @Override
    public String updateConRule(ConGrabCRule tem) {
        return articleManagerRuleDao.updateConRule(tem);
    }

    @Override
    public void deleteRuleByObjectId(String id) {
        articleManagerRuleDao.deleteRuleByObjectId(id);
    }

    @Override
    public List<ConGrabCRule> getSelect(ConGrabCRule bean) {
        return articleManagerRuleDao.getSelect(bean);
    }

    @Override
    public List<ConGrabCRule> getAllConByLid(Integer id) {
        return articleManagerRuleDao.getAllConByLid(id);
    }
}
