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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import ir.huri.jcal.JalaliCalendar;

public class HomeFragmentViewModel extends BaseViewModel<HomeFragmentCallback> {

    public ObservableArrayList<MatchesModel> data = new ObservableArrayList<>();
    public MatchesAdapter adapter = new MatchesAdapter(data, new OnMatchesListener() {
        @Override
        public void onMatch(MatchesModel matchesModel) {
            getNavigator().onMatch(matchesModel);
        }
    });
    public DatePickerAdapter dateAdapter = new DatePickerAdapter(new OnDateChange() {
        @Override
        public void onDateChange(String day, String month) {

            JalaliCalendar jalaliCalendar = new JalaliCalendar(1399, Integer.parseInt(month), Integer.parseInt(day));
            GregorianCalendar gc = jalaliCalendar.toGregorian();
            int y = (gc.get(Calendar.MONTH) + 1);
            int d = gc.get(Calendar.DAY_OF_MONTH);
            getNavigator().onDateChange(gc.get(Calendar.YEAR) + "-" + (y < 10 ? "0" + y : y) + "-" + (d < 10 ? "0" + d : d));
        }
    });


    public HomeFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void getMatches(String date) throws Exception {
        getCompositeDisposable().add(getDataManager()
                .doGetMatches(date)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            Gson gson = new Gson();
                            Type listType = new TypeToken<List<MatchesModel>>() {
                            }.getType();
                            List<MatchesModel> matches = gson.fromJson(response, listType);
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
