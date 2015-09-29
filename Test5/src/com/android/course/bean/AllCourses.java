package com.android.course.bean;

import com.example.netease.R;

public class AllCourses {
	public Bean[] allCourses;
	
	public AllCourses(){
		
		allCourses = new Bean[6];
		
		allCourses[0] = new Bean(R.drawable.i3, "云南历史与文化","秦树才", "人文科学类");
		allCourses[1] = new Bean(R.drawable.i1, "微积分解题技巧","李永昆", "自然科学类");
		allCourses[2] = new Bean(R.drawable.i1, "管理伦理","王克岭", "社会科学类");
		allCourses[3] = new Bean(R.drawable.i3, "汉学与汉学研究","张月明", "人文科学类");
		allCourses[4] = new Bean(R.drawable.i5, "西方的智慧","刘玉鹏", "人文科学类");
		allCourses[5] = new Bean(R.drawable.i3, "数码图片处理技术及其应用","余映", "体技类");
				
		
	}

}
