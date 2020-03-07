package com.srp.carwash.ui.increase_credit;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class IncreaseCreditFragmentModule {

    @Provides
    IncreaseCreditFragmentViewModel provideIncreaseCreditViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new IncreaseCreditFragmentViewModel(dataManager, schedulerProvider);
    }
}
