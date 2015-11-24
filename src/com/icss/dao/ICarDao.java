package com.icss.dao;

import java.util.List;

import com.icss.pojo.CarInfo;

public interface ICarDao {
	List<CarInfo> findId(String keyword);
	List<CarInfo> findCarById(int id);
	List<CarInfo> findCarAllNameById(int id);
	List<CarInfo> findCarByCarName(String keyword);
	List<CarInfo> findCarByCarType(String keyword);
	List<CarInfo> findCarByCarNameOfLimit(String keyword);
	List<CarInfo> findSeriesByCarName(String keyword);
	List<CarInfo> findCarNameByPId(int PId);
	//List<CarInfo> findPIdByCarName(String keyword);
}
