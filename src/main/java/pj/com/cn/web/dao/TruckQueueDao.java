package pj.com.cn.web.dao;

public interface TruckQueueDao {
	
	/**
	 * 集卡排队
	 * @return 
	 */
	String truckQueue(String guid,String localeId,String vehicleId);
	
}
