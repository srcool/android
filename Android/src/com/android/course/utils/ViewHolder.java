package com.android.course.utils;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {

	private SparseArray<View> mViews;
	private int mPosition;
	private View mConvertView;
	
	//构造方法
	public ViewHolder(Context context, ViewGroup parent, int layoutId, int position){
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
		mConvertView.setTag(this);
	}
	
	//入口方法，判断convertView是否为空
	public static ViewHolder get(Context context,View convertView, ViewGroup parent, int layoutId, int position){
		if(convertView == null){
			return new ViewHolder(context, parent, layoutId, position);
		}else{
			ViewHolder holder = (ViewHolder) convertView.getTag();
			holder.mPosition = position; //即使复用，mPosition是变化的，需要更新
			return holder;
		}
	}
	
	//通过viewId获取控件
	public <T extends View> T getView(int viewId){
		View view = mViews.get(viewId);
		
		if(view == null){
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId,view);
		}
		return (T)view;
	}

	public View getmConvertView() {
		return mConvertView;
	}
	
	//为TextView编写辅助方法
	public ViewHolder setText(int viewId, String text){
		TextView tv = getView(viewId);
		tv.setText(text);
		return this;
	}
	
	//为ImageView编写辅助方法
	public ViewHolder setImageResource(int viewId, int resId){
		ImageView view = getView(viewId);
		view.setImageResource(resId);
		return this;
	}
	
	//网络加载ImageView
	public ViewHolder setImageURI(int viewId, String url){
	
		ImageView view = getView(viewId);
		//目前无该类    Imageloader.getInstance().loadImg(view, url);
		return this;
	}


}


