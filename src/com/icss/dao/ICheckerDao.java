package com.icss.dao;

import java.util.List;

import com.icss.pojo.CheckerInfo;

public interface ICheckerDao {
	List<CheckerInfo> findCheckerById(int checkerId);
}
