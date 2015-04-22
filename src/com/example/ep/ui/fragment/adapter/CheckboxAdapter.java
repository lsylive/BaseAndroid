package com.example.ep.ui.fragment.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.example.ep.R;
import com.example.ep.ui.fragment.AbsTabContext;


/**
 * 数据适配器
 * 
 * @author liusy 2015-04-18
 *
 */
@SuppressLint("NewApi")
public class CheckboxAdapter extends BaseAdapter {

	Context context;
	ArrayList<Map<String, Object>> listData;
	AbsTabContext tabFragment;
	CheckboxAdapter checkboxAdapter;
	
	// 记录checkbox的状态
	Map<Integer, Boolean> selectState = new HashMap<Integer, Boolean>();

	// 构造函数
	public CheckboxAdapter(AbsTabContext tabFragment,ArrayList<Map<String, Object>> listData) {
		this.tabFragment = tabFragment;
		this.context = tabFragment.getActivity();
		this.listData = listData;
		this.checkboxAdapter = this;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listData.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listData.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	public Map<Integer, Boolean>  getSelectState()
	{
		return this.selectState;
	}

	// 重写View
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		LayoutInflater mInflater = LayoutInflater.from(context);
		convertView = mInflater.inflate(R.layout.context2_list_view, null);
		TextView textView1 = (TextView) convertView.findViewById(R.id.textView1);
		textView1.setText((String) listData.get(position).get("textView1"));
		TextView textView2 = (TextView) convertView.findViewById(R.id.textView2);
		textView2.setText((String) listData.get(position).get("textView2"));
		CheckBox check = (CheckBox) convertView.findViewById(R.id.checkBox1);
		check.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					selectState.put(position, isChecked);
				} else {
					selectState.remove(position);
				}
				
				tabFragment.listViewItemCheckedChanged(position, isChecked,checkboxAdapter);
			}
		});
		check.setChecked((selectState.get(position) == null ? false : true));
		
		
		
		
		return convertView;
	}
	
	
	
	
}