package com.android.course.bean;

import com.example.netease.R;

public class AllCourses {
	public Bean[] allCourses;
	
	public AllCourses(){
		
		allCourses = new Bean[6];
		
		allCourses[0] = new Bean(R.drawable.i3, "������ʷ���Ļ�","������", "���Ŀ�ѧ��");
		allCourses[1] = new Bean(R.drawable.i1, "΢���ֽ��⼼��","������", "��Ȼ��ѧ��");
		allCourses[2] = new Bean(R.drawable.i1, "��������","������", "����ѧ��");
		allCourses[3] = new Bean(R.drawable.i3, "��ѧ�뺺ѧ�о�","������", "���Ŀ�ѧ��");
		allCourses[4] = new Bean(R.drawable.i5, "�������ǻ�","������", "���Ŀ�ѧ��");
		allCourses[5] = new Bean(R.drawable.i3, "����ͼƬ����������Ӧ��","��ӳ", "�弼��");
				
		
	}

}
