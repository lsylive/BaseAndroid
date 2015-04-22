package com.example.ep.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.example.ep.ui.fragment.adapter.CheckboxAdapter;

/**
 * Tab内容基类
 * 
 * @author liusy 2015-04-18
 *
 */
@SuppressLint("NewApi")
public abstract class AbsTabContext extends AbsBaseFragment {
	
	
	protected  int layout;

	public AbsTabContext(int layout) {
		super();
		this.layout = layout;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		  return inflater.inflate(layout, container,false);
	}


	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		if(!hidden)
		{
			//在前端显示
		}
		else
		{
			//不在前端显示
		}
	}
	
	

	public int getLayout() {
		return layout;
	}


	public void listViewItemCheckedChanged(int currtPosition,boolean isChecked,CheckboxAdapter checkboxAdapter){};
}
