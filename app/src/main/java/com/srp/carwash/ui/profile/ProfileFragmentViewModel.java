package com.srp.carwash.ui.profile;


import com.srp.carwash.data.DataManager;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

public class ProfileFragmentViewModel extends BaseViewModel<ProfileFragmentCallback> {

    public ProfileFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void clickDismiss() {
        getNavigator().onBack();
    }

    public void onContactUsClicked(){
        getNavigator().onContactUs();
    }

    public void onAboutUsClicked(){
        getNavigator().onAboutUs();
    }

    public void onReportsClicked(){
        getNavigator().onReports();
    }
}
