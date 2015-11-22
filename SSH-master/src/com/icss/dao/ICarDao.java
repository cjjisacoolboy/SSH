package com.icss.dao;

import java.util.List;

import com.icss.pojo.CarInfo;

public interface ICarDao {
	List<CarInfo> findId(String keyword);
}
