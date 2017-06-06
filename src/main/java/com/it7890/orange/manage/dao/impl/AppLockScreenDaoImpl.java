package com.it7890.orange.manage.dao.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.dao.AppLockScreenDao;
import com.it7890.orange.manage.model.AppLockScreen;
import com.it7890.orange.manage.po.AppLockScreenQuery;
import com.it7890.orange.manage.utils.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6.
 */
@Repository
public class AppLockScreenDaoImpl implements AppLockScreenDao {
    public String saveOrUpdate(AppLockScreen appLockScreen) throws AVException {
        appLockScreen.save();
        return appLockScreen.getObjectId();
    }

    public AppLockScreen get(String objectId) throws AVException {
        AVQuery<AppLockScreen> avQuery = new AVQuery<>("AppLockScreen");
        AppLockScreen appLockScreen = avQuery.get(objectId);
        return appLockScreen;
    }

    public List<AppLockScreen> get(AppLockScreenQuery appLockScreenQuery) throws AVException {
        AVQuery<AppLockScreen> query = new AVQuery<>("AppLockScreen");

        if (StringUtil.isNotEmpty(appLockScreenQuery.getObjectId())) {
            query.whereEqualTo("objectId", appLockScreenQuery.getObjectId());
        }
        if (StringUtil.isNotEmpty(appLockScreenQuery.getCountryObjectId())) {
            query.whereEqualTo("countryObj", AVObject.createWithoutData("hb_countrys",appLockScreenQuery.getCountryObjectId()));
        }
        List<AppLockScreen> appLockScreenList = query.find();

        return appLockScreenList;
    }
}
