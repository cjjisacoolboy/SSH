package com.icss.service;

import java.util.List;
import java.util.Map;

import com.icss.pojo.MerchantsStore;
import com.icss.pojo.MerchantsStore_audit;


public interface IAdminService {
	//�̼���Ϣ��ѯ����ѯ���ͨ�����̼� �������������ѯ
	public Map<String, Object> findMerchantsStore(MerchantsStore merchantsStore,Integer page,Integer size);
	//��ѯ��˱������ 
	public Map<String, Object> findMerchantsStore_audit(Integer page,Integer size);
	//�޸���˱��״̬�����ܹ�����״̬����update,ma���Է���һ��html����
	public Map<String, Object> updateMerchantsStore_audit(MerchantsStore_audit merchantsStore_audit);
	//�鿴���ֳ��ĳ�����
	
	
}
