package com.it7890.orange.manage.service.collectionService;

import com.it7890.orange.manage.model.ConGrabCRule;

import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */
public interface ArticleManagerRuleService {

    public List<ConGrabCRule> getAll();

    public List<ConGrabCRule> getSelect(ConGrabCRule bean);

    List<ConGrabCRule> getAllConByLid(Integer id);

    public ConGrabCRule getContentById(String id);

    public String insertConRule(ConGrabCRule tem);

    public String updateConRule(ConGrabCRule tem);

    public void deleteRuleByObjectId(String id);
}
