package pj.com.cn.web.dao;

import java.util.List;

import pj.com.cn.web.model.Rds;
import pj.com.cn.web.model.RequestResult;

/**
 * @author PJ
 * @version 创建时间：2020年3月21日 下午7:34:58 <br>
 */
public interface OilEleDao {
	
	/**
	 * 油电
	 * @param map
	 * @return
	 */
	RequestResult oilEle(List<Rds> rdss);

}
