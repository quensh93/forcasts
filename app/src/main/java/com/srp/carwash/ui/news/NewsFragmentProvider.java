package com.srp.carwash.ui.news;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class NewsFragmentProvider {

    @ContributesAndroidInjector(modules = NewsFragmentModule.class)
    abstract NewsFragment provideAboutUsFragmentFactory();
}
