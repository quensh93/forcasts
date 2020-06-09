package com.srp.carwash.ui.contact;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.srp.carwash.R;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.ContactUsRequest;
import com.srp.carwash.data.model.api.User;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.CommonUtils;
import com.srp.carwash.utils.rx.SchedulerProvider;

public class ContactUsFragmentViewModel extends BaseViewModel<ContactUsFragmentCallback> {

    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> description = new ObservableField<>();
    public ObservableInt errorCode = new ObservableInt(0);

    public ContactUsFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void clickDismiss() {
        getNavigator().onBack();
    }

    public void onSendClicked(){
        if (!CommonUtils.nullChecker(title.get()) || title.get().length()<5)
            errorCode.set(1);
        else if (!CommonUtils.nullChecker(description.get()) || description.get().length()<15)
            errorCode.set(2);
        else
            getNavigator().onSend();
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        errorCode.set(0);
    }

    public void onBackClicked() {
        getNavigator().onBack();
    }


    public void doContactUs() throws Exception {
        getCompositeDisposable().add(getDataManager()
                .doContactUs(new ContactUsRequest(User.find(User.class, "", "").get(0).getUid(), title.get(), description.get()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            getNavigator().showMessage(R.string.contact_successfully);
                            getNavigator().onBack();
                        }
                        , throwable -> {
                            getNavigator().showMessage(R.string.public_error);
                        }
                ));
    }

}
