package com.example.viewpagedemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ViewPager viewPager;
	private PagerAdapter adapter;
	private List<View> pagers;
	private myPagerAdapter pagerAdapter;
	private PagerTabStrip pageTabStrip;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		init();
	}

	private void init() {
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		initPager();
		pagerAdapter = new myPagerAdapter();
		viewPager.setAdapter(pagerAdapter);
		initStrip();
		
	}
	
	private void initStrip() {
		pageTabStrip = (PagerTabStrip) findViewById(R.id.tabstrip);
		pageTabStrip.setDrawFullUnderline(false);
		pageTabStrip.setTabIndicatorColor(Color.RED);
		
		
	}

	private void initPager() {
		pagers = new ArrayList<View>();
		TextView textView = new TextView(getApplicationContext());
		textView.setText("北京1");
		pagers.add(textView);
		
		textView = new TextView(getApplicationContext());
		textView.setText("上海");
		pagers.add(textView);
		
		textView = new TextView(getApplicationContext());
		textView.setText("广州");
		pagers.add(textView);
		
		textView = new TextView(getApplicationContext());
		textView.setText("深圳");
		pagers.add(textView);
		
	
	}
	private String[] titles = new String[]{"北京","上海","广州","深圳"};
	
	
	private class myPagerAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			return titles.length ;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
		
			return view == object;
		}
		@Override
		public Object instantiateItem(View container, int position) {
			View view = pagers.get(position);
			 ((ViewGroup) container).addView(view);
			return view;
		}
		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(pagers.get(position));
		}
		@Override
		public CharSequence getPageTitle(int position) {
			return titles[position];
		}
		
	}
}
