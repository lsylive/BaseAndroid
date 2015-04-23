package com.example.ep.ui.activity;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.ep.R;
import com.example.ep.R.id;
import com.example.ep.ui.fragment.AbsMainFragment;
import com.example.ep.ui.fragment.MainTabFragment;


/**
 * 主页面
 * 
 * @author liusy 2015-04-18
 *
 */
@SuppressLint({ "NewApi", "JavascriptInterface" })
public class MainActivity extends AbsMainActivity {

	private AbsMainFragment mainFragment;

	
	//点击返回按钮,调用主界面Fragme中的处理方法
	//提示：在activity中写onKeyDown后，onBackPressed将无效果
	@Override
	public void onBackPressed() {
		mainFragment.onBackPressed();
	}


	@Override
	protected void initMainFragment()
	{
		mainFragment = new MainTabFragment();
	    FragmentTransaction tx = fgm.beginTransaction();
	  //tx.setCustomAnimations(R.anim.push_left_in, R.anim.push_left_out,R.anim.push_left_in, R.anim.push_left_out);
	    tx.add(R.id.mainActivity, mainFragment,"mainFragment");
	  //tx.addToBackStack(null);
	    tx.commit();
	}

	

}
