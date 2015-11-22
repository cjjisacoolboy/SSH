package com.icss.dao;

import java.util.List;

import com.icss.pojo.SellerCar;

public interface ISellerCarDao {
	List<SellerCar> findSaleCar(String keyword);
}
