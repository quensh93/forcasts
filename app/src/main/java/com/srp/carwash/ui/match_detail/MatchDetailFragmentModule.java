package com.srp.carwash.ui.match_detail;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class MatchDetailFragmentModule {

    @Provides
    MatchDetailFragmentViewModel provideAboutUsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new MatchDetailFragmentViewModel(dataManager, schedulerProvider);
    }
}
