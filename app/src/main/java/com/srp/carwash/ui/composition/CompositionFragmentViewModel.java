package com.srp.carwash.ui.composition;


import com.srp.carwash.data.DataManager;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

public class CompositionFragmentViewModel extends BaseViewModel<CompositionFragmentCallback> {

    public CompositionFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

}
