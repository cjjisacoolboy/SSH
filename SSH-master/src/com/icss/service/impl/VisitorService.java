package com.icss.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icss.dao.ICarDao;
import com.icss.pojo.CarInfo;
import com.icss.pojo.MerchantsStore;
import com.icss.pojo.Seller;
import com.icss.pojo.UserInfo;
import com.icss.service.IVisitorService;
import com.opensymphony.xwork2.ActionContext;

public class VisitorService implements IVisitorService {
	private ICarDao carDao;
	private List<CarInfo> list;
	private Map<String, Object> map;
	

	public List<CarInfo> getList() {
		return list;
	}

	public void setList(List<CarInfo> list) {
		this.list = list;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public void setCarDao(ICarDao carDao) {
		this.carDao = carDao;
	}

	@Override
	public Map<String, Object> findCar(String keyword) {
		//要注入Idao
		//我要从keyword中找出这种车的id，找出父id等于keyword对应的id
		System.out.println("进入service");
		//System.out.println("key:"+keyword);
		 list = carDao.findId(keyword+"%");
		System.out.println("****"+list.size());
//		map = new HashMap<String, Object>();
//		map.put("0",list);
		
		ActionContext ac = ActionContext.getContext();
		System.out.println("ac:"+ac.getName());
		ac.put("list", list);
		System.out.println("0:"+ac.get("list"));
		
		return map;
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
