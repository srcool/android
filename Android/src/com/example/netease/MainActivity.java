package com.example.netease;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.balysv.materialmenu.MaterialMenuIcon;
import com.balysv.materialmenu.MaterialMenuDrawable.Stroke;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	/** DrawerLayout */
	private DrawerLayout mDrawerLayout;
	 /** ������˵� */ 
	private View mMenuView;
	/** Material Design��� */ 
	private MaterialMenuIcon mMaterialMenuIcon;
	/** �˵���/�ر�״̬ */ 
	private boolean isDirection_left = false;
	private View showView;
	/**Ϊ���˵���Ŀؼ�����*/
	private TextView Register_text;
	private Context Register_text_context;
	private TextView Allcourse_text;
	private TextView Collect_text;
	private TextView AboutApp_text;
	private TextView ContectUs_text;
	private ImageView Headimg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		setContentView(R.layout.activity_main);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mMenuView = (View) findViewById(R.id.left_drawer);
		this.showView = mMenuView;

		// ���ó����ʱ����Ҫ���������Զ�����Ӱ����
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		
        // ����ActionBar�ɼ��������л��˵���������ͼ
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		Resources r = getResources();
		Drawable myDrawable = r.getDrawable(R.drawable.top_background_pic);
		getActionBar().setBackgroundDrawable(myDrawable);
		
		
		mMaterialMenuIcon = new MaterialMenuIcon(this, Color.WHITE, Stroke.THIN);
		mDrawerLayout.setDrawerListener(new DrawerLayoutStateListener());

		//��û��ѡ�����˵��е�ѡ��ʱ���ص��ǿγ��б�ҳ��

					Fragment fragment = new ContentFragment();
					FragmentManager fragmentManager = getSupportFragmentManager();
					fragmentManager.beginTransaction()
							.replace(R.id.content_frame, fragment).commit();
					setTitle("ȫ���γ�");
		/**
		 * ���menu�ϵĵ���¼�
		 */
		//ע����¼�ĵ���¼�
		Register_text_context = this;
		Register_text = (TextView) findViewById(R.id.id_left_login_or_register);
		Register_text.setOnClickListener(new OnClickListener() {//�����ת��ע��͵�¼ҳ��
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(Register_text_context, LoginActivity.class);
				startActivity(intent);
				// TODO Auto-generated method stub
			}
		});
		
		Headimg = (ImageView)findViewById(R.id.id_left_icon1);
		Headimg.setOnClickListener(new OnClickListener() {//�����ת��ע��͵�¼ҳ��
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(Register_text_context, LoginActivity.class);
				startActivity(intent);
				// TODO Auto-generated method stub
			}
		});
		
		
        // ȫ���γ�
	    Allcourse_text = (TextView) findViewById(R.id.id_allcourse);
	    Allcourse_text.setOnClickListener(new OnClickListener() {//�����ת��ע��͵�¼ҳ��
			@Override
			public void onClick(View v) {
				Fragment fragment = new ContentFragment();
				Bundle args = new Bundle();
				args.putString("key", "ȫ���γ�");
				FragmentManager fragmentManager = getSupportFragmentManager();
				fragmentManager.beginTransaction()
						.replace(R.id.content_frame, fragment).commit();
				setTitle("ȫ���γ�");
				mDrawerLayout.closeDrawer(mMenuView);
			}
		});

		
		//�ҵ��ղصĵ���¼�
				Collect_text = (TextView) findViewById(R.id.id_left_collect);
				Collect_text.setOnClickListener(new OnClickListener() {//�����ת��ע��͵�¼ҳ��
					@Override
					public void onClick(View v) {
						Fragment fragment = new CollectionList();
						Bundle args = new Bundle();
						args.putString("key", "�ҵ��ղ�");
						FragmentManager fragmentManager = getSupportFragmentManager();
						fragmentManager.beginTransaction()
								.replace(R.id.content_frame, fragment).commit();
						setTitle("�ҵ��ղ�");
						mDrawerLayout.closeDrawer(mMenuView);
					}
				});

		//��������ĵ���¼�
				AboutApp_text = (TextView) findViewById(R.id.id_left_about);
				AboutApp_text.setOnClickListener(new OnClickListener() {//�����ת��ע��͵�¼ҳ��
					@Override
					public void onClick(View v) {
						Fragment fragment = new AboutAppFragment();
						Bundle args = new Bundle();
						args.putString("key", "�������");
						FragmentManager fragmentManager = getSupportFragmentManager();
						fragmentManager.beginTransaction()
								.replace(R.id.content_frame, fragment).commit();
						setTitle("�������");
						mDrawerLayout.closeDrawer(mMenuView);
					}
				});
				
	}

	/**
	 * DrawerLayout״̬�仯����
	 */
	private class DrawerLayoutStateListener extends
			DrawerLayout.SimpleDrawerListener {
		/**
		 * �������˵�������ʱ��ִ��
		 */
		@Override
		public void onDrawerSlide(View drawerView, float slideOffset) {
			showView = drawerView;
			if (drawerView == mMenuView) {// ����isDirection_left����ִ�ж��� 
				mMaterialMenuIcon.setTransformationOffset(
						MaterialMenuDrawable.AnimationState.BURGER_ARROW,
						isDirection_left ? 2 - slideOffset : slideOffset);
			} 
			}
		

		/**
		 * �������˵���ʱִ��
		 */
		@Override
		public void onDrawerOpened(android.view.View drawerView) {
			if (drawerView == mMenuView) {
				isDirection_left = true;//��߲˵���
			} 
		}

		/**
		 * �������˵��ر�ʱִ�С�
		 */
		@Override
		public void onDrawerClosed(android.view.View drawerView) {
			if (drawerView == mMenuView) {
				isDirection_left = false;//��߲˵��ر�
			}
		}
	
	
	}


	
	/**
	 * ���ActionBar�ϲ˵�ͼ��
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
		case android.R.id.home:
			if (showView == mMenuView) {
				if (!isDirection_left) { // // ������˵��ر�ʱ����
					mDrawerLayout.openDrawer(mMenuView);
				} else {// ������˵���ʱ���ر�
					mDrawerLayout.closeDrawer(mMenuView);
				}
			} 
			break;
		case R.id.ic_search:
			Intent intent=new Intent(this, SearchActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * ����onPostCreate�ص���״̬����ԭ��Ӧ��icon state 
	 */
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mMaterialMenuIcon.syncState(savedInstanceState);
	}

	/**
	 * ����onSaveInstanceState�ص���״̬�����浱ǰicon state 
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		mMaterialMenuIcon.onSaveInstanceState(outState);
		super.onSaveInstanceState(outState);
	}

	/**
	 * ���ز˵�
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
