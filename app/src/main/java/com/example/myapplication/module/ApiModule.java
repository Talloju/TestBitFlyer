package com.example.myapplication.module;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
@Module
public class ApiModule {

	private static final String BASE_URL = "https://api.github.com/";

	@Provides
	@Singleton
	Retrofit getClient() {
		return new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
	}
}
