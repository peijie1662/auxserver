package pj.com.cn.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj.com.cn.web.dao.LoginDao;
import pj.com.cn.web.model.RequestResult;
import pj.com.cn.web.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public RequestResult loginByUserId(String userId, String password) {
		RequestResult result = new RequestResult();
		List<Map<String,Object>> users = loginDao.loginByUserId(userId, password);
		if (users.size()>0){
			result.setFlag(true);
		}else{
			result.setFlag(false);
		}
		result.setData(users);
		return result;
	}

	@Override
	public RequestResult loginByWorkId(String workId, String password) {
		RequestResult result = new RequestResult();
		List<Map<String,Object>> users = loginDao.loginByWorkId(workId, password);
		if (users.size()>0){
			result.setFlag(true);
		}else{
			result.setFlag(false);
		}
		result.setData(users);
		return result;
	}

}
