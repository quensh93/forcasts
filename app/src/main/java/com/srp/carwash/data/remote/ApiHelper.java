package com.srp.carwash.data.remote;

import com.srp.carwash.data.model.api.BaseRequest;
import com.srp.carwash.data.model.api.ContactUsRequest;
import com.srp.carwash.data.model.api.IncreaseCreditRequest;
import com.srp.carwash.data.model.api.LoginRequest;
import com.srp.carwash.data.model.api.VerifyRequest;

import java.io.File;

import io.reactivex.Single;

public interface ApiHelper {

    ApiHeader getApiHeader();

    Single<String> doGetForecasts() throws Exception;

    Single<String> doLogin(LoginRequest request) throws Exception;

    Single<String> doVerify(VerifyRequest request) throws Exception;

    Single<String> doContactUs(ContactUsRequest request) throws Exception;

    Single<String> doIncreaseCredit(IncreaseCreditRequest request) throws Exception;

    Single<String> doGetVouchers(BaseRequest request) throws Exception;

    Single<String> doUploadAvatar(String uid, File avatar) throws Exception;

}
