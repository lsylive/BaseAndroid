package com.example.ep.ui.fragment;

import java.util.Map.Entry;

import android.annotation.SuppressLint;
import android.app.FragmentManager.OnBackStackChangedListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ep.R;
import com.example.ep.util.FragmentMangeUtil;


/**
 * Fragme主页面，启动页面
 * 
 * @author liusy 2015-04-18
 *
 */
@SuppressLint({ "NewApi", "ResourceAsColor", "UseSparseArrays" })
public class MainTabFragment extends AbsMainFragment {
	

	
	private FragmentMangeUtil fgmUtil;
	
	//判断是否是回退键事件
	private boolean isButtonsClickEvent = true;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			super.onCreateView(inflater, container, savedInstanceState);
		  return inflater.inflate(R.layout.main_tab, container,false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);

		
		
		
		initBackStackChangedListener();
		
		initFragment();
		
		initBottomButtonsClickEvent();
		
		
		
	}

	
	 
		/**
		 * 初始化Fragment页面集合
		 */
		private void initFragment() {
			
			fgmUtil = new FragmentMangeUtil(this.fgm,R.id.fragmentRoot);
			
			fgmUtil.putSubFragme(R.id.rbMain, new TabContext1(R.layout.tab_context1));
			fgmUtil.putSubFragme(R.id.rbCategory,new TabContext(R.layout.tab_context2));
			//fgmUtil.putSubFragme(R.id.rbFind, new TabContext(R.layout.tab_context3));
			fgmUtil.putSubFragme(R.id.rbFind, new TabContext3(R.layout.tab_context3));
			fgmUtil.putSubFragme(R.id.rbData,new TabContext(R.layout.tab_context4));
			fgmUtil.putSubFragme(R.id.rbMe,new TabContext(R.layout.tab_context5));
			
			initFirstFragment(R.id.rbMain);
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
		
		
		
		
		/**
		 * 处理底部点击事件
		 */
		private RadioButton rb;
		private void initBottomButtonsClickEvent() { 
			
			OnClickListener bottomButtonsClick =new OnClickListener() {
				@Override
				public void onClick(View v) {
					String name =(String) ((RadioButton)v).getText();
					
					acMain.findViewById(fgmUtil.getCurrentrRbId()).setBackgroundResource(R.color.footBar);
					
					for(Integer rbId :fgmUtil.getMapTab().keySet())
					{
						rb = ((RadioButton)acMain.findViewById(rbId));
						if(name.equals(rb.getText()))
						{
							((TextView)acMain.findViewById(R.id.tvOrg)).setText(rb.getText());
							
							//Toast.makeText(acMain, ((TextView)acMain.findViewById(R.id.tvOrg)).getText()+"  :   ", Toast.LENGTH_SHORT).show();
							
							acMain.findViewById(rbId).setBackgroundResource(R.color.black_overlay);
							fgmUtil.addFragmentManager(rbId);
							
						}
					}
				}
				
			};
			
			for(Integer rbId :fgmUtil.getMapTab().keySet())
			{
				rb = ((RadioButton)acMain.findViewById(rbId));
				rb.setOnClickListener(bottomButtonsClick);
			}
		}
		
		
		/**
		 * 从back stack弹出所有的fragment，保留首页的那个
		 */
		public void popAllFragmentsExceptTheBottomOne() {
			for (int i = 0, count = fgm.getBackStackEntryCount() - 1; i < count; i++) {
				fgm.popBackStack();
			}
		}
		
		
	/**
	 * 回退
	 * 提示：在activity中写onKeyDown后，onBackPressed将无效果
	 * 供给主Activity调用，既acMain
	 */
	private long exitTime = 0;
	@Override
	public void onBackPressed() {
		if (fgmUtil.isHomePage()) {
			//显示的是第一个页面,按两下退出
			  if((System.currentTimeMillis()-exitTime) > 2000){  
		        	Toast.makeText(acMain, "再按一次退出程序", Toast.LENGTH_SHORT).show();
		            exitTime = System.currentTimeMillis(); 
		        } else {
		        	acMain.finish();
		        }
		} else {
			isButtonsClickEvent = false;
			fgm.popBackStack();
		}
	}
				
	
		
		
		public void initBackStackChangedListener()
		{
			fgm.addOnBackStackChangedListener(new OnBackStackChangedListener(){
				@Override
				public void onBackStackChanged() {
					//只有当用户按回退键的时候才执行
					if(!isButtonsClickEvent)
					{
						for(Entry<Integer,AbsTabContext> entry:fgmUtil.getMapTab().entrySet())
						{
							if(entry.getValue().isVisible()&&entry.getKey()!=fgmUtil.getCurrentrRbId())
							{
								acMain.findViewById(entry.getKey()).setBackgroundResource(R.color.black_overlay);
								acMain.findViewById(fgmUtil.getCurrentrRbId()).setBackgroundResource(R.color.footBar);
								((TextView)acMain.findViewById(R.id.tvOrg)).setText(((RadioButton) acMain.findViewById(fgmUtil.getCurrentrRbId())).getText());
								
								 //Toast.makeText(acMain, ((RadioButton) acMain.findViewById(fgmUtil.getCurrentrRbId())).getText()+"  :   "+((RadioButton) acMain.findViewById(entry.getKey())).getText(), Toast.LENGTH_SHORT).show();
								fgmUtil.setCurrentLayout(entry.getValue().getLayout());
								fgmUtil.setCurrentrRbId(entry.getKey());
							}
						}
						isButtonsClickEvent = true;
					}
				}});
		}
		

	
	
	
	
	
	
	

}
