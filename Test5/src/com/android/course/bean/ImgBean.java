package com.android.course.bean;

//用于存放课程介绍里的图片
public class ImgBean {
	private int courseBigImg;
	
	//构造方法：
		public ImgBean(int courseBigImg) {
			super();
			this.courseBigImg = courseBigImg;
		}

		
		
		public int getCourseImg() {
			return courseBigImg;
		}



		public void setCourseImg(int courseBigImg) {
			this.courseBigImg = courseBigImg;
		}
}