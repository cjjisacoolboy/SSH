package com.icss.service;

import java.util.List;

import com.icss.pojo.CarInfo;
import com.icss.pojo.SellerCar;
import com.icss.pojo.UserCollect;
import com.icss.pojo.UserInfo;

//�̳��ο�����Ϊ�û�Ҳ���ο͵Ĺ���
public interface IUserService extends IVisitorService{
	//�û����Լ����ղأ���������ϢID���û��Լ�����Ϣ�ù������ŵ��ղر��У�
	public int addCollect(UserInfo userInfo,CarInfo carInfo);
	//�û����Բ鿴�Լ����ղ�
	public List<UserCollect> findCollect(UserInfo userInfo);
	//�û������Լ��ĸ������ģ����Բ鿴�Լ����ĳ���
	public List<SellerCar> findSellerCar(UserInfo uerInfo);
	//�û������޸��Լ�������
	public int updateUser(UserInfo userInfo);
	
}
