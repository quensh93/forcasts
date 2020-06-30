package com.srp.carwash.ui.forecasts;


import android.util.Log;

import androidx.databinding.ObservableArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.ForecastModel;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

import java.lang.reflect.Type;
import java.util.List;

public class ForecastsFragmentViewModel extends BaseViewModel<ForecastsFragmentCallback> {

    public ObservableArrayList<ForecastModel> data = new ObservableArrayList<>();
    public ForecastsAdapter adapter = new ForecastsAdapter(data);

    public ForecastsFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void getForecasts(String matchId) throws Exception {
        getCompositeDisposable().add(getDataManager()
                .doGetForecasts(matchId)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            Gson gson = new Gson();
                            Type listType = new TypeToken<List<ForecastModel>>() {
                            }.getType();
                            List<ForecastModel> forecast = gson.fromJson(response, listType);

                            data.clear();
                            data.addAll(forecast);
                            adapter.notifyData(data);
                        }
                        , throwable -> {
                            Log.e("", "");
                        }
                ));
    }

}
