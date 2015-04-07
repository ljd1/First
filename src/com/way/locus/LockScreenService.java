package com.way.locus;

import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class LockScreenService extends Service {


	private KeyguardManager km;
	private KeyguardLock kl;
	private BroadcastReceiver broadcastReceiver2 = new BroadcastReceiver(){

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO 自动生成的方法存根
			Intent LockScreenView = new Intent();
			LockScreenView.setClass(context,StartMenuActivity.class);
			LockScreenView.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(LockScreenView);
		}
	};
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO 自动生成的方法存根
		return null;
	}
	
	@Override
	public void onCreate(){
		super.onCreate();
		km = (KeyguardManager)getSystemService(Context.KEYGUARD_SERVICE);
		kl =km.newKeyguardLock("");
		kl.disableKeyguard();
	}
	@Override
	public void onStart(Intent intent, int startid){
		super.onStart(intent, startid);
		IntentFilter intentFilter = new IntentFilter(Intent.ACTION_SCREEN_ON);
		intentFilter.setPriority(1000);
		this.registerReceiver(broadcastReceiver2, intentFilter);
		
		
	}
	@Override
	public void onDestroy(){
		kl.reenableKeyguard();
		super.onDestroy();
	}

}