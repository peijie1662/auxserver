package pj.com.cn.web.service;

import pj.com.cn.web.model.RequestResult;

public interface FlagService {
	
	RequestResult setAutoVoice(String workId,String flag);
	
	RequestResult setHeadVoice(String workId,String flag);
	
	RequestResult setTextVoice(String workId,String flag);

}
