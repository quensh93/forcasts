package com.srp.carwash.ui.profile;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class ProfileFragmentModule {

    @Provides
    ProfileFragmentViewModel provideProfileViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new ProfileFragmentViewModel(dataManager, schedulerProvider);
    }
}
