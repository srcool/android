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
	
	//���췽��
	public ViewHolder(Context context, ViewGroup parent, int layoutId, int position){
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
		mConvertView.setTag(this);
	}
	
	//��ڷ������ж�convertView�Ƿ�Ϊ��
	public static ViewHolder get(Context context,View convertView, ViewGroup parent, int layoutId, int position){
		if(convertView == null){
			return new ViewHolder(context, parent, layoutId, position);
		}else{
			ViewHolder holder = (ViewHolder) convertView.getTag();
			holder.mPosition = position; //��ʹ���ã�mPosition�Ǳ仯�ģ���Ҫ����
			return holder;
		}
	}
	
	//ͨ��viewId��ȡ�ؼ�
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
	
	//ΪTextView��д��������
	public ViewHolder setText(int viewId, String text){
		TextView tv = getView(viewId);
		tv.setText(text);
		return this;
	}
	
	//ΪImageView��д��������
	public ViewHolder setImageResource(int viewId, int resId){
		ImageView view = getView(viewId);
		view.setImageResource(resId);
		return this;
	}
	
	//�������ImageView
	public ViewHolder setImageURI(int viewId, String url){
	
		ImageView view = getView(viewId);
		//Ŀǰ�޸���    Imageloader.getInstance().loadImg(view, url);
		return this;
	}


}


