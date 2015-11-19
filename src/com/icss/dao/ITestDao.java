package com.icss.dao;

import java.util.List;
import java.util.Map;

import com.icss.pojo.CarInfo;
import com.icss.pojo.test.Course_info;

public interface ITestDao {
	public List<Course_info> selectAll();
	public void test();
	public void add();
	public List<CarInfo> findCarByCarName(String keyword);
	public List<CarInfo> findCarByCarType(String keyword);
}
