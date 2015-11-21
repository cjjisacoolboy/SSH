package com.icss.dao;

import java.util.List;

import com.icss.pojo.UserInfo;

public interface IUserDao {
	List<UserInfo> findUser(UserInfo userInfo);
}
