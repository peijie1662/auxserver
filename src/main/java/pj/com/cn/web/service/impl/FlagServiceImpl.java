package pj.com.cn.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj.com.cn.web.dao.FlagDao;
import pj.com.cn.web.model.RequestResult;
import pj.com.cn.web.service.FlagService;

@Service
public class FlagServiceImpl implements FlagService{
	
	@Autowired
	private FlagDao flagDao;

	@Override
	public RequestResult setAutoVoice(String workId, String flag) {
		RequestResult result = new RequestResult();
		if (flagDao.setAutoVoice(workId, flag)>0){
			result.setFlag(true);
		}else{
			result.setFlag(false);
		}
		return result;
	}

	@Override
	public RequestResult setHeadVoice(String workId, String flag) {
		RequestResult result = new RequestResult();
		if (flagDao.setHeadVoice(workId, flag)>0){
			result.setFlag(true);
		}else{
			result.setFlag(false);
		}
		return result;
	}

	@Override
	public RequestResult setTextVoice(String workId, String flag) {
		RequestResult result = new RequestResult();
		if (flagDao.setTextVoice(workId, flag)>0){
			result.setFlag(true);
		}else{
			result.setFlag(false);
		}
		return result;
	}
	
	@Override
	public RequestResult setAutoSwichCallId(String workId, String flag) {
		RequestResult result = new RequestResult();
		if (flagDao.setAutoSwichCallId(workId, flag)>0){
			result.setFlag(true);
		}else{
			result.setFlag(false);
		}
		return result;
	}

}
