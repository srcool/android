package com.example.netease;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AboutAppFragment extends Fragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.aboutapp_fragment, container, false);
		TextView tv = (TextView)view.findViewById(R.id.id_plus);
		tv.setText("¹ØÓÚ¿Î³ÌPlus");
	return view;
	}
}
