package com.it7890.orange.manage.service;

import com.avos.avoscloud.AVException;
import java.text.ParseException;
import java.util.Map;

/**
 * Created by wyq on 2017/6/6.
 */
public interface RecommendArtService {
    public Map getList(int pushNum, String countryCode, String startDate, String endDate, int page) throws AVException, ParseException;
}
