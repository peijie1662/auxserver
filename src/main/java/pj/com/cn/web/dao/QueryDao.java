package pj.com.cn.web.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface QueryDao {
	/**
	 * 查询设备状态
	 */
	List<Map<String,Object>> deviceStatus();
	
	/**
	 * 查询设备历史
	 */
	List<Map<String,Object>> deviceHis(String terminalId);
	
	/**
	 * 时间段查询语音
	 */
	List<Map<String,Object>> qryVoiceByDate(String bgDate,String edDate);
	
	/**
	 * 查询消息
	 */
	List<Map<String,Object>> qryMessage(String terminalId,String msgType,Date bgDate,Date edDate);
}
