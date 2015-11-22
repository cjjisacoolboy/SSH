package com.icss.action;

import java.util.HashMap;
import java.util.List;

import com.icss.pojo.CarInfo;
import com.icss.pojo.test.Course_info;
import com.icss.service.ITestService;
import com.icss.service.IVisitorService;
import com.icss.service.impl.TestService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.javafx.collections.MappingChange.Map;

public class TestAction extends ActionSupport{
	private IVisitorService visitorService;
	public void setVisitorService(IVisitorService visitorService) {
		this.visitorService = visitorService;
	}


	public String execute(){
		System.out.println("Ω¯»Î¡Àaction");
		visitorService.findCar("2012");
	    
		//testService.add();
		//List<Course_info>list = testService.selectAll();
//		for(Course_info ci : list) {
//			System.out.println(ci.getCourse_name());
//		}
//		
		return "success";
	}
}
