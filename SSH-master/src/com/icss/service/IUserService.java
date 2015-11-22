package com.icss.service;

import java.util.List;

import com.icss.pojo.CarInfo;
import com.icss.pojo.SellerCar;
import com.icss.pojo.UserCollect;
import com.icss.pojo.UserInfo;

//继承游客是因为用户也有游客的功能
public interface IUserService extends IVisitorService{
	//用户可以加入收藏（将车的信息ID和用户自己的信息拿过来，放到收藏表中）
	public int addCollect(UserInfo userInfo,CarInfo carInfo);
	//用户可以查看自己的收藏
	public List<UserCollect> findCollect(UserInfo userInfo);
	//用户进入自己的个人中心，可以查看自己卖的车辆
	public List<SellerCar> findSellerCar(UserInfo uerInfo);
	//用户可以修改自己的密码
	public int updateUser(UserInfo userInfo);
	
}
