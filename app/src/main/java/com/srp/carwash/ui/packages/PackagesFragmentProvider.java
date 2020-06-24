package com.srp.carwash.ui.packages;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class PackagesFragmentProvider {

    @ContributesAndroidInjector(modules = PackagesFragmentModule.class)
    abstract PackagesFragment provideAboutUsFragmentFactory();
}
