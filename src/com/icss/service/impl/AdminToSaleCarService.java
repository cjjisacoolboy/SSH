package com.icss.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icss.dao.ISellerCarDao;
import com.icss.pojo.MerchantsStore;
import com.icss.pojo.MerchantsStore_audit;
import com.icss.pojo.Seller;
import com.icss.pojo.SellerCar;
import com.icss.service.IAdminService;

public class AdminToSaleCarService implements IAdminService {
	private ISellerCarDao sellerCarDao;
	private Map<String,Object> map = new HashMap<String,Object>();
	
	public void setSellerCarDao(ISellerCarDao sellerCarDao) {
		this.sellerCarDao = sellerCarDao;
	}

	@Override
	public Map<String, Object> findMerchantsStore(MerchantsStore merchantsStore, Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> findMerchantsStore_audit(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateMerchantsStore_audit(MerchantsStore_audit merchantsStore_audit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> findAllSaleCar(String keyword, Integer page, Integer size) {
		//查出所有二手车
		List<SellerCar> list =  sellerCarDao.findSaleCar(keyword);
		Seller seller = new Seller();
		MerchantsStore merchantsStore = new MerchantsStore();
		seller.setSellerName("非个人");
		merchantsStore.setBusinessName("个人"); 
		System.out.println(list.get(0).getTel());
		//因为是map 将seller 和 merchantsStore 分别取出来
		System.out.println(list.get(0).getSeller());
		if(list.get(0).getSeller() != null){
			list.get(0).setMerchantsStore(merchantsStore);;
		} else {
			list.get(0).setSeller(seller);;
		}
		System.out.println(list.get(0).getSeller());
		map.put("list", list);
		System.out.println("进入了salesservice");
		return map;
	}

}
