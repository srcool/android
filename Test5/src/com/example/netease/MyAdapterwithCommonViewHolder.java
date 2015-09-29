package com.example.netease;

import java.util.List;



import com.android.course.bean.Bean;
import com.android.course.utils.CommonAdapter;
import com.android.course.utils.ViewHolder;

import android.content.Context;

public class MyAdapterwithCommonViewHolder extends CommonAdapter<Bean> {


	public MyAdapterwithCommonViewHolder(Context context, List<Bean> datas){
		super(context,datas);
	}

	@Override
	public void convert(ViewHolder holder, Bean bean) {		
		   
		//Á´Ê½±à³Ì
		holder.setImageResource(R.id.id_courseImg, bean.getCourseImg())
		      .setText(R.id.id_courseName, bean.getCourseName())
		      .setText(R.id.id_teacherName, bean.getTeacherName())
		      .setText(R.id.id_courseAttribute, bean.getCourseAttribute());
		
	}
	

}

