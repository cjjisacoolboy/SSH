package com.icss.action;

import java.util.List;

import com.icss.pojo.UserInfo;
import com.icss.service.IVisitorService;

public class LoginAction {
	private IVisitorService visitorService;
	private UserInfo userInfo;
	public void setVisitorService(IVisitorService visitorService) {
		this.visitorService = visitorService;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String execute(){
		//ģ��ǰ̨������
		userInfo = new UserInfo();
		userInfo.setTel("18316022274");
//		userInfo.setPassword("123");
//		userInfo.setUserId(1);
//		userInfo.setRole("�û�");
		List<UserInfo> list = visitorService.loginInUser(userInfo);


		return "success";
	}
}
