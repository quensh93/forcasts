package com.srp.carwash.data.remote;

import com.srp.carwash.BuildConfig;

public final class ApiEndPoint {

    public static final String FORECASTS = BuildConfig.BASE_URL + "forecasts";
    public static final String LOGIN = BuildConfig.BASE_URL + "login";
    public static final String REGISTER = BuildConfig.BASE_URL + "register";
    public static final String CONTACT_US = BuildConfig.BASE_URL + "contactUs";
    public static final String INCREASE_CREDIT = BuildConfig.BASE_URL + "increaseCredit";
    public static final String VOUCHERS = BuildConfig.BASE_URL + "vouchers";
    public static final String EXTEND_SUBSCRIPTION = BuildConfig.BASE_URL + "extendSubscription";
    public static final String PACKAGES = BuildConfig.BASE_URL + "packages";
    public static final String USER = BuildConfig.BASE_URL + "user";
    public static final String CHECKOUTS = BuildConfig.BASE_URL + "checkouts";
    public static final String ADD_CHECKOUT = BuildConfig.BASE_URL + "addCheckout";

    public static final String COUNTRIES = BuildConfig.BASE_URL + "countries";
    public static final String LEAGUES = BuildConfig.BASE_URL + "leagues";
    public static final String SPORTS = BuildConfig.BASE_URL + "sports";
    public static final String MATCHES = BuildConfig.BASE_URL + "matches.php";
    public static final String NEWS = BuildConfig.BASE_URL + "news";
    public static final String VOTE = BuildConfig.BASE_URL + "vote";
    public static final String STATISTICS = BuildConfig.BASE_URL + "statistics";
    public static final String COMPOSITION = BuildConfig.BASE_URL + "composition";
    public static final String MATCH_STATISTICS = BuildConfig.BASE_URL + "matchStatistics";
    public static final String CHECK_VERSION = BuildConfig.BASE_URL + "checkVersion";

    public static final String LOAD_AVATAR = BuildConfig.BASE_URL + "uploads/";
    public static final String UPLOAD_AVATAR = BuildConfig.BASE_URL + "uploadFile";

    private ApiEndPoint() {

    }
}
