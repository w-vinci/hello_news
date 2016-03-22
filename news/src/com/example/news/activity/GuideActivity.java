package com.example.news.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.news.R;

public class GuideActivity extends Activity {
	private ViewPager vp_guide;
	private static final int[] imag_guide = new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
	private ArrayList<ImageView> imagList;
	private LinearLayout guide_gray;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_guide);
		
		vp_guide = (ViewPager) findViewById(R.id.vp_guide);
		guide_gray =  (LinearLayout) findViewById(R.id.guide_point);
		vp_guide.setAdapter(new MyAdapter());
		initView();
	}
	
	/**
	 * 初始化引导页图片
	 * @author vinci
	 *
	 */
	private void initView() {
		imagList = new ArrayList<ImageView>();
		for(int i=0;i<imag_guide.length;i++){
			ImageView imag = new ImageView(this);
			imag.setBackgroundResource(imag_guide[i]);
			imagList.add(imag);
		}
		
		for(int i=0;i<imag_guide.length;i++){
			View point = new View(this);
			point.setBackgroundResource(R.drawable.shap_point_gray);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10, 10);
			if(i>0){
				params.leftMargin=10;
			}
			point.setLayoutParams(params);
			
			guide_gray.addView(point);
		}
	}
	
	class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return imag_guide.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			container.addView(imagList.get(position));
			return imagList.get(position);
		}
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
		}
	}
}
