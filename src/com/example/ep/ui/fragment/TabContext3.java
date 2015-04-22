package com.example.ep.ui.fragment;

import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

import com.example.ep.R;
import com.example.ep.util.FragmentMangeUtil;

@SuppressLint({ "NewApi", "ValidFragment" })
public class TabContext3 extends AbsTabContext {
	
	
	
	private FragmentMangeUtil fgmUtil;
	
	
	public TabContext3(int layout) {
		super(layout);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		 initTabContext();
	}

	
	
	public void initTabContext()
	{
		//添加改页面动作不需要加入到回退键事件中
		fgmUtil = new FragmentMangeUtil(this.fgm,R.id.tab_context3_fragmentRoot,false);
		
		fgmUtil.putSubFragme(R.id.context3_rb1, new TabContext(R.layout.tab_context3_sub1));
		fgmUtil.putSubFragme(R.id.context3_rb2,new TabContext(R.layout.tab_context3_sub2));
		
		initFirstFragment(R.id.context3_rb1);
		
		
//		acMain.findViewById(R.id.context3).setOnTouchListener(new OnTouchListener(){
//			@Override
//			public boolean onTouch(View arg0, MotionEvent arg1) {
//				dispatchTouchEvent(arg1);
//				return false;
//			}});
	}
	
	
	/**
	 * 
	 * @param rbId tab下的标签按钮R.id.rbMain.，mapTab中的Key
	 */
	private void initFirstFragment(Integer rbId)
	{
		acMain.findViewById(rbId).setBackgroundResource(R.color.black_overlay);
		fgmUtil.addFragmentManager(rbId);		
	}
	
	
	
	/*
	 * 上下左右事件
	 */
	private float mPosX;
	private float mPosY;
	private float mCurrentPosX;
	private float mCurrentPosY;
	public boolean dispatchTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		// 按下
		case MotionEvent.ACTION_DOWN:
			mPosX = event.getX();
			mPosY = event.getY();
			break;
		// 移动
		case MotionEvent.ACTION_MOVE:
			mCurrentPosX = event.getX();
			mCurrentPosY = event.getY();
			if (mCurrentPosX - mPosX > 0 && Math.abs(mCurrentPosY - mPosY) < 10) {
				transformLeftOrRight(MotionEvent.EDGE_RIGHT);
			} else if (mCurrentPosX - mPosX < 0 && Math.abs(mCurrentPosY - mPosY) < 10) {
				transformLeftOrRight(MotionEvent.EDGE_LEFT);
			}
			else if (mCurrentPosY - mPosY > 0 && Math.abs(mCurrentPosX - mPosX) < 10) {
				//transformTopOrBottom(MotionEvent.EDGE_BOTTOM);
			}
			else if (mCurrentPosY - mPosY < 0 && Math.abs(mCurrentPosX - mPosX) < 10) {
				//transformTopOrBottom(MotionEvent.EDGE_TOP);
			}
			break;
		// 拿起
		case MotionEvent.ACTION_UP:
			break;
		default:
			break;
		}
		return true;
	}
	
	
	
	public void transformLeftOrRight(int left)
	{
		List<Integer> list =this.fgmUtil.getListMapTabKey();
		if (left == MotionEvent.EDGE_LEFT) {
			for (int i = 0; i < list.size(); i++) {
					if (i == (list.size()-1) && list.get(i) == fgmUtil.getCurrentrRbId())
					break;
					else if (list.get(i) == fgmUtil.getCurrentrRbId()) {
					fgmUtil.addFragmentManager(list.get(i+1));
					break;
				}
			}
			 Toast.makeText(acMain, "向左", Toast.LENGTH_SHORT).show();
		}
		else if(left ==MotionEvent.EDGE_RIGHT)
		{
			for (int i = 0; i < list.size(); i++) {
				if (i == 0 && list.get(i) == fgmUtil.getCurrentrRbId())
				break;
				else if (list.get(i) == fgmUtil.getCurrentrRbId()) {
				fgmUtil.addFragmentManager(list.get(i-1));
				break;
			}
		}
			
			
		Toast.makeText(acMain, "向右", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void transformTopOrBottom(int top)
	{
		if(top == MotionEvent.EDGE_TOP)
		{
			Toast.makeText(acMain, "向下", Toast.LENGTH_SHORT).show();
		}
		else if(top ==MotionEvent.EDGE_BOTTOM)
		{
			Toast.makeText(acMain, "向上", Toast.LENGTH_SHORT).show();
		}
	}
	
	
	
}
