package pj.com.cn.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pj.com.cn.web.model.RequestResult;
import pj.com.cn.web.service.LoginService;

@RestController
public class LoginController {
	private static Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	/**
	 * 根据用户名登录
	 */
	@RequestMapping(value = "/login/userid/{userId}/{password}", produces = "application/json;charset=UTF-8")
	public RequestResult loginByUserId(@PathVariable String userId,
			@PathVariable String password, HttpServletRequest request) {
		RequestResult result = loginService.loginByUserId(userId, password);
		if (result.isFlag()) {
			logger.info(" IP:" + request.getRemoteAddr()
					+ " Login_By_UserId_Success: UserId = " + userId);
		} else {
			logger.info(" IP:" + request.getRemoteAddr()
					+ " Login_By_UserId_Failed: UserId = " + userId);
		}
		return result;
	}

	/**
	 * 根据工号登录
	 */
	@RequestMapping(value = "/login/workid/{workId}/{password}", produces = "application/json;charset=UTF-8")
	public RequestResult loginByWorkId(@PathVariable String workId,
			@PathVariable String password, HttpServletRequest request) {
		RequestResult result = loginService.loginByWorkId(workId, password);
		if (result.isFlag()) {
			logger.info(" IP:" + request.getRemoteAddr()
					+ " Login_By_WorkId_Success: WorkId = " + workId);
		} else {
			logger.info(" IP:" + request.getRemoteAddr()
					+ " Login_By_WorkId_Failed: WorkId = " + workId);
		}
		return result;
	}

}
