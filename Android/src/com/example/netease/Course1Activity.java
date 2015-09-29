package com.example.netease;

import java.util.ArrayList;
import java.util.List;

import com.android.course.bean.Bean;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;







import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Course1Activity extends Activity {

	private ImageView img_course1Img;
	private TextView tv_course1Name;
//	private TextView tv_course1Summarize;
	private TextView tv_course1SummarizeImf;
//	private TextView tv_course1AchieAsse;
	private TextView tv_course1AchieAsseIfm;
//	private TextView tv_course1TimePlace;
	private TextView tv_course1TimePlaceIfm;
	private TextView tv_course1MethodologyOfPerformanceInfo;
	private Button collection_btn;
    private int position;
	private Button btn_to_mainActivity;
	private Context btn_to_mainActivity_context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);//自定义的标题栏
		setContentView(R.layout.course1activity); //加载页面
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.course1_titlebar);//加载标题栏
		
		img_course1Img = (ImageView) findViewById(R.id.id_course1Img);
		tv_course1Name = (TextView) findViewById(R.id.id_course1Name);
		tv_course1SummarizeImf = (TextView) findViewById(R.id.id_course1SummarizeIfm);
		tv_course1AchieAsseIfm = (TextView) findViewById(R.id.id_course1AchieAsseIfm);
		tv_course1TimePlaceIfm = (TextView) findViewById(R.id.id_course1TimePlaceIfm);
		tv_course1MethodologyOfPerformanceInfo = (TextView) findViewById(R.id.id_course1MethodologyOfPerformanceInfo);
		collection_btn=(Button) findViewById(R.id.collectionBtn);
		
		
		
		/*获取Intent中的Bundle对象*/  
		  Bundle bundle = this.getIntent().getExtras();  
	
		/*获取Bundle中的数据，注意类型和key*/
		int Cuorse1BigImg = bundle.getInt("Cuorse1BigImg");
		img_course1Img.setBackgroundResource(Cuorse1BigImg);
		String Course1Name = bundle.getString("Course1Name");
		tv_course1Name.setText(Course1Name);
		String Course1Sum = bundle.getString("Course1Sum");
		tv_course1SummarizeImf.setText(Course1Sum);
		String Course1Grade = bundle.getString("Course1Grade");
		tv_course1AchieAsseIfm.setText(Course1Grade);
		String Course1TimePlace = bundle.getString("Course1TimePlace");
		tv_course1TimePlaceIfm.setText(Course1TimePlace);
		String course1MethodologyOfPerformance = bundle.getString("course1MethodologyOfPerformance");
		tv_course1MethodologyOfPerformanceInfo.setText(course1MethodologyOfPerformance);
		
	       position = bundle.getInt("position");
	       
		collection_btn.setOnClickListener(new OnClickListener() {
			
			AVObject testObject = new AVObject("collection_");
			@Override
			public void onClick(View v) {
				
				switch(position){
				
				case 0:
					//AVObject testObject = new AVObject("collection_");
					testObject.put("course0","a" );
					testObject.saveInBackground();
					    Toast.makeText(Course1Activity.this,//提示浮框同时显示查询数据
								"收藏成功",
								Toast.LENGTH_SHORT).show();
					
					break;
				case 1:
					//AVObject testObject1 = new AVObject("collection_");
					testObject.put("course1","b");
					testObject.saveInBackground();
					    Toast.makeText(Course1Activity.this,//提示浮框同时显示查询数据
								"收藏成功",
								Toast.LENGTH_SHORT).show();
				break;
				case 2:
					//AVObject testObject = new AVObject("collection_");
					testObject.put("course2","c" );
					testObject.saveInBackground();
					    Toast.makeText(Course1Activity.this,//提示浮框同时显示查询数据
								"收藏成功",
								Toast.LENGTH_SHORT).show();
				
				break;
				case 3:
					//AVObject testObject = new AVObject("collection_");
					testObject.put("course3","d" );
					testObject.saveInBackground();
					    Toast.makeText(Course1Activity.this,//提示浮框同时显示查询数据
								"收藏成功",
								Toast.LENGTH_SHORT).show();
				break;
				case 4:
					//AVObject testObject = new AVObject("collection_");
					testObject.put("course4","e" );
					testObject.saveInBackground();
					    Toast.makeText(Course1Activity.this,//提示浮框同时显示查询数据
								"收藏成功",
								Toast.LENGTH_SHORT).show();
				
				break;
			
				default: 	
					//AVObject testObject = new AVObject("collection_");
				testObject.put("course5","f" );
				testObject.saveInBackground();
				    Toast.makeText(Course1Activity.this,//提示浮框同时显示查询数据
							"收藏成功",
							Toast.LENGTH_SHORT).show();
				
				}
				
				
				
				
				/*Toast.makeText(Course1Activity.this,//提示浮框同时显示查询数据
						"收藏成功",
						Toast.LENGTH_SHORT).show();*/
				
				
				    }
				});
		
		btn_to_mainActivity_context = this;
		btn_to_mainActivity = (Button) findViewById(R.id.id_back_to_mainActivity);
		btn_to_mainActivity.setOnClickListener(new OnClickListener() {//点击跳转到注册和登录页面
				@Override
				public void onClick(View v) {
					Intent intent=new Intent(btn_to_mainActivity_context, MainActivity.class);
					startActivity(intent);
					// TODO Auto-generated method stub
				}
			});
		
		
	}

}
