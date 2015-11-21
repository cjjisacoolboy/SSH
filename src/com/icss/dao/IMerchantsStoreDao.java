package com.icss.dao;

import java.util.List;

import com.icss.pojo.MerchantsStore;

public interface IMerchantsStoreDao {
	List<MerchantsStore> findMerchantsStore(MerchantsStore merchantsStore);
	int insertMerchantsStore(MerchantsStore merchantsStore);
}
