package com.it7890.orange.manage.service.articalService;

import com.it7890.orange.manage.model.ConPublication;

import java.util.List;
import java.util.Map;


/**
 * @Description:
 * @date 2015年11月13日 下午12:13:37
 */
public interface IConPublicationService {

    List<ConPublication> getAllConpublication();

    int insertConPublication(ConPublication conpublication);

    int updateConPublication(ConPublication conpublication);

    int deleteConPublication(int id);

    ConPublication getConPublicationById(int id);

//	List<ConPublication> getPublicationByPage(ConPublication publication, PageBounds pagebounds);

    int getcountBycountryid(int countryid);

    List<ConPublication> getAllSelfConpublication();

    List<ConPublication> getAllES();


}
