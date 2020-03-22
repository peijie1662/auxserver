package pj.com.cn.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj.com.cn.web.dao.TruckQueueDao;
import pj.com.cn.web.service.TruckQueueService;

/**
* @author PJ 
* @version 创建时间：2019年11月19日 下午2:43:34
*/
@Service
public class TruckQueueServiceImpl implements TruckQueueService{
	
	@Autowired
	private TruckQueueDao truckDao;

	@Override 
	public String truckQueue(String guid,String localeId,String vehicleId) {
		return truckDao.truckQueue(guid, localeId, vehicleId);
		
	}

}
