package com.srp.carwash.ui.composition;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class CompositionFragmentModule {

    @Provides
    CompositionFragmentViewModel provideAboutUsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new CompositionFragmentViewModel(dataManager, schedulerProvider);
    }
}
