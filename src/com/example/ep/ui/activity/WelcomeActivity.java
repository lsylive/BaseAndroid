package com.example.ep.ui.activity;

import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.ep.R;
import com.example.ep.R.id;
import com.example.ep.R.layout;
import com.example.ep.util.SystemUiHider;

/**
 * 欢迎页面
 * 
 * @author liusy 2015-04-18
 *
 */
@SuppressLint("NewApi")
public class WelcomeActivity extends Activity {


	private Timer timer;
	
	private Activity activity;
	
	 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.welcome);
        
        activity = this;
		timer = new Timer(true);
		timer.schedule(hello, 100, 1000); //延迟200毫秒执行，每150毫秒执行一次
		 

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
  
    }
    
    final Handler handler = new Handler(){
    	TextView txtView;
        @Override
        public void handleMessage(Message msg) {
            //循环播放图片,到计时进入系统
        	//fragmentManager.findFragmentById(arg0)(R.id.welcomeLayout)
        	txtView =(TextView) activity.findViewById(R.id.welcomeLable);
        	txtView.setText("进入系统"+msg.what);
           // iv.setBackgroundResource(hellores[msg.what]);
        }
    };
    
    
    TimerTask hello = new TimerTask(){ 
    	private int index = 0;
    	  @Override
    	  public void run() {
    	    if(index < 3){
    	      index++;
    	      Message msg = new Message();
    	      msg.what = index;
    	      handler.sendMessage(msg);
    	    }else if(index < 5){
    	      index++;  //静止片刻
    	    }else{
    	      //停止播放，启动主Activity
    	      timer.cancel();
    	      Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
    	      startActivity(intent);
    	      WelcomeActivity.this.finish();  
    	      //进入登陆界面 
    	    }
    	  } 
    	};
    	
    
}




