package com.srp.carwash.data.remote;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.srp.carwash.data.model.api.LoginRequest;
import com.srp.carwash.data.model.api.VerifyRequest;

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
    public Single<String> doGetMyOrder() throws Exception {
        return Rx2AndroidNetworking.get(ApiEndPoint.GET_MY_ORDER)
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
    public Single<String> doVerify(VerifyRequest request) throws Exception {
        return Rx2AndroidNetworking.post(ApiEndPoint.VERIFY)
                .addHeaders("Authorization", "123456")
                .addApplicationJsonBody(request)
                .build()
                .getStringSingle();
    }

}
