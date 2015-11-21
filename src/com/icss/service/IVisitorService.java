package com.icss.service;

import java.util.List;
import java.util.Map;

import com.icss.pojo.MerchantsStore;
import com.icss.pojo.Seller;
import com.icss.pojo.UserInfo;

public interface IVisitorService {
	//�οͿ���ͨ�����������ҳ���
	public Map<String,Object> findCar(String keyword);
	//�οͿ���ע���Ϊ�û�,�޸��û�����ʹ��map
	public boolean registerAsUser(UserInfo userInfo);
	//�οͿ��������Ϊ�̼ң�
	public boolean applyAsBussiness(MerchantsStore merchantsStore);
	//�ο͵�¼Ϊ�û�
	public List<UserInfo> loginInUser(UserInfo userInfo);
	//�ο͵�¼Ϊ�̼�
	public boolean loginInBussiness(MerchantsStore merchantsStore);
	//�οͿ��Լ��복���Ա�
	public int addCompare(Integer carId,String ip);
	//�οͿ��Բ鿴�Ա�ͨ���Լ���ip
	public int checkCompare(String ip);
	//�οͿ����Ƴ��Աȱ����е�һ������
	public int removeCompare(Integer carId,String ip);
	//ԤԼ����������б����ύ
	public int order(Seller seller); 
	//�������� ����Ϊǰ̨�������ĳ������� ����������������ڣ��������Ʋ�ѯ��ID ���Բ鵽һ�ֵļ۸�
	public int evaluate(String carName, double km, String licenceDate);
}
