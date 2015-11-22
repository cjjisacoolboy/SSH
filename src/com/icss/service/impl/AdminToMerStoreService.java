package com.icss.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icss.dao.IMerchantsStoreDao;
import com.icss.dao.IMerchantsStore_auditDao;
import com.icss.dao.ISellerCarDao;
import com.icss.pojo.MerchantsStore;
import com.icss.pojo.MerchantsStore_audit;
import com.icss.service.IAdminService;

public class AdminToMerStoreService implements IAdminService {
	private Map<String,Object> map = new HashMap<String,Object>();
	private IMerchantsStoreDao merchantsStoreDao;
	private IMerchantsStore_auditDao merchantsStoreDao_auditDao;
	private ISellerCarDao sellerCarDao;
	
	public void setMerchantsStoreDao_auditDao(IMerchantsStore_auditDao merchantsStoreDao_auditDao) {
		this.merchantsStoreDao_auditDao = merchantsStoreDao_auditDao;
	}
	
	public void setMerchantsStoreDao(IMerchantsStoreDao merchantsStoreDao) {
		this.merchantsStoreDao = merchantsStoreDao;
	}

	@Override
	public Map<String,Object> findMerchantsStore(MerchantsStore merchantsStore,Integer page,Integer size) {
		// TODO Auto-generated method stub
		//ע��dao
		//System.out.println(merchantsStore.getTel());
		int allRecord = 0;//��ҳ��
		int pageSize = 1;
		int count = (page-1)*size+1;   //page=2 ���ڶ�ҳ�����ӵ�5����ʼ��
		List<MerchantsStore> list = merchantsStoreDao.findMerchantsStore(merchantsStore);
		allRecord = list.size();
		pageSize = allRecord / size + 1;
		//��page�����ҳ������Ӧ��list����Ϊ���ֻ��5������
		map.put("list", list);
		map.put("count", count);
		map.put("pageSize", pageSize);
		
		return map;
	}

	@Override
	public Map<String,Object> findMerchantsStore_audit(Integer page,Integer size) {
		// TODO Auto-generated method stub
		int allRecord = 0;//��ҳ��
		int pageSize = 1;
		
		int count = (page-1)*size+1;   //page=2 ���ڶ�ҳ�����ӵ�5����ʼ��
		List<MerchantsStore_audit> list = merchantsStoreDao_auditDao.findMerchantsStore_audit();
		System.out.println("��ѯ���");
		allRecord = list.size();
		pageSize = allRecord / size + 1;
		//��page�����ҳ������Ӧ��list����Ϊ���ֻ��5������
		map.put("list", list);
		map.put("count", count);
		map.put("pageSize", pageSize);
		System.out.println(list.size());
		return map;
	}

	@Override
	public Map<String, Object> updateMerchantsStore_audit(MerchantsStore_audit merchantsStore_audit) {
		// TODO Auto-generated method stub
		//�޸ĵ�ͨ���Ժ���̼ұ������ӣ�ʹ������
		String applyState = merchantsStore_audit.getApplyState();
		//int audit_id = merchantsStore_audit.getAudit_id();
		if ("ͨ��".equals(applyState)) {
			int count = merchantsStoreDao_auditDao.updateApplyState(merchantsStore_audit);
			// ��һ������̼Ҳ����
			System.out.println("111111111111");
			List<MerchantsStore_audit> list = merchantsStoreDao_auditDao
					.findMerchantsStore_auditById(merchantsStore_audit);
			// ���������������ݱ��������ŵ�merchantsStore�У���Ϊͨ����˱�϶�ֻ��һ������
			MerchantsStore merchantsStore = new MerchantsStore();
			// id��������
			merchantsStore.setBusinessName(list.get(0).getBusinessName());
			merchantsStore.setCompanyName(list.get(0).getCompanyName());
			merchantsStore.setDealerAddress(list.get(0).getDealerAddress());
			merchantsStore.setDealerType(list.get(0).getDealerType());
			merchantsStore.setPassword(list.get(0).getPassword());
			merchantsStore.setTel(list.get(0).getTel());
			merchantsStore.setState("1");
			System.out.println(merchantsStore.getBusinessName());
			// ���������������̼ҵ��̼ұ�
			int count1 = merchantsStoreDao.insertMerchantsStore(merchantsStore);
			System.out.println("ͬʱ��������");
			System.out.println("�޸���" + count + "һ����˱�����ݺ������" + count1 + "һ���̼�����");

		} else {
			int count = merchantsStoreDao_auditDao.updateApplyState(merchantsStore_audit);
			System.out.println("�޸���"+count+"һ����˱�����ݺ������");
		}
		//int count = merchantsStoreDao_auditDao.updateApplyState(merchantsStore_audit);
		System.out.println("����service");
		//System.out.println("�޸���"+count+"������");
		return map;
	}

	@Override
	public Map<String, Object> findAllSaleCar(String keyword, Integer page, Integer size) {
		// TODO Auto-generated method stub
		System.out.println("����service");
		return null;
	}

}
