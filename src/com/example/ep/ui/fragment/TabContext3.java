package com.example.ep.ui.fragment;

import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.ep.R;
import com.example.ep.util.FragmentMangeUtil;
import com.example.ep.util.MoveListerner;

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
		fgmUtil.putSubFragme(R.id.context3_rb3,new TabContext(R.layout.tab_context3_sub3));
		
		initFirstFragment(R.id.context3_rb1);
		
		
		acMain.findViewById(R.id.context3).setOnTouchListener(new MoveListerner(acMain){
			@Override
			public void moveDirection(View v, int direction) {
				transformLeftOrRight(direction);
			}
			@Override
			public void moveUpAndDownDistance(MotionEvent event, int distance,
					int distanceY) {
			}
			@Override
			public void moveOver() {
			}
		});
	}
	
	
	/**
	 * 
	 * @param rbId tab下的标签按钮R.id.rbMain.，mapTab中的Key
	 */
	private void initFirstFragment(Integer rbId)
	{
		acMain.findViewById(rbId).setBackgroundResource(R.color.head);
		fgmUtil.addFragmentManager(rbId);		
	}
	

	
	
	public void transformLeftOrRight(int left) {
		List<Integer> list = this.fgmUtil.getListMapTabKey();
		int rbId = 0;
		if (left == MoveListerner.MOVE_TO_LEFT) {
			for (int i = 0; i < list.size(); i++) {
				if (i == (list.size() - 1)
						&& list.get(i) == fgmUtil.getCurrentrRbId()) {
					acMain.findViewById(list.get(0)).setBackgroundResource(
							R.color.head);
					rbId = list.get(0);
					break;
				} else if (list.get(i) == fgmUtil.getCurrentrRbId()) {
					rbId = list.get(i + 1);
					break;
				}
			}
			//Toast.makeText(acMain, "向左", Toast.LENGTH_SHORT).show();
		} else if (left == MoveListerner.MOVE_TO_RIGHT) {
			for (int i = 0; i < list.size(); i++) {
				if (i == 0 && list.get(i) == fgmUtil.getCurrentrRbId()) {
					rbId = list.get(list.size() - 1);
					break;
				} else if (list.get(i) == fgmUtil.getCurrentrRbId()) {
					rbId = list.get(i - 1);
					break;
				}
			}
		//	Toast.makeText(acMain, "向右", Toast.LENGTH_SHORT).show();
		}
		if (rbId != 0) {
			acMain.findViewById(fgmUtil.getCurrentrRbId()).setBackgroundResource(R.color.body);
			fgmUtil.addFragmentManager(rbId);
			acMain.findViewById(rbId).setBackgroundResource(R.color.head);
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
