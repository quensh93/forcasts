package com.srp.carwash.ui.profile;

import android.content.Context;
import android.util.Log;

import androidx.databinding.ObservableField;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.ProgressCallback;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.User;
import com.srp.carwash.data.remote.ApiEndPoint;
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

    public void doCallLogin(Context context, File file) throws Exception {
        Ion.with(context)
                .load(ApiEndPoint.UPLOAD_AVATAR)
                .uploadProgressHandler(new ProgressCallback() {
                    @Override
                    public void onProgress(long uploaded, long total) {
                        Log.e("avatar", "" + uploaded);

                    }
                })
                .setTimeout(60 * 60 * 1000)
                .setMultipartFile("file", "image/jpeg", file)
                .setMultipartParameter("uid", user.get().getUid() + "")
                .asString()
                // run a callback on completion
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        Log.e("avatar", "result : " + result);
                        user.notifyChange();
                    }
                });
    }
}
