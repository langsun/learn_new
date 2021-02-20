package com.sun.baseapp.di.module;


import com.sun.baseapp.ui.di.LoginActivityModule;
import com.sun.baseapp.ui.di.MainActivityModule;
import com.sun.baseapp.ui.di.RegisterActivityModule;
import com.sun.baseapp.ui.login.LoginActivity;
import com.sun.baseapp.ui.main.MainActivity;
import com.sun.baseapp.ui.register.RegisterActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AllActivitiesModule {

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity contributeLoginActivityInjector();

    @ContributesAndroidInjector(modules = RegisterActivityModule.class)
    abstract RegisterActivity contributeRegisterActivityInjector();

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivityInjector();


}
