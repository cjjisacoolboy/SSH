package com.icss.action;

import java.util.HashMap;
import java.util.Map;

import com.icss.service.ITestService;

public class SearchCarInAdminAction {
	private String keyword;
	private String type;
	private ITestService testService;
	private Map<String,Object> map = new HashMap<String,Object>();
	
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public void setTestService(ITestService testService) {
		this.testService = testService;
	}

	
	
	public String execute(){
		System.out.println("sdsdsd");
		System.out.println(type);
		map = testService.findCarByLimit(keyword,type);
		
		return "success";
	}
}
