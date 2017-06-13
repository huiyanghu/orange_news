package com.it7890.orange.manage.service.impl;

import com.avos.avoscloud.AVObject;
import com.it7890.orange.manage.dao.HbTopicsDao;
import com.it7890.orange.manage.model.HbTopics;
import com.it7890.orange.manage.service.HbTopicsService;
import com.it7890.orange.manage.vo.AppTopicsDTO;
import com.it7890.orange.manage.vo.HbTopicsDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gg
 * @create 2017/6/13
 **/
@Component
public class HbTopicsServiceImpl implements HbTopicsService {

    @Resource
    HbTopicsDao hbTopicsDao;
    @Override
    public List<HbTopicsDTO> getDtoList() {
        List<AVObject> ls = hbTopicsDao.getList();
        return buildDto(ls);
    }

    public List<HbTopicsDTO> buildDto(List<AVObject> ls){
        List<HbTopicsDTO> dtols = null;
        if (ls!=null){
            dtols = new ArrayList<>();
            for (AVObject avo : ls){
                HbTopicsDTO dto = HbTopicsDTO.avo2dto(avo);
                dtols.add(dto);
            }
        }
        return dtols;
    }

}
