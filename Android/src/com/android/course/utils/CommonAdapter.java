package com.android.course.utils;

import java.util.List;

import com.example.netease.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class CommonAdapter<T> extends BaseAdapter {

	protected Context mContext; //protected��������Է���
	protected List<T> mDatas;
	protected LayoutInflater mInflater; //���ز���
	
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
		convert(holder, getItem(position)); //�û��Զ��尴ť����
		return holder.getmConvertView(); //��ΪConvertView����Holder�г�ʼ����
		
	}

	public abstract void convert(ViewHolder holder, T t);
}
