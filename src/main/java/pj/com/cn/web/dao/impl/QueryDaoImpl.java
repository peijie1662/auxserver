package pj.com.cn.web.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pj.com.cn.web.dao.QueryDao;

@Repository
public class QueryDaoImpl implements QueryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> deviceStatus() {
		List<Map<String, Object>> db_list = null;
		try {
			String sql = "select * from ip_device_status where inLast='Y' order by deviceType,terminalId";
			db_list = jdbcTemplate.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return db_list;
	}

	@Override
	public List<Map<String, Object>> qryVoiceByDate(String bgDate, String edDate) {
		List<Map<String, Object>> db_list = null;
		try {
			String sql = " select *  from ip_message "
					+ " where crttime >= to_date('" + bgDate
					+ "', 'yyyymmddhh24miss') and crttime < to_date('" + edDate
					+ "', 'yyyymmdd-hh24miss')" + //
					" and filename is not null " + //
					" and srcgh is not null " + //
					" and targetgh is not null " + //
					" order by crttime desc ";
			db_list = jdbcTemplate.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return db_list;
	}

	@Override
	public List<Map<String, Object>> deviceHis(String terminalId) {
		List<Map<String, Object>> db_list = null;
		try {
			String sql = "select * from ip_device_status " + //
					" where terminalId = '" + terminalId + //
					"' order by loginTime desc ";
			db_list = jdbcTemplate.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return db_list;
	}

	@Override
	public List<Map<String, Object>> qryMessage(String terminalId,
			String msgType, Date bgDate, Date edDate) {
		List<Map<String, Object>> db_list = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		try {
			String sql = " select *  from ip_message "
					+ " where crttime >= to_date('" + df.format(bgDate)
					+ "-000000', 'yyyymmdd-hh24miss')"
					+ "   and crttime < to_date('" + df.format(edDate)
					+ "-235959', 'yyyymmdd-hh24miss')"
					+ " and (srcTerminalId='" + terminalId
					+ "' or targetTerminalId='" + terminalId + "') "
					+ " and msgType='" + msgType.toUpperCase()
					+ "' order by crttime desc ";
			db_list = jdbcTemplate.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return db_list;
	}

}
