package com.sun.baseapp;

import android.app.Activity;
import android.app.Application;

import com.facebook.stetho.Stetho;

import com.sun.baseapp.di.component.DaggerAppComponent;
import com.sun.baseapp.util.imageutil.ImageProxy;
import com.sun.baseapp.util.imageutil.PicassoModel;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(Stetho.newInitializerBuilder(this).enableDumpapp(Stetho.defaultDumperPluginsProvider(this)).enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this)).build());
        DaggerAppComponent.create().inject(this);
//        ImageProxy.init(new GlideModel());
        ImageProxy.init(new PicassoModel());

    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
