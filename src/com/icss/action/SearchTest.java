package com.icss.action;

import java.util.HashMap;
import java.util.Map;

import com.icss.service.ITestService;
import com.icss.service.impl.TestService;

public class SearchTest {
	private String keyword;
	private ITestService testService;
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

	public void setTestService(ITestService testService) {
		this.testService = testService;
	}

	
	
	public String execute(){
		
		map = testService.findCar(keyword);
		//System.out.println(map.get("list"));
		return "success";
	}
}
