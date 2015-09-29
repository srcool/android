package com.example.netease;

import java.util.ArrayList;
import java.util.List;

import com.android.course.bean.Bean;
import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.CloudQueryCallback;
import com.avos.avoscloud.FindCallback;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class CollectionList extends Fragment {
	//listview的变量声明
		private ListView mListView; //声明列表
		private List<Bean> mDatas; //声明数据集
		private MyAdapterwithCommonViewHolder mMyAdapterwithCommonViewHolder; //1、新建适配器；
	    public  int[] a={9,9,9,9,9,9};
	    private Context mContext;

		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			View view = inflater.inflate(R.layout.collection_list, container, false);
			mContext = getActivity().getApplicationContext();
			mListView = (ListView) view.findViewById(R.id.id_listview);
	//***************************************************************************************************

			
			
	//****************************************************************************************       
	//listview的适配器配置
			initDatas(); 
				
			//initView(); //3、视图加载适配器。
			return view;
			
			}
		
	/*ListView:Android系统中显示列表的控件。
	 * Adapter(适配器)的使目的：适配器是把数据映射到*ListView的中介。
	 * Adapter(适配器)的使用：1、新建适配器；
	 *                   2、添加数据源到适配器；
	 *                   3、视图加载适配器。
	 */	

		
		
		private void initDatas() {
			
			
		
			
			
			
			AVQuery<AVObject> query = new AVQuery<AVObject>("collection_");
			query.whereStartsWith("course0", "a");
			query.findInBackground(new FindCallback<AVObject>() {
				public void done(List<AVObject> avObjects, AVException e) {
			        if (e == null) {
			        	Log.e("获取分数0", "成功: ");
			        	 CollectionList.this.a[0]=0;
			        	 
			        	initView();
			            //数据集添加到适配器
			    		
			        } else {
			        	Log.e("获取分数", "错误: ");
			        	
			        	//coursesDatas[0]=null;
			        }
			    }
			});
			/*AVQuery<AVObject> query1 = new AVQuery<AVObject>("collection_");
			query1.whereEqualTo("course1", "b");
			query1.findInBackground(new FindCallback<AVObject>() {
			    public void done(List<AVObject> avObjects, AVException e) {
			        if (e == null) {
			        	CollectionList.this.a[1]=1;
			        	Log.e("获取分数1", "成功: ");
			        	 //initView();
			        } else {
			        	Log.e("获取分数", "错误: ");
			        }
			    }
			});
			AVQuery<AVObject> query2 = new AVQuery<AVObject>("collection_");
			query2.whereEqualTo("course2", "c");
			query2.findInBackground(new FindCallback<AVObject>() {
			    public void done(List<AVObject> avObjects, AVException e) {
			        if (e == null) {
			        	CollectionList.this.a[2]=2;
			        	Log.e("获取分数2", "成功: ");
			        	// initView();
			        	
			        } else {
			        	Log.e("获取分数", "错误: ");
			        }
			    }
			});
			AVQuery<AVObject> query3 = new AVQuery<AVObject>("collection_");
			query3.whereEqualTo("course3", "d");
			query3.findInBackground(new FindCallback<AVObject>() {
			    public void done(List<AVObject> avObjects, AVException e) {
			        if (e == null) {
			        	CollectionList.this.a[3]=3;
			        	Log.e("获取分数3", "成功: ");
			        	 //initView();
			        } else {
			        	Log.e("获取分数", "错误: ");
			        }
			    }
			});
			AVQuery<AVObject> query4 = new AVQuery<AVObject>("collection_");
			query4.whereEqualTo("course4","e");
			query4.findInBackground(new FindCallback<AVObject>() {
			    public void done(List<AVObject> avObjects, AVException e) {
			        if (e == null) {
			        	CollectionList.this.a[4]=4;
			        	Log.e("获取分数4", "成功: ");
			        	 //initView();
			        } else {
			        	Log.e("获取分数", "错误: ");
			        }
			    }
			});
			AVQuery<AVObject> query5 = new AVQuery<AVObject>("collection_");
			query5.whereEqualTo("course5", "f");
			query5.findInBackground(new FindCallback<AVObject>() {
			    public void done(List<AVObject> avObjects, AVException e) {
			        if (e == null) {
			        	CollectionList.this.a[5]=5;
			        	Log.e("获取分数5", "成功: ");
			        	 initView();
			        } else {
			        	Log.e("获取分数", "错误: ");
			        }
			    }
			});
			
			
			
			/*mDatas = new ArrayList<Bean>(); 
			
			for(int i=0; i<coursesDatas.length; i++){
				
				//if(coursesDatas[i]!=null){
					for(int j=0; j<6 ;j++){
						Log.e("获取", " "+CollectionList.this.a[0]);
						if(a[j]==i){
				Bean bean = coursesDatas[i];
				mDatas.add(bean);}
					}
				//}
			}
				       
	        //数据集添加到适配器
			mMyAdapterwithCommonViewHolder = new MyAdapterwithCommonViewHolder(this, mDatas);*/
			
		}
		
		
		private void initView() {
			
			
	Bean[] coursesDatas = new Bean[6];
			
			coursesDatas[0] = new Bean(R.drawable.i3, "云南历史与文化","秦树才", "人文科学类");
			coursesDatas[1] = new Bean(R.drawable.i1, "微积分解题技巧","李永昆", "自然科学类");
			coursesDatas[2] = new Bean(R.drawable.i1, "管理伦理","王克岭", "社会科学类");
			coursesDatas[3] = new Bean(R.drawable.i3, "汉学与汉学研究","张月明", "人文科学类");
			coursesDatas[4] = new Bean(R.drawable.i5, "西方的智慧","刘玉鹏", "人文科学类");
			coursesDatas[5] = new Bean(R.drawable.i3, "数码图片处理技术及其应用","余映", "体技类");
			
	mDatas = new ArrayList<Bean>(); 
			
			for(int i=0; i<coursesDatas.length; i++){
				
				//if(coursesDatas[i]!=null){
					
						//Log.e("获取", " "+CollectionList.this.a[0]);
						if(a[i]==i){
				Bean bean = coursesDatas[i];
				mDatas.add(bean);}
					}
				//}
			
				       
	        //数据集添加到适配器
			mMyAdapterwithCommonViewHolder = new MyAdapterwithCommonViewHolder(mContext, mDatas);
			
				       
	        //数据集添加到适配器
			mMyAdapterwithCommonViewHolder = new MyAdapterwithCommonViewHolder(mContext, mDatas);
			
			//视图加载适配器
			mListView.setAdapter(mMyAdapterwithCommonViewHolder); 
		}

		public void query0() {
			AVQuery.doCloudQueryInBackground("select * from collection_ where course0 = 'a'",new CloudQueryCallback<AVCloudQueryResult>(){

		          @Override
		          public void done(AVCloudQueryResult result, AVException cqlException) {
		             if(cqlException==null){
		            	 Log.e("获取分数0", "成功: "+result.getResults());//这里是你查询到的结果
		            	 CollectionList.this.a[0]=0;
		            	 initView();
		             }
		            
		          }
		          
		});
			
		}
		
		public void query1(){
			AVQuery<AVObject> query = new AVQuery<AVObject>("collection_");
			query.whereStartsWith("course1", "b");
			query.findInBackground(new FindCallback<AVObject>() {
				public void done(List<AVObject> avObjects, AVException f) {
			        if (f == null) {
			        	Log.e("获取分数1", "成功: ");
			        	 CollectionList.this.a[1]=1;
			        	 initView();
			        	
			        	 
			            //数据集添加到适配器
			    		
			        } else {
			        	Log.e("获取分数1", "错误: ");
			        	
			        	//coursesDatas[0]=null;
			        }
			    }
				
			});
			
		}
		public void query2(){
			AVQuery<AVObject> query2 = new AVQuery<AVObject>("collection_");
			query2.whereEqualTo("course2", "c");
			query2.findInBackground(new FindCallback<AVObject>() {
			    public void done(List<AVObject> avObjects, AVException g) {
			        if (g == null) {
			        	CollectionList.this.a[2]=2;
			        	Log.e("获取分数2", "成功: ");
			        	initView();
			        	
			        } else {
			        	Log.e("获取分数", "错误: ");
			        }
			    }
			});
			//query3();
		}
		public void query3(){
			AVQuery<AVObject> query3 = new AVQuery<AVObject>("collection_");
			query3.whereEqualTo("course3", "d");
			query3.findInBackground(new FindCallback<AVObject>() {
			    public void done(List<AVObject> avObjects, AVException h) {
			        if (h == null) {
			        	CollectionList.this.a[3]=3;
			        	Log.e("获取分数3", "成功: ");
			        	 //initView();
			        } else {
			        	Log.e("获取分数", "错误: ");
			        }
			    }
			});
			//query4();
		}
		public void query4(){
			AVQuery<AVObject> query4 = new AVQuery<AVObject>("collection_");
			query4.whereEqualTo("course4","e");
			query4.findInBackground(new FindCallback<AVObject>() {
			    public void done(List<AVObject> avObjects, AVException i) {
			        if (i == null) {
			        	CollectionList.this.a[4]=4;
			        	Log.e("获取分数4", "成功: ");
			        	 //initView();
			        } else {
			        	Log.e("获取分数", "错误: ");
			        }
			    }
			});
			//query5();
		}
		public void query5(){
			AVQuery<AVObject> query5 = new AVQuery<AVObject>("collection_");
			query5.whereEqualTo("course5", "f");
			query5.findInBackground(new FindCallback<AVObject>() {
			    public void done(List<AVObject> avObjects, AVException j) {
			        if (j == null) {
			        	CollectionList.this.a[5]=5;
			        	Log.e("获取分数5", "成功: ");
			        	 //initView();
			        } else {
			        	Log.e("获取分数", "错误: ");
			        }
			    }
			});
			 initView();
		}

	}

