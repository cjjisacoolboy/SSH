package com.icss.service;

import java.util.List;
import java.util.Map;

import com.icss.pojo.MerchantsStore;
import com.icss.pojo.MerchantsStore_audit;


public interface IAdminService {
	//商家信息查询，查询审核通过的商家 这里包含条件查询
	public Map<String, Object> findMerchantsStore(MerchantsStore merchantsStore,Integer page,Integer size);
	//查询审核表的内容 
	public Map<String, Object> findMerchantsStore_audit(Integer page,Integer size);
	//修改审核表的状态，接受过来的状态就行update,ma可以返回一个html代码
	public Map<String, Object> updateMerchantsStore_audit(MerchantsStore_audit merchantsStore_audit);
	//查看二手车的车辆，
	
	
}
