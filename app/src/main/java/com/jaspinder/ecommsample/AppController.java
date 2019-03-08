package com.jaspinder.ecommsample;

import android.app.Application;
public class AppController extends Application
{
	private static AppController appControllerInstance;

	public static AppController getInstance() {
		return appControllerInstance;
	}

	@Override
	public void onCreate()
	{
		super.onCreate();

		appControllerInstance = this;
	}
}
