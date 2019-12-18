package pj.com.cn.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pj.com.cn.web.service.TruckQueueService;

/**
 * @author PJ
 * @version 创建时间：2019年11月8日 下午1:44:55
 */
@RestController
public class TruckQueueController {

	private static Logger logger = LoggerFactory.getLogger(TruckQueueController.class);

	@Autowired
	private TruckQueueService truckService;

	@RequestMapping(value = "/truckqueue", produces = "application/json;charset=UTF-8")
	public String truckQueue(@RequestParam(value = "GUID", required = true) String guid,
			@RequestParam(value = "LocaleID", required = true) String localeId,
			@RequestParam(value = "VehicleID", required = true) String vehicleId,
			@RequestParam(value = "DT", required = true) String DT, HttpServletRequest request) {
		// 检测点不能为空,存储过程按照这个判断
		localeId = StringUtils.isEmpty(localeId) ? "ERROR" : localeId;
		String io = truckService.truckQueue(guid, localeId, vehicleId);
		logger.info(" IP:" + request.getRemoteAddr() + " GUID=" + guid + ",LocaleID=" + localeId + ",VehicleID="
				+ vehicleId);
		return String.format("{'GUID':'%s','VehicleID':'%s','IO':'%s'}", new Object[] { guid, vehicleId, io });
	}

}
