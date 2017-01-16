package pj.com.cn.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Utils.MappingUtil;

import pj.com.cn.web.model.DeviceStatus;


@RestController
public class TestController {
   
	@RequestMapping("/test")
	public @ResponseBody String test(){
		
		Map<String,Object> map = new HashMap<String,Object>(); 
		map.put("TERMINALID", "001");
		map.put("DEVICEID", "KZ01");
		map.put("CHGTIME", new Date());
		
		
		DeviceStatus truck = new DeviceStatus();
		MappingUtil.mapToBean(map, truck);
		
	    System.out.println(truck.toString());
		
		return "ok";
	}
	
}
