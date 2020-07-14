package com.srp.carwash.data.remote;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.srp.carwash.data.model.api.CheckoutRequest;
import com.srp.carwash.data.model.api.ContactUsRequest;
import com.srp.carwash.data.model.api.ExtendSubRequest;
import com.srp.carwash.data.model.api.IncreaseCreditRequest;
import com.srp.carwash.data.model.api.LoginRequest;
import com.srp.carwash.data.model.api.RegisterRequest;
import com.srp.carwash.data.model.api.UpdateViewRequest;
import com.srp.carwash.data.model.api.VoteRequest;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

import static com.srp.carwash.MvvmApp.token;

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
    public Single<String> doGetForecasts(String matchId) throws Exception {
        return Rx2AndroidNetworking.get(ApiEndPoint.FORECASTS + "/" + matchId)
                .addHeaders("Authorization", token)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doLogin(LoginRequest request) throws Exception {
        return Rx2AndroidNetworking.post(ApiEndPoint.LOGIN)
                .addApplicationJsonBody(request)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doRegister(RegisterRequest request) throws Exception {
        return Rx2AndroidNetworking.post(ApiEndPoint.REGISTER)
                .addApplicationJsonBody(request)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doContactUs(ContactUsRequest request) throws Exception {
        return Rx2AndroidNetworking.post(ApiEndPoint.CONTACT_US)
                .addHeaders("Authorization", token)
                .addApplicationJsonBody(request)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doIncreaseCredit(IncreaseCreditRequest request) throws Exception {
        return Rx2AndroidNetworking.post(ApiEndPoint.INCREASE_CREDIT)
                .addHeaders("Authorization", token)
                .addApplicationJsonBody(request)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doGetVouchers() throws Exception {
        return Rx2AndroidNetworking.get(ApiEndPoint.VOUCHERS)
                .addHeaders("Authorization", token)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doGetPackages() throws Exception {
        return Rx2AndroidNetworking.get(ApiEndPoint.PACKAGES)
                .addHeaders("Authorization", token)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doExtendSubscription(ExtendSubRequest request) throws Exception {
        return Rx2AndroidNetworking.post(ApiEndPoint.EXTEND_SUBSCRIPTION)
                .addHeaders("Authorization", token)
                .addApplicationJsonBody(request)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doGetUserInfo() throws Exception {
        return Rx2AndroidNetworking.get(ApiEndPoint.USER)
                .addHeaders("Authorization", token)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doGetCheckouts() throws Exception {
        return Rx2AndroidNetworking.get(ApiEndPoint.CHECKOUTS)
                .addHeaders("Authorization", token)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doAddCheckout(CheckoutRequest request) throws Exception {
        return Rx2AndroidNetworking.post(ApiEndPoint.ADD_CHECKOUT)
                .addHeaders("Authorization", token)
                .addApplicationJsonBody(request)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doGetCountries() throws Exception {
        return Rx2AndroidNetworking.get(ApiEndPoint.COUNTRIES)
                .addHeaders("Authorization", token)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doGetLeagues() throws Exception {
        return Rx2AndroidNetworking.get(ApiEndPoint.LEAGUES)
                .addHeaders("Authorization", token)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doGetSports() throws Exception {
        return Rx2AndroidNetworking.get(ApiEndPoint.SPORTS)
                .addHeaders("Authorization", token)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doGetMatches(String date) throws Exception {
        return Rx2AndroidNetworking.get(ApiEndPoint.MATCHES)
                .addHeaders("Authorization", token)
                .addQueryParameter("date", date)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doGetNews(String matchId) throws Exception {
        return Rx2AndroidNetworking.get(ApiEndPoint.NEWS + "/" + matchId)
                .addHeaders("Authorization", token)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doUpdateNewsView(UpdateViewRequest newsId) throws Exception {
        return Rx2AndroidNetworking.post(ApiEndPoint.NEWS)
                .addHeaders("Authorization", token)
                .addApplicationJsonBody(newsId)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doVote(VoteRequest request) throws Exception {
        return Rx2AndroidNetworking.post(ApiEndPoint.VOTE)
                .addHeaders("Authorization", token)
                .addApplicationJsonBody(request)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doGetStatistics(String date) throws Exception {
        return Rx2AndroidNetworking.get(ApiEndPoint.STATISTICS)
                .addHeaders("Authorization", token)
                .addQueryParameter("date", date)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doGetComposition(String matchId) throws Exception {
        return Rx2AndroidNetworking.get(ApiEndPoint.COMPOSITION + "/" + matchId)
                .addHeaders("Authorization", token)
                .build()
                .getStringSingle();
    }

    @Override
    public Single<String> doGetMatchStatistics(String matchId) throws Exception {
        return Rx2AndroidNetworking.get(ApiEndPoint.MATCH_STATISTICS + "/" + matchId)
                .addHeaders("Authorization", token)
                .build()
                .getStringSingle();
    }

}
