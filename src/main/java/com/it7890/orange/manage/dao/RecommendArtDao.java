package com.it7890.orange.manage.dao;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;

import java.text.ParseException;
import java.util.List;

/**
 * Created by wyq on 2017/6/6.
 */
public interface RecommendArtDao {
    public List<AVObject> getList(int pushNum,String countryCode,String startDate,String endDate,int page) throws AVException, ParseException;
    public int getCount();
}
