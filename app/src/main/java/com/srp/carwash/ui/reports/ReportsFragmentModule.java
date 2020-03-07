package com.srp.carwash.ui.reports;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class ReportsFragmentModule {

    @Provides
    ReportsFragmentViewModel provideReportsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new ReportsFragmentViewModel(dataManager, schedulerProvider);
    }
}
