package com.example.ep.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.ep.ui.activity.AbsMainActivity;

/**
 * Fragme基本类
 * 
 * @author liusy 2015-04-18
 *
 */
@SuppressLint("NewApi")
public abstract class AbsBaseFragment extends Fragment {
	
	protected AbsMainActivity acMain;
	
	protected FragmentManager fgm;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			acMain = (AbsMainActivity)this.getActivity();
			fgm = acMain.getFragmentManager();
		  return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	
}
