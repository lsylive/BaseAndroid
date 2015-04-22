package com.example.ep.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ep.R;
import com.example.ep.util.UserInfo;

/**
 * 登陆
 * 
 * @author liusy 2015-04-18
 *
 */
public class LoginActivity extends Activity implements Runnable {
	
	private ProgressBar  progressBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		
		progressBar= (ProgressBar) this.findViewById(R.id.progressBar1);
		
		
		this.findViewById(R.id.loginBtn).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						
						
						showProgressBar(progressBar,true);
						UserInfo userInfo = new UserInfo("1","liusy","liusy","刘先生","3615@qq.com","经理","市场部","佛山佛格机电设备有限公司");
						Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
						showProgressBar(progressBar,false);
						Intent intent = new Intent(LoginActivity.this, MainActivity.class);
						Bundle bundle = new Bundle();
						bundle.putSerializable("UserInfo", userInfo);
						intent.putExtras(bundle);
						startActivity(intent);
					    finish();//不加这一句，按回退键就会回到欢迎界面不合理。
					}
				});
		
		
	}

	
	private void showProgressBar(ProgressBar  mProgressBar01,boolean flag)
	{
        /* 将隐藏的ProgressBar显示出来 */
		if(flag)  mProgressBar01.setVisibility(View.VISIBLE);
        /* 设置ProgressBar Widget为隐藏 */
		else  mProgressBar01.setVisibility(View.GONE);
	}

	@Override
	public void run() {
		
	}

}
