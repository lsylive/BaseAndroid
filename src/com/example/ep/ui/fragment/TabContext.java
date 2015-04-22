package com.example.ep.ui.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ep.R;
import com.example.ep.ui.fragment.adapter.CheckboxAdapter;
import com.example.ep.util.DateTimePickDialogUtil;


/**
 * Tab内容页
 * 
 * @author liusy 2015-04-18
 *
 */
@SuppressLint({ "NewApi", "ValidFragment" })
public class TabContext extends AbsTabContext {
	
	
	public TabContext(int layout) {
		super(layout);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		if(layout==R.layout.tab_context1)
			initTabContext1();
		else if(layout==R.layout.tab_context2)
			initTabContext2();
	}

	
	
	public void initTabContext1()
	{
		WebView mWebView = (WebView) acMain.findViewById(R.id.webView1);
		WebSettings webSettings = mWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		// mWebView.addJavascriptInterface(new Object() {
		// public void clickOnAndroid() {
		// mHandler.post(new Runnable() {
		// public void run() {
		// mWebView.loadUrl("javascript:wave()");
		// }
		// });
		// }
		// }, "demo");
		mWebView.loadUrl("http://www.baidu.com");

		// 覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
		mWebView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				// 返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
				view.loadUrl(url);
				return true;
			}
		});
		
	}
	
	
	
	
	
	ListView listView;
    String initStartDateTime = "2013年9月3日 14:44"; // 初始化开始时间  
    String initEndDateTime = "2014年8月23日 17:44"; // 初始化结束时间  
    EditText  startDateTime;
    EditText  endDateTime;  
    DateTimePickDialogUtil dateTimePicKDialog1;
    DateTimePickDialogUtil dateTimePicKDialog2;
	public void initTabContext2()
	{
		//------------------------------------初始化日期----------------------------------
		initStartDateTime = "2013年9月3日 14:44"; // 初始化开始时间
		initEndDateTime = "2014年8月23日 17:44"; // 初始化结束时间
		// 两个输入框
		startDateTime = (EditText) acMain.findViewById(R.id.editText1);
		endDateTime = (EditText) acMain.findViewById(R.id.editText2);

		startDateTime.setText(initStartDateTime);
		endDateTime.setText(initEndDateTime);
		
		dateTimePicKDialog1 = new DateTimePickDialogUtil(acMain, initEndDateTime);  
		dateTimePicKDialog2 = new DateTimePickDialogUtil(acMain, initEndDateTime);  
		
	    //绑定焦点事件
//		startDateTime.setOnFocusChangeListener(new OnFocusChangeListener() {   
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//            	if(hasFocus)
//            	dateTimePicKDialog1.dateTimePicKDialog(startDateTime);  
//            }
//        });
//		endDateTime.setOnFocusChangeListener(new OnFocusChangeListener() {  
//			public void onFocusChange(View v, boolean hasFocus) {
//				if(hasFocus)
//				dateTimePicKDialog2.dateTimePicKDialog(endDateTime);  
//            }  
//        });  
		
		startDateTime.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN: {
					dateTimePicKDialog1.dateTimePicKDialog(startDateTime);
					return true;
				}
				}
				return true;
			}
		});
		endDateTime.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN: {
					dateTimePicKDialog2.dateTimePicKDialog(endDateTime);  
					return true;
				}
				}
				return true;
			}
		});
		
		
		
		
        //-----------------------------------ListView初始化----------------------------------
		listView = (ListView)acMain.findViewById(R.id.listView1);
		ArrayList<Map<String,Object>> listData= new ArrayList<Map<String,Object>>();  
	     Map<String,Object> item = new HashMap<String,Object>();  
	        item.put("textView1", "大型设备1");  
	        item.put("textView2", "4千瓦");  
	        item.put("checkBox1", true);  
	        listData.add(item);
	        Map<String,Object> item2 = new HashMap<String,Object>();  
	        item2.put("textView1", "大型设备2");  
	        item2.put("textView2", "4千瓦");  
	        item2.put("checkBox1", false);  
	        listData.add(item2);
	        Map<String,Object> item3 = new HashMap<String,Object>();  
	        item3.put("textView1", "大型设备3");  
	        item3.put("textView2", "2千瓦");  
	        item3.put("checkBox1", false);  
	        listData.add(item3);
	        Map<String,Object> item4 = new HashMap<String,Object>();  
	        item4.put("textView1", "大型设备4");  
	        item4.put("textView2", "6千瓦");  
	        item4.put("checkBox1", false);  
	        listData.add(item4);
	       
		  //  SimpleAdapter adapter = new SimpleAdapter(acMain,mData,R.layout.context2_list_view,new String[]{"textView1","textView2","checkBox1"},new int[]{R.id.textView1,R.id.textView2,R.id.checkBox1});
	        CheckboxAdapter checkboxAdapter = new CheckboxAdapter(this, listData);
		    listView.setAdapter(checkboxAdapter);
		    listView.setOnItemClickListener(new OnItemClickListener() {  
		        @Override  
		        public void onItemClick(AdapterView<?> adapterView, View view, int position,  
		            long id) {  
		        	Map<String,Object> map = (Map<String,Object>)listView.getItemAtPosition(position);
		        	Toast.makeText(acMain,"您选择了"+map.get("textView1"), Toast.LENGTH_LONG).show();  
		        }  
		    });
		    
	}

	
	
	
	
	
	
	@Override
	public void listViewItemCheckedChanged(int currtPosition,boolean isChecked, CheckboxAdapter checkboxAdapter) {
		Map<Integer, Boolean> selectState =checkboxAdapter.getSelectState();
		String options="";
		for(int j=0;j<checkboxAdapter.getCount();j++){
			if(selectState.get(j)!=null){
			@SuppressWarnings("unchecked")
			HashMap<String, Object> map=(HashMap<String, Object>) checkboxAdapter.getItem(j);
			String textView1=map.get("textView1").toString();
			options+="\n"+textView1;
			}
		}
		Toast.makeText(acMain,"您选择了"+options, Toast.LENGTH_SHORT).show();
	}
	
	

}
