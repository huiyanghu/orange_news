package com.it7890.orange.manage.service.articalService;

import com.it7890.orange.manage.model.ConChannel;

import java.util.List;


/**
 * @Description: 
 * @date 2015年11月13日 下午1:44:52
 */
public interface IConChannelService {

	List<ConChannel> getAllConChannel();
	
	int insertConChannel(ConChannel conchannel);
	
	int updateConChannel(ConChannel conchannel);
	
	int deleteConChannel(int id);
	
	ConChannel getConChannelById(int id);
	
	List<ConChannel> getAllConChannelByStatus();
}
