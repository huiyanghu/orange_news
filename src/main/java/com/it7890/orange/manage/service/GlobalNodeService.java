package com.it7890.orange.manage.service;

import com.it7890.orange.manage.model.GlobalNode;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */
public interface GlobalNodeService {
    public List<GlobalNode> getAll();
    public List<Map> getGlobalNodeList();
}
