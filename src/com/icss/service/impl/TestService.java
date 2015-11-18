package com.icss.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icss.dao.ITestDao;
import com.icss.dao.impl.TestDao;
import com.icss.pojo.Course_info;
import com.icss.pojo.test.Carinfo;
import com.icss.service.ITestService;

public class TestService implements ITestService {
	private ITestDao testDao;
	private Map<String,Object>map = new HashMap<String,Object>();
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Map<String, Object> getMap() {
		return map;
	}
	public void setTestDao(ITestDao testDao) {
		this.testDao = testDao;
	}
	
	
	
	@Override
	public void add() {
		// TODO Auto-generated method stub
		//testDao.test();
	}
	@Override
	public Map<String,Object> findCar(String keyword) {
		// TODO Auto-generated method stub
		map = testDao.findCarByCarName(keyword);
		List<Carinfo> list = (List<Carinfo>) map.get("list");
		int listSize = list.size();
		System.out.println(listSize);
		if(0 == listSize){
			map = testDao.findCarByCarType(keyword);
		}
		return map;
	}

	@Override
	public List<Course_info> selectAll() {
		// TODO Auto-generated method stub
		
		return testDao.selectAll();
	}
	


}
