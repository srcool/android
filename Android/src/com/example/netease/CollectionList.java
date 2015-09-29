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
	//listview�ı�������
		private ListView mListView; //�����б�
		private List<Bean> mDatas; //�������ݼ�
		private MyAdapterwithCommonViewHolder mMyAdapterwithCommonViewHolder; //1���½���������
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
	//listview������������
			initDatas(); 
				
			//initView(); //3����ͼ������������
			return view;
			
			}
		
	/*ListView:Androidϵͳ����ʾ�б�Ŀؼ���
	 * Adapter(������)��ʹĿ�ģ��������ǰ�����ӳ�䵽*ListView���н顣
	 * Adapter(������)��ʹ�ã�1���½���������
	 *                   2���������Դ����������
	 *                   3����ͼ������������
	 */	

		
		
		private void initDatas() {
			
			
		
			
			
			
			AVQuery<AVObject> query = new AVQuery<AVObject>("collection_");
			query.whereStartsWith("course0", "a");
			query.findInBackground(new FindCallback<AVObject>() {
				public void done(List<AVObject> avObjects, AVException e) {
			        if (e == null) {
			        	Log.e("��ȡ����0", "�ɹ�: ");
			        	 CollectionList.this.a[0]=0;
			        	 
			        	initView();
			            //���ݼ���ӵ�������
			    		
			        } else {
			        	Log.e("��ȡ����", "����: ");
			        	
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
			        	Log.e("��ȡ����1", "�ɹ�: ");
			        	 //initView();
			        } else {
			        	Log.e("��ȡ����", "����: ");
			        }
			    }
			});
			AVQuery<AVObject> query2 = new AVQuery<AVObject>("collection_");
			query2.whereEqualTo("course2", "c");
			query2.findInBackground(new FindCallback<AVObject>() {
			    public void done(List<AVObject> avObjects, AVException e) {
			        if (e == null) {
			        	CollectionList.this.a[2]=2;
			        	Log.e("��ȡ����2", "�ɹ�: ");
			        	// initView();
			        	
			        } else {
			        	Log.e("��ȡ����", "����: ");
			        }
			    }
			});
			AVQuery<AVObject> query3 = new AVQuery<AVObject>("collection_");
			query3.whereEqualTo("course3", "d");
			query3.findInBackground(new FindCallback<AVObject>() {
			    public void done(List<AVObject> avObjects, AVException e) {
			        if (e == null) {
			        	CollectionList.this.a[3]=3;
			        	Log.e("��ȡ����3", "�ɹ�: ");
			        	 //initView();
			        } else {
			        	Log.e("��ȡ����", "����: ");
			        }
			    }
			});
			AVQuery<AVObject> query4 = new AVQuery<AVObject>("collection_");
			query4.whereEqualTo("course4","e");
			query4.findInBackground(new FindCallback<AVObject>() {
			    public void done(List<AVObject> avObjects, AVException e) {
			        if (e == null) {
			        	CollectionList.this.a[4]=4;
			        	Log.e("��ȡ����4", "�ɹ�: ");
			        	 //initView();
			        } else {
			        	Log.e("��ȡ����", "����: ");
			        }
			    }
			});
			AVQuery<AVObject> query5 = new AVQuery<AVObject>("collection_");
			query5.whereEqualTo("course5", "f");
			query5.findInBackground(new FindCallback<AVObject>() {
			    public void done(List<AVObject> avObjects, AVException e) {
			        if (e == null) {
			        	CollectionList.this.a[5]=5;
			        	Log.e("��ȡ����5", "�ɹ�: ");
			        	 initView();
			        } else {
			        	Log.e("��ȡ����", "����: ");
			        }
			    }
			});
			
			
			
			/*mDatas = new ArrayList<Bean>(); 
			
			for(int i=0; i<coursesDatas.length; i++){
				
				//if(coursesDatas[i]!=null){
					for(int j=0; j<6 ;j++){
						Log.e("��ȡ", " "+CollectionList.this.a[0]);
						if(a[j]==i){
				Bean bean = coursesDatas[i];
				mDatas.add(bean);}
					}
				//}
			}
				       
	        //���ݼ���ӵ�������
			mMyAdapterwithCommonViewHolder = new MyAdapterwithCommonViewHolder(this, mDatas);*/
			
		}
		
		
		private void initView() {
			
			
	Bean[] coursesDatas = new Bean[6];
			
			coursesDatas[0] = new Bean(R.drawable.i3, "������ʷ���Ļ�","������", "���Ŀ�ѧ��");
			coursesDatas[1] = new Bean(R.drawable.i1, "΢���ֽ��⼼��","������", "��Ȼ��ѧ��");
			coursesDatas[2] = new Bean(R.drawable.i1, "��������","������", "����ѧ��");
			coursesDatas[3] = new Bean(R.drawable.i3, "��ѧ�뺺ѧ�о�","������", "���Ŀ�ѧ��");
			coursesDatas[4] = new Bean(R.drawable.i5, "�������ǻ�","������", "���Ŀ�ѧ��");
			coursesDatas[5] = new Bean(R.drawable.i3, "����ͼƬ����������Ӧ��","��ӳ", "�弼��");
			
	mDatas = new ArrayList<Bean>(); 
			
			for(int i=0; i<coursesDatas.length; i++){
				
				//if(coursesDatas[i]!=null){
					
						//Log.e("��ȡ", " "+CollectionList.this.a[0]);
						if(a[i]==i){
				Bean bean = coursesDatas[i];
				mDatas.add(bean);}
					}
				//}
			
				       
	        //���ݼ���ӵ�������
			mMyAdapterwithCommonViewHolder = new MyAdapterwithCommonViewHolder(mContext, mDatas);
			
				       
	        //���ݼ���ӵ�������
			mMyAdapterwithCommonViewHolder = new MyAdapterwithCommonViewHolder(mContext, mDatas);
			
			//��ͼ����������
			mListView.setAdapter(mMyAdapterwithCommonViewHolder); 
		}

		public void query0() {
			AVQuery.doCloudQueryInBackground("select * from collection_ where course0 = 'a'",new CloudQueryCallback<AVCloudQueryResult>(){

		          @Override
		          public void done(AVCloudQueryResult result, AVException cqlException) {
		             if(cqlException==null){
		            	 Log.e("��ȡ����0", "�ɹ�: "+result.getResults());//���������ѯ���Ľ��
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
			        	Log.e("��ȡ����1", "�ɹ�: ");
			        	 CollectionList.this.a[1]=1;
			        	 initView();
			        	
			        	 
			            //���ݼ���ӵ�������
			    		
			        } else {
			        	Log.e("��ȡ����1", "����: ");
			        	
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
			        	Log.e("��ȡ����2", "�ɹ�: ");
			        	initView();
			        	
			        } else {
			        	Log.e("��ȡ����", "����: ");
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
			        	Log.e("��ȡ����3", "�ɹ�: ");
			        	 //initView();
			        } else {
			        	Log.e("��ȡ����", "����: ");
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
			        	Log.e("��ȡ����4", "�ɹ�: ");
			        	 //initView();
			        } else {
			        	Log.e("��ȡ����", "����: ");
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
			        	Log.e("��ȡ����5", "�ɹ�: ");
			        	 //initView();
			        } else {
			        	Log.e("��ȡ����", "����: ");
			        }
			    }
			});
			 initView();
		}

	}

