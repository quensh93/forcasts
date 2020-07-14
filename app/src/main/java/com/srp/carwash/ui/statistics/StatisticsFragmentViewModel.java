package com.srp.carwash.ui.statistics;


import androidx.databinding.ObservableField;

import com.google.gson.Gson;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.MatchStatisticsModel;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

public class StatisticsFragmentViewModel extends BaseViewModel<StatisticsFragmentCallback> {

    public ObservableField<MatchStatisticsModel> matchStatistics = new ObservableField<>();

    public StatisticsFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void doGetMatchStatistics(String matchId) throws Exception {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .doGetMatchStatistics(matchId)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            setIsLoading(false);
                            matchStatistics.set(new Gson().fromJson(response, MatchStatisticsModel.class));
                        }
                        , throwable -> {
                            setIsLoading(false);
                        }
                ));
    }

}
