package com.it7890.orange.manage.service.impl;

import com.it7890.orange.manage.dao.GlobalNodeDao;
import com.it7890.orange.manage.model.GlobalNode;
import com.it7890.orange.manage.service.GlobalNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */
@Service
public class GlobalNodeServiceImpl implements GlobalNodeService {
    @Autowired
    GlobalNodeDao globalNodeDao;

    public List<GlobalNode> getAll() {
        return globalNodeDao.getAll();
    }

    public List<Map> getGlobalNodeList() {
        List<GlobalNode> globalNodeList = globalNodeDao.getAll();
        List<Map> list = new ArrayList<>();
        Map map;
        for (GlobalNode globalNode :globalNodeList) {
            map = new HashMap();
            map.put("objectId", globalNode.getObjectId());
            map.put("nodeName", globalNode.getNodename());
            map.put("nodeCode", globalNode.getNodecode());
            list.add(map);
        }
        return list;
    }
}
