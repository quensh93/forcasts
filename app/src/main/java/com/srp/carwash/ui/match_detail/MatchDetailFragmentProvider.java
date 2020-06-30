package com.srp.carwash.ui.match_detail;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MatchDetailFragmentProvider {

    @ContributesAndroidInjector(modules = MatchDetailFragmentModule.class)
    abstract MatchDetailFragment provideAboutUsFragmentFactory();
}
