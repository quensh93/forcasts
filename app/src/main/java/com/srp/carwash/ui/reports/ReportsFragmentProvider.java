package com.srp.carwash.ui.reports;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ReportsFragmentProvider {

    @ContributesAndroidInjector(modules = ReportsFragmentModule.class)
    abstract ReportsFragment provideReportsFragmentFactory();
}
