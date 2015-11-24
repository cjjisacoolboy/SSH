package com.icss.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icss.dao.ICarDao;
import com.icss.dao.ITestDao;
import com.icss.pojo.CarInfo;
import com.icss.pojo.test.Course_info;
import com.icss.service.ITestService;

public class TestService implements ITestService {
	//private ITestDao testDao;
	private ICarDao carDao;
	private Map<String,Object>map = new HashMap<String,Object>();
	private CarInfo carInfo;
	
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}


	public void setCarDao(ICarDao carDao) {
		this.carDao = carDao;
	}


	public void setCarinfo(CarInfo carInfo) {
		this.carInfo = carInfo;
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		//testDao.test();
	}
	@Override
	public Map<String,Object> findCar(String keyword) {
		//List<CarInfo> carList = carDao.findCarAllNameByCarName(keyword);
		//carName = carList.get(0).getCarBrand()+carList.get(0).getCarseries()+carList.get(0).getCarName();
		String findword = keyword+"%";
		//carInfo.setCarName(findword);
		List<CarInfo> list = new ArrayList<CarInfo>();
		// TODO Auto-generated method stub
		try {
			list = carDao.findCarByCarName(findword);
			//list = carDao.findCarByCarNameOfLimit(findword);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//list = (List<CarInfo>) map.get("list");
		int listSize = list.size();
		System.out.println(listSize);
		if(0 == listSize){
			list = carDao.findCarByCarType(findword);
		}
		map.put("list",list);
		return map;
	}

	@Override
	public Map<String,Object> findCarByLimit(String keyword,String type) {
		List<CarInfo> list = new ArrayList<CarInfo>();
		String findword = keyword+"%";
		if(keyword.length()==0){
			findword="%%";
		}
		if("品牌".equals(type)){
			try {
				list = carDao.findCarByCarNameOfLimit(findword);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if("车系".equals(type)){
			list = findSeriesByCarName(findword);
		} else {
			System.out.println("找车名");
			//先查出传进来的车的id
			try {
				List<CarInfo> idList = carDao.findId(keyword);
				//查出来的id作为父id，查出需要的车
				if(idList.size()!=0){
					list = carDao.findCarNameByPId(idList.get(0).getCarId());
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
			//System.out.println(list.get(0).getCarName());
		}

		//System.out.println(keyword.length()+"-------------------------");
		
		
		
		//list = (List<CarInfo>) map.get("list");
		int listSize = list.size();
		//System.out.println(listSize);
		System.out.println("完成查询");
		map.put("list",list);
		return map;
	}


	@Override
	public List<CarInfo> findSeriesByCarName(String keyword) {
		// TODO Auto-generated method stub
		
		return carDao.findSeriesByCarName(keyword);
	}


	@Override
	public Map<String, Object> findCarNameByPId(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
