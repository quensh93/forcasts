package com.srp.carwash.data.remote;

import com.srp.carwash.BuildConfig;

public final class ApiEndPoint {

    public static final String GET_FORECASTS = BuildConfig.BASE_URL + "getForeCasts.php";
    public static final String GET_MY_ORDER = BuildConfig.BASE_URL + "getOrders.php";
    public static final String LOGIN = BuildConfig.BASE_URL + "login.php";
    public static final String VERIFY = BuildConfig.BASE_URL + "validation.php";

    private ApiEndPoint() {

    }
}
