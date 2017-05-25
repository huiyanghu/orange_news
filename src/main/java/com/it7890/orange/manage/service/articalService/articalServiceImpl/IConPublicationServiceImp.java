package com.it7890.orange.manage.service.articalService.articalServiceImpl;

import java.util.*;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.model.ConPublication;
import com.it7890.orange.manage.service.articalService.IConPublicationService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @date 2015年11月13日 下午12:14:01
 */
@Service
public class IConPublicationServiceImp implements IConPublicationService {
    @Override
    public List<ConPublication> getAllConpublication() {
        List<ConPublication> list = new ArrayList<ConPublication>();
        AVQuery<ConPublication> query = AVObject.getQuery(ConPublication.class);
        try {
            list = query.find();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int insertConPublication(ConPublication conpublication) {
        return 0;
    }

    @Override
    public int updateConPublication(ConPublication conpublication) {
        return 0;
    }

    @Override
    public int deleteConPublication(int id) {
        return 0;
    }

    @Override
    public ConPublication getConPublicationById(int id) {
        return null;
    }

    @Override
    public int getcountBycountryid(int countryid) {
        return 0;
    }

    @Override
    public List<ConPublication> getAllSelfConpublication() {
        return null;
    }

    @Override
    public List<ConPublication> getAllES() {
        return null;
    }
}
