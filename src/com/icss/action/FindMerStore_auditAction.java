package com.icss.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icss.pojo.MerchantsStore_audit;
import com.icss.service.IAdminService;

public class FindMerStore_auditAction {
	private int page=1;
	private int size=1;
	private Map<String,Object> map = new HashMap<String,Object>(); 
	private IAdminService adminToMerStoreService;
	
	
	public void setPage(int page) {
		this.page = page;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Map<String, Object> getMap() {
		return map;
	}


	public void setAdminToMerStoreService(IAdminService adminToMerStoreService) {
		this.adminToMerStoreService = adminToMerStoreService;
	}


	public String execute(){
		if(size != 1){
		//MerchantsStore_audit merchantsStore_audit = new MerchantsStore_audit();
		map = adminToMerStoreService.findMerchantsStore_audit(page,size);
		}
		return "success";
	}
}
