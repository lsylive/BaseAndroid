package com.example.ep.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;

import com.example.ep.R;
import com.example.ep.R.layout;
import com.example.ep.util.UserInfo;

/**
 * 主页面父类
 * 
 * @author liusy 2015-04-18
 *
 */
@SuppressLint({ "NewApi", "JavascriptInterface" })
public abstract class AbsMainActivity extends Activity {

	
	protected FragmentManager fgm;
	protected Display display;
	protected UserInfo userInfo = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//如果没登陆，将跳转到登陆页面,登陆了，将进入方法
		if(checkUserLogin())
		{
			//获得Fragment管理所需要的类的对象
			fgm = getFragmentManager();
	        display = getWindowManager().getDefaultDisplay();
	        initMainFragment();
		}
        
	}
	
	protected abstract void initMainFragment();
	
	/**
	 * 检查用户是否登陆
	 * 
	 * @return true 已经登陆，false 未登陆
	 */
	private boolean checkUserLogin()
	{
		
		 	Intent intent = this.getIntent();  
	        Bundle bundle = intent.getExtras();  
	        if(null != bundle )
	        {
	        	 userInfo = (UserInfo) bundle.get("UserInfo");
	        }
	        
	        
	        
		if(null==userInfo)
		{
			Intent intentLoginActivity = new Intent(AbsMainActivity.this, LoginActivity.class);
            startActivity(intentLoginActivity);
            finish();    //不加这一句，按回退键就会回到欢迎界面不合理。
            return false;
		}
		return true;
	}
	
	
	public UserInfo getUserInfo()
	{
		return this.userInfo;
	}

}
