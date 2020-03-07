package com.srp.carwash.ui.checkout;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class CheckoutFragmentModule {

    @Provides
    CheckoutFragmentViewModel provideIncreaseCreditViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new CheckoutFragmentViewModel(dataManager, schedulerProvider);
    }
}
