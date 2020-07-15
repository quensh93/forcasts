package com.srp.carwash.data.remote;

import com.srp.carwash.data.model.api.CheckoutRequest;
import com.srp.carwash.data.model.api.ContactUsRequest;
import com.srp.carwash.data.model.api.ExtendSubRequest;
import com.srp.carwash.data.model.api.IncreaseCreditRequest;
import com.srp.carwash.data.model.api.LoginRequest;
import com.srp.carwash.data.model.api.RegisterRequest;
import com.srp.carwash.data.model.api.UpdateViewRequest;
import com.srp.carwash.data.model.api.VoteRequest;

import io.reactivex.Single;

public interface ApiHelper {

    ApiHeader getApiHeader();

    Single<String> doGetForecasts(String matchId) throws Exception;

    Single<String> doLogin(LoginRequest request) throws Exception;

    Single<String> doRegister(RegisterRequest request) throws Exception;

    Single<String> doContactUs(ContactUsRequest request) throws Exception;

    Single<String> doIncreaseCredit(IncreaseCreditRequest request) throws Exception;

    Single<String> doGetVouchers() throws Exception;

    Single<String> doGetPackages() throws Exception;

    Single<String> doExtendSubscription(ExtendSubRequest extendSubRequest) throws Exception;

    Single<String> doGetUserInfo() throws Exception;

    Single<String> doGetCheckouts() throws Exception;

    Single<String> doAddCheckout(CheckoutRequest request) throws Exception;

    Single<String> doGetCountries() throws Exception;

    Single<String> doGetLeagues() throws Exception;

    Single<String> doGetSports() throws Exception;

    Single<String> doGetMatches(String date) throws Exception;

    Single<String> doGetNews(String matchId) throws Exception;

    Single<String> doUpdateNewsView(UpdateViewRequest newsId) throws Exception;

    Single<String> doVote(VoteRequest request) throws Exception;

    Single<String> doGetStatistics(String date) throws Exception;

    Single<String> doGetComposition(String matchId) throws Exception;

    Single<String> doGetMatchStatistics(String matchId) throws Exception;

    Single<String> doCheckVersion() throws Exception;

}
