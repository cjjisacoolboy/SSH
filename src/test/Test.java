package test;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.icss.pojo.Course_info;

public class Test {
	private static Course_info course_info = new Course_info();
	private static NamedParameterJdbcTemplate jt;     //声明jt 数据库模板
	public void setJt(NamedParameterJdbcTemplate jt) {
		this.jt = jt;
	}
	public static NamedParameterJdbcTemplate getJt() {
		return jt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
//		ServletContext sc = ServletActionContext.getServletContext();
////		WebApplicationContext wac = WebApplicationContextUtils
////				.getWebApplicationContext(sc);
//		WebApplicationContext wac = WebApplicationContextUtils
//				.getWebApplicationContext(sc);
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

}
