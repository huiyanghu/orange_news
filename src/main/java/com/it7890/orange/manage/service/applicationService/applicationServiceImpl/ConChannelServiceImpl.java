package com.it7890.orange.manage.service.applicationService.applicationServiceImpl;

import com.it7890.orange.manage.dao.ConChannelDao;
import com.it7890.orange.manage.model.ConChannel;
import com.it7890.orange.manage.service.applicationService.ConChannelService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */
@Component
public class ConChannelServiceImpl implements ConChannelService {
    @Resource
    ConChannelDao conChannelDao;

    @Override
    public List<ConChannel> getAll() {
        return this.conChannelDao.getAll();
    }
}
