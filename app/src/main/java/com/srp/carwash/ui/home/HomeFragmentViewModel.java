package com.srp.carwash.ui.home;


import android.util.Log;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.ForecastModel;
import com.srp.carwash.data.model.api.MyOrder;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

import java.lang.reflect.Type;
import java.util.List;

public class HomeFragmentViewModel extends BaseViewModel<HomeFragmentCallback> {

    public ObservableList<ForecastModel> data = new ObservableArrayList<>();
    public ForcastsAdapter forcastsAdapter = new ForcastsAdapter(data);
    private List<MyOrder> myOrders = new ObservableArrayList<>();

    public HomeFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void getForcasts() throws Exception {
        getCompositeDisposable().add(getDataManager()
                .doGetForecasts()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            Gson gson = new Gson();
                            Type listType = new TypeToken<List<ForecastModel>>() {}.getType();
                            List<ForecastModel> forcasts = gson.fromJson(response, listType);
                            data.addAll(forcasts);
                            forcastsAdapter.notifyData(data);
                        }
                        , throwable -> {
                            Log.e("","");
                        }
                ));
    }

    public void clickDismiss() {
        getNavigator().onBack();
    }

}
