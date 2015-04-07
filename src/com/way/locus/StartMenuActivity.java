package com.way.locus;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartMenuActivity extends Activity {
	private Button button;
	private Button button2;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timetable_activity);
		button=(Button)findViewById(R.id.tel);
		button2=(Button)findViewById(R.id.open);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:110"));
				// 打开新的Activity
				startActivity(intent);
			}
		});
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(StartMenuActivity.this,OpenLoginActivity.class);
				// 打开新的Activity
				startActivity(intent);
				finish();
			}
		});
		
	}
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN
                && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            return true;//消费掉后退键 
        }else if(event.getAction()==KeyEvent.ACTION_DOWN
        		&& event.getKeyCode() == KeyEvent.KEYCODE_APP_SWITCH){
        	return true;
        }
        return super.onKeyDown(keyCode, event);
    }
	

}
