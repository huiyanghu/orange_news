package com.it7890.orange.manage.service.collectionService.collectionServiceImpl;


import com.it7890.orange.manage.dao.ListManagerRuleDao;
import com.it7890.orange.manage.model.ConGrabLRule;
import com.it7890.orange.manage.service.collectionService.ListManagerRuleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ListManagerRuleServiceImpl implements ListManagerRuleService {

    @Resource
    ListManagerRuleDao listRuledao;

    @Override
    public List<ConGrabLRule> getAll() {
        return listRuledao.getAll();
    }

    @Override
    public ConGrabLRule getLRuleById(String objectId) {
        return this.listRuledao.getLRuleById(objectId);
    }

    @Override
    public String insert(ConGrabLRule bean) {
        return this.listRuledao.insert(bean);
    }

    @Override
    public void update(ConGrabLRule bean) {
        this.listRuledao.update(bean);
    }

    @Override
    public void deleteRuleByObjectId(String objectId) {
        this.listRuledao.deleteRuleByObjectId(objectId);
    }
}





















