package com.srp.carwash.ui.home.detail;

import androidx.databinding.ObservableField;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.MixForecastModel;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

public class MixForecastsDetailViewModel extends BaseViewModel<MixForecastsDetailCallback> {

    public ObservableField<MixForecastModel> model = new ObservableField<>();
    public MixForecastsDetailAdapter adapter = new MixForecastsDetailAdapter();

    public MixForecastsDetailViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onBackClicked() {
        getNavigator().onBack();
    }

    public void setModelData(MixForecastModel modelData) {
        this.model.set(modelData);
        adapter.setData(model.get());
        adapter.notifyDataSetChanged();
    }
}
