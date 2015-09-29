package com.example.netease;

import java.util.ArrayList;
import java.util.List;

import com.android.course.bean.AllCourses;
import com.android.course.bean.AllcoursesBigImg;
import com.android.course.bean.Bean;
import com.android.course.bean.ImgBean;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.GetCallback;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class ContentFragment extends Fragment{
	//listview的变量声明
		private ListView mListView; //声明列表
		private List<Bean> mDatas; //声明数据集
		private MyAdapterwithCommonViewHolder mMyAdapterwithCommonViewHolder; //1、新建适配器；
		private Context mContext;
		
		//Bean相对于一个存放一门课程信息的结构体，创建Bean类型的数组coursesDatas，第i门课存在Bean[i]中。
		private AllCourses coursesData = new AllCourses();
		Bean[] coursesDatas =  coursesData.allCourses;
		
		//课程背景图数组
		private AllcoursesBigImg couresesBigImg = new AllcoursesBigImg();
		ImgBean[] couresesBigImgs = couresesBigImg.allcoursesBigImg;
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_layout, container, false);
		mContext = getActivity().getApplicationContext();
		AVOSCloud.initialize(mContext, "5pboq38097nyu227n71r8xnzzn2t1vh2ci6979n93wvi2mut", "s9g84wka9ldhg1uqrzlx945z0zzey8osl35sr7s2nov4lg69");
		mListView = (ListView)view.findViewById(R.id.id_listview);
		//listview的适配器配置
		initDatas(); //2、添加数据源到适配器
		
		//视图加载适配器
		mListView.setAdapter(mMyAdapterwithCommonViewHolder); 
		mListView.setOnItemClickListener(new DrawerItemClickListener());	
		return view;
	}

	/*ListView:Android系统中显示列表的控件。
	 * Adapter(适配器)的使目的：适配器是把数据映射到*ListView的中介。
	 * Adapter(适配器)的使用：1、新建适配器；
	 *                   2、添加数据源到适配器；
	 *                   3、视图加载适配器。
	 */	
		private void initDatas() {
			
			
			mDatas = new ArrayList<Bean>(); 
					
			for(int i=0; i<coursesDatas.length; i++){
				Bean bean = coursesDatas[i];
				mDatas.add(bean);
					}
			   
		
	        //数据集添加到适配器
			mMyAdapterwithCommonViewHolder = new MyAdapterwithCommonViewHolder(mContext, mDatas);
		}
		
		private class DrawerItemClickListener implements
		ListView.OnItemClickListener {
	    @Override
	     public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		selectItem(position);
	}


private void selectItem( int position) {
	switch (position) {
	case 0:		
		AVQuery<AVObject> query = new AVQuery<AVObject>("classteach_plus");
		query.getInBackground("5559f309e4b0f937a0e135e6", new GetCallback<AVObject>() {//多线程查询在后台运行，不会影响程序的响应
		    public void done(AVObject num1, AVException e) {
		        if (e == null) {
		Intent intent = new Intent(getActivity(),Course1Activity.class);
		
		/* 通过Bundle对象存储需要传递的数据 */  
		Bundle bundle = new Bundle();  
		
//！！下面是任皓要添加云端数据的地方！		
		/*字符、字符串、布尔、字节数组、浮点数等等，都可以传*/
		bundle.putInt("Cuorse1BigImg", couresesBigImgs[0].getCourseImg());
		bundle.putString("Course1Name", coursesDatas[0].getCourseName());
		bundle.putString("Course1Sum", num1.getString("classintro"));
		bundle.putString("Course1Grade", num1.getString("teachway"));
		bundle.putString("Course1TimePlace", num1.getString("classtime"));
		bundle.putString("course1MethodologyOfPerformance", num1.getString("textway"));
		
		/*把bundle对象assign给Intent*/  
		intent.putExtras(bundle); 
		
		//实现页面的无返回值跳转 
		startActivity(intent);
		        } else {
		            Log.e("获取分数", "错误: " + e.getMessage());//错误提示信息
		        }
		    }
		});
		break;
		
	case 1:
		AVQuery<AVObject> query1 = new AVQuery<AVObject>("classteach_plus");
		query1.getInBackground("5559f338e4b0f937a0e13936", new GetCallback<AVObject>() {//多线程查询在后台运行，不会影响程序的响应
		    public void done(AVObject num1, AVException e) {
		        if (e == null) {
		Intent intent = new Intent(getActivity(),Course1Activity.class);
		
		/* 通过Bundle对象存储需要传递的数据 */  
		Bundle bundle = new Bundle();  
		
//！！下面是任皓要添加云端数据的地方！		
		/*字符、字符串、布尔、字节数组、浮点数等等，都可以传*/
		bundle.putInt("Cuorse1BigImg", couresesBigImgs[1].getCourseImg());
		bundle.putString("Course1Name", coursesDatas[1].getCourseName());
		bundle.putString("Course1Sum", num1.getString("classintro"));
		bundle.putString("Course1Grade", num1.getString("teachway"));
		bundle.putString("Course1TimePlace", num1.getString("classtime"));
		bundle.putString("course1MethodologyOfPerformance", num1.getString("textway"));
		
		/*把bundle对象assign给Intent*/  
		intent.putExtras(bundle); 
		
		//实现页面的无返回值跳转 
		startActivity(intent);
		        } else {
		            Log.e("获取分数", "错误: " + e.getMessage());//错误提示信息
		        }
		    }
		});
		break;
	case 2:
		AVQuery<AVObject> query2 = new AVQuery<AVObject>("classteach_plus");
		query2.getInBackground("5562cd7de4b00c57d9b9fa7d", new GetCallback<AVObject>() {//多线程查询在后台运行，不会影响程序的响应
		    public void done(AVObject num1, AVException e) {
		        if (e == null) {
		Intent intent = new Intent(getActivity(),Course1Activity.class);
		
		/* 通过Bundle对象存储需要传递的数据 */  
		Bundle bundle = new Bundle();  
		
//！！下面是任皓要添加云端数据的地方！		
		/*字符、字符串、布尔、字节数组、浮点数等等，都可以传*/
		bundle.putInt("Cuorse1BigImg", couresesBigImgs[2].getCourseImg());
		bundle.putString("Course1Name", coursesDatas[2].getCourseName());
		bundle.putString("Course1Sum", num1.getString("classintro"));
		bundle.putString("Course1Grade", num1.getString("teachway"));
		bundle.putString("Course1TimePlace", num1.getString("classtime"));
		bundle.putString("course1MethodologyOfPerformance", num1.getString("textway"));
		
		/*把bundle对象assign给Intent*/  
		intent.putExtras(bundle); 
		
		//实现页面的无返回值跳转 
		startActivity(intent);
		        } else {
		            Log.e("获取分数", "错误: " + e.getMessage());//错误提示信息
		        }
		    }
		});
		
		break;
		
	case 3 :
		
		AVQuery<AVObject> query3 = new AVQuery<AVObject>("classteach_plus");
		query3.getInBackground("5562cbfee4b00c57d9b9efbc", new GetCallback<AVObject>() {//多线程查询在后台运行，不会影响程序的响应
		    public void done(AVObject num1, AVException e) {
		        if (e == null) {
		Intent intent = new Intent(getActivity(),Course1Activity.class);
		
		/* 通过Bundle对象存储需要传递的数据 */  
		Bundle bundle = new Bundle();  
		
//！！下面是任皓要添加云端数据的地方！		
		/*字符、字符串、布尔、字节数组、浮点数等等，都可以传*/  
		bundle.putInt("Cuorse1BigImg", couresesBigImgs[3].getCourseImg());
		bundle.putString("Course1Name", coursesDatas[3].getCourseName());
		bundle.putString("Course1Sum", num1.getString("classintro"));
		bundle.putString("Course1Grade", num1.getString("teachway"));
		bundle.putString("Course1TimePlace", num1.getString("classtime"));
		bundle.putString("course1MethodologyOfPerformance", num1.getString("textway"));
		
		/*把bundle对象assign给Intent*/  
		intent.putExtras(bundle); 
		
		//实现页面的无返回值跳转 
		startActivity(intent);
		        } else {
		            Log.e("获取分数", "错误: " + e.getMessage());//错误提示信息
		        }
		    }
		});
		
		break;
		
	case 4 :
		
		AVQuery<AVObject> query4 = new AVQuery<AVObject>("classteach_plus");
		query4.getInBackground("5562ccb9e4b00c57d9b9f4ba", new GetCallback<AVObject>() {//多线程查询在后台运行，不会影响程序的响应
		    public void done(AVObject num1, AVException e) {
		        if (e == null) {
		Intent intent = new Intent(getActivity(),Course1Activity.class);
		
		/* 通过Bundle对象存储需要传递的数据 */  
		Bundle bundle = new Bundle();  
		
//！！下面是任皓要添加云端数据的地方！		
		/*字符、字符串、布尔、字节数组、浮点数等等，都可以传*/  
		bundle.putInt("Cuorse1BigImg", couresesBigImgs[4].getCourseImg());
		bundle.putString("Course1Name", coursesDatas[4].getCourseName());
		bundle.putString("Course1Sum", num1.getString("classintro"));
		bundle.putString("Course1Grade", num1.getString("teachway"));
		bundle.putString("Course1TimePlace", num1.getString("classtime"));
		bundle.putString("course1MethodologyOfPerformance", num1.getString("textway"));
		
		/*把bundle对象assign给Intent*/  
		intent.putExtras(bundle); 
		
		//实现页面的无返回值跳转 
		startActivity(intent);
		        } else {
		            Log.e("获取分数", "错误: " + e.getMessage());//错误提示信息
		        }
		    }
		});
		
		break;
		
		
	default:
		AVQuery<AVObject> query5 = new AVQuery<AVObject>("classteach_plus");
		query5.getInBackground("5562f61ce4b07ae45cfcebde", new GetCallback<AVObject>() {//多线程查询在后台运行，不会影响程序的响应
		    public void done(AVObject num1, AVException e) {
		        if (e == null) {
		Intent intent = new Intent(getActivity(),Course1Activity.class);
		
		/* 通过Bundle对象存储需要传递的数据 */  
		Bundle bundle = new Bundle();  
		
//！！下面是任皓要添加云端数据的地方！		
		/*字符、字符串、布尔、字节数组、浮点数等等，都可以传*/  
		bundle.putInt("Cuorse1BigImg", couresesBigImgs[5].getCourseImg());
		bundle.putString("Course1Name", coursesDatas[5].getCourseName());
		bundle.putString("Course1Sum", num1.getString("classintro"));
		bundle.putString("Course1Grade", num1.getString("teachway"));
		bundle.putString("Course1TimePlace", num1.getString("classtime"));
		bundle.putString("course1MethodologyOfPerformance", num1.getString("textway"));
		
		/*把bundle对象assign给Intent*/  
		intent.putExtras(bundle); 
		
		//实现页面的无返回值跳转 
		startActivity(intent);
		        } else {
		            Log.e("获取分数", "错误: " + e.getMessage());//错误提示信息
		        }
		    }
		});
		break;
	}

    // 更新选择后的item和title，然后关闭菜单  	
	mListView.setItemChecked(position, true);
	//setTitle(mMenuTitles[position]);
     }
		}
}
