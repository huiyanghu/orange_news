package com.it7890.orange.manage.service.articalService.articalServiceImpl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.it7890.orange.manage.model.HbCountrys;
import com.it7890.orange.manage.model.HbLanguage;
import com.it7890.orange.manage.service.articalService.IHbCountrysService;
import org.springframework.stereotype.Service;

/**
 * HbCountrys service层实现类
 *
 * @author lihaiguang
 */
@Service
public class IHbCountrysServiceImpl implements IHbCountrysService {
    @Override
    public List<HbCountrys> getHbCountrysAll() {
        List<HbCountrys> list = new ArrayList<HbCountrys>();
        AVQuery<HbCountrys> query = AVObject.getQuery(HbCountrys.class);
        try {
            list = query.find();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<HbCountrys> getHbCountrysAllOrderByCode() {
        return null;
    }
}
