package com.icss.pojo;

public class SellerCar {
	private Integer sellerCarId;
	private Seller seller; //卖家的信息id
	private MerchantsStore merchantsStore; //商家的信息id
	private CarInfo carInfo;  //车辆的信息
	private SecondPrice secondPrice; //二手价格的id
	private Image image; //图片的id
	private String address;//看车地点
	private Integer tel;
	private String carPlate;//车牌号码
	private ProcedureInfo procedureInfo; //手续情况id
	public Integer getSellerCarId() {
		return sellerCarId;
	}
	public void setSellerCarId(Integer sellerCarId) {
		this.sellerCarId = sellerCarId;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public MerchantsStore getMerchantsStore() {
		return merchantsStore;
	}
	public void setMerchantsStore(MerchantsStore merchantsStore) {
		this.merchantsStore = merchantsStore;
	}
	public CarInfo getCarInfo() {
		return carInfo;
	}
	public void setCarInfo(CarInfo carInfo) {
		this.carInfo = carInfo;
	}
	public SecondPrice getSecondPrice() {
		return secondPrice;
	}
	public void setSecondPrice(SecondPrice secondPrice) {
		this.secondPrice = secondPrice;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getTel() {
		return tel;
	}
	public void setTel(Integer tel) {
		this.tel = tel;
	}
	public String getCarPlate() {
		return carPlate;
	}
	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}
	public ProcedureInfo getProcedureInfo() {
		return procedureInfo;
	}
	public void setProcedureInfo(ProcedureInfo procedureInfo) {
		this.procedureInfo = procedureInfo;
	}
	
	
	
	
	
}
