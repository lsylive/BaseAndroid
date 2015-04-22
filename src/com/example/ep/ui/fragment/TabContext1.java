package com.example.ep.ui.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.ep.R;
import com.example.ep.ui.fragment.listviewitems.BarChartItem;
import com.example.ep.ui.fragment.listviewitems.ChartItem;
import com.example.ep.ui.fragment.listviewitems.LineChartItem;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;


/**
 * Tab内容页1（注册服务信息）
 * 
 * @author liusy 2015-04-18
 *
 */
@SuppressLint({ "NewApi", "ValidFragment" })
public class TabContext1 extends AbsTabContext {
	
	  protected String[] mMonths = new String[] {
	            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec"
	    };

	    protected String[] mParties = new String[] {
	            "Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H",
	            "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P",
	            "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X",
	            "Party Y", "Party Z"
	    };

	  
	    
	public TabContext1(int layout) {
		super(layout);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		
		super.onViewCreated(view, savedInstanceState);
		initTabContext1();
			
	}

	
	
	public void initTabContext1()
	{
		
        
		 ListView lvSSFH = (ListView) acMain.findViewById(R.id.chartListViewSSFH);
	        ArrayList<ChartItem> list = new ArrayList<ChartItem>();
	        list.add(new LineChartItem(generateDataLine(1), acMain.getApplicationContext(),"实时负荷情况","单位(千瓦)/小时"));
	        ChartDataAdapter cda = new ChartDataAdapter(acMain.getApplicationContext(), list);
	        lvSSFH.setAdapter(cda);
	        
	        
	        //list.add(new PieChartItem(generateDataPie(i + 1), acMain.getApplicationContext()));

	  
			 ListView lvFHZL = (ListView) acMain.findViewById(R.id.chartListViewFHZL);
		        ArrayList<ChartItem> listFHZL = new ArrayList<ChartItem>();
		        listFHZL.add(new BarChartItem(generateDataBar(1), acMain.getApplicationContext(),"负荷总量","单位(千瓦)/天"));
		        ChartDataAdapter cdaFHZL = new ChartDataAdapter(acMain.getApplicationContext(), listFHZL);
		        lvFHZL.setAdapter(cdaFHZL);
		        
		        
		        ListView  listViewSBXJMX = (ListView)acMain.findViewById(R.id.listViewSBXJMX);
				ArrayList<Map<String,Object>> listData= new ArrayList<Map<String,Object>>();  
			     Map<String,Object> item = new HashMap<String,Object>();  
			        item.put("textView1", "大型设备1");  
			        item.put("textView2", "4千瓦");  
			        listData.add(item);
			        Map<String,Object> item2 = new HashMap<String,Object>();  
			        item2.put("textView1", "大型设备2");  
			        item2.put("textView2", "4千瓦");  
			        listData.add(item2);
			        Map<String,Object> item3 = new HashMap<String,Object>();  
			        item3.put("textView1", "大型设备3");  
			        item3.put("textView2", "2千瓦");  
			        listData.add(item3);
			        Map<String,Object> item4 = new HashMap<String,Object>();  
			        item4.put("textView1", "大型设备4");  
			        item4.put("textView2", "6千瓦");  
			        listData.add(item4);
			       
				   SimpleAdapter adapter = new SimpleAdapter(acMain,listData,R.layout.context1_sub1_list_view,new String[]{"textView1","textView2"},new int[]{R.id.textView1,R.id.textView2,R.id.checkBox1});
				   listViewSBXJMX.setAdapter(adapter);
//	        
	}
	
	 /** adapter that supports 3 different item types */
    private class ChartDataAdapter extends ArrayAdapter<ChartItem> {
        
        public ChartDataAdapter(Context context, List<ChartItem> objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getItem(position).getView(position, convertView, getContext());
        }
        
        @Override
        public int getItemViewType(int position) {           
            // return the views type
            return getItem(position).getItemType();
        }
        
        @Override
        public int getViewTypeCount() {
            return 3; // we have 3 different item-types
        }
    }
	
    
    /**
     * generates a random ChartData object with just one DataSet
     * 
     * @return
     */
    private LineData generateDataLine(int cnt) {

        ArrayList<Entry> e1 = new ArrayList<Entry>();

        for (int i = 0; i < 24; i++) {
            e1.add(new Entry((int) (Math.random() * 65) + 40, i));
        }

        LineDataSet d1 = new LineDataSet(e1, "New DataSet " + cnt + ", (1)");
        d1.setLineWidth(2.5f);
        d1.setCircleSize(4.5f);
        d1.setHighLightColor(Color.rgb(244, 117, 117));
        d1.setDrawValues(false);
        d1.setLabel("昨日负荷");
        
        
        
        ArrayList<Entry> e2 = new ArrayList<Entry>();

        for (int i = 0; i < 24; i++) {
            e2.add(new Entry((int)(Math.random() * 65) + 50, i));
        }

        LineDataSet d2 = new LineDataSet(e2, "New DataSet " + cnt + ", (2)");
        d2.setLineWidth(2.5f);
        d2.setCircleSize(4.5f);
        d2.setHighLightColor(Color.rgb(244, 117, 117));
        d2.setColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        d2.setCircleColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        d2.setDrawValues(false);
        d2.setLabel("今日负荷");
        
        ArrayList<LineDataSet> sets = new ArrayList<LineDataSet>();
        sets.add(d1);
        sets.add(d2);
        
        LineData cd = new LineData(getHours(), sets);
        return cd;
    }
    
    
    /**
     * generates a random ChartData object with just one DataSet
     * 
     * @return
     */
    private BarData generateDataBar(int cnt) {

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

        for (int i = 0; i < 31; i++) {
            entries.add(new BarEntry((int) (Math.random() * 70) + 30, i));
        }

        BarDataSet d = new BarDataSet(entries, "1个月");
        d.setBarSpacePercent(20f);
        d.setColors(ColorTemplate.VORDIPLOM_COLORS);
        d.setHighLightAlpha(255);
        
        BarData cd = new BarData(getDays(), d);
        return cd;
    }
    
    /**
     * generates a random ChartData object with just one DataSet
     * 
     * @return
     */
    private PieData generateDataPie(int cnt) {

        ArrayList<Entry> entries = new ArrayList<Entry>();

        for (int i = 0; i < 4; i++) {
            entries.add(new Entry((int) (Math.random() * 70) + 30, i));
        }

        PieDataSet d = new PieDataSet(entries, "");
        
        // space between slices
        d.setSliceSpace(2f);
        d.setColors(ColorTemplate.VORDIPLOM_COLORS);
        
        PieData cd = new PieData(getQuarters(), d);
        return cd;
    }
    
    private ArrayList<String> getQuarters() {
        
        ArrayList<String> q = new ArrayList<String>();
        q.add("1st Quarter");
        q.add("2nd Quarter");
        q.add("3rd Quarter");
        q.add("4th Quarter");
        
        return q;
    }

    private ArrayList<String> getMonths() {

        ArrayList<String> m = new ArrayList<String>();
        m.add("一");
        m.add("二");
        m.add("三");
        m.add("四");
        m.add("五");
        m.add("六");
        m.add("七");
        m.add("八");
        m.add("九");
        m.add("十");
        m.add("十一");
        m.add("十二");

        return m;
    }
    
    private ArrayList<String> getDays() {

        ArrayList<String> m = new ArrayList<String>();
        for(int i=0;i<31;i++)
        {
        	m.add(""+i);
        }
        return m;
    }
    
    private ArrayList<String> getHours() {

        ArrayList<String> m = new ArrayList<String>();
        for(int i=0;i<24;i++)
        {
        	m.add(""+i);
        }
        return m;
    }
    

}
