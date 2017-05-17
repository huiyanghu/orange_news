package com.it7890.orange.manage.service.applicationService.applicationServiceImpl;

import com.it7890.orange.manage.dao.HbCountryDao;
import com.it7890.orange.manage.model.HbCountrys;
import com.it7890.orange.manage.service.applicationService.HbCountryService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */
@Component
public class HbCountryServiceImpl implements HbCountryService {

    @Resource
    HbCountryDao hbCountryDao;

    @Override
    public List<HbCountrys> getAll() {
        return hbCountryDao.getAll();
    }
}
