package com.srp.carwash.data.remote;

import com.srp.carwash.BuildConfig;

public final class ApiEndPoint {

    public static final String GET_FORECASTS = BuildConfig.BASE_URL + "getForeCasts.php";

    public static final String GET_MY_ORDER = BuildConfig.BASE_URL + "getOrders.php";

    private ApiEndPoint() {

    }
}
