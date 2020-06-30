package com.srp.carwash.ui.news;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class NewsFragmentModule {

    @Provides
    NewsFragmentViewModel provideAboutUsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new NewsFragmentViewModel(dataManager, schedulerProvider);
    }
}
