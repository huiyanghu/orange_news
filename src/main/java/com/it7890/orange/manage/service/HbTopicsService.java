package com.it7890.orange.manage.service;

import com.avos.avoscloud.AVException;
import com.it7890.orange.manage.vo.AppTopicsDTO;
import com.it7890.orange.manage.vo.HbTopicsDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */
public interface HbTopicsService {

    public List<HbTopicsDTO> getDtoList();
    public HbTopicsDTO getById(String hid);
}
