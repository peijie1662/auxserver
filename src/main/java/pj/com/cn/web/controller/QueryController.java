package pj.com.cn.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pj.com.cn.web.model.DeviceStatus;
import pj.com.cn.web.model.Message;
import pj.com.cn.web.model.RequestResult;
import pj.com.cn.web.model.Voice;
import pj.com.cn.web.service.QueryService;
import Utils.MappingUtil;

@Controller
public class QueryController {

	@Autowired
	private QueryService queryService;

	/**
	 * 设备状态
	 */
	@RequestMapping(value = "/devicestatus",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<DeviceStatus> deviceStatus() {
		RequestResult result = queryService.deviceStatus();
		List<DeviceStatus> list = new ArrayList<DeviceStatus>();
		try {
			MappingUtil.mapToBeanList(result.getData(), list,
					DeviceStatus.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 设备历史
	 */
	@RequestMapping(value = "/devicehis/{terminalId}", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<DeviceStatus> deviceHis(@PathVariable String terminalId) {
		RequestResult result = queryService.deviceHis(terminalId);
		List<DeviceStatus> list = new ArrayList<DeviceStatus>();
		try {
			MappingUtil.mapToBeanList(result.getData(), list,
					DeviceStatus.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 按照开始结束日期返回语音列表JSON
	 */
	
	@RequestMapping(value = "/voice/begin/{bgDate}/end/{edDate}", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Voice> qryVoiceJson(@PathVariable String bgDate,
			@PathVariable String edDate) {
		System.out.println(new Date());
		List<Voice> list = new ArrayList<Voice>();
		try {
			RequestResult result = queryService.qryVoiceByDate(
					bgDate, edDate);
			MappingUtil.mapToBeanList(result.getData(), list, Voice.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(new Date());
		return list;
	}

	/**
	 * 消息查询
	 */
	@RequestMapping(value = "/message/id/{terminalId}/type/{msgType}/begin/{bgDate}/end/{edDate}", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Message> qryMessage(@PathVariable String terminalId,
			@PathVariable String msgType, @PathVariable String bgDate,
			@PathVariable String edDate) {
		List<Message> list = new ArrayList<Message>();
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			RequestResult result = queryService.qryMessage(terminalId, msgType,
					df.parse(bgDate), df.parse(edDate));
			MappingUtil.mapToBeanList(result.getData(), list, Message.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
