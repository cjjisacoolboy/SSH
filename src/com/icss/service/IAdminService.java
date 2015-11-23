package com.icss.service;

import java.util.List;
import java.util.Map;

import com.icss.pojo.EmpInfo;
import com.icss.pojo.MerchantsStore_audit;



public interface IAdminService {
	public Map<String, Object> findempInfo();
	public Map<String,Object> selectOneEmp(String empId);
	//public List<EmpInfo> updateemp(EmpInfo empInfo);
	public int updateEmp(EmpInfo empInfo,int imageId);
	public int deEmp(String Id);
}
