package pj.com.cn.web.service;

import java.util.Date;

import pj.com.cn.web.model.RequestResult;

public interface QueryService {
	
	RequestResult deviceStatus();
	
	RequestResult deviceHis(String terminalId);
	
	RequestResult qryVoiceByDate(String bgDate,String edDate);
	
	RequestResult qryMessage(String terminalId,String type,Date bgDate,Date edDate);

}
