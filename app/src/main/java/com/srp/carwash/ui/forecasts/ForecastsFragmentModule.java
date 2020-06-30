package com.srp.carwash.ui.forecasts;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class ForecastsFragmentModule {

    @Provides
    ForecastsFragmentViewModel provideAboutUsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new ForecastsFragmentViewModel(dataManager, schedulerProvider);
    }
}
