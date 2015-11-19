package com.icss.service.impl;

import java.util.List;
import java.util.Map;

import com.icss.dao.ICarDao;
import com.icss.pojo.CarInfo;
import com.icss.pojo.MerchantsStore;
import com.icss.pojo.Seller;
import com.icss.pojo.UserInfo;
import com.icss.service.IVisitorService;

public class VisitorService implements IVisitorService {
	private ICarDao carDao;
	public void setCarDao(ICarDao carDao) {
		this.carDao = carDao;
	}

	@Override
	public Map<String, Object> findCar(String keyword) {
		//Ҫע��Idao
		//��Ҫ��keyword���ҳ����ֳ���id���ҳ���id����keyword��Ӧ��id
		List<CarInfo> list = carDao.findId(keyword);
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
	public boolean loginInUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return false;
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
