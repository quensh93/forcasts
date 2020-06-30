package com.srp.carwash.ui.statistics;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class StatisticsFragmentProvider {

    @ContributesAndroidInjector(modules = StatisticsFragmentModule.class)
    abstract StatisticsFragment provideAboutUsFragmentFactory();
}
