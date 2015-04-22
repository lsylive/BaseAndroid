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
 * Fragme主页面基类
 * 
 * @author liusy 2015-04-18
 *
 */
@SuppressLint("NewApi")
public abstract class AbsMainFragment extends AbsBaseFragment {
	
	
	
	/**
	 * 回退（activity事件    点击返回按钮）
	 * 
	 * 提示：在activity中写onKeyDown后，onBackPressed将无效果
	 * 
	 * 供给主Activity调用，既acMain
	 */
	public  void onBackPressed(){};
	
	public boolean dispatchTouchEvent(MotionEvent ev){return true;}
	
}
