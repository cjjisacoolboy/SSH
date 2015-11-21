package com.icss.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icss.pojo.MerchantsStore;
import com.icss.service.IAdminService;

public class FindMerStoreAction {
	private int page=1;
	private int size=5;
	private MerchantsStore merchantsStore;
	private Map<String,Object> map = new HashMap<String,Object>();
	private IAdminService adminService;
	
	
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

	public MerchantsStore getMerchantsStore() {
		return merchantsStore;
	}

	public void setMerchantsStore(MerchantsStore merchantsStore) {
		this.merchantsStore = merchantsStore;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}


	public String execute(){
		merchantsStore = new MerchantsStore();
		//merchantsStore.setStore_id(1);
		//merchantsStore.setBusinessName("李盛");
		//merchantsStore.setCompanyName("seven head公司");
		//merchantsStore.setDealerType("打劫");
		//merchantsStore.setDealerAddress("广东");
		map = adminService.findMerchantsStore(merchantsStore,page,size);
		System.out.println(map);
		//System.out.println(list.get(0).getBusinessName());
		
		return "success";
		
	}
}
