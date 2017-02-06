package pj.com.cn.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pj.com.cn.web.model.RequestResult;
import pj.com.cn.web.service.FlagService;

@RestController
@RequestMapping("/set")
public class FlagController {
	private static Logger logger = LoggerFactory
			.getLogger(FlagController.class);

	@Autowired
	private FlagService flagService;

	/**
	 * 自动播放
	 */
	@RequestMapping(value = "/autovoice/{workId}/{flag}", produces = "application/json;charset=UTF-8")
	public RequestResult setAutoVoice(@PathVariable String workId,
			@PathVariable String flag, HttpServletRequest request) {
		RequestResult result = flagService.setAutoVoice(workId, flag);
		logger.info(" IP:" + request.getRemoteAddr() + " WorkId = " + workId
				+ " SetAutoVoice = " + flag);
		return result;
	}

	/**
	 * 播放头信息
	 */
	@RequestMapping(value = "/headvoice/{workId}/{flag}", produces = "application/json;charset=UTF-8")
	public RequestResult setHeadVoice(@PathVariable String workId,
			@PathVariable String flag, HttpServletRequest request) {
		RequestResult result = flagService.setHeadVoice(workId, flag);
		logger.info(" IP:" + request.getRemoteAddr() + " WorkId = " + workId
				+ " SetHeadVoice = " + flag);
		return result;
	}

	/**
	 * 播放文本
	 */
	@RequestMapping(value = "/textvoice/{workId}/{flag}", produces = "application/json;charset=UTF-8")
	public RequestResult setTextVoice(@PathVariable String workId,
			@PathVariable String flag, HttpServletRequest request) {
		RequestResult result = flagService.setTextVoice(workId, flag);
		logger.info(" IP:" + request.getRemoteAddr() + " WorkId = " + workId
				+ " SetTextVoice = " + flag);
		return result;
	}
}
