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
	 /** 左边栏菜单 */ 
	private View mMenuView;
	/** Material Design风格 */ 
	private MaterialMenuIcon mMaterialMenuIcon;
	/** 菜单打开/关闭状态 */ 
	private boolean isDirection_left = false;
	private View showView;
	/**为左侧菜单项的控件声明*/
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

		// 设置抽屉打开时，主要内容区被自定义阴影覆盖
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		
        // 设置ActionBar可见，并且切换菜单和内容视图
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		Resources r = getResources();
		Drawable myDrawable = r.getDrawable(R.drawable.top_background_pic);
		getActionBar().setBackgroundDrawable(myDrawable);
		
		
		mMaterialMenuIcon = new MaterialMenuIcon(this, Color.WHITE, Stroke.THIN);
		mDrawerLayout.setDrawerListener(new DrawerLayoutStateListener());

		//当没有选择左侧菜单中的选项时加载的是课程列表页面

					Fragment fragment = new ContentFragment();
					FragmentManager fragmentManager = getSupportFragmentManager();
					fragmentManager.beginTransaction()
							.replace(R.id.content_frame, fragment).commit();
					setTitle("全部课程");
		/**
		 * 左侧menu上的点击事件
		 */
		//注册或登录的点击事件
		Register_text_context = this;
		Register_text = (TextView) findViewById(R.id.id_left_login_or_register);
		Register_text.setOnClickListener(new OnClickListener() {//点击跳转到注册和登录页面
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(Register_text_context, LoginActivity.class);
				startActivity(intent);
				// TODO Auto-generated method stub
			}
		});
		
		Headimg = (ImageView)findViewById(R.id.id_left_icon1);
		Headimg.setOnClickListener(new OnClickListener() {//点击跳转到注册和登录页面
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(Register_text_context, LoginActivity.class);
				startActivity(intent);
				// TODO Auto-generated method stub
			}
		});
		
		
        // 全部课程
	    Allcourse_text = (TextView) findViewById(R.id.id_allcourse);
	    Allcourse_text.setOnClickListener(new OnClickListener() {//点击跳转到注册和登录页面
			@Override
			public void onClick(View v) {
				Fragment fragment = new ContentFragment();
				Bundle args = new Bundle();
				args.putString("key", "全部课程");
				FragmentManager fragmentManager = getSupportFragmentManager();
				fragmentManager.beginTransaction()
						.replace(R.id.content_frame, fragment).commit();
				setTitle("全部课程");
				mDrawerLayout.closeDrawer(mMenuView);
			}
		});

		
		//我的收藏的点击事件
				Collect_text = (TextView) findViewById(R.id.id_left_collect);
				Collect_text.setOnClickListener(new OnClickListener() {//点击跳转到注册和登录页面
					@Override
					public void onClick(View v) {
						Fragment fragment = new CollectionList();
						Bundle args = new Bundle();
						args.putString("key", "我的收藏");
						FragmentManager fragmentManager = getSupportFragmentManager();
						fragmentManager.beginTransaction()
								.replace(R.id.content_frame, fragment).commit();
						setTitle("我的收藏");
						mDrawerLayout.closeDrawer(mMenuView);
					}
				});

		//关于软件的点击事件
				AboutApp_text = (TextView) findViewById(R.id.id_left_about);
				AboutApp_text.setOnClickListener(new OnClickListener() {//点击跳转到注册和登录页面
					@Override
					public void onClick(View v) {
						Fragment fragment = new AboutAppFragment();
						Bundle args = new Bundle();
						args.putString("key", "关于软件");
						FragmentManager fragmentManager = getSupportFragmentManager();
						fragmentManager.beginTransaction()
								.replace(R.id.content_frame, fragment).commit();
						setTitle("关于软件");
						mDrawerLayout.closeDrawer(mMenuView);
					}
				});
				
	}

	/**
	 * DrawerLayout状态变化监听
	 */
	private class DrawerLayoutStateListener extends
			DrawerLayout.SimpleDrawerListener {
		/**
		 * 当导航菜单滑动的时候被执行
		 */
		@Override
		public void onDrawerSlide(View drawerView, float slideOffset) {
			showView = drawerView;
			if (drawerView == mMenuView) {// 根据isDirection_left决定执行动画 
				mMaterialMenuIcon.setTransformationOffset(
						MaterialMenuDrawable.AnimationState.BURGER_ARROW,
						isDirection_left ? 2 - slideOffset : slideOffset);
			} 
			}
		

		/**
		 * 当导航菜单打开时执行
		 */
		@Override
		public void onDrawerOpened(android.view.View drawerView) {
			if (drawerView == mMenuView) {
				isDirection_left = true;//左边菜单打开
			} 
		}

		/**
		 * 当导航菜单关闭时执行
		 */
		@Override
		public void onDrawerClosed(android.view.View drawerView) {
			if (drawerView == mMenuView) {
				isDirection_left = false;//左边菜单关闭
			}
		}
	
	
	}


	
	/**
	 * 点击ActionBar上菜单图标
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
		case android.R.id.home:
			if (showView == mMenuView) {
				if (!isDirection_left) { // // 左边栏菜单关闭时，打开
					mDrawerLayout.openDrawer(mMenuView);
				} else {// 左边栏菜单打开时，关闭
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
	 * 根据onPostCreate回调的状态，还原对应的icon state 
	 */
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mMaterialMenuIcon.syncState(savedInstanceState);
	}

	/**
	 * 根据onSaveInstanceState回调的状态，保存当前icon state 
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		mMaterialMenuIcon.onSaveInstanceState(outState);
		super.onSaveInstanceState(outState);
	}

	/**
	 * 加载菜单
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
