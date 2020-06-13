package com.srp.carwash.data.remote;

import com.srp.carwash.data.model.api.BaseRequest;
import com.srp.carwash.data.model.api.ContactUsRequest;
import com.srp.carwash.data.model.api.IncreaseCreditRequest;
import com.srp.carwash.data.model.api.LoginRequest;
import com.srp.carwash.data.model.api.RegisterRequest;

import io.reactivex.Single;

public interface ApiHelper {

    ApiHeader getApiHeader();

    Single<String> doGetForecasts() throws Exception;

    Single<String> doLogin(LoginRequest request) throws Exception;

    Single<String> doRegister(RegisterRequest request) throws Exception;

    Single<String> doContactUs(ContactUsRequest request) throws Exception;

    Single<String> doIncreaseCredit(IncreaseCreditRequest request) throws Exception;

    Single<String> doGetVouchers(BaseRequest request) throws Exception;

}
