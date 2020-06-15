package com.srp.carwash.ui.investment;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class InvestmentFragmentModule {

    @Provides
    InvestmentFragmentViewModel provideAboutUsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new InvestmentFragmentViewModel(dataManager, schedulerProvider);
    }
}
