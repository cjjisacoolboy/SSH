package com.icss.action;

import java.util.HashMap;
import java.util.Map;

import com.icss.service.IAdminService;

public class FindAllsaleCarsAction {

	private Map<String,Object> map = new HashMap<String,Object>();
	private IAdminService adminToSaleCarService;
	


	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}


	public void setAdminToSaleCarService(IAdminService adminToSaleCarService) {
		this.adminToSaleCarService = adminToSaleCarService;
	}



	public String execute(){
		String keyword = "sda";
		int page = 1;
		int size = 1;
		map =  adminToSaleCarService.findAllSaleCar(keyword, page, size);
		//System.out.println(map);
		return "success";	
	}
}
