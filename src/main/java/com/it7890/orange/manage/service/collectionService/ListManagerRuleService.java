package com.it7890.orange.manage.service.collectionService;

import com.it7890.orange.manage.model.ConGrabLRule;

import java.util.List;

public interface ListManagerRuleService {

    List<ConGrabLRule> getAll();

    List<ConGrabLRule> getSelect(ConGrabLRule bean);

    ConGrabLRule getLRuleById(String objectId);

    String insert(ConGrabLRule bean);

    void update(ConGrabLRule bean);

    void deleteRuleByObjectId(String objectId);
}

















