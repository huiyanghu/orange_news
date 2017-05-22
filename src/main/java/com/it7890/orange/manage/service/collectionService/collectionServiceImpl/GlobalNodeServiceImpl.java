package com.it7890.orange.manage.service.collectionService.collectionServiceImpl;

import com.it7890.orange.manage.dao.GlobalNodeDao;
import com.it7890.orange.manage.model.GlobalNode;
import com.it7890.orange.manage.service.collectionService.GlobalNodeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */
@Component
public class GlobalNodeServiceImpl implements GlobalNodeService {
    @Resource
    private GlobalNodeDao nodeDao;

    @Override
    public List<GlobalNode> getAll() {
        return nodeDao.getAll();
    }
}
