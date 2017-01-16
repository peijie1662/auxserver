package pj.com.cn.web.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj.com.cn.web.dao.QueryDao;
import pj.com.cn.web.model.RequestResult;
import pj.com.cn.web.service.QueryService;

@Service
public class QueryServiceImpl implements QueryService {

	@Autowired
	private QueryDao queryDao;

	@Override
	public RequestResult deviceStatus() {
		RequestResult result = new RequestResult();
		List<Map<String, Object>> groups = queryDao.deviceStatus();
		if (groups.size() > 0) {
			result.setFlag(true);
		} else {
			result.setFlag(false);
		}
		result.setData(groups);
		return result;
	}

	@Override
	public RequestResult qryVoiceByDate(String bgDate, String edDate) {
		RequestResult result = new RequestResult();
		List<Map<String, Object>> groups = queryDao.qryVoiceByDate(bgDate,
				edDate);
		if (groups.size() > 0) {
			result.setFlag(true);
		} else {
			result.setFlag(false);
		}
		result.setData(groups);
		return result;
	}

	@Override
	public RequestResult deviceHis(String terminalId) {
		RequestResult result = new RequestResult();
		List<Map<String, Object>> groups = queryDao.deviceHis(terminalId);
		if (groups.size() > 0) {
			result.setFlag(true);
		} else {
			result.setFlag(false);
		}
		result.setData(groups);
		return result;
	}

	@Override
	public RequestResult qryMessage(String terminalId, String type,
			Date bgDate, Date edDate) {
		RequestResult result = new RequestResult();
		List<Map<String, Object>> msgs = queryDao.qryMessage(terminalId, type,
				bgDate, edDate);
		if (msgs.size() > 0) {
			result.setFlag(true);
		} else {
			result.setFlag(false);
		}
		result.setData(msgs);
		return result;
	}

}
