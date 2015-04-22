package com.example.ep.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.example.ep.ui.fragment.AbsTabContext;


/**
 * 控制各页面加载显示，隐藏等操作
 * 
 * @author liusy 2015-04-20
 *
 */
@SuppressLint("NewApi")
public class FragmentMangeUtil {

	
	//首页，tab下的标签按钮R.id.rbMain.，mapTab中的Key， 
	private int homePageRbId = 0;
	
	//Fragme中的layout R.layout.tab_context1
	private int currentLayout = 0;
	//tab下的标签按钮R.id.rbMain.，mapTab中的Key
	private int currentrRbId = 0;
	//要在tab里显示的内容，如{currentrRbId,Fragment}始
	private Map<Integer,AbsTabContext> mapTab = new HashMap<Integer,AbsTabContext>();
	
	private List<Integer> listMapTabKey = new ArrayList<Integer>();
	
	private FragmentManager fgm;
	
	private Integer fragmentRoot;
	
	private boolean isAddToBackStack = true;
	
	
	
	
	public FragmentMangeUtil(FragmentManager fgm,Integer fragmentRoot) {
		super();
		this.fgm = fgm;
		this.fragmentRoot = fragmentRoot;
	}
	
	public FragmentMangeUtil(FragmentManager fgm,Integer fragmentRoot,boolean isAddToBackStack) {
		super();
		this.fgm = fgm;
		this.fragmentRoot = fragmentRoot;
		this.isAddToBackStack = isAddToBackStack;
	}
	
	

	public void putSubFragme(Integer rbId,AbsTabContext absTabContext)
	{
		this.mapTab.put(rbId, absTabContext);
		listMapTabKey.add(rbId);
	}
	
	
	public boolean isHomePage()
	{
		return homePageRbId == currentrRbId;
	}
	
	
	/**
	 * 
	 * @param rbId  tab下的标签按钮Id，mapTab中的Key
	 * @param tabContextFragme
	 */
	public void addFragmentManager(Integer rbId)
	{
		addFragmentManager(rbId,mapTab.get(rbId));
	}


	public Map<Integer, AbsTabContext> getMapTab() {
		return mapTab;
	}

	public List<Integer> getListMapTabKey() {
		return listMapTabKey;
	}

	public int getCurrentLayout() {
		return currentLayout;
	}

	public void setCurrentLayout(int currentLayout) {
		this.currentLayout = currentLayout;
	}

	public int getCurrentrRbId() {
		return currentrRbId;
	}

	public void setCurrentrRbId(int currentrRbId) {
		this.currentrRbId = currentrRbId;
	}

	
	
	
	
	public int gethomePageRbId() {
		return homePageRbId;
	}

	/**
	 * 
	 * @param rbId  tab下的标签按钮Id，mapTab中的Key
	 * @param tabContextFragme
	 */
	private void addFragmentManager(Integer rbId,AbsTabContext tabContextFragme)
	{
		if(homePageRbId==0)
		{
			this.homePageRbId = rbId;//第一次添加的页面是显示的页面
		}
		
		if(fgm.findFragmentByTag(String.valueOf(tabContextFragme.getLayout()))!=null) {
			if(!fgm.findFragmentByTag(String.valueOf(tabContextFragme.getLayout())).isVisible())
			{
				//存在，但没显示
				FragmentTransaction ft=	fgm.beginTransaction();
				//ft.setCustomAnimations(R.anim.push_left_in, R.anim.push_right_out);
				ft.hide(fgm.findFragmentByTag(String.valueOf(currentLayout)));
				ft.show(fgm.findFragmentByTag(String.valueOf(tabContextFragme.getLayout())));
				ft.commit();
				//Toast.makeText(acMain, "This is a "+layout+"  "+R.id.rbMain, Toast.LENGTH_LONG).show();
				
				
			}
		}else
		{
			FragmentTransaction ft = fgm.beginTransaction();
			//ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
			if(currentLayout!=0)
			ft.hide(fgm.findFragmentByTag(String.valueOf(currentLayout)));
			ft.add(fragmentRoot, tabContextFragme, String.valueOf(tabContextFragme.getLayout()));
			if(isAddToBackStack)
			ft.addToBackStack(String.valueOf(tabContextFragme.getLayout()));
			ft.commit();
		}
		currentLayout = tabContextFragme.getLayout();
		currentrRbId = rbId;
	}
}
