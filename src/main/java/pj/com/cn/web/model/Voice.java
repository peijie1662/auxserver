package pj.com.cn.web.model;

import Utils.ConvertUtils;






public class Voice {
	/**
	 * 语音文件
	 */
	private String fileName;
	
	/**
	 * 发起人
	 */
	private String srcName;
	
	/**
	 * 发起设备
	 */
	private String srcMac;
	
	/**
	 * 接收人
	 */
	private String targetName;
	
	/**
	 * 接收设备
	 */
	private String targetMac;
	
	/**
	 * 消息时间
	 */
	private String crtTime;
	
	/**
	 * 接收标记
	 */
	private String received;

	public String getFileName() {
		return fileName;
	}

	/**
	 * 文件名去掉大括号
	 */
	public void setFileName(String fileName) {
		this.fileName = ConvertUtils.convertFilename(fileName);
	}

	public String getSrcName() {
		return srcName;
	}

	public void setSrcName(String srcName) {
		this.srcName = srcName;
	}

	public String getSrcMac() {
		return srcMac;
	}

	public void setSrcMac(String srcMac) {
		this.srcMac = srcMac;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public String getTargetMac() {
		return targetMac;
	}

	public void setTargetMac(String targetMac) {
		this.targetMac = targetMac;
	}

	public String getReceived() {
		return received;
	}

	public void setReceived(String received) {
		this.received = received;
	}

	public String getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(String crtTime) {
		this.crtTime = crtTime;
	}
	
}
