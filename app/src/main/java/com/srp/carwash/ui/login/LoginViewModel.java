package com.srp.carwash.ui.login;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.google.gson.Gson;
import com.srp.carwash.R;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.LoginRequest;
import com.srp.carwash.data.model.api.VerifyRequest;
import com.srp.carwash.data.model.api.VerifyResponse;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.CommonUtils;
import com.srp.carwash.utils.rx.SchedulerProvider;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    public ObservableField<String> mobile = new ObservableField<>();
    public ObservableField<String> code = new ObservableField<>();
    public ObservableInt isError = new ObservableInt(0);
    public ObservableInt step = new ObservableInt(0);
    public ObservableBoolean loadingStatus = new ObservableBoolean(false);

    public LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public int getStepValue() {
        return this.step.get();
    }

    public void setStepValue(int s) {
        this.step.set(s);
    }

    public void verifyMobile(CharSequence str, int start, int before, int count) {
        if (str.toString().length() == 11) {
            if (str.toString().startsWith("09"))
                isError.set(0);
            else
                isError.set(1);
        } else
            isError.set(0);
    }

    public void verifyCode(CharSequence str, int start, int before, int count) {
        if (str.toString().length() == 5) {
            getNavigator().onVerify(str.toString());
        } else
            isError.set(0);
    }

    public void onClicked() {
        if (loadingStatus.get())
            return;
        if (step.get() == 0)
            if (CommonUtils.isMobileValid(mobile.get()))
                getNavigator().onLogin();
            else
                isError.set(1);
        else if (code.get() != null && code.get().length() == 5)
            getNavigator().onVerify(code.get());
        else
            isError.set(2);
    }

    public void setLoadingValue(boolean status) {
        loadingStatus.set(status);
    }

    public void doCallLogin() throws Exception {
        setLoadingValue(true);
        getCompositeDisposable().add(getDataManager()
                .doLogin(new LoginRequest(mobile.get()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            setLoadingValue(false);
                            setStepValue(1);
                        }
                        , throwable -> {
                            setLoadingValue(false);
                            getNavigator().showMessage(R.string.public_error);
                        }
                ));
    }

    public void doCallVerify(String code) throws Exception {
        setLoadingValue(true);
        getCompositeDisposable().add(getDataManager()
                .doVerify(new VerifyRequest(mobile.get(), code))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            setLoadingValue(false);
                            VerifyResponse verifyResponse = new Gson().fromJson(response, VerifyResponse.class);
                            if (verifyResponse.isResult()) {
                                verifyResponse.getUser().save();
                                getNavigator().openMain();
                            }
//                                if (verifyResponse.getUser().getName()!=null && verifyResponse.getUser().getName().length()>2) {
//                                    verifyResponse.getUser().save();
//                                    getNavigator().openMain();
//                                }else
//                                    getNavigator().openMain();
                                /*
                                    age khastim etelaat takmili ro inja bayad begirim
                                    setStepValue(3);

                                 */
                            else
                                isError.set(2);
                        }
                        , throwable -> {
                            setLoadingValue(false);
                            getNavigator().showMessage(R.string.public_error);
                        }
                ));
    }


}
