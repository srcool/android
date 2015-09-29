package com.android.course.bean;

import com.example.netease.R;

public class AllcoursesBigImg {
	public ImgBean[] allcoursesBigImg;
	
	public AllcoursesBigImg(){
		allcoursesBigImg = new ImgBean[6];
		
		allcoursesBigImg[0]= new ImgBean(R.drawable.i3);
		allcoursesBigImg[1]= new ImgBean(R.drawable.i1);
		allcoursesBigImg[2]= new ImgBean(R.drawable.i1);
		allcoursesBigImg[3]= new ImgBean(R.drawable.i3);
		allcoursesBigImg[4]= new ImgBean(R.drawable.i5);
		allcoursesBigImg[5]= new ImgBean(R.drawable.i3);

	}

}
