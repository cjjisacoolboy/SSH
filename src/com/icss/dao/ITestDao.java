package com.icss.dao;

import java.util.List;
import java.util.Map;

import com.icss.pojo.Course_info;

public interface ITestDao {
	public List<Course_info> selectAll();
	public void test();
	public void add();
	public Map<String, Object> findCarByCarName(String keyword);
	public Map<String, Object> findCarByCarType(String keyword);
}
