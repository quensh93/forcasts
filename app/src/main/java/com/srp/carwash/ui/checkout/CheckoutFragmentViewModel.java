package com.srp.carwash.ui.checkout;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.srp.carwash.R;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.CheckoutModel;
import com.srp.carwash.data.model.api.CheckoutRequest;
import com.srp.carwash.data.model.api.User;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

import java.lang.reflect.Type;
import java.util.List;

public class CheckoutFragmentViewModel extends BaseViewModel<CheckoutFragmentCallback> {

    public ObservableField<String> price = new ObservableField<>();
    public ObservableField<String> errorMessage = new ObservableField<>();
    public ObservableBoolean isError = new ObservableBoolean();
    public ObservableBoolean loadingStatus = new ObservableBoolean(false);
    public ObservableList<CheckoutModel> data = new ObservableArrayList<>();
    public CheckoutsAdapter adapter = new CheckoutsAdapter(data);

    public CheckoutFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onBackClicked() {
        getNavigator().onBack();
    }

    public void verifyPrice(CharSequence str, int start, int before, int count) {
        isError.set(false);
    }

    public void onCheckoutClicked() {
        if (price.get() == null || price.get().length() == 0) {
            errorMessage.set("لطفا مبلغ را وارد نمایید.");
            isError.set(true);
        } else if (Integer.parseInt(price.get()) < 500000) {
            errorMessage.set("حداقل مبلغ قابل برداشت 50 هزار تومان می باشد.");
            isError.set(true);
        } else if (User.find(User.class, null, null).get(0).getCredit() <= Integer.parseInt(price.get())) {
            errorMessage.set("مبلغ وارد شده بیشتر از موجودی است");
            isError.set(true);
        } else {
            getNavigator().onAddCheckout();
        }

    }

    public void doGetCheckouts() throws Exception {
        getCompositeDisposable().add(getDataManager()
                .doGetCheckouts()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            Gson gson = new Gson();
                            Type listType = new TypeToken<List<CheckoutModel>>() {
                            }.getType();
                            List<CheckoutModel> voucherModels = gson.fromJson(response, listType);
                            if (voucherModels.size() > 0)
                                data.clear();
                            data.addAll(voucherModels);
                            adapter.notifyDataSetChanged();
                        }
                        , throwable -> {
                            getNavigator().showMessage(R.string.public_error);
                        }
                ));
    }

    public void doAddCheckout() throws Exception {
        loadingStatus.set(true);
        getCompositeDisposable().add(getDataManager()
                .doAddCheckout(new CheckoutRequest(User.find(User.class, null, null).get(0).getUid(), price.get()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            loadingStatus.set(false);
                            getNavigator().showMessage("درخواست شما با موفقیت ثبت شد");
                            doGetCheckouts();
                        }
                        , throwable -> {
                            loadingStatus.set(false);
                            getNavigator().showMessage(R.string.public_error);
                        }
                ));
    }
}
