package pj.com.cn.web.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pj.com.cn.web.dao.ClearDao;

@Repository
public class ClrDaoImpl implements ClearDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void clr() {
		String sql = "delete from ip_message where sysdate-crttime>7 ";
		jdbcTemplate.update(sql);
		sql = "delete from ip_device_status where sysdate-logintime>7";
		jdbcTemplate.update(sql);
	}

}
