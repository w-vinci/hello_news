package com.example.news.activity;

import com.example.news.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.AnalogClock;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class SplishActivity extends Activity {
	RelativeLayout iv_splish;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splish);

		iv_splish = (RelativeLayout) findViewById(R.id.sp_animation);
		startSplish();
	}

	/**
	 * 闪屏页动画
	 * 
	 * @return
	 */
	private void startSplish() {
		AnimationSet set = new AnimationSet(false);
		RotateAnimation rotate = new RotateAnimation(0, 360,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		rotate.setDuration(2000);
		rotate.setFillAfter(true); // 保持动画状态
		
		ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		scale.setDuration(2000);
		scale.setFillAfter(true);
		
		AlphaAnimation alpha = new AlphaAnimation(0, 1);
		alpha.setDuration(2000);
		alpha.setFillAfter(true);
		
		set.addAnimation(rotate);
		set.addAnimation(scale);
		set.addAnimation(alpha);
		set.setAnimationListener(new AnimationListener() {
			
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				jumpGuidePage();
			}
		});
		iv_splish.startAnimation(set);
	}
	
	private void jumpGuidePage(){
		startActivity(new Intent(SplishActivity.this, GuideActivity.class));
		finish();
	}
	
}
