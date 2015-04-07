package com.way.locus;

import com.way.locus.LocusPassWordView.OnCompleteListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class OpenLoginActivity extends Activity {
	private LocusPassWordView lpwv;
	private Toast toast;
	

	private void showToast(CharSequence message) {
		if (null == toast) {
			toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}

		toast.show();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);
		lpwv = (LocusPassWordView) this.findViewById(R.id.mLocusPassWordView);
		lpwv.setOnCompleteListener(new OnCompleteListener() {
			
			@Override
			public void onComplete(String mPassword) {
				// 如果密码正确,则进入主页面。
				if (lpwv.verifyPassword(mPassword)) {
					showToast("登陆成功！");
					finish();
				} else {
					showToast("密码输入错误,请重新输入");
					lpwv.clearPassword();
				}
			}
		});

	}


	@Override
	protected void onStop() {
		super.onStop();
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