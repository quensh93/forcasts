package com.srp.carwash.ui.profile;

import androidx.databinding.ObservableField;

import com.srp.carwash.R;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.User;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

import java.io.File;

public class ProfileFragmentViewModel extends BaseViewModel<ProfileFragmentCallback> {

    public ObservableField<User> user = new ObservableField<>();

    public ProfileFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        user.set(User.find(User.class, null, null).get(0));
    }

    public void clickDismiss() {
        getNavigator().onBack();
    }

    public void onContactUsClicked(){
        getNavigator().onContactUs();
    }

    public void onAboutUsClicked() {
        getNavigator().onAboutUs();
    }

    public void onReportsClicked() {
        getNavigator().onReports();
    }

    public void onIncreaseCredit() {
        getNavigator().onIncreaseCredit();
    }

    public void onAvatarClicked() {
        getNavigator().onAvatar();
    }

    public void doCallLogin(File file) throws Exception {
        getCompositeDisposable().add(getDataManager()
                .doUploadAvatar(user.get().getUid(), file)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            user.notifyChange();
                        }
                        , throwable -> {
                            getNavigator().showMessage(R.string.public_error);
                        }
                ));
    }
}
