package pj.com.cn.web.dao;

import java.util.List;
import java.util.Map;

public interface LoginDao {
	
	List<Map<String,Object>> loginByUserId(String userID,String password);
	
	List<Map<String,Object>> loginByWorkId(String workId,String password);

}
