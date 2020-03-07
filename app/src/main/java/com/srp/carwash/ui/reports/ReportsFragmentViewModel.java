package com.srp.carwash.ui.reports;


import com.srp.carwash.data.DataManager;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

public class ReportsFragmentViewModel extends BaseViewModel<ReportsFragmentCallback> {

    public ReportsFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void clickDismiss() {
        getNavigator().onBack();
    }


    public void onBackClicked(){
        getNavigator().onBack();
    }

}
