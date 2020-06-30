package com.srp.carwash.ui.statistics;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class StatisticsFragmentModule {

    @Provides
    StatisticsFragmentViewModel provideAboutUsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new StatisticsFragmentViewModel(dataManager, schedulerProvider);
    }
}
