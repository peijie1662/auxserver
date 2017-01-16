package pj.com.cn.web.dao;

import java.util.List;
import java.util.Map;

public interface GroupDao {
	
	List<Map<String,Object>> groupInfo();
	
	List<Map<String,Object>> groupMember();
	
	List<Map<String,Object>> groupMacInfo();
}
