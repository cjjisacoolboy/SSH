package com.icss.service;

import java.util.Map;

import com.icss.pojo.MerchantsStore;
import com.icss.pojo.Seller;
import com.icss.pojo.Userinfo;

public interface IVisitorService {
	//�οͿ���ͨ�����������ҳ���
	public Map<String,Object> findCar(String keyword);
	//�οͿ���ע���Ϊ�û�,�޸��û�����ʹ��map
	public boolean registerAsUser(Userinfo userinfo);
	//�οͿ��������Ϊ�̼ң�
	public boolean applyAsBussiness(MerchantsStore merchantsStore);
	//�ο͵�¼Ϊ�û�
	public boolean loginInUser(Userinfo userinfo);
	//�ο͵�¼Ϊ�̼�
	public boolean loginInBussiness(MerchantsStore merchantsStore);
	//�οͿ��Լ��복���Ա�
	public void addCompare(Integer carId,String ip);
	//�οͿ��Բ鿴�Ա�ͨ���Լ���ip
	public void checkCompare(String ip);
	//�οͿ����Ƴ��Աȱ����е�һ������
	public void removeCompare(Integer carId,String ip);
	//ԤԼ����������б����ύ
	public void order(Seller seller); 
	//�������� ����Ϊǰ̨�������ĳ������� ����������������ڣ��������Ʋ�ѯ��ID ���Բ鵽һ�ֵļ۸�
	public Integer evaluate(String carName, double km, String licenceDate);
}
