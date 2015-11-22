package com.icss.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icss.service.IAdminService;

public class FindAllsaleCarsAction {
	int page = 1;
	int size = 1;
	private Map<String,Object> map = new HashMap<String,Object>();
	private IAdminService adminToSaleCarService;
	


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

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
		if(size != 1){
		map =  adminToSaleCarService.findAllSaleCar(keyword, page, size);
		}
		//System.out.println(map);
		return "success";	
	}
}
