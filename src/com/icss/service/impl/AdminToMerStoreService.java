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
		//注入dao
		//System.out.println(merchantsStore.getTel());
		int allRecord = 0;//总页数
		int pageSize = 1;
		int count = (page-1)*size+1;   //page=2 即第二页，即从第5个开始找
		List<MerchantsStore> list = merchantsStoreDao.findMerchantsStore(merchantsStore);
		allRecord = list.size();
		pageSize = allRecord / size + 1;
		//把page请求的页数传对应的list，因为最多只传5个数据
		map.put("list", list);
		map.put("count", count);
		map.put("pageSize", pageSize);
		
		return map;
	}

	@Override
	public Map<String,Object> findMerchantsStore_audit(Integer page,Integer size) {
		// TODO Auto-generated method stub
		int allRecord = 0;//总页数
		int pageSize = 1;
		
		int count = (page-1)*size+1;   //page=2 即第二页，即从第5个开始找
		List<MerchantsStore_audit> list = merchantsStoreDao_auditDao.findMerchantsStore_audit();
		System.out.println("查询审核");
		allRecord = list.size();
		pageSize = allRecord / size + 1;
		//把page请求的页数传对应的list，因为最多只传5个数据
		map.put("list", list);
		map.put("count", count);
		map.put("pageSize", pageSize);
		System.out.println(list.size());
		return map;
	}

	@Override
	public Map<String, Object> updateMerchantsStore_audit(MerchantsStore_audit merchantsStore_audit) {
		// TODO Auto-generated method stub
		//修改的通过以后对商家表进行添加，使用事务
		String applyState = merchantsStore_audit.getApplyState();
		//int audit_id = merchantsStore_audit.getAudit_id();
		if ("通过".equals(applyState)) {
			int count = merchantsStoreDao_auditDao.updateApplyState(merchantsStore_audit);
			// 把一个这个商家查出来
			System.out.println("111111111111");
			List<MerchantsStore_audit> list = merchantsStoreDao_auditDao
					.findMerchantsStore_auditById(merchantsStore_audit);
			// 把这个查出来的数据遍历出来放到merchantsStore中，因为通过审核表肯定只有一个数据
			MerchantsStore merchantsStore = new MerchantsStore();
			// id是自增列
			merchantsStore.setBusinessName(list.get(0).getBusinessName());
			merchantsStore.setCompanyName(list.get(0).getCompanyName());
			merchantsStore.setDealerAddress(list.get(0).getDealerAddress());
			merchantsStore.setDealerType(list.get(0).getDealerType());
			merchantsStore.setPassword(list.get(0).getPassword());
			merchantsStore.setTel(list.get(0).getTel());
			merchantsStore.setState("1");
			System.out.println(merchantsStore.getBusinessName());
			// 插入这个查出来的商家到商家表
			int count1 = merchantsStoreDao.insertMerchantsStore(merchantsStore);
			System.out.println("同时更新两个");
			System.out.println("修改了" + count + "一条审核表的数据和添加了" + count1 + "一条商家数据");

		} else {
			int count = merchantsStoreDao_auditDao.updateApplyState(merchantsStore_audit);
			System.out.println("修改了"+count+"一条审核表的数据和添加了");
		}
		//int count = merchantsStoreDao_auditDao.updateApplyState(merchantsStore_audit);
		System.out.println("进入service");
		//System.out.println("修改了"+count+"条数据");
		return map;
	}

	@Override
	public Map<String, Object> findAllSaleCar(String keyword, Integer page, Integer size) {
		// TODO Auto-generated method stub
		System.out.println("进入service");
		return null;
	}

}
