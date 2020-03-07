package com.srp.carwash.ui.increase_credit;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class IncreaseCreditFragmentProvider {

    @ContributesAndroidInjector(modules = IncreaseCreditFragmentModule.class)
    abstract IncreaseCreditFragment provideIncreaseCreditFragmentFactory();
}
