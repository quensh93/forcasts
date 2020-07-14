package com.srp.carwash.ui.news.news_detail;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class NewsDetailDialogProvider {

    @ContributesAndroidInjector(modules = NewsDetailDialogModule.class)
    abstract NewsDetailDialog provideNewsDetailDialogFactory();

}
