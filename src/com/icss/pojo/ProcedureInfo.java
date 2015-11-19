package com.icss.pojo;

public class ProcedureInfo {
	private Integer procedureId;
	private Integer transferNumber;
	private String useProperties;
	private String transferProcedures;
	private String lastDate;
	private String validityPeriod;
	private String maintenance;
	
	
	public Integer getProcedureId() {
		return procedureId;
	}
	public void setProcedureId(Integer procedureId) {
		this.procedureId = procedureId;
	}
	public Integer getTransferNumber() {
		return transferNumber;
	}
	public void setTransferNumber(Integer transferNumber) {
		this.transferNumber = transferNumber;
	}
	public String getUseProperties() {
		return useProperties;
	}
	public void setUseProperties(String useProperties) {
		this.useProperties = useProperties;
	}
	public String getTransferProcedures() {
		return transferProcedures;
	}
	public void setTransferProcedures(String transferProcedures) {
		this.transferProcedures = transferProcedures;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public String getValidityPeriod() {
		return validityPeriod;
	}
	public void setValidityPeriod(String validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
	public String getMaintenance() {
		return maintenance;
	}
	public void setMaintenance(String maintenance) {
		this.maintenance = maintenance;
	}
}
