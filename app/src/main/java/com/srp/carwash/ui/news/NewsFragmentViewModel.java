package com.srp.carwash.ui.news;


import android.util.Log;

import androidx.databinding.ObservableArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.News;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

import java.lang.reflect.Type;
import java.util.List;

public class NewsFragmentViewModel extends BaseViewModel<NewsFragmentCallback> {

    public ObservableArrayList<News> data = new ObservableArrayList<>();
    public NewsAdapter adapter = new NewsAdapter(data, new OnNews() {
        @Override
        public void onNews(News news) {
            getNavigator().onNewsDetail(news);
        }
    });
    private String matchId;

    public NewsFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void setMatchId(String id) {
        this.matchId = id;
    }

    public void getMatchNews() throws Exception {
        getCompositeDisposable().add(getDataManager()
                .doGetNews(matchId)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            Gson gson = new Gson();
                            Type listType = new TypeToken<List<News>>() {
                            }.getType();
                            List<News> matches = gson.fromJson(response, listType);
                            data.clear();
                            data.addAll(matches);
                            adapter.notifyData(data);
                        }
                        , throwable -> {
                            Log.e("", "");
                        }
                ));
    }

}
