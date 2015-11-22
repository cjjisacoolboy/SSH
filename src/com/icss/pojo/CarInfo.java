package com.icss.pojo;

public class CarInfo {
	//Î´Íê³É
	private int CarId;
	private int PId;
	private String carName;
	private String carType;
	private int price;
	private CarEngine carEngine;
	private CarbodyInfo CarbodyInfo;
	private BasicParameters BasicParameters;
	private ParametersConfig parametersConfig;
	
	public int getCarId() {
		return CarId;
	}
	public void setCarId(int carId) {
		CarId = carId;
	}
	public int getPId() {
		return PId;
	}
	public void setPId(int pId) {
		PId = pId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public CarEngine getCarEngine() {
		return carEngine;
	}
	public void setCarEngine(CarEngine carEngine) {
		this.carEngine = carEngine;
	}
	public CarbodyInfo getCarbodyInfo() {
		return CarbodyInfo;
	}
	public void setCarbodyInfo(CarbodyInfo carbodyInfo) {
		CarbodyInfo = carbodyInfo;
	}
	public BasicParameters getBasicParameters() {
		return BasicParameters;
	}
	public void setBasicParameters(BasicParameters basicParameters) {
		BasicParameters = basicParameters;
	}
	public ParametersConfig getParametersConfig() {
		return parametersConfig;
	}
	public void setParametersConfig(ParametersConfig parametersConfig) {
		this.parametersConfig = parametersConfig;
	}
	
	
}
