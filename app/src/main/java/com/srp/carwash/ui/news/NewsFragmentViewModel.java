package com.srp.carwash.ui.news;


import com.srp.carwash.data.DataManager;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

public class NewsFragmentViewModel extends BaseViewModel<NewsFragmentCallback> {

    public NewsFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

}
