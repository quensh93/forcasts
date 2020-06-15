package com.srp.carwash.ui.home.detail;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class MixForecastsDetailModule {

    @Provides
    MixForecastsDetailViewModel provideContactUsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new MixForecastsDetailViewModel(dataManager, schedulerProvider);
    }
}
