package com.srp.carwash.data.remote;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.srp.carwash.data.model.api.BaseRequest;
import com.srp.carwash.data.model.api.ContactUsRequest;
import com.srp.carwash.data.model.api.IncreaseCreditRequest;
import com.srp.carwash.data.model.api.LoginRequest;
import com.srp.carwash.data.model.api.RegisterRequest;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Single<String> doGetForecasts() throws Exception {
        return Rx2AndroidNetworking.get(ApiEndPoint.GET_FORECASTS)
                .addHeaders("Authorization", "123456")
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doLogin(LoginRequest request) throws Exception {
        return Rx2AndroidNetworking.post(ApiEndPoint.LOGIN)
                .addHeaders("Authorization", "123456")
                .addApplicationJsonBody(request)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doRegister(RegisterRequest request) throws Exception {
        return Rx2AndroidNetworking.post(ApiEndPoint.REGISTER)
                .addHeaders("Authorization", "123456")
                .addApplicationJsonBody(request)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doContactUs(ContactUsRequest request) throws Exception {
        return Rx2AndroidNetworking.post(ApiEndPoint.CONTACT_US)
                .addHeaders("Authorization", "123456")
                .addApplicationJsonBody(request)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doIncreaseCredit(IncreaseCreditRequest request) throws Exception {
        return Rx2AndroidNetworking.post(ApiEndPoint.INCREASE_CREDIT)
                .addHeaders("Authorization", "123456")
                .addApplicationJsonBody(request)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doGetVouchers(BaseRequest request) throws Exception {
        return Rx2AndroidNetworking.post(ApiEndPoint.GET_VOUCHERS)
                .addHeaders("Authorization", "123456")
                .addApplicationJsonBody(request)
                .build()
                .getStringSingle();
    }
}
