package com.example.myapplication.module;


import com.example.myapplication.ItemListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {
	void inject(ItemListActivity activity);
}
