package com.srp.carwash.ui.investment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class InvestmentFragmentProvider {

    @ContributesAndroidInjector(modules = InvestmentFragmentModule.class)
    abstract InvestmentFragment provideAboutUsFragmentFactory();
}
