package com.sun.baseapp.di.component;


import com.sun.baseapp.App;
import com.sun.baseapp.di.module.AllActivitiesModule;
import com.sun.baseapp.di.module.AppModule;
import com.sun.baseapp.network.api.WanAndroidApi;
import com.sun.baseapp.network.di.ApiServiceModule;
import com.sun.baseapp.network.di.HttpModule;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

//@Singleton
@Component(modules = {AndroidInjectionModule.class
        , AndroidSupportInjectionModule.class
        , AllActivitiesModule.class
        , AppModule.class
        , HttpModule.class
        , ApiServiceModule.class})
public interface AppComponent {

    void inject(App application);

    WanAndroidApi getWanAndroidApi();
}
