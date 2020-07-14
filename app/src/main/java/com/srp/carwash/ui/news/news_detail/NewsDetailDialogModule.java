package com.srp.carwash.ui.news.news_detail;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class NewsDetailDialogModule {

    @Provides
    NewsDetailDialogViewModel provideNewsDetailViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new NewsDetailDialogViewModel(dataManager, schedulerProvider);
    }
}
