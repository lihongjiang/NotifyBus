package com.bslee.notifitybus;

import android.os.Bundle;


public interface BaseNotifityEvent {
	
	public void  onReceive(String action,Bundle savedInstanceState);
	
}

