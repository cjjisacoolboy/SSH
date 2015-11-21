package com.icss.service;

import java.util.List;
import java.util.Map;

import com.icss.pojo.MerchantsStore;
import com.icss.pojo.Seller;
import com.icss.pojo.UserInfo;

public interface IVisitorService {
	//游客可以通过搜索器查找车辆
	public Map<String,Object> findCar(String keyword);
	//游客可以注册成为用户,修改用户数据使用map
	public boolean registerAsUser(UserInfo userInfo);
	//游客可以申请成为商家，
	public boolean applyAsBussiness(MerchantsStore merchantsStore);
	//游客登录为用户
	public List<UserInfo> loginInUser(UserInfo userInfo);
	//游客登录为商家
	public boolean loginInBussiness(MerchantsStore merchantsStore);
	//游客可以加入车辆对比
	public int addCompare(Integer carId,String ip);
	//游客可以查看对比通过自己的ip
	public int checkCompare(String ip);
	//游客可以移除对比表其中的一个车辆
	public int removeCompare(Integer carId,String ip);
	//预约卖车这里会有表单的提交
	public int order(Seller seller); 
	//车辆估价 数据为前台传过来的车辆名称 ，里程数，上牌日期，车辆名称查询到ID 可以查到一手的价格
	public int evaluate(String carName, double km, String licenceDate);
}
