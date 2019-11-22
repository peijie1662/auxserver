package pj.com.cn.web.register;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import pj.com.cn.web.register.CallResult;

/**
 * 注册本服务
 */
@Component
public class Register {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Properties properties;

	public void reg() {
		ObjectMapper objectMapper = new ObjectMapper(); 
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);//避免415
		//注册的对象
		ServiceProvider service = new ServiceProvider();
		service.setServerName(properties.getProperty("server_name"));
		service.setIp(properties.getProperty("server_ip"));
		service.setPort(Integer.parseInt(properties.getProperty("server_port")));
		String serverId = service.getServerName() + "@" + service.getIp() + "@" + service.getPort();
		service.setServerId(serverId.replace(".", "@"));
		service.setWeight(properties.getProperty("server_weight"));
		service.setVersion(properties.getProperty("server_version"));
		//注册
		List<String> regUrls = new ArrayList<String>();
		regUrls.add(properties.getProperty("first_register_url"));
		regUrls.add(properties.getProperty("second_register_url"));	
		for (String regUrl : regUrls) {
			try {
				String s = objectMapper.writeValueAsString(service);
				HttpEntity<String> entity = new HttpEntity<String>(s,headers);
				restTemplate.postForObject(regUrl, entity, CallResult.class);
			} catch (Exception e) {
			}
		}
	}

}
