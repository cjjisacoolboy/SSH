package com.icss.action;

import java.util.HashMap;
import java.util.Map;

import com.icss.service.IVisitorService;

public class SearchSaleCarAction {
	private String keyword;
	private IVisitorService visitorService;
	private Map<String,Object> map = new HashMap<String,Object>();
	
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}


	public void setVisitorService(IVisitorService visitorService) {
		this.visitorService = visitorService;
	}

	public String execute(){
		
		map = visitorService.findCar("°ÂµÏQ3(½ø¿Ú)");
		//System.out.println(map.get("list"));
		return "success";
	}
}
