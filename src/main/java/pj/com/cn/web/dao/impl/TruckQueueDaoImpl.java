package pj.com.cn.web.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
import pj.com.cn.web.dao.TruckQueueDao;

/**
* @author PJ 
* @version 创建时间：2019年11月19日 下午2:15:33
*/
@Repository
public class TruckQueueDaoImpl implements TruckQueueDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String truckQueue(String guid, final String localeId, final String vehicleId) {
		Object o = jdbcTemplate.execute(new CallableStatementCreator() {
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				String storedProc = "{call nbct.p_truck_goup(?,?,?,?,?)}";
				CallableStatement cs = con.prepareCall(storedProc);
				cs.setString(1, localeId);
				cs.setString(2, vehicleId); 
				// flag
				cs.registerOutParameter(3, OracleTypes.VARCHAR);
				// errMsg
				cs.registerOutParameter(4, OracleTypes.VARCHAR);
				// msgOut
				cs.registerOutParameter(5, OracleTypes.VARCHAR);
				return cs;
			}
		}, new CallableStatementCallback<Object>() {
			public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
				cs.execute();
				return cs.getString(5);
			}
		});
		return o.toString(); 
	}

}
