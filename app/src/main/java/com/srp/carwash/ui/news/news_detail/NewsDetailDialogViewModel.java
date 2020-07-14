package com.srp.carwash.ui.news.news_detail;

import android.util.Log;

import androidx.databinding.ObservableField;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.News;
import com.srp.carwash.data.model.api.UpdateViewRequest;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

public class NewsDetailDialogViewModel extends BaseViewModel<NewsDetailDialogCallback> {

    public ObservableField<News> news = new ObservableField<>();

    public NewsDetailDialogViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onBackClicked() {
        getNavigator().onBack();
    }

    public void setNews(News news) {
        this.news.set(news);
    }

    public void updateView() throws Exception {
        getCompositeDisposable().add(getDataManager()
                .doUpdateNewsView(new UpdateViewRequest(news.get().getId()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {

                        }
                        , throwable -> {
                            Log.e("", "");
                        }
                ));
    }
}