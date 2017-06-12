package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.GlobalNodeDao;
import com.it7890.orange.manage.model.GlobalNode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */
@Component
public class GlobalNodeDaoImpl implements GlobalNodeDao {

    @Override
    public List<GlobalNode> getAll() {
        List<GlobalNode> list = new ArrayList<GlobalNode>();
        AVCloudQueryResult result;
        try {
            String cql = "select * from GlobalNode";
            result =  AVQuery.doCloudQuery(cql, GlobalNode.class);
            list = (List<GlobalNode>) result.getResults();
        } catch (Exception e) {
        }
        return   list;
    }


}
