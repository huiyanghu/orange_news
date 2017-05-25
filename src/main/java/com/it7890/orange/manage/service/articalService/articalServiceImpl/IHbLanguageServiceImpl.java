package com.it7890.orange.manage.service.articalService.articalServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.model.HbLanguage;
import com.it7890.orange.manage.model.HbTopics;
import com.it7890.orange.manage.model.SysUser;
import com.it7890.orange.manage.service.articalService.IHbLanguageService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;


/**
 * @Description:语言管理service层实现类
 * @date 2015年11月13日 上午10:58:45
 */
@Service
public class IHbLanguageServiceImpl implements IHbLanguageService {
    @Override
    public List<HbLanguage> getAllHbLanguage() {

        List<HbLanguage> list = new ArrayList<HbLanguage>();
        AVQuery<HbLanguage> query = AVObject.getQuery(HbLanguage.class);
        try {
            list = query.find();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int insertHbLanguage(HbLanguage hblanguage) {
        return 0;
    }

    @Override
    public int updateHblanguage(HbLanguage hblanguage) {
        return 0;
    }

    @Override
    public int deleteHblanguage(int id) {
        return 0;
    }

    @Override
    public HbLanguage getHbLanguageById(int id) {
        return null;
    }

    @Override
    public List<HbLanguage> getAllHbLanguageOrderByHbcode() {


        List<HbLanguage> list = new ArrayList<HbLanguage>();
        AVCloudQueryResult result;
        String cql = "select * from hb_languages order by hbcode";
        int count = 0;
        try {
            result = AVQuery.doCloudQuery(cql, HbLanguage.class);
            list = (List<HbLanguage>) result.getResults();
        } catch (Exception e) {
        }
        return list;

    }

}
