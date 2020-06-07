package com.srp.carwash.data.remote;

import com.srp.carwash.data.model.api.LoginRequest;
import com.srp.carwash.data.model.api.VerifyRequest;

import io.reactivex.Single;

public interface ApiHelper {

    ApiHeader getApiHeader();

    Single<String> doGetForecasts() throws Exception;

    Single<String> doGetMyOrder() throws Exception;

    Single<String> doLogin(LoginRequest request) throws Exception;

    Single<String> doVerify(VerifyRequest request) throws Exception;

}
