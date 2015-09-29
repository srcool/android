package com.android.course.utils;

import java.util.List;

import com.example.netease.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class CommonAdapter<T> extends BaseAdapter {

	protected Context mContext; //protected让子类可以访问
	protected List<T> mDatas;
	protected LayoutInflater mInflater; //加载布局
	
	public CommonAdapter(Context context, List<T> datas){
		this.mContext = context;
		this.mDatas = datas;
		mInflater = LayoutInflater.from(context);
		
	}
	
	@Override
	public int getCount() {
		
		return mDatas.size();
	}

	@Override
	public T getItem(int position) {
		
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent){

		ViewHolder holder = ViewHolder.get(mContext, convertView, parent, R.layout.item_listview, position);
		convert(holder, getItem(position)); //用户自定义按钮内容
		return holder.getmConvertView(); //因为ConvertView是在Holder中初始化的
		
	}

	public abstract void convert(ViewHolder holder, T t);
}
