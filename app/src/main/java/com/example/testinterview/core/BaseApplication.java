package com.example.testinterview.core;

import com.example.testinterview.di.ApplicationComponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import com.example.testinterview.viewmodel.di.component.DaggerApplicationComponent;


public class BaseApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        ApplicationComponent component = DaggerApplicationComponent.builder().application(this).build();
        component.inject(this);

        return component;
    }
}
