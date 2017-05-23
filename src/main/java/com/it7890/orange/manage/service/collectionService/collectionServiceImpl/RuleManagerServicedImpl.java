package com.it7890.orange.manage.service.collectionService.collectionServiceImpl;

import com.it7890.orange.manage.dao.RuleManagerDao;
import com.it7890.orange.manage.model.GlobalRule;
import com.it7890.orange.manage.service.collectionService.RuleManagerService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */
@Component
public class RuleManagerServicedImpl implements RuleManagerService {
    @Resource
    RuleManagerDao ruleManagerDao;

    @Override
    public List<GlobalRule> getAll() {
        return ruleManagerDao.getAll();
    }

    @Override
    public GlobalRule getById(String objectId) {
        return ruleManagerDao.getById(objectId);
    }

    @Override
    public String insert(GlobalRule bean) {
        return ruleManagerDao.insert(bean);
    }

    @Override
    public String update(GlobalRule bean) {
        return ruleManagerDao.update(bean);
    }

    @Override
    public void deleteRuleByObjectId(String id) {
        ruleManagerDao.deleteRuleByObjectId(id);
    }

    @Override
    public List<GlobalRule> getByRuleNameAndPid(GlobalRule bean) {
        return ruleManagerDao.getByRuleNameAndPid(bean);
    }
}
