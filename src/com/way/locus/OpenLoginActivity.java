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
				// ���������ȷ,�������ҳ�档
				if (lpwv.verifyPassword(mPassword)) {
					showToast("��½�ɹ���");
					finish();
				} else {
					showToast("�����������,����������");
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
            return true;//���ѵ����˼� 
        }else if(event.getAction()==KeyEvent.ACTION_DOWN
        		&& event.getKeyCode() == KeyEvent.KEYCODE_APP_SWITCH){
        	return true;
        }
        return super.onKeyDown(keyCode, event);
    }
	
	
}