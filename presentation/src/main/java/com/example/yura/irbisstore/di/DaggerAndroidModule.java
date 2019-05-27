package com.example.yura.irbisstore.di;

import com.example.yura.irbisstore.mvvm.view.screen.sing_in.SingInActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = AndroidSupportInjectionModule.class)
public interface DaggerAndroidModule {

    @ContributesAndroidInjector
    SingInActivity singInActivity();
}
