package com.example.netease;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	private Button Register;
	private EditText account;
	private EditText psw;
	private EditText email;
	private Button btn_to_lastpage;
	private Context btn_to_lastpage_context;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);//自定义的标题栏
		setContentView(R.layout.register_layout);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar1);//加载标题栏
		TextView tv = (TextView)findViewById(R.id.id_TitleContext); 
		tv.setText("注册");
		
		 account=(EditText)findViewById(R.id.set_user);
		 psw=(EditText)findViewById(R.id.set_password);
		 email=(EditText)findViewById(R.id.email_address);
		 Register=(Button)findViewById(R.id.Register);
		 Register.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					String val=account.getText().toString();
					String val1=psw.getText().toString();
					String val2=email.getText().toString();
					AVUser user = new AVUser();
					user.setUsername(val);
					user.setPassword(val1);
					user.setEmail(val2);
					user.signUpInBackground(new SignUpCallback() {
					    public void done(AVException e) {
					        if (e == null) {
					        	Toast.makeText(RegisterActivity.this,//提示浮框同时显示查询数据
										"注册成功",
										Toast.LENGTH_SHORT).show();
					        	Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
								startActivity(intent);
					        } else {
					        	Toast.makeText(RegisterActivity.this,//提示浮框同时显示查询数据
										"注册失败",
										Toast.LENGTH_SHORT).show();
					        }
					    }
					});
					
				}
			});
		 
		 btn_to_lastpage_context = this;
		 btn_to_lastpage = (Button) findViewById(R.id.id_back_to_lastpage);
		 btn_to_lastpage.setOnClickListener(new OnClickListener() {//点击跳转到注册和登录页面
				@Override
				public void onClick(View v) {
					Intent intent=new Intent(btn_to_lastpage_context, LoginActivity.class);
					startActivity(intent);
					// TODO Auto-generated method stub
				}
			});
}
}