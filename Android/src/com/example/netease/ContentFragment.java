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
	//listview�ı�������
		private ListView mListView; //�����б�
		private List<Bean> mDatas; //�������ݼ�
		private MyAdapterwithCommonViewHolder mMyAdapterwithCommonViewHolder; //1���½���������
		private Context mContext;
		
		//Bean�����һ�����һ�ſγ���Ϣ�Ľṹ�壬����Bean���͵�����coursesDatas����i�ſδ���Bean[i]�С�
		private AllCourses coursesData = new AllCourses();
		Bean[] coursesDatas =  coursesData.allCourses;
		
		//�γ̱���ͼ����
		private AllcoursesBigImg couresesBigImg = new AllcoursesBigImg();
		ImgBean[] couresesBigImgs = couresesBigImg.allcoursesBigImg;
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_layout, container, false);
		mContext = getActivity().getApplicationContext();
		AVOSCloud.initialize(mContext, "5pboq38097nyu227n71r8xnzzn2t1vh2ci6979n93wvi2mut", "s9g84wka9ldhg1uqrzlx945z0zzey8osl35sr7s2nov4lg69");
		mListView = (ListView)view.findViewById(R.id.id_listview);
		//listview������������
		initDatas(); //2���������Դ��������
		
		//��ͼ����������
		mListView.setAdapter(mMyAdapterwithCommonViewHolder); 
		mListView.setOnItemClickListener(new DrawerItemClickListener());	
		return view;
	}

	/*ListView:Androidϵͳ����ʾ�б�Ŀؼ���
	 * Adapter(������)��ʹĿ�ģ��������ǰ�����ӳ�䵽*ListView���н顣
	 * Adapter(������)��ʹ�ã�1���½���������
	 *                   2���������Դ����������
	 *                   3����ͼ������������
	 */	
		private void initDatas() {
			
			
			mDatas = new ArrayList<Bean>(); 
					
			for(int i=0; i<coursesDatas.length; i++){
				Bean bean = coursesDatas[i];
				mDatas.add(bean);
					}
			   
		
	        //���ݼ���ӵ�������
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
		query.getInBackground("5559f309e4b0f937a0e135e6", new GetCallback<AVObject>() {//���̲߳�ѯ�ں�̨���У�����Ӱ��������Ӧ
		    public void done(AVObject num1, AVException e) {
		        if (e == null) {
		Intent intent = new Intent(getActivity(),Course1Activity.class);
		
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
		
	case 1:
		AVQuery<AVObject> query1 = new AVQuery<AVObject>("classteach_plus");
		query1.getInBackground("5559f338e4b0f937a0e13936", new GetCallback<AVObject>() {//���̲߳�ѯ�ں�̨���У�����Ӱ��������Ӧ
		    public void done(AVObject num1, AVException e) {
		        if (e == null) {
		Intent intent = new Intent(getActivity(),Course1Activity.class);
		
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
	case 2:
		AVQuery<AVObject> query2 = new AVQuery<AVObject>("classteach_plus");
		query2.getInBackground("5562cd7de4b00c57d9b9fa7d", new GetCallback<AVObject>() {//���̲߳�ѯ�ں�̨���У�����Ӱ��������Ӧ
		    public void done(AVObject num1, AVException e) {
		        if (e == null) {
		Intent intent = new Intent(getActivity(),Course1Activity.class);
		
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
		Intent intent = new Intent(getActivity(),Course1Activity.class);
		
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
		Intent intent = new Intent(getActivity(),Course1Activity.class);
		
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
		Intent intent = new Intent(getActivity(),Course1Activity.class);
		
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

    // ����ѡ����item��title��Ȼ��رղ˵�  	
	mListView.setItemChecked(position, true);
	//setTitle(mMenuTitles[position]);
     }
		}
}
