package pj.com.cn.web.scheduled;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装文件序列
 */
public class AudioFile {

	/**
	 * 文件名前缀
	 */
	private String prefix;

	/**
	 * amr文件序列
	 */
	private List<String> filePaths = new ArrayList<String>();

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public List<String> getFilePaths() {
		return filePaths;
	}

	public void setFilePaths(List<String> filePaths) {
		this.filePaths = filePaths;
	}

}
