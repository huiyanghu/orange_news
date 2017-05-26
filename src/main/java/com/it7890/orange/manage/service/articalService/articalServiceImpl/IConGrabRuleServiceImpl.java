package com.it7890.orange.manage.service.articalService.articalServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.model.ConArticle;
import com.it7890.orange.manage.model.ConChannel;
import com.it7890.orange.manage.model.ConGrabCRule;
import com.it7890.orange.manage.model.ConGrabLRule;
import com.it7890.orange.manage.service.articalService.IConGrabRuleService;
import com.it7890.orange.manage.utils.PageUtil;
import org.springframework.stereotype.Service;


@Service
public class IConGrabRuleServiceImpl implements IConGrabRuleService {

    @Override
    public int insert(ConGrabLRule bean) {
        return 0;
    }

    @Override
    public int update(ConGrabLRule bean) {
        return 0;
    }

    @Override
    public List<ConGrabLRule> getAll() {
        return null;
    }

    @Override
    public ConGrabLRule getById(Integer id) {
        return null;
    }

    @Override
    public List<ConGrabLRule> getAllByNodeid(int nodeid) {
        return null;
    }

    @Override
    public int countPage(ConGrabLRule bean) {
        return 0;
    }

    @Override
    public List<ConGrabLRule> LikeSearch(String search) {
        return null;
    }

    @Override
    public List<ConGrabLRule> getAllByCondition(int channelid, int nodeid, int publication, int topicid) {
        return null;
    }

    @Override
    public List getAllNodes() {
        return null;
    }

    @Override
    public List<ConChannel> getChannellist() {
        List<ConChannel> list = new ArrayList<ConChannel>();
        AVQuery<ConChannel> avQuery = new AVQuery<>("con_channel");
        try {
            list = avQuery.find();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List getPublications() {
        return null;
    }

    @Override
    public ConGrabCRule getContentById(Integer id) {
        return null;
    }

    @Override
    public List<ConGrabCRule> getAllContent() {
        return null;
    }

    @Override
    public int insertConRule(ConGrabCRule bean) {
        return 0;
    }

    @Override
    public int updateConRule(ConGrabCRule bean) {
        return 0;
    }

    @Override
    public int countConPage(ConGrabCRule bean) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public List<ConGrabCRule> LikeConSearch(String search) {
        return null;
    }

    @Override
    public List<ConGrabCRule> getAllConByNodeid(int nodeid) {
        return null;
    }

    @Override
    public List<ConGrabCRule> getAllConByLid(int lid) {
        return null;
    }

    @Override
    public List<ConGrabCRule> getAllPrepareCon(int constatus) {
        return null;
    }

    @Override
    public List<ConArticle> getAllEsArticleByChannelid(int channelid, PageUtil pageUtil) {
        return null;
    }

    @Override
    public long conutArticle(int channelid) {
        return 0;
    }

    @Override
    public long updateConArticleES(ConArticle conarticle) {
        return 0;
    }

    @Override
    public ConArticle getConArticleByIdES(int id) {
        return null;
    }

    @Override
    public List<Map<String, Object>> getTopicListByCountry(String code) {
        return null;
    }
}





















