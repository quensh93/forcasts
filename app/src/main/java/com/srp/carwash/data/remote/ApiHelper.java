package com.srp.carwash.data.remote;

import io.reactivex.Single;

public interface ApiHelper {

    ApiHeader getApiHeader();

    Single<String> doGetForecasts() throws Exception;

    Single<String> doGetMyOrder() throws Exception;

}
