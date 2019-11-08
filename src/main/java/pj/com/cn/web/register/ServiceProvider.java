package pj.com.cn.web.register;

/**
 * 服务提供者 
 */
public class ServiceProvider {

	/**
	 * 服务ID
	 */
	private String serverId;
	
	/**
	 * 服务名
	 */
	private String serverName;
	
	/**
	 * 服务IP
	 */
	private String ip;
	
	/**
	 * 服务端口
	 */
	private int port;
	
	/**
	 * 权重
	 */
	private String weight;
	
	/**
	 * 版本
	 */
	private String version;

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
}
