package com.example.netease;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.GetCallback;
import com.avos.avoscloud.LogInCallback;



public class LoginActivity extends Activity {
	private Button LoginBtn;
	private TextView Forget;
	private Button RegBtn;
	private EditText Addresss; 
	private EditText psw_; 
	private Context Login_Context;
	private Context Reg_Context;
	private Button btn_to_lastpage;
	private Context btn_to_lastpage_context;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);//�Զ���ı�����
		setContentView(R.layout.login_or_register);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar1);//���ر�����
		TextView tv = (TextView)findViewById(R.id.id_TitleContext); 
		tv.setText("��½");
		
		Addresss=(EditText)findViewById(R.id.accountEt_login);
		 psw_=(EditText)findViewById(R.id.pwdEt_login);
		Reg_Context=this;
		Login_Context=this;
		RegBtn=(Button)findViewById(R.id.Register_Btn);
		RegBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(Reg_Context, RegisterActivity.class);
				startActivity(intent);
				// TODO Auto-generated method stub
			}
		});
		
		
		LoginBtn=(Button)findViewById(R.id.LoginBtn);
		LoginBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String val=Addresss.getText().toString();
				String val2=psw_.getText().toString();
				AVUser.logInInBackground(val, val2, new LogInCallback() {
				    public void done(AVUser user, AVException e) {
				        if (user != null) {
				        	Toast.makeText(LoginActivity.this,//��ʾ����ͬʱ��ʾ��ѯ����
									"��½�ɹ�",
									Toast.LENGTH_SHORT).show();
			        		Intent intent=new Intent(Login_Context, MainActivity.class);
							startActivity(intent);
				            // ��¼�ɹ�
				        } else {
				        	Toast.makeText(LoginActivity.this,//��ʾ����ͬʱ��ʾ��ѯ����
									"��¼ʧ��",
									Toast.LENGTH_SHORT).show();
				            // ��¼ʧ��
				        }
				    }
				});
				/*String val=Addresss.getText().toString();
				AVQuery<AVObject> query = new AVQuery<AVObject>("log_in");
				query.whereEqualTo("address", val);
				query.findInBackground(new FindCallback<AVObject>() {
				    public void done(List<AVObject> avObjects, AVException e) {
				        if (e == null) {
				        	String val2=psw_.getText().toString(); 
				        	for (AVObject comment : avObjects) {
				        	      //���ｫ����Ҫ����һ��������ʾͿ��Է��ʵ�post������
				        	
				        	     AVObject post = comment.getAVObject("psw");
				        	//String post = new String("222");
				        	if(post.equals(val2)){
				        		Toast.makeText(LoginActivity.this,//��ʾ����ͬʱ��ʾ��ѯ����
										"��½�ɹ�",
										Toast.LENGTH_SHORT).show();
				        		Intent intent=new Intent(Login_Context, MainActivity.class);
								startActivity(intent);
								// TODO Auto-generated method stub
				        	}
				        	}
				        	
				        	
				        
				       
				        	Log.d("�ɹ�", "srsrsrsr");
				        } else {
				            Log.d("ʧ��", "��ѯ����: " + e.getMessage());
				        }
				    }
				});*/
				
				
				
				
				
			}
		});
		
		Forget=(TextView)findViewById(R.id.forget_View);
		Forget.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Toast.makeText(LoginActivity.this,//��ʾ����ͬʱ��ʾ��ѯ����
						"�����ڴ���",
						Toast.LENGTH_SHORT).show();
		
			}
		});
		
		btn_to_lastpage_context = this;
		 btn_to_lastpage = (Button) findViewById(R.id.id_back_to_lastpage);
		 btn_to_lastpage.setOnClickListener(new OnClickListener() {//�����ת��ע��͵�¼ҳ��
				@Override
				public void onClick(View v) {
					Intent intent=new Intent(btn_to_lastpage_context, MainActivity.class);
					startActivity(intent);
					// TODO Auto-generated method stub
				}
			});
	}
}
