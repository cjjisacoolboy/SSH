package com.icss.service;

import java.util.List;
import java.util.Map;

import com.icss.pojo.CarInfo;
import com.icss.pojo.test.Course_info;

public interface ITestService {
	public void add();
	public Map<String,Object> findCar(String keyword);
	public Map<String,Object> findCarByLimit(String keyword,String type);
	public List<CarInfo> findSeriesByCarName(String keyword);
	
	public Map<String,Object> findCarNameByPId(String keyword);//没有用了
}
