package com.icss.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.icss.pojo.UserInfo;
import com.icss.service.IVisitorService;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class LoginAction implements ServletRequestAware{
	private IVisitorService visitorService;
	private UserInfo userInfo;
	private HttpServletRequest request;
	
	public void setVisitorService(IVisitorService visitorService) {
		this.visitorService = visitorService;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public String execute(){
		//模拟前台拿数据
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		System.out.println(""+account);
		System.out.println(""+password);
		userInfo = new UserInfo();
		userInfo.setTel(account);
		userInfo.setPassword(password);
//		userInfo.setPassword("123");
//		userInfo.setUserId(1);
//		userInfo.setRole("用户");
		List<UserInfo> list = visitorService.loginInUser(userInfo);
		//System.out.println("password:"+list.get(0).getPassword());
		System.out.println("size:"+list.size());
		if(list.size()==0 || list == null){
			return "error";
		}
		if(!list.get(0).getPassword().equals(userInfo.getPassword())){
			return "error";
		}
		return "success";
	}

	
}
