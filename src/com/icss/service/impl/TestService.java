package com.icss.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icss.dao.ITestDao;
import com.icss.dao.impl.TestDao;
import com.icss.pojo.Carinfo;
import com.icss.pojo.test.Course_info;
import com.icss.service.ITestService;

public class TestService implements ITestService {
	private ITestDao testDao;
	private Map<String,Object>map = new HashMap<String,Object>();
	private Carinfo carinfo;
	
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public void setTestDao(ITestDao testDao) {
		this.testDao = testDao;
	}
		
	public void setCarinfo(Carinfo carinfo) {
		this.carinfo = carinfo;
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		//testDao.test();
	}
	@Override
	public Map<String,Object> findCar(String keyword) {
		String findword = keyword+"%";
		//carinfo.setCarName(findword);
		List<Carinfo> list = new ArrayList<Carinfo>();
		// TODO Auto-generated method stub
		list = testDao.findCarByCarName(findword);
		//list = (List<Carinfo>) map.get("list");
		int listSize = list.size();
		System.out.println(listSize);
		if(0 == listSize){
			list = testDao.findCarByCarType(findword);
		}
		map.put("list",list);
		return map;
	}

	@Override
	public List<Course_info> selectAll() {
		// TODO Auto-generated method stub
		
		return testDao.selectAll();
	}
	


}
