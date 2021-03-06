package com.icss.service.impl;

import java.util.List;
import java.util.Map;

import com.icss.dao.ICarDao;
import com.icss.dao.IUserDao;
import com.icss.pojo.CarInfo;
import com.icss.pojo.MerchantsStore;
import com.icss.pojo.Seller;
import com.icss.pojo.UserInfo;
import com.icss.service.IVisitorService;

public class VisitorService implements IVisitorService {
	private ICarDao carDao;
	private IUserDao userDao;
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void setCarDao(ICarDao carDao) {
		this.carDao = carDao;
	}

	@Override
	public Map<String, Object> findCar(String keyword) {
		//要注入Idao
		//我要从keyword中找出这种车的id，找出父id等于keyword对应的id
		List<CarInfo> list = carDao.findId(keyword);
		System.out.println("进入了service");
		System.out.println(list.get(0).getCarId());
		
		return null;
	}

	@Override
	public boolean registerAsUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean applyAsBussiness(MerchantsStore merchantsStore) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserInfo> loginInUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		//注入一个dao
		System.out.println("进入了loginservice");
//		Integer tel = userInfo.getAccount();
		List<UserInfo> list = userDao.findUser(userInfo);
		System.out.println(list.get(0).getRole());
//		userInfo.getPassword()
//		//拿出的是List 遍历list
//		//如果密码不正确
//		list =null;
		
		return null;
	}

	@Override
	public boolean loginInBussiness(MerchantsStore merchantsStore) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addCompare(Integer carId, String ip) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkCompare(String ip) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCompare(Integer carId, String ip) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int order(Seller seller) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int evaluate(String carName, double km, String licenceDate) {
		// TODO Auto-generated method stub
		return 0;
	}

}
