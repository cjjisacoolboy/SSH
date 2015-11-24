package com.icss.action;

import com.icss.pojo.SellerCar;

public class UpdateSellerCarAction {
	private SellerCar sellerCar;
	
	public void setSellerCar(SellerCar sellerCar) {
		this.sellerCar = sellerCar;
	}
	
	public SellerCar getSellerCar() {
		return sellerCar;
	}

	public String execute(){
		System.out.println(sellerCar.getSellerCarId());
		
		return "success";
		
	}
}
