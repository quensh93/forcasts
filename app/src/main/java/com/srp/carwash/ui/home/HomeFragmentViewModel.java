package com.srp.carwash.ui.home;


import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.Forecast;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

public class HomeFragmentViewModel extends BaseViewModel<HomeFragmentCallback> {

    public ObservableList<Forecast> data = new ObservableArrayList<>();

    public HomeFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void setData(){
        data.add(new Forecast());
        data.add(new Forecast());
        data.add(new Forecast());
        data.add(new Forecast());
        data.add(new Forecast());
        data.add(new Forecast());
        data.add(new Forecast());
        data.add(new Forecast());
        data.add(new Forecast());
        data.add(new Forecast());
        data.add(new Forecast());
    }

    public void clickDismiss() {
        getNavigator().onBack();
    }

}
