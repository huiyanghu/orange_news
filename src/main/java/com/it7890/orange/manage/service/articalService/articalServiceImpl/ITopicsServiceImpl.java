package com.it7890.orange.manage.service.articalService.articalServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.model.AppTopics;
import com.it7890.orange.manage.model.ConArticle;
import com.it7890.orange.manage.model.HbTopics;
import com.it7890.orange.manage.service.articalService.ITopicsService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;


/**
 * @author zhoujie@7890it.com
 * @ClassName: IHbTopicsServiceImpl
 * @Description:
 * @date 2015年10月15日 下午5:52:00
 */
@Service
public class ITopicsServiceImpl implements ITopicsService {


    @Override
    public List<HbTopics> getAllHbTopics() {
        List<HbTopics> list = new ArrayList<HbTopics>();
     /*   AVCloudQueryResult result;
        String cql = "select * from AppTopics";
        int count = 0;
        try {
            result = AVQuery.doCloudQuery(cql, HbTopics.class);
            list = (List<HbTopics>) result.getResults();
        } catch (Exception e) {
       }
*/
        AVQuery<HbTopics> query = AVObject.getQuery(HbTopics.class);
        try {
            list = query.find();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<AppTopics> getAppTopicsById(int countryid) {
        return null;
    }

    @Override
    public HbTopics getAppTopicsByid(int tid) {
        return null;
    }

    @Override
    public int insertHbTopics(HbTopics topics) {
        return 0;
    }

    @Override
    public int updateHbTopics(HbTopics topics) {
        return 0;
    }

    @Override
    public int delete(int tid) {
        return 0;
    }

    @Override
    public int deleteAppTopics(int topicid) {
        return 0;
    }

    @Override
    public int updateAppTopics(AppTopics apptopics) {
        return 0;
    }

    @Override
    public int updateCountryTopics(int topicid, List<AppTopics> delapptics, List<AppTopics> addapptics, List<AppTopics> updateapptopics) {
        return 0;
    }

    @Override
    public HbTopics getHbTopicsBytid(int i) {
        return null;
    }

    @Override
    public int insert(AppTopics apptopics) {
        return 0;
    }

    @Override
    public int updateApptopicsBytidAdnCountryid(AppTopics apptopics) {
        return 0;
    }

    @Override
    public List<HbTopics> getAllHbTopicsBytopicType(int topictype) {
        return null;
    }
}
