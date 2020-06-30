package com.srp.carwash.ui.composition;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CompositionFragmentProvider {

    @ContributesAndroidInjector(modules = CompositionFragmentModule.class)
    abstract CompositionFragment provideAboutUsFragmentFactory();
}
