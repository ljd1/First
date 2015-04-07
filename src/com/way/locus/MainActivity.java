package com.way.locus;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	private ScreenBroadcastReceiver broadcastReceiver;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		IntentFilter intentFilter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
		broadcastReceiver = new  ScreenBroadcastReceiver();
		registerReceiver(broadcastReceiver, intentFilter);
		View v = (View) this.findViewById(R.id.tvReset);
		v.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						SetPasswordActivity.class);
				// 打开新的Activity
				startActivity(intent);
				finish();
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}
	public class ScreenBroadcastReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO 自动生成的方法存根
			KeyguardManager km = (KeyguardManager)context.getSystemService(Context.KEYGUARD_SERVICE);
			KeyguardLock kl = km.newKeyguardLock("");
			kl.disableKeyguard();
			
			Intent service = new Intent();
			service.setClass(context, LockScreenService.class);
			context.startService(service);

		}

	}

}
