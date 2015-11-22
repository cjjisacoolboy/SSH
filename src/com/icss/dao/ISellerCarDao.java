package com.icss.dao;

import java.util.List;

import com.icss.pojo.SellerCar;

public interface ISellerCarDao {
	List<SellerCar> findSaleCars(String keyword);
	List<SellerCar> findSellerCarById(int sellerId);
}
