package com.it7890.orange.manage.service.articalService;

import com.it7890.orange.manage.model.HbLanguage;

import java.util.List;


/**
 * @Description:语言管理service层接口
 * @date 2015年11月13日 上午10:58:08
 */
public interface IHbLanguageService {
	
	/**
	 * 获取所有语言列表
	 * @return List 语言列表
	 */
    List<HbLanguage> getAllHbLanguage();
	
    /**
     * 添加语言信息
     * @param hblanguage 语言信息
     * @return int 条件个数
     */
	int insertHbLanguage(HbLanguage hblanguage);
	
	/**
	 * 更新语言信息
	 * @return int 更新条数
	 */
	int updateHblanguage(HbLanguage hblanguage);
	
	/**
	 * 根据ID删除语言信心
	 * @param id 语言ID
	 * @return int 删除条数
	 */
	int deleteHblanguage(int id);
	
	/**
	 * 根据ID获取语言信息
	 * @param id 语言ID
	 * @return hblanguage 语言信息
	 */
	HbLanguage getHbLanguageById(int id);
	
	/**
	 * 获取所有语言列表,并按hbcode排序
	 * @return list 语言列表
	 */
	List<HbLanguage> getAllHbLanguageOrderByHbcode();
}
