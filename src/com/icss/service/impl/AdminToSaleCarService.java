package com.icss.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icss.dao.ICarDao;
import com.icss.dao.ICheckerDao;
import com.icss.dao.ISellerCarDao;
import com.icss.pojo.CarInfo;
import com.icss.pojo.CheckerInfo;
import com.icss.pojo.Image;
import com.icss.pojo.MerchantsStore;
import com.icss.pojo.MerchantsStore_audit;
import com.icss.pojo.ProcedureInfo;
import com.icss.pojo.SecondPrice;
import com.icss.pojo.Seller;
import com.icss.pojo.SellerCar;
import com.icss.service.IAdminService;

public class AdminToSaleCarService implements IAdminService {
	private ISellerCarDao sellerCarDao;
	private ICarDao carDao;
	private ICheckerDao checkerDao;
	private Map<String,Object> map = new HashMap<String,Object>();
	
	public void setSellerCarDao(ISellerCarDao sellerCarDao) {
		this.sellerCarDao = sellerCarDao;
	}

	public void setCarDao(ICarDao carDao) {
		this.carDao = carDao;
	}

	@Override
	public Map<String, Object> findMerchantsStore(MerchantsStore merchantsStore, Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> findMerchantsStore_audit(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateMerchantsStore_audit(MerchantsStore_audit merchantsStore_audit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> findAllSaleCar(String keyword, Integer page, Integer size) {
		//System.out.println("������salesservice");
		//������ж��ֳ�
		int allRecord = 0;//��ҳ��
		int pageSize = 1;
		int count = (page-1)*size;   //page=2 ���ڶ�ҳ�����ӵ�5����ʼ��
		
		List<SellerCar> list =  sellerCarDao.findSaleCars(keyword);
		allRecord = list.size();
		for(int i = 0; i < list.size(); i++){
			Seller seller = new Seller();
			MerchantsStore merchantsStore = new MerchantsStore();
			
			String carName = "";
			seller.setSellerName("�Ǹ���");
			merchantsStore.setCompanyName("����"); 
			CarInfo carInfo = new CarInfo();
			//System.out.println("����ѭ��");
			//�������ҳ���
//			try{
			List<CarInfo> carList = carDao.findCarAllNameById(list.get(i).getCarInfo().getCarId());
			carName = carList.get(0).getCarBrand()+carList.get(0).getCarseries()+carList.get(0).getCarName();
//			} catch (Exception e){
//				e.printStackTrace();
//			}
			//System.out.println(list.get(0).getCarInfo().getPId());
			
			carInfo.setCarName(carName);

			list.get(i).setCarInfo(carInfo);
			//��Ϊ��map ��seller �� merchantsStore �ֱ�ȡ����
			//System.out.println(list.get(0).getSeller());

			if(list.get(i).getSeller() != null){
				list.get(i).setMerchantsStore(merchantsStore);
			} else {
				list.get(i).setSeller(seller);;
			}
	
			//System.out.println(list.get(i).getMerchantsStore().getCompanyName());


		//�ѳ���ȫ��ȡ����
		//System.out.println(list.get(0).getSeller());

		}
		
		pageSize = allRecord / size + 1;
		//��page�����ҳ������Ӧ��list����Ϊ���ֻ��5������
		map.put("list", list);
		map.put("count", count);
		map.put("pageSize", pageSize);
		//System.out.println("�뿪��salesservice");
		return map;
	}
	
	public Map<String,Object> findCarDetail(int sellerCarId){
		//System.out.println("�����ѯ����service");
		//�Ѷ��ֳ�����Ϣ�����
		//������Ƕ�׾�ʹ��list�������û�о�ֱ����ʵ��������
		ProcedureInfo procedureInfo;
		MerchantsStore merchantsStore;
		Seller seller;
		List<CarInfo> carList;
		Image image;
		SecondPrice secondPrice;
		List<SellerCar> sellerCarList = sellerCarDao.findSellerCarById(sellerCarId);
		//System.out.println(sellerCarList.size());
		
		if(sellerCarList != null){
			merchantsStore = new MerchantsStore();
			seller = new Seller();
			
			//�ó�������id�ٲ�ѯ  ʹ��carDao
//			try{
			carList = carDao.findCarById(sellerCarList.get(0).getCarInfo().getCarId());
			
			List<CarInfo> carNameList = carDao.findCarAllNameById(sellerCarList.get(0).getCarInfo().getCarId());
			String carName = carNameList.get(0).getCarBrand()+carNameList.get(0).getCarseries()+carNameList.get(0).getCarName();
			carList.get(0).setCarName(carName);
			//System.out.println(carList.get(0).getCarName());
			//ͼƬֱ��ȥ����
			image = sellerCarList.get(0).getImage();
			
			//���̼���Ϣȥ����
			if(sellerCarList.get(0).getSeller() != null){
				
				merchantsStore.setCompanyName("����");
				sellerCarList.get(0).setMerchantsStore(merchantsStore);
				seller = sellerCarList.get(0).getSeller();
				merchantsStore = sellerCarList.get(0).getMerchantsStore();
				//System.out.println(merchantsStore.getBusinessName());
				//System.out.println(seller.getSellerName());
			} else {
				seller.setSellerName("�Ǹ���");
				sellerCarList.get(0).setSeller(seller);
				seller = sellerCarList.get(0).getSeller();
				merchantsStore = sellerCarList.get(0).getMerchantsStore();
				//System.out.println(merchantsStore.getBusinessName());
				//System.out.println(seller.getSellerName());
			}
			//�������
			procedureInfo = sellerCarList.get(0).getProcedureInfo();
			//�Ѷ��ּ۸������ó���
			//List<SecondPrice> secondPrinceList = 
			secondPrice = sellerCarList.get(0).getSecondPrice();
			//System.out.println(sellerCarList.get(0).getSecondPrice().getCheckerInfo());
			//���ʦ
			CheckerInfo checkerInfo = sellerCarList.get(0).getSecondPrice().getCheckerInfo();
			//List<CheckerInfo> checkerList = checkerDao.findCheckerById(secondPrice);
			map.put("carList",carList);
			map.put("image", image);
			
			map.put("merchantsStore",merchantsStore);
			map.put("seller", seller);
			map.put("procedureInfo",procedureInfo);
			map.put("secondPrice", secondPrice);
			map.put("checkerInfo", checkerInfo);
//			} catch(Exception e){
//				e.printStackTrace();
//				
//			}
		}
			
		System.out.println("�뿪service");
		map.put("sellerCarList",sellerCarList);

		
		
		return map;
		
	}

}
