package com.icss.action;

import java.util.HashMap;
import java.util.Map;

import com.icss.pojo.MerchantsStore_audit;
import com.icss.service.IAdminService;

public class DoMer_auditAction {
	private IAdminService adminToMerStoreService;
	private int audit_id;
	private String applyState;
	private MerchantsStore_audit merchantsStore_audit;
	private Map<String,Object> map = new HashMap<String,Object>();
	
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public int getAudit_id() {
		return audit_id;
	}

	public void setAudit_id(int audit_id) {
		this.audit_id = audit_id;
	}

	public String getApplyState() {
		return applyState;
	}

	public void setApplyState(String applyState) {
		this.applyState = applyState;
	}

	public MerchantsStore_audit getMerchantsStore_audit() {
		return merchantsStore_audit;
	}

	public void setMerchantsStore_audit(MerchantsStore_audit merchantsStore_audit) {
		this.merchantsStore_audit = merchantsStore_audit;
	}


	public void setAdminToMerStoreService(IAdminService adminToMerStoreService) {
		this.adminToMerStoreService = adminToMerStoreService;
	}

	public String execute(){
		merchantsStore_audit = new MerchantsStore_audit();
		//System.out.println(audit_id);
		//System.out.println(applyState);
		merchantsStore_audit.setAudit_id(audit_id);
		merchantsStore_audit.setApplyState(applyState);
		map = adminToMerStoreService.updateMerchantsStore_audit(merchantsStore_audit);
		//System.out.println(merchantsStore_audit);
		System.out.println("½øÈëµ½action");
		return "success";
	}
}
