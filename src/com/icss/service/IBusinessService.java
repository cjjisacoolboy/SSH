package com.icss.service;

import java.util.List;

import com.icss.pojo.CarInfo;
import com.icss.pojo.MerchantsStore;
import com.icss.pojo.SellerCar;
import com.icss.pojo.UserCollect;


//�̼Ҽ̳��ο�Ҳ����Ϊ�����ο͵Ĺ��ܣ�ͬ��Ҳ�ǻ������û��Ĺ���һ�������ڴ���Ĳ�����ͬ����֭�����οͽӿ�
public interface IBusinessService extends IVisitorService{
	//�̼ҿ��Լ����ղأ���������ϢID���û��Լ�����Ϣ�ù������ŵ��ղر��У�
	public int addCollect(MerchantsStore merchantsStore,CarInfo carInfo);
	//�ϼܿ��Բ鿴�Լ����ղ�
	public List<UserCollect> findCollect(MerchantsStore merchantsStore);
	//�̼ҽ����Լ����̼����ģ����Բ鿴�Լ����ĳ���
	public List<SellerCar> findSellerCar(MerchantsStore merchantsStore);
	//�̼ҿ����޸��Լ�������
	public int updateUser(MerchantsStore merchantsStore);
	
	
	
}
