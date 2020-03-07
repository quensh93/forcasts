package com.srp.carwash.ui.checkout;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CheckoutFragmentProvider {

    @ContributesAndroidInjector(modules = CheckoutFragmentModule.class)
    abstract CheckoutFragment provideIncreaseCreditFragmentFactory();
}
