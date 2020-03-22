package pj.com.cn.web.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import oracle.jdbc.OracleTypes;
import pj.com.cn.web.dao.OilEleDao;
import pj.com.cn.web.model.Rds;
import pj.com.cn.web.model.RequestResult;

/**
 * @author PJ
 * @version 创建时间：2020年3月21日 下午7:40:36
 */
@Repository
public class OilEleDaoImpl implements OilEleDao {

	private static Logger log = LoggerFactory.getLogger(OilEleDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public RequestResult oilEle(final List<Rds> rdss) {
		final ObjectMapper mapper = new ObjectMapper();
		RequestResult r = jdbcTemplate.execute(new CallableStatementCreator() {
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				String storedProc = "{call nbct.p_aux_oilele(?,?,?,?)}";
				CallableStatement cs = con.prepareCall(storedProc);
				// msgIn
				try {
					String msgIn = mapper.writeValueAsString(rdss);
					cs.setString(1, msgIn);
					log.info("油电: " + msgIn);
				} catch (Exception e) {
					cs.setString(1, "[]");
					log.info("油电: 传入参数格式转换错误");
				}
				// flag
				cs.registerOutParameter(2, OracleTypes.VARCHAR);
				// errMsg
				cs.registerOutParameter(3, OracleTypes.VARCHAR);
				// msgOut
				cs.registerOutParameter(4, OracleTypes.VARCHAR);
				return cs;
			}
		}, new CallableStatementCallback<RequestResult>() {
			public RequestResult doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
				cs.execute();
				RequestResult r = new RequestResult();
				r.setFlag("0".equals(cs.getString(2)));
				r.setErrMsg(cs.getString(3));
				return r;
			}
		});
		return r;
	}

}
