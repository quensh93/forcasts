package com.srp.carwash.ui.forecasts;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ForecastsFragmentProvider {

    @ContributesAndroidInjector(modules = ForecastsFragmentModule.class)
    abstract ForecastsFragment provideAboutUsFragmentFactory();
}
