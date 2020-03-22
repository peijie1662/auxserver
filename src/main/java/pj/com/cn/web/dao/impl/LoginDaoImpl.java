package pj.com.cn.web.dao.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pj.com.cn.web.dao.LoginDao;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> loginByUserId(String userId, String password) {
		List<Map<String, Object>> db_list = null;
		try {
			String sql = "select a.*,b.setstr from sycdurp a,ip_userset b where upper(a.shorur)=upper('" + userId
					+ "') and upper(passur)=upper('" + password + "') and a.wkidur = b.workid(+)";
			db_list = jdbcTemplate.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return db_list;
	}

	@Override
	public List<Map<String, Object>> loginByWorkId(String workId, String password) {
		List<Map<String, Object>> db_list = null;
		try {
			String sql = "select a.*,b.setstr from sycdurp a,ip_userset b where upper(a.wkidur)=upper('" + workId
					+ "') and upper(passur)=upper('" + password + "') and a.wkidur = b.workid(+)";
			db_list = jdbcTemplate.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return db_list;
	}

}
