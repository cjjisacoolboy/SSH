package com.icss.pojo;

public class Course_info {
	private int course_id;
	private String course_name;
	private float credit;
	private int period;
	private Teacher_info teacher_info;
	private String lessontime;
	private String introduction;
	public Teacher_info getTeacher_info() {
		return teacher_info;
	}
	public void setTeacher_info(Teacher_info teacher_info) {
		this.teacher_info = teacher_info;
	}
	public Academe_info getAcademe_info() {
		return academe_info;
	}
	public void setAcademe_info(Academe_info academe_info) {
		this.academe_info = academe_info;
	}
	private int stunumber;
	private Academe_info academe_info;
	
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public float getCredit() {
		return credit;
	}
	public void setCredit(float credit) {
		this.credit = credit;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}

	public String getLessontime() {
		return lessontime;
	}
	public void setLessontime(String lessontime) {
		this.lessontime = lessontime;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public int getStunumber() {
		return stunumber;
	}
	public void setStunumber(int stunumber) {
		this.stunumber = stunumber;
	}

}
