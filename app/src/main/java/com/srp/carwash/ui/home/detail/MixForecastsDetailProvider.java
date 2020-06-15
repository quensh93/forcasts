package com.srp.carwash.ui.home.detail;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MixForecastsDetailProvider {

    @ContributesAndroidInjector(modules = MixForecastsDetailModule.class)
    abstract MixForecastsDetailFragment provideContactUsFragmentFactory();

}
