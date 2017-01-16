package pj.com.cn.web.service;

import pj.com.cn.web.model.RequestResult;

public interface LoginService {
	
	RequestResult loginByUserId(String userId,String password);
	
	RequestResult loginByWorkId(String workId,String password);

}
