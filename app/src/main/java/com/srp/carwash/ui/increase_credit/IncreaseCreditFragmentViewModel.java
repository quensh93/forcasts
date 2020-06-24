package com.srp.carwash.ui.increase_credit;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.srp.carwash.R;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.IncreaseCreditRequest;
import com.srp.carwash.data.model.api.User;
import com.srp.carwash.data.model.api.VoucherModel;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

import java.lang.reflect.Type;
import java.util.List;

public class IncreaseCreditFragmentViewModel extends BaseViewModel<IncreaseCreditFragmentCallback> {

    public ObservableField<String> voucher = new ObservableField<>();
    public ObservableBoolean isError = new ObservableBoolean();
    public ObservableBoolean loadingStatus = new ObservableBoolean(false);
    public ObservableList<VoucherModel> data = new ObservableArrayList<>();
    public VouchersAdapter vouchersAdapter = new VouchersAdapter(data);

    public IncreaseCreditFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onIncreaseClicked() {
        if (voucher.get() != null && voucher.get().length() > 5)
            getNavigator().onIncrease();
        else
            isError.set(true);
    }

    public void verifyVoucher(CharSequence str, int start, int before, int count) {
        isError.set(false);
    }

    public void onBackClicked() {
        getNavigator().onBack();
    }

    public void onUrlClicked() {
        getNavigator().onOpenUrl();
    }

    public void doIncreaseCredit() throws Exception {
        loadingStatus.set(true);
        getCompositeDisposable().add(getDataManager()
                .doIncreaseCredit(new IncreaseCreditRequest(User.find(User.class, null, null).get(0).getUid(), voucher.get()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            loadingStatus.set(false);
                            getNavigator().showMessage(R.string.increase_credit_successfully);
                            voucher.set("");
                            doGetVouchers();
                        }
                        , throwable -> {
                            loadingStatus.set(false);
                            getNavigator().showMessage(R.string.public_error);
                        }
                ));
    }

    public void doGetVouchers() throws Exception {
        getCompositeDisposable().add(getDataManager()
                .doGetVouchers()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            Gson gson = new Gson();
                            Type listType = new TypeToken<List<VoucherModel>>() {
                            }.getType();
                            List<VoucherModel> voucherModels = gson.fromJson(response, listType);
                            if (voucherModels.size() > 0)
                                data.clear();
                            data.addAll(voucherModels);
                            vouchersAdapter.notifyDataSetChanged();
                        }
                        , throwable -> {
                            getNavigator().showMessage(R.string.public_error);
                        }
                ));
    }

}
