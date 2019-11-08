package pj.com.cn.web.dao;

public interface FlagDao {
	
	int setAutoVoice(String workId,String flag);
	
	int setHeadVoice(String workId,String flag);
	
	int setTextVoice(String workId,String flag);

	int setAutoSwichCallId(String workId, String flag);

}
