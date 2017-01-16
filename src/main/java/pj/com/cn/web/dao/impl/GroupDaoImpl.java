package pj.com.cn.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDaoImpl implements pj.com.cn.web.dao.GroupDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Map<String, Object>> groupInfo() {
		List<Map<String, Object>> db_list = null;
		try {
			String sql = "select * from ip_group where isactive='Y' order by group_order";
			db_list = jdbcTemplate.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return db_list;
	}

	@Override
	public List<Map<String, Object>> groupMember() {
		List<Map<String, Object>> db_list = null;
		try {
			String sql = "select * from ip_group_mac order by group_id,mac_type,mac_id";
			db_list = jdbcTemplate.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return db_list;
	}

	@Override
	public List<Map<String, Object>> groupMacInfo() {
		List<Map<String, Object>> db_list = null;
		try {
			String sql = " select b.* from "
					+ " (select a.*,f_getcallid(a.id,a.type) as callid from "
					+ "    (select rtrim(syidtb) as id, rtrim(sydstb) as ds, rtrim(sycotb) as type"
					+ "       from sycdtbp"
					+ "      where sycdtb = 'TCTBRG'"
					+ "        and sycotb = 'LMD'"
					+ "        and syidtb<>'TCTBRG'"
					+ "     union"
					+ "     select rtrim(syidtb) as id, rtrim(sydstb) as ds, rtrim(sycotb) as type"
					+ "       from sycdtbp"
					+ "      where sycdtb = 'TCTBRG'"
					+ "        and sycotb = 'DGJ'"
					+ "        and syidtb<>'TCTBRG'"
					+ "     union"
					+ "     select rtrim(syidtb) as id, rtrim(sydstb) as ds, rtrim(sycotb) as type"
					+ "       from sycdtbp"
					+ "      where sycdtb = 'TCTBRG'"
					+ "        and sycotb = 'ZMD'"
					+ "        and syidtb<>'TCTBRG'"
					+ "     union"
					+ "     select rtrim(syidtb) as id, rtrim(sydstb) as ds, rtrim(sycotb) as type"
					+ "       from sycdtbp"
					+ "      where sycdtb = 'TCTBQD'"
					+ "        and sycotb = 'QD'"
					+ "        and syidtb<>'TCTBQD'"
					+ "     union"
					+ "     select rtrim(syidfl) as id, rtrim(sydsfl) as ds, 'JK' as type"
					+ "       from sycdflp"
					+ "      where syc1fl = '8888'"
					+ "     union"
					+ "     select rtrim(syidtb) as id, rtrim(sydstb) as ds, 'KZ' as type"
					+ "       from sycdtbp" + "      where sycdtb = 'TCTBKZ'"
					+ "        and syidtb<>'TCTBKZ') a"
					+ " order by type,id) b" + " where b.callid is not null";
			db_list = jdbcTemplate.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return db_list;
	}
}
