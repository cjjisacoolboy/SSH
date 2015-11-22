package com.icss.service;

import java.util.List;
import java.util.Map;

import com.icss.pojo.test.Course_info;

public interface ITestService {
	public void add();
	public Map<String,Object> findCar(String keyword);
	public List<Course_info> selectAll();
}
