package com.icss.pojo;

public class SecondPrice {
	private int secondpriceid;
	private int secondPrice;
	private double km;
	private String buyTime;
	private CheckerInfo CheckerInfo;//¼ì²âÊ¦µÄId
	
	
	public int getSecondpriceid() {
		return secondpriceid;
	}
	public void setSecondpriceid(int secondpriceid) {
		this.secondpriceid = secondpriceid;
	}
	public int getSecondPrice() {
		return secondPrice;
	}
	public void setSecondPrice(int secondPrice) {
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
