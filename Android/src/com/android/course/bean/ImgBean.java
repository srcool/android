package com.android.course.bean;

//���ڴ�ſγ̽������ͼƬ
public class ImgBean {
	private int courseBigImg;
	
	//���췽����
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