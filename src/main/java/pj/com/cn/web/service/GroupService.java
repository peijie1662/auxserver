package pj.com.cn.web.service;

import pj.com.cn.web.model.RequestResult;

public interface GroupService {
	
	RequestResult groupInfo();
	
	RequestResult groupMember();
	
	RequestResult groupMacInfo();
}
