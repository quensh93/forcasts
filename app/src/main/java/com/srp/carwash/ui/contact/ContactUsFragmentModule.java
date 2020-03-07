package com.srp.carwash.ui.contact;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class ContactUsFragmentModule {

    @Provides
    ContactUsFragmentViewModel provideContactUsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new ContactUsFragmentViewModel(dataManager, schedulerProvider);
    }
}
