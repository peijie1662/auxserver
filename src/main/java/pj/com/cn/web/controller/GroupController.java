package pj.com.cn.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pj.com.cn.web.model.RequestResult;
import pj.com.cn.web.service.GroupService;

@RestController
public class GroupController {
	private static Logger logger = LoggerFactory
			.getLogger(GroupController.class);
	
	@Autowired
	private GroupService groupService;
	
	/**
	 * 组信息
	 */
	@RequestMapping(value="/groupinfo",produces="application/json;charset=UTF-8")
	public RequestResult groupInfo(HttpServletRequest request){
		RequestResult result = groupService.groupInfo();
		logger.info(" IP:" + request.getRemoteAddr()
				+ " Get_Group_Info");
		return result;
	}
	
	/**
	 * 组成员信息
	 */
	@RequestMapping(value="/groupmember",produces="application/json;charset=UTF-8")
	public RequestResult groupMember(HttpServletRequest request){		
		RequestResult result = groupService.groupMember();
		logger.info(" IP:" + request.getRemoteAddr()
				+ " Get_Group_Member");
		return result;
	}
	
	/**
	 * 组设备信息
	 */
	@RequestMapping(value="/groupmacinfo",produces="application/json;charset=UTF-8")
	public RequestResult groupMacInfo(HttpServletRequest request){		
		RequestResult result = groupService.groupMacInfo();
		logger.info(" IP:" + request.getRemoteAddr()
				+ " Get_Group_Mac_Info");
		return result;
	}
}
