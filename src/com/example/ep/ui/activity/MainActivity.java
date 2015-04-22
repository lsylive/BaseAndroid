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

//	@Override
//	public boolean dispatchTouchEvent(MotionEvent ev) {
//		// TODO Auto-generated method stub
//		return mainFragment.dispatchTouchEvent(ev);
//	}
	
	
	
	
	

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

	
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
//	     switch (event.getAction()) {
//         case MotionEvent.ACTION_DOWN:// 手指按下时
//                 startX = (int) event.getRawX();
//                 startY = (int) event.getRawY();
//                 break;
//         case MotionEvent.ACTION_MOVE:// 手指移动时
//                 int currentX = (int) event.getRawX();// 获取当前x坐标
//                 int currentY = (int) event.getRawY();// 获取当前y坐标
//                 int disX = currentX - startX;// x方向移动的距离
//                 int disY = currentY - startY;// y方向移动的距离
//                 // 当x方向移动的距离大于y方向移动的距离时
//                 if (Math.abs(disX) > Math.abs(disY) ) {
//                         
//                 }
//                 startX = (int) event.getRawX();
//                 startY = (int) event.getRawY();
//                 break;
//         case MotionEvent.ACTION_UP:// 手指离开时
//
//                 break;
//
//         }
		return super.onTouchEvent(event);
	}


	
	

}
