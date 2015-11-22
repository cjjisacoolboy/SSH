package com.icss.pojo;

public class SecondPrice {
	private Integer secondpriceid;
	private Integer secondPrice;
	private double km;
	private String buyTime;
	private CheckerInfo CheckerInfo;//¼ì²âÊ¦µÄId
	public Integer getSecondpriceid() {
		return secondpriceid;
	}
	public void setSecondpriceid(Integer secondpriceid) {
		this.secondpriceid = secondpriceid;
	}
	public Integer getSecondPrice() {
		return secondPrice;
	}
	public void setSecondPrice(Integer secondPrice) {
		this.secondPrice = secondPrice;
	}
	public double getKm() {
		return km;
	}
	public void setKm(double km) {
		this.km = km;
	}
	public String getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}
	public CheckerInfo getCheckerInfo() {
		return CheckerInfo;
	}
	public void setCheckerInfo(CheckerInfo checkerInfo) {
		CheckerInfo = checkerInfo;
	}
	
}
