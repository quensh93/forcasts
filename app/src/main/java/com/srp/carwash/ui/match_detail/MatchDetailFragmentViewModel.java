package com.srp.carwash.ui.match_detail;


import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.MatchesModel;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

public class MatchDetailFragmentViewModel extends BaseViewModel<MatchDetailFragmentCallback> {

    public ObservableField<MatchesModel> match = new ObservableField<>();
    public ObservableInt state = new ObservableInt(1);

    public MatchDetailFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onBackClicked() {
        getNavigator().onBack();
    }

    public void setMatch(MatchesModel match) {
        this.match.set(match);
    }

    public void setState(int state) {
        this.state.set(state);
        switch (state) {
            case 0:
                getNavigator().onStatistics();
                break;
            case 1:
                getNavigator().onForecasts();
                break;
            case 2:
                getNavigator().onNews(match.get().getId());
                break;
            case 3:
                getNavigator().onComposition();
                break;
        }
    }

    public void onClick(int state) {
        setState(state);
    }
}
