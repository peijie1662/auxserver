package pj.com.cn.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pj.com.cn.web.model.Rds;
import pj.com.cn.web.model.RequestResult;
import pj.com.cn.web.service.OilEleService;

/**
 * @author PJ
 * @version 创建时间：2020年3月20日 下午2:40:21
 */
@RestController
public class OilEleController {

	@Autowired
	private OilEleService oeService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/oe", produces = "application/json;charset=UTF-8")
	public RequestResult oilele(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		Iterator<String> it = map.keySet().iterator();
		List<Rds> rdss = new ArrayList<Rds>();
		while (it.hasNext()) {
			// RDSID
			Rds rds = new Rds();
			String key = it.next();
			rds.setRdsId(key.substring(2));
			// STATUS
			String status = map.get(key)[0];
			if ("Oil".equals(status)) {
				rds.setStatus("O");
			} else if ("Ele".equals(status)) {
				rds.setStatus("P");
			} else {
				rds.setStatus("N");
			}
			rdss.add(rds);
		}
		return oeService.oilEle(rdss);
	}

}
