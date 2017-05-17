package com.it7890.orange.manage.service.collectionService;

import com.it7890.orange.manage.model.GlobalRule;

import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */
public interface RuleManagerService {

    public List<GlobalRule> getAll();

    public GlobalRule getById(String objectId);

    public String insert(GlobalRule bean);

    public String update(GlobalRule bean);

    public void deleteRuleByObjectId(String id);

}
