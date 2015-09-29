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
	//title_bar�е�Button��������
	private Button btn_return_center;
	private EditText edittext_search;
	private Button btn_into_search;
	private Context btn_return_center_Context;
	private Context btn_into_search_Context;
		
	private ListView mListView; //�����б�
	private List<Bean> mDatas; //�������ݼ�
	private MyAdapterwithCommonViewHolder mMyAdapterwithCommonViewHolder;
	
	private int[] relativeAddr = new int[10];
	
	//Bean�����һ�����һ�ſγ���Ϣ�Ľṹ�壬����Bean���͵�����coursesDatas����i�ſδ���Bean[i]�С� 
	private AllCourses coursesData = new AllCourses();
	Bean[] coursesDatas =  coursesData.allCourses;
	
	//�γ̱���ͼ����
	private AllcoursesBigImg couresesBigImg = new AllcoursesBigImg();
	ImgBean[] couresesBigImgs = couresesBigImg.allcoursesBigImg;
			
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);//�Զ���ı�����
		setContentView(R.layout.search_activity);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.search_titlebar);//���ر�����
		
		//�����б���SeachTitle_bar�ġ����ء�����¼�
		btn_return_center_Context = this;
		btn_return_center = (Button)findViewById(R.id.id_return_center);
		btn_return_center.setOnClickListener(new OnClickListener() {
					
		    @Override
		    public void onClick(View v) {
				Intent intent=new Intent(btn_return_center_Context, MainActivity.class);
				startActivity(intent);
						
		    }
	    });
				
		
		//���������б���SeachTitle_bar�ġ�����������¼�
		edittext_search =  (EditText) findViewById(R.id.editText_search);
		btn_into_search_Context = this;
		btn_into_search = (Button) findViewById(R.id.id_into_search);
		btn_into_search.setOnClickListener(new OnClickListener() {
					
		    @Override
		    public void onClick(View v) {
		    	
		    	String search_infm = edittext_search.getText().toString();
		    	
		    	//���������Ϊ�յ����ѯ�������ʾ��
		    	if(search_infm.length()==0){
		    	Toast toast=Toast.makeText(getApplicationContext(), "δ�����ѯ��Ϣ", Toast.LENGTH_SHORT);  
		    	toast.show();
		    	}else{
		    	//****************************************************************************************       
				//listview������������
						initDatas(); //2���������Դ��������
							
						initView(); //3����ͼ������������
						
						initIntent(); //ʵ�� ��ת
		    	}
		    }
	     });
	
	}
			
		/*ListView:Androidϵͳ����ʾ�б�Ŀؼ���
		 * Adapter(������)��ʹĿ�ģ��������ǰ�����ӳ�䵽*ListView���н顣
		 * Adapter(������)��ʹ�ã�1���½���������
		 *                   2���������Դ����������
		 *                   3����ͼ������������
		 */	
			private void initDatas() {
				
				//��EditText�л�ȡ������Ϣ
			    String search_infm = edittext_search.getText().toString();
			    int k = 0;
				
						
				mDatas = new ArrayList<Bean>(); 
						
				for(int i=0; i<coursesDatas.length; i++){
					//��Ѱ�ҵ�������Ϣ����֮������������ ��
					if(coursesDatas[i].getCourseName().contains(search_infm) 
							|| coursesDatas[i].getTeacherName().contains(search_infm)){
					    
					    Bean bean = coursesDatas[i];
					    mDatas.add(bean);
					    
					    relativeAddr[k] = i;
				        k++;	
					}
				}
				
				if(k == 0){
					Toast toast3=Toast.makeText(getApplicationContext(), "δѰ�ҵ���Ϣ", Toast.LENGTH_SHORT);  
			    	toast3.show();
				}
		
		        //���ݼ���ӵ�������
				mMyAdapterwithCommonViewHolder = new MyAdapterwithCommonViewHolder(this, mDatas);
			}
			
			
			private void initView() {
				mListView = (ListView) findViewById(R.id.id_search_listview);
				
				//��ͼ����������
				mListView.setAdapter(mMyAdapterwithCommonViewHolder); 
			}

			
		/*	initIntent() -->ʵ�ִ�ListView��һ��Item��ת��һ��ҳ�棬
		 *                  �ɸ���Item��position�����б������λ�ã�int�ͣ���0��ʼ���������ݿ��в�����Ӧ���ݣ�ͨ����ֵ�Է�ʽ����bundle�У�
		 *                  bundle��ֵ�ɴ��ݸ���һ��ҳ����ʾ�� 
		 */
			private void initIntent() {
				//���õ��Item����
				mListView.setOnItemClickListener(this);		
			}

			//��дsetOnItemClickListener��������
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				//Toast��С�ڿ�
				//String text = mListView.getItemAtPosition(position)+"";
				//Toast.makeText(this, "position="+position+"text"+text,Toast.LENGTH_LONG ).show();
		
				//��listview�е�positionת��Ϊ�ƶ˶�Ӧ��position
				//ʵ��Ҳҳ����ת
				switch (relativeAddr[position]){
				case 0 :
					
				AVQuery<AVObject> query = new AVQuery<AVObject>("classteach_plus");
				query.getInBackground("5559f309e4b0f937a0e135e6", new GetCallback<AVObject>() {//���̲߳�ѯ�ں�̨���У�����Ӱ��������Ӧ
				    public void done(AVObject num1, AVException e) {
				        if (e == null) {
				Intent intent = new Intent(SearchActivity.this,Course1Activity.class);
				
				/* ͨ��Bundle����洢��Ҫ���ݵ����� */  
				Bundle bundle = new Bundle();  
				
		//�������������Ҫ����ƶ����ݵĵط���		
				/*�ַ����ַ������������ֽ����顢�������ȵȣ������Դ�*/  
				bundle.putInt("Cuorse1BigImg", couresesBigImgs[0].getCourseImg());
				bundle.putString("Course1Name", coursesDatas[0].getCourseName());
				bundle.putString("Course1Sum", num1.getString("classintro"));
				bundle.putString("Course1Grade", num1.getString("teachway"));
				bundle.putString("Course1TimePlace", num1.getString("classtime"));
				bundle.putString("course1MethodologyOfPerformance", num1.getString("textway"));
				
				/*��bundle����assign��Intent*/  
				intent.putExtras(bundle); 
				
				//ʵ��ҳ����޷���ֵ��ת 
				startActivity(intent);
				        } else {
				            Log.e("��ȡ����", "����: " + e.getMessage());//������ʾ��Ϣ
				        }
				    }
				});
				
				break;
				
				case 1 :
					
					AVQuery<AVObject> query1 = new AVQuery<AVObject>("classteach_plus");
					query1.getInBackground("5559f338e4b0f937a0e13936", new GetCallback<AVObject>() {//���̲߳�ѯ�ں�̨���У�����Ӱ��������Ӧ
					    public void done(AVObject num1, AVException e) {
					        if (e == null) {
					Intent intent = new Intent(SearchActivity.this,Course1Activity.class);
					
					/* ͨ��Bundle����洢��Ҫ���ݵ����� */  
					Bundle bundle = new Bundle();  
					
			//�������������Ҫ����ƶ����ݵĵط���		
					/*�ַ����ַ������������ֽ����顢�������ȵȣ������Դ�*/  
					bundle.putInt("Cuorse1BigImg", couresesBigImgs[1].getCourseImg());
					bundle.putString("Course1Name", coursesDatas[1].getCourseName());
					bundle.putString("Course1Sum", num1.getString("classintro"));
					bundle.putString("Course1Grade", num1.getString("teachway"));
					bundle.putString("Course1TimePlace", num1.getString("classtime"));
					bundle.putString("course1MethodologyOfPerformance", num1.getString("textway"));
					
					/*��bundle����assign��Intent*/  
					intent.putExtras(bundle); 
					
					//ʵ��ҳ����޷���ֵ��ת 
					startActivity(intent);
					        } else {
					            Log.e("��ȡ����", "����: " + e.getMessage());//������ʾ��Ϣ
					        }
					    }
					});
					
					break;
					
				case 2 :
					
					AVQuery<AVObject> query2 = new AVQuery<AVObject>("classteach_plus");
					query2.getInBackground("5562cd7de4b00c57d9b9fa7d", new GetCallback<AVObject>() {//���̲߳�ѯ�ں�̨���У�����Ӱ��������Ӧ
					    public void done(AVObject num1, AVException e) {
					        if (e == null) {
					Intent intent = new Intent(SearchActivity.this,Course1Activity.class);
					
					/* ͨ��Bundle����洢��Ҫ���ݵ����� */  
					Bundle bundle = new Bundle();  
					
			//�������������Ҫ����ƶ����ݵĵط���		
					/*�ַ����ַ������������ֽ����顢�������ȵȣ������Դ�*/  
					bundle.putInt("Cuorse1BigImg", couresesBigImgs[2].getCourseImg());
					bundle.putString("Course1Name", coursesDatas[2].getCourseName());
					bundle.putString("Course1Sum", num1.getString("classintro"));
					bundle.putString("Course1Grade", num1.getString("teachway"));
					bundle.putString("Course1TimePlace", num1.getString("classtime"));
					bundle.putString("course1MethodologyOfPerformance", num1.getString("textway"));
					
					/*��bundle����assign��Intent*/  
					intent.putExtras(bundle); 
					
					//ʵ��ҳ����޷���ֵ��ת 
					startActivity(intent);
					        } else {
					            Log.e("��ȡ����", "����: " + e.getMessage());//������ʾ��Ϣ
					        }
					    }
					});
					
					break;
					
				
					
				case 3 :
					
					AVQuery<AVObject> query3 = new AVQuery<AVObject>("classteach_plus");
					query3.getInBackground("5562cbfee4b00c57d9b9efbc", new GetCallback<AVObject>() {//���̲߳�ѯ�ں�̨���У�����Ӱ��������Ӧ
					    public void done(AVObject num1, AVException e) {
					        if (e == null) {
					Intent intent = new Intent(SearchActivity.this,Course1Activity.class);
					
					/* ͨ��Bundle����洢��Ҫ���ݵ����� */  
					Bundle bundle = new Bundle();  
					
			//�������������Ҫ����ƶ����ݵĵط���		
					/*�ַ����ַ������������ֽ����顢�������ȵȣ������Դ�*/  
					bundle.putInt("Cuorse1BigImg", couresesBigImgs[3].getCourseImg());
					bundle.putString("Course1Name", coursesDatas[3].getCourseName());
					bundle.putString("Course1Sum", num1.getString("classintro"));
					bundle.putString("Course1Grade", num1.getString("teachway"));
					bundle.putString("Course1TimePlace", num1.getString("classtime"));
					bundle.putString("course1MethodologyOfPerformance", num1.getString("textway"));
					
					/*��bundle����assign��Intent*/  
					intent.putExtras(bundle); 
					
					//ʵ��ҳ����޷���ֵ��ת 
					startActivity(intent);
					        } else {
					            Log.e("��ȡ����", "����: " + e.getMessage());//������ʾ��Ϣ
					        }
					    }
					});
					
					break;
					
				case 4 :
					
					AVQuery<AVObject> query4 = new AVQuery<AVObject>("classteach_plus");
					query4.getInBackground("5562ccb9e4b00c57d9b9f4ba", new GetCallback<AVObject>() {//���̲߳�ѯ�ں�̨���У�����Ӱ��������Ӧ
					    public void done(AVObject num1, AVException e) {
					        if (e == null) {
					Intent intent = new Intent(SearchActivity.this,Course1Activity.class);
					
					/* ͨ��Bundle����洢��Ҫ���ݵ����� */  
					Bundle bundle = new Bundle();  
					
			//�������������Ҫ����ƶ����ݵĵط���		
					/*�ַ����ַ������������ֽ����顢�������ȵȣ������Դ�*/  
					bundle.putInt("Cuorse1BigImg", couresesBigImgs[4].getCourseImg());
					bundle.putString("Course1Name", coursesDatas[4].getCourseName());
					bundle.putString("Course1Sum", num1.getString("classintro"));
					bundle.putString("Course1Grade", num1.getString("teachway"));
					bundle.putString("Course1TimePlace", num1.getString("classtime"));
					bundle.putString("course1MethodologyOfPerformance", num1.getString("textway"));
					
					/*��bundle����assign��Intent*/  
					intent.putExtras(bundle); 
					
					//ʵ��ҳ����޷���ֵ��ת 
					startActivity(intent);
					        } else {
					            Log.e("��ȡ����", "����: " + e.getMessage());//������ʾ��Ϣ
					        }
					    }
					});
					
					break;
					
					
				default:
					AVQuery<AVObject> query5 = new AVQuery<AVObject>("classteach_plus");
					query5.getInBackground("5562f61ce4b07ae45cfcebde", new GetCallback<AVObject>() {//���̲߳�ѯ�ں�̨���У�����Ӱ��������Ӧ
					    public void done(AVObject num1, AVException e) {
					        if (e == null) {
					Intent intent = new Intent(SearchActivity.this,Course1Activity.class);
					
					/* ͨ��Bundle����洢��Ҫ���ݵ����� */  
					Bundle bundle = new Bundle();  
					
			//�������������Ҫ����ƶ����ݵĵط���		
					/*�ַ����ַ������������ֽ����顢�������ȵȣ������Դ�*/  
					bundle.putInt("Cuorse1BigImg", couresesBigImgs[5].getCourseImg());
					bundle.putString("Course1Name", coursesDatas[5].getCourseName());
					bundle.putString("Course1Sum", num1.getString("classintro"));
					bundle.putString("Course1Grade", num1.getString("teachway"));
					bundle.putString("Course1TimePlace", num1.getString("classtime"));
					bundle.putString("course1MethodologyOfPerformance", num1.getString("textway"));
					
					/*��bundle����assign��Intent*/  
					intent.putExtras(bundle); 
					
					//ʵ��ҳ����޷���ֵ��ת 
					startActivity(intent);
					        } else {
					            Log.e("��ȡ����", "����: " + e.getMessage());//������ʾ��Ϣ
					        }
					    }
					});
					break;
			}
			
		
		
			
	
	
	}
}
