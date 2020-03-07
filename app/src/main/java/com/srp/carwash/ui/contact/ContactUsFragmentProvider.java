package com.srp.carwash.ui.contact;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ContactUsFragmentProvider {

    @ContributesAndroidInjector(modules = ContactUsFragmentModule.class)
    abstract ContactUsFragment provideContactUsFragmentFactory();
}
