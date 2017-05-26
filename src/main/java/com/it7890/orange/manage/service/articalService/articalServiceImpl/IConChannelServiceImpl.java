package com.it7890.orange.manage.service.articalService.articalServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.model.ConArticle;
import com.it7890.orange.manage.model.ConChannel;
import com.it7890.orange.manage.model.HbTopics;
import com.it7890.orange.manage.service.articalService.IConChannelService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;


/**
 * @Description:
 * @date 2015年11月13日 下午1:45:31
 */
@Service
public class IConChannelServiceImpl implements IConChannelService {

    @Override
    public List<ConChannel> getAllConChannel() {
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
    public int insertConChannel(ConChannel conchannel) {
        return 0;
    }

    @Override
    public int updateConChannel(ConChannel conchannel) {
        return 0;
    }

    @Override
    public int deleteConChannel(int id) {
        return 0;
    }

    @Override
    public ConChannel getConChannelById(int id) {
        return null;
    }

    @Override
    public List<ConChannel> getAllConChannelByStatus() {
        List<ConChannel> list = new ArrayList<ConChannel>();
        AVCloudQueryResult result;
        String cql = "select * from con_channel where status !=1 and status !=-1";
        int count = 0;
        try {
            result = AVQuery.doCloudQuery(cql, ConChannel.class);
            list = (List<ConChannel>) result.getResults();
        } catch (Exception e) {
        }

        return list;
    }
}
