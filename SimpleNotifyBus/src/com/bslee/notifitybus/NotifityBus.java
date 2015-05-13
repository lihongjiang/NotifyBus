package com.bslee.notifitybus;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import android.os.Bundle;


public class NotifityBus {

	private static final Set<BaseNotifityEvent> listeners = new CopyOnWriteArraySet<BaseNotifityEvent>();

	public static void addNotifityEventListener(BaseNotifityEvent listener) {
		listeners.add(listener);
	}

	public static void removeNotifityEventListener(BaseNotifityEvent listener) {
		listeners.remove(listener);
	}

	public static synchronized void broadcast(String action,
			Bundle savedInstanceState) {
		for (BaseNotifityEvent listener : listeners) {
			try {
				listener.onReceive(action, savedInstanceState);
			} catch (RuntimeException unexpected) {
			}
		}
	}

}
