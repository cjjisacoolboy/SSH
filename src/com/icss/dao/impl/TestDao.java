package com.icss.dao.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.icss.dao.ITestDao;
import com.icss.pojo.Course_info;
import com.icss.pojo.test.Carinfo;

public class TestDao implements ITestDao {
	
	private Course_info course_info = new Course_info();
	private NamedParameterJdbcTemplate jt;     //声明jt 数据库模板
	public void setJt(NamedParameterJdbcTemplate jt) {
		this.jt = jt;
	}
	
	private Map<String,Object>map = new HashMap<String,Object>();
	String keyword;
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	@Override
	public void add() {
		 String mybatisConfigXml = "mybatis-config.xml";
	        SqlSession session = null;
	        try {
				Reader reader = 
						Resources.getResourceAsReader(mybatisConfigXml);
				//将prop作为参数传入到build方法中BEGIN
//				Properties prop = new Properties();
//				prop.put("username", "bbb");
//				SqlSessionFactory factory = 
//						new SqlSessionFactoryBuilder().build(reader,prop);
				//将prop作为参数传入到build方法中END
				SqlSessionFactory factory = 
						new SqlSessionFactoryBuilder().build(reader);
				session = factory.openSession();
				
	
				List<Course_info>list = 
						session.selectList("myBatis.Course_info.selectAll");
				System.out.println(list);
				for (int i = 0;i < list.size();i ++) {
					Course_info ci = list.get(i);
					String course_name = ci.getCourse_name();
					String academe_name = ci.getAcademe_info().getAcademe_name();
					String teacher_name = ci.getTeacher_info().getTeacher_name();
					System.out.println("课程名称：" + course_name + "||学院名称：" + academe_name + "||老师姓名：" + teacher_name);
				}
				//提交事务
				session.commit();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				session.close();
			}
	        System.out.println("添加了一条数据！");
		}
		// TODO Auto-generated method stub

	@Override
	public Map<String, Object> findCarByCarName(String keyword) {
		// TODO Auto-generated method stub
		this.keyword = keyword + "%";
		String mybatisConfigXml = "mybatis-config.xml";
        SqlSession session = null;
        try {
			Reader reader = 
					Resources.getResourceAsReader(mybatisConfigXml);
			//将prop作为参数传入到build方法中BEGIN
//			Properties prop = new Properties();
//			prop.put("username", "bbb");
//			SqlSessionFactory factory = 
//					new SqlSessionFactoryBuilder().build(reader,prop);
			//将prop作为参数传入到build方法中END
			SqlSessionFactory factory = 
					new SqlSessionFactoryBuilder().build(reader);
			session = factory.openSession();
			
			//System.out.println("8888888888");
			List<Carinfo> list = 
					session.selectList("myBatis.Carinfo.selectCarinfoByCarName",this.keyword);
			//System.out.println(list);
//			for (int i = 0;i < list.size();i ++) {
//				Carinfo ci = list.get(i);
//				Integer carId = ci.getCarId();
//				Integer PId = ci.getPId();
//				String carName = ci.getCarName();
//				String carType = ci.getCarType();
//				Integer price = ci.getPrice();
//				System.out.println("ID：" + carId + "||从属ID：" + PId + "||车辆名称：" + carName + "||车辆类型：" + carType +"||价格："+price );
//			}
			//提交事务
			map.put("list",list);
			session.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		String data = "seven head";
		System.out.println("找到数据！");
		return map;
	}

	@Override
	public Map<String, Object> findCarByCarType(String keyword) {
		// TODO Auto-generated method stub
				this.keyword = keyword + "%";
				String mybatisConfigXml = "mybatis-config.xml";
		        SqlSession session = null;
		        try {
					Reader reader = 
							Resources.getResourceAsReader(mybatisConfigXml);

					SqlSessionFactory factory = 
							new SqlSessionFactoryBuilder().build(reader);
					session = factory.openSession();
					
					//System.out.println("8888888888");
					List<Carinfo> list = 
							session.selectList("myBatis.Carinfo.selectCarinfoByCarType",this.keyword);
					//System.out.println(list);
					for (int i = 0;i < list.size();i ++) {
						Carinfo ci = list.get(i);
						Integer carId = ci.getCarId();
						Integer PId = ci.getPId();
						String carName = ci.getCarName();
						String carType = ci.getCarType();
						Integer price = ci.getPrice();
						System.out.println("ID：" + carId + "||从属ID：" + PId + "||车辆名称：" + carName + "||车辆类型：" + carType +"||价格："+price );
					}
					//提交事务
					map.put("list",list);
					session.commit();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					session.close();
				}
				System.out.println("找到数据！");
				return map;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		String sql ="SELECT *"
				+ "FROM course_info_demo CID NATURAL JOIN academe_info AI "
				+ "NATURAL JOIN TEACHER_INFO_DEMO TID";
//		
//		Test ps =  (Test) wac.getBean("test");
		SqlParameterSource sp = new BeanPropertySqlParameterSource(course_info);
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println(jt);
		SqlRowSet srs = jt.queryForRowSet(sql, sp);
		while(srs.next()){
			System.out.println(srs.getString("course_name"));
			
		}
		System.out.println("测试成功！");
	}

	@Override
	public List<Course_info> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
		

}
