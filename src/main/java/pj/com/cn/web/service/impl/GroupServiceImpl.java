package pj.com.cn.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj.com.cn.web.dao.GroupDao;
import pj.com.cn.web.model.RequestResult;
import pj.com.cn.web.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService{

	@Autowired
	private GroupDao groupDao;
	
	@Override
	public RequestResult groupInfo() {
		RequestResult result = new RequestResult();
		List<Map<String,Object>> groups = groupDao.groupInfo();
		if (groups.size()>0){
			result.setFlag(true);
		}else{
			result.setFlag(false);
		}
		result.setData(groups);
		return result;
	}

	@Override
	public RequestResult groupMember() {
		RequestResult result = new RequestResult();
		List<Map<String,Object>> members = groupDao.groupMember();
		if (members.size()>0){
			result.setFlag(true);
		}else{
			result.setFlag(false);
		}
		result.setData(members);
		return result;
	}

	@Override
	public RequestResult groupMacInfo() {
		RequestResult result = new RequestResult();
		List<Map<String,Object>> macs = groupDao.groupMacInfo();
		if (macs.size()>0){
			result.setFlag(true);
		}else{
			result.setFlag(false);
		}
		result.setData(macs);
		return result;
	}

}
