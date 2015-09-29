package com.android.course.bean;

public class Bean {
	private int courseImg;
	private String courseName;
	private String teacherName;
	private String courseAttribute;
		


	//构造方法2：
	public Bean(int courseImg, String courseName, String teacherName, String courseAttribute) {
		super();
		this.courseImg = courseImg;
		this.courseName = courseName;
		this.teacherName = teacherName;
		this.courseAttribute= courseAttribute;
	}

	
	
	public int getCourseImg() {
		return courseImg;
	}



	public void setCourseImg(int courseImg) {
		this.courseImg = courseImg;
	}



	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	public String getCourseAttribute() {
		return courseAttribute;
	}

	public void setCourseAttribute(String courseAttribute) {
		this.courseAttribute = courseAttribute;
	}
	
	
}

