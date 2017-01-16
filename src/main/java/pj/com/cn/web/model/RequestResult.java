package pj.com.cn.web.model;

import java.util.List;
import java.util.Map;

/**
 * @param <T>
 */
public class RequestResult {
	
	private boolean flag;
	
	private String errMsg;
	
	private List<Map<String, Object>> data;
	
	public RequestResult(){};
	
	public RequestResult(boolean flag){
		this.setFlag(flag);
	}
	
	public RequestResult(boolean flag,String errMsg){
		this.setFlag(flag);
		this.setErrMsg(errMsg);
	}
	
	public RequestResult(boolean flag,String errMsg,List<Map<String, Object>> data){
		this.setFlag(flag);
		this.setErrMsg(errMsg);
		this.setData(data);
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public List<Map<String, Object>> getData() {
		return data;
	}

	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}

}
