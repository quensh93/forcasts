package com.srp.carwash.ui.packages;

import android.util.Log;

import androidx.databinding.ObservableArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.srp.carwash.R;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.ExtendSubRequest;
import com.srp.carwash.data.model.api.Packages;
import com.srp.carwash.data.model.api.User;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

import java.lang.reflect.Type;
import java.util.List;

public class PackagesFragmentViewModel extends BaseViewModel<PackagesFragmentCallback> {

    public ObservableArrayList<Packages> data = new ObservableArrayList<>();
    public PackagesAdapter adapter = new PackagesAdapter(data, new OnPackagesListener() {
        @Override
        public void onPackageClicked(Packages packages) {
            getNavigator().onExtend(packages.getId());
        }
    });

    public PackagesFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onBackClicked() {
        getNavigator().onBack();
    }

    public void getPackages() throws Exception {
        getCompositeDisposable().add(getDataManager()
                .doGetPackages()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            Gson gson = new Gson();
                            Type listType = new TypeToken<List<Packages>>() {
                            }.getType();
                            List<Packages> packages = gson.fromJson(response, listType);
                            data.addAll(packages);
                            adapter.notifyDataSetChanged();
                        }
                        , throwable -> {
                            Log.e("getPackages", "b");
                        }
                ));
    }

    public void extendSubscription(int pid) throws Exception {
        getCompositeDisposable().add(getDataManager()
                .doExtendSubscription(new ExtendSubRequest("" + User.find(User.class, null, null).get(0).getUid(), "" + pid))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            if (response.equals("1")) {
                                getNavigator().showMessage(R.string.extend_successfully);
                                getNavigator().onBack();
                            } else
                                getNavigator().showMessage(R.string.public_error);
                        }
                        , throwable -> {
                            Log.e("getPackages", "b");
                        }
                ));
    }

}
