package com.example.netease;

import java.util.ArrayList;
import java.util.List;

import com.android.course.bean.AllCourses;
import com.android.course.bean.AllcoursesBigImg;
import com.android.course.bean.Bean;
import com.android.course.bean.ImgBean;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.GetCallback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class SearchActivity extends Activity implements OnItemClickListener{
	//title_bar中的Button对象声明
	private Button btn_return_center;
	private EditText edittext_search;
	private Button btn_into_search;
	private Context btn_return_center_Context;
	private Context btn_into_search_Context;
		
	private ListView mListView; //声明列表
	private List<Bean> mDatas; //声明数据集
	private MyAdapterwithCommonViewHolder mMyAdapterwithCommonViewHolder;
	
	private int[] relativeAddr = new int[10];
	
	//Bean相对于一个存放一门课程信息的结构体，创建Bean类型的数组coursesDatas，第i门课存在Bean[i]中。 
	private AllCourses coursesData = new AllCourses();
	Bean[] coursesDatas =  coursesData.allCourses;
	
	//课程背景图数组
	private AllcoursesBigImg couresesBigImg = new AllcoursesBigImg();
	ImgBean[] couresesBigImgs = couresesBigImg.allcoursesBigImg;
			
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);//自定义的标题栏
		setContentView(R.layout.search_activity);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.search_titlebar);//加载标题栏
		
		//搜索列表中SeachTitle_bar的“返回”点击事件
		btn_return_center_Context = this;
		btn_return_center = (Button)findViewById(R.id.id_return_center);
		btn_return_center.setOnClickListener(new OnClickListener() {
					
		    @Override
		    public void onClick(View v) {
				Intent intent=new Intent(btn_return_center_Context, MainActivity.class);
				startActivity(intent);
						
		    }
	    });
				
		
		//搜索搜索列表中SeachTitle_bar的“搜索”点击事件
		edittext_search =  (EditText) findViewById(R.id.editText_search);
		btn_into_search_Context = this;
		btn_into_search = (Button) findViewById(R.id.id_into_search);
		btn_into_search.setOnClickListener(new OnClickListener() {
					
		    @Override
		    public void onClick(View v) {
		    	
		    	String search_infm = edittext_search.getText().toString();
		    	
		    	//如果搜索框为空点击查询，输出提示！
		    	if(search_infm.length()==0){
		    	Toast toast=Toast.makeText(getApplicationContext(), "未输入查询信息", Toast.LENGTH_SHORT);  
		    	toast.show();
		    	}else{
		    	//****************************************************************************************       
				//listview的适配器配置
						initDatas(); //2、添加数据源到适配器
							
						initView(); //3、视图加载适配器。
						
						initIntent(); //实现 跳转
		    	}
		    }
	     });
	
	}
			
		/*ListView:Android系统中显示列表的控件。
		 * Adapter(适配器)的使目的：适配器是把数据映射到*ListView的中介。
		 * Adapter(适配器)的使用：1、新建适配器；
		 *                   2、添加数据源到适配器；
		 *                   3、视图加载适配器。
		 */	
			private void initDatas() {
				
				//从EditText中获取搜索信息
			    String search_infm = edittext_search.getText().toString();
			    int k = 0;
				
						
				mDatas = new ArrayList<Bean>(); 
						
				for(int i=0; i<coursesDatas.length; i++){
					//若寻找到搜索信息，将之加入搜索数据 集
					if(coursesDatas[i].getCourseName().contains(search_infm) 
							|| coursesDatas[i].getTeacherName().contains(search_infm)){
					    
					    Bean bean = coursesDatas[i];
					    mDatas.add(bean);
					    
					    relativeAddr[k] = i;
				        k++;	
					}
				}
				
				if(k == 0){
					Toast toast3=Toast.makeText(getApplicationContext(), "未寻找到信息", Toast.LENGTH_SHORT);  
			    	toast3.show();
				}
		
		        //数据集添加到适配器
				mMyAdapterwithCommonViewHolder = new MyAdapterwithCommonViewHolder(this, mDatas);
			}
			
			
			private void initView() {
				mListView = (ListView) findViewById(R.id.id_search_listview);
				
				//视图加载适配器
				mListView.setAdapter(mMyAdapterwithCommonViewHolder); 
			}

			
		/*	initIntent() -->实现从ListView的一个Item跳转到一个页面，
		 *                  可根据Item的position（在列表中相对位置，int型，从0开始），从数据库中查找相应数据，通过键值对方式绑定在bundle中，
		 *                  bundle中值可传递给下一个页面显示。 
		 */
			private void initIntent() {
				//调用点击Item方法
				mListView.setOnItemClickListener(this);		
			}

			//重写setOnItemClickListener（）方法
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				//Toast弹小黑框
				//String text = mListView.getItemAtPosition(position)+"";
				//Toast.makeText(this, "position="+position+"text"+text,Toast.LENGTH_LONG ).show();
		
				//把listview中的position转换为云端对应的position
				//实现也页面跳转
				switch (relativeAddr[position]){
				case 0 :
					
				AVQuery<AVObject> query = new AVQuery<AVObject>("classteach_plus");
				query.getInBackground("5559f309e4b0f937a0e135e6", new GetCallback<AVObject>() {//多线程查询在后台运行，不会影响程序的响应
				    public void done(AVObject num1, AVException e) {
				        if (e == null) {
				Intent intent = new Intent(SearchActivity.this,Course1Activity.class);
				
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
				
				case 1 :
					
					AVQuery<AVObject> query1 = new AVQuery<AVObject>("classteach_plus");
					query1.getInBackground("5559f338e4b0f937a0e13936", new GetCallback<AVObject>() {//多线程查询在后台运行，不会影响程序的响应
					    public void done(AVObject num1, AVException e) {
					        if (e == null) {
					Intent intent = new Intent(SearchActivity.this,Course1Activity.class);
					
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
					
				case 2 :
					
					AVQuery<AVObject> query2 = new AVQuery<AVObject>("classteach_plus");
					query2.getInBackground("5562cd7de4b00c57d9b9fa7d", new GetCallback<AVObject>() {//多线程查询在后台运行，不会影响程序的响应
					    public void done(AVObject num1, AVException e) {
					        if (e == null) {
					Intent intent = new Intent(SearchActivity.this,Course1Activity.class);
					
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
					Intent intent = new Intent(SearchActivity.this,Course1Activity.class);
					
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
					Intent intent = new Intent(SearchActivity.this,Course1Activity.class);
					
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
					Intent intent = new Intent(SearchActivity.this,Course1Activity.class);
					
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
			
		
		
			
	
	
	}
}
