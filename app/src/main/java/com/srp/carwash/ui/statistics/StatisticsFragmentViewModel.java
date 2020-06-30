package com.srp.carwash.ui.statistics;


import com.srp.carwash.data.DataManager;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

public class StatisticsFragmentViewModel extends BaseViewModel<StatisticsFragmentCallback> {

    public StatisticsFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

}
