package com.srp.carwash.data.remote;

import com.srp.carwash.BuildConfig;

public final class ApiEndPoint {

    public static final String GET_FORECASTS = BuildConfig.BASE_URL + "getForeCasts.php";
    public static final String LOGIN = BuildConfig.BASE_URL + "login.php";
    public static final String VERIFY = BuildConfig.BASE_URL + "validation.php";
    public static final String CONTACT_US = BuildConfig.BASE_URL + "contactUs.php";
    public static final String INCREASE_CREDIT = BuildConfig.BASE_URL + "increaseCredit.php";
    public static final String GET_VOUCHERS = BuildConfig.BASE_URL + "getVouchers.php";

    private ApiEndPoint() {

    }
}
