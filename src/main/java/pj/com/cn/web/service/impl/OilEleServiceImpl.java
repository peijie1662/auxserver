package pj.com.cn.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj.com.cn.web.dao.OilEleDao;
import pj.com.cn.web.model.Rds;
import pj.com.cn.web.model.RequestResult;
import pj.com.cn.web.service.OilEleService;

/**
* @author PJ 
* @version 创建时间：2020年3月21日 下午8:10:16
*/
@Service
public class OilEleServiceImpl implements OilEleService{
	
	@Autowired
	private OilEleDao oilEleDao;

	@Override
	public RequestResult oilEle(List<Rds> rdss) {
		return oilEleDao.oilEle(rdss);
	}

}
