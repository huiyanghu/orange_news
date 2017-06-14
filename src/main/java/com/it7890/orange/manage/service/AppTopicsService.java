package com.it7890.orange.manage.service;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.model.AppTopics;
import com.it7890.orange.manage.vo.AppTopicsDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */
public interface AppTopicsService {
    public List<Map> getAppTopicsList() throws AVException;

    public List<AppTopicsDTO> getDtoList(String cid,String hid);

    public int updateAppTopics(String countryId, List<AppTopicsDTO> delapptics,
                               List<AVObject> addapptics,List<AppTopicsDTO> updateapptopics);
}
