package com.icss.action;

import java.util.List;

import com.icss.pojo.Course_info;
import com.icss.service.ITestService;
import com.icss.service.impl.TestService;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	private ITestService testService;
	
	public void setTestService(ITestService testService) {
		this.testService = testService;
	}

	public String execute(){
		
		testService.add();
		List<Course_info>list = testService.selectAll();
		for(Course_info ci : list) {
			System.out.println(ci.getCourse_name());
		}
		return "success";
	}
}
