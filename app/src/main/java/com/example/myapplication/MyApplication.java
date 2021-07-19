package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.module.ApiComponent;
import com.example.myapplication.module.ApiModule;
import com.example.myapplication.module.AppModule;
import com.example.myapplication.module.DaggerApiComponent;

public class MyApplication extends Application {

	private ApiComponent mApiComponent;

	//"https://restcountries.eu/rest/v2/"
	@Override
	public void onCreate() {
		super.onCreate();
		mApiComponent = DaggerApiComponent.builder()
				.appModule(new AppModule(this))
				.apiModule(new ApiModule())
				.build();
	}

	public ApiComponent getNetComponent() {
		return mApiComponent;
	}
}
