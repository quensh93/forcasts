package com.srp.carwash.ui.packages;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class PackagesFragmentModule {

    @Provides
    PackagesFragmentViewModel provideAboutUsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new PackagesFragmentViewModel(dataManager, schedulerProvider);
    }
}
