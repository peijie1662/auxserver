package pj.com.cn.web.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pj.com.cn.web.dao.FlagDao;

@Repository
public class FlagDaoImpl implements FlagDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int setAutoVoice(String workId, String flag) {
		String sql = "update ip_userset set setstr='" + flag
				+ "'||substr(setstr,2)" + " where workid='" + workId + "'";
		return jdbcTemplate.update(sql);
	}

	@Override
	public int setHeadVoice(String workId, String flag) {
		String sql = "update ip_userset set setstr=substr(setstr,1,1)||'"
				+ flag + "'||substr(setstr,3)" + " where workid='" + workId
				+ "'";
		return jdbcTemplate.update(sql);
	}

	@Override
	public int setTextVoice(String workId, String flag) {
		String sql = "update ip_userset set setstr=substr(setstr,1,2)||'"
				+ flag + "'||substr(setstr,4)" + " where workid='" + workId
				+ "'";
		return jdbcTemplate.update(sql);
	}
	
	@Override
	public int setAutoSwichCallId(String workId, String flag) {
		String sql = "update ip_userset set setstr=substr(setstr,1,4)||'"
				+ flag + "'||substr(setstr,6)" + " where workid='" + workId
				+ "'";
		return jdbcTemplate.update(sql);
	}

}
