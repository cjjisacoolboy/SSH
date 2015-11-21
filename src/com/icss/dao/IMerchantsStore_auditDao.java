package com.icss.dao;

import java.util.List;

import com.icss.pojo.MerchantsStore_audit;

public interface IMerchantsStore_auditDao {
	List<MerchantsStore_audit> findMerchantsStore_audit();
	List<MerchantsStore_audit> findMerchantsStore_auditById(MerchantsStore_audit merchantsStore_audit);
	int updateApplyState(MerchantsStore_audit merchantsStore_audit);
	
}
