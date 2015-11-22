package com.icss.action;

import java.util.HashMap;
import java.util.Map;

import com.icss.service.IAdminService;

public class FindSalCarDetailAction {
	private int sellerCarId;
	private IAdminService adminToSaleCarService;
	private Map<String,Object> map = new HashMap<String,Object>();
	
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public void setSellerCarId(int sellerCarId) {
		this.sellerCarId = sellerCarId;
	}

	public void setAdminToSaleCarService(IAdminService adminToSaleCarService) {
		this.adminToSaleCarService = adminToSaleCarService;
	}

	public String execute(){
		map = adminToSaleCarService.findCarDetail(sellerCarId);
		//System.out.println(map+"sdsdsdsdsdsdssdsdsdsd");
		return "success";
	}
}
