package com.srp.carwash.ui.login;

import com.srp.carwash.ui.base.BaseNavigator;

public interface LoginNavigator extends BaseNavigator {

    void onLogin();

    void onVerify(String code);

    void onRegister();

    void openMain();
}
