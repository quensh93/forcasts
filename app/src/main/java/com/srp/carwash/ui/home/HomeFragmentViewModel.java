package com.srp.carwash.ui.home;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

public class HomeFragmentViewModel extends BaseViewModel<HomeFragmentCallback> {

    public HomeFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

//    public void getForecasts() throws Exception {
//        getCompositeDisposable().add(getDataManager()
//                .doGetForecasts()
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(response -> {
//                            Gson gson = new Gson();
//                            Type listType = new TypeToken<List<ForecastModel>>() {
//                            }.getType();
//                            List<ForecastModel> forcasts = gson.fromJson(response, listType);
//                            data.addAll(forcasts);
//                            forcastsAdapter.notifyData(data);
//                        }
//                        , throwable -> {
//                            Log.e("","");
//                        }
//                ));
//    }
}
