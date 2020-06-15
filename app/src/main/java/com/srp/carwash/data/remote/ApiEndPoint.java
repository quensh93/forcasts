package com.srp.carwash.data.remote;

import com.srp.carwash.BuildConfig;

public final class ApiEndPoint {

    public static final String GET_FORECASTS = BuildConfig.BASE_URL + "getForeCasts.php";
    public static final String LOGIN = BuildConfig.BASE_URL + "login.php";
    public static final String REGISTER = BuildConfig.BASE_URL + "register.php";
    public static final String CONTACT_US = BuildConfig.BASE_URL + "contactUs.php";
    public static final String INCREASE_CREDIT = BuildConfig.BASE_URL + "increaseCredit.php";
    public static final String GET_VOUCHERS = BuildConfig.BASE_URL + "getVouchers.php";
    public static final String EXTEND_SUBSCRIPTION = BuildConfig.BASE_URL + "extendSubscription.php";
    public static final String GET_PACKAGES = BuildConfig.BASE_URL + "getPackages.php";
    public static final String GET_USER_INFO = BuildConfig.BASE_URL + "getUserInfo.php";

    public static final String LOAD_AVATAR = BuildConfig.BASE_URL + "uploads/";
    public static final String UPLOAD_AVATAR = BuildConfig.BASE_URL + "uploadFile.php";

    private ApiEndPoint() {

    }
}
