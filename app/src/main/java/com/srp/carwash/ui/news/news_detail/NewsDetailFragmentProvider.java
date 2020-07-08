package com.srp.carwash.ui.news.news_detail;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class NewsDetailFragmentProvider {

    @ContributesAndroidInjector(modules = NewsDetailFragmentModule.class)
    abstract NewsDetailFragment provideNewsDetailFragmentFactory();
}
