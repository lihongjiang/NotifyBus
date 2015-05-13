package com.bslee.notifitybus;


import com.bslee.handler.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity implements BaseNotifityEvent {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		NotifityBus.addNotifityEventListener(this);
	}

	@Override
	public void onReceive(String action, Bundle savedInstanceState) {
       Toast.makeText(getApplicationContext(), action+"=="+savedInstanceState.getString("key"), Toast.LENGTH_SHORT).show();
	}
	
	public void broadcast(View v){
		Bundle bundle=new Bundle();
		bundle.putString("key","123456789" );
		NotifityBus.broadcast("0x001",bundle );
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		NotifityBus.removeNotifityEventListener(this);
	}

}
