package pj.com.cn.web.service;

import java.util.List;

import pj.com.cn.web.model.Rds;
import pj.com.cn.web.model.RequestResult;

/**
* @author PJ 
* @version 创建时间：2020年3月21日 下午8:08:33
*/
public interface OilEleService {
	
	RequestResult oilEle(List<Rds> rdss);

}
