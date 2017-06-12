package com.it7890.orange.manage.service;

import com.avos.avoscloud.AVException;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */
public interface PublicationService {
    public List<Map> getPublictionList() throws AVException;
}
