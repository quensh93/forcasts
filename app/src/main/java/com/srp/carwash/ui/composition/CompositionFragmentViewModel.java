package com.srp.carwash.ui.composition;


import android.util.Log;

import androidx.databinding.ObservableField;

import com.google.gson.Gson;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.CompositionModel;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

public class CompositionFragmentViewModel extends BaseViewModel<CompositionFragmentCallback> {

    public ObservableField<CompositionModel> compositionModel = new ObservableField<>();

    public CompositionFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void doGetComposition(int matchId) throws Exception {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .doGetComposition("" + matchId)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            setIsLoading(false);
                            compositionModel.set(new Gson().fromJson(response, CompositionModel.class));
                        }
                        , throwable -> {
                            setIsLoading(false);
                            Log.e("", "");
                        }
                ));
    }

}
