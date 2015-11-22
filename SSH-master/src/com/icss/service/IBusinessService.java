package com.icss.service;

import java.util.List;

import com.icss.pojo.CarInfo;
import com.icss.pojo.MerchantsStore;
import com.icss.pojo.SellerCar;
import com.icss.pojo.UserCollect;


//商家继承游客也是因为具有游客的功能，同样也是基本和用户的功能一样，由于传入的参数不同所以汁即成游客接口
public interface IBusinessService extends IVisitorService{
	//商家可以加入收藏（将车的信息ID和用户自己的信息拿过来，放到收藏表中）
	public int addCollect(MerchantsStore merchantsStore,CarInfo carInfo);
	//上架可以查看自己的收藏
	public List<UserCollect> findCollect(MerchantsStore merchantsStore);
	//商家进入自己的商家中心，可以查看自己卖的车辆
	public List<SellerCar> findSellerCar(MerchantsStore merchantsStore);
	//商家可以修改自己的密码
	public int updateUser(MerchantsStore merchantsStore);
	
	
	
}
