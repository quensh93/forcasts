package com.srp.carwash.ui.forecasts;


import android.util.Log;

import androidx.databinding.ObservableArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.ForecastModel;
import com.srp.carwash.data.model.api.VoteRequest;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

import java.lang.reflect.Type;
import java.util.List;

public class ForecastsFragmentViewModel extends BaseViewModel<ForecastsFragmentCallback> {

    public ObservableArrayList<ForecastModel> data = new ObservableArrayList<>();
    public ForecastsAdapter adapter = new ForecastsAdapter(data, new OnForecastsListener() {
        @Override
        public void onDisagree(int pid) {
            try {
                doVote(2, pid);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onAgree(int pid) {
            try {
                doVote(1, pid);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });

    public ForecastsFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void doVote(int type, int pid) throws Exception {
        getCompositeDisposable().add(getDataManager()
                .doVote(new VoteRequest(type, pid))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            if (Integer.parseInt(response) == 0) {
                                for (ForecastModel forecastModel :
                                        data) {
                                    if (forecastModel.getId() == pid) {
                                        if (type == 1)
                                            forecastModel.setAgree(forecastModel.getAgree() + 1);
                                        else
                                            forecastModel.setDisagree(forecastModel.getDisagree() + 1);
                                        break;
                                    }
                                }
                                adapter.notifyData(data);
                            } else if (Integer.parseInt(response) == 1)
                                getNavigator().showMessage("خطایی در ثبت رای رخ داد");
                            else
                                getNavigator().showMessage("شما قبلا به این پیشبینی رای داده اید");
                        }
                        , throwable -> {
                            Log.e("", "");
                        }
                ));
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
