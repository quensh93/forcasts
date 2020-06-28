package com.srp.carwash.ui.home;

import android.util.Log;

import androidx.databinding.ObservableArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.MatchesModel;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

import java.lang.reflect.Type;
import java.util.List;

public class HomeFragmentViewModel extends BaseViewModel<HomeFragmentCallback> {

    public ObservableArrayList<MatchesModel> data = new ObservableArrayList<>();
    public MatchesAdapter adapter = new MatchesAdapter(data, new OnMatchesListener() {
        @Override
        public void onMatch(MatchesModel matchesModel) {

        }
    });

    public HomeFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void getMatches() throws Exception {
        getCompositeDisposable().add(getDataManager()
                .doGetMatches()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            Gson gson = new Gson();
                            Type listType = new TypeToken<List<MatchesModel>>() {
                            }.getType();
                            List<MatchesModel> matches = gson.fromJson(response, listType);
                            data.addAll(matches);
                            adapter.notifyData(data);
                        }
                        , throwable -> {
                            Log.e("", "");
                        }
                ));
    }
}
