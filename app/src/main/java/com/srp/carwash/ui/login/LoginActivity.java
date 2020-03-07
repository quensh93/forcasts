package com.srp.carwash.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.srp.carwash.BR;
import com.srp.carwash.R;
import com.srp.carwash.databinding.ActivityLoginBinding;
import com.srp.carwash.ui.base.BaseActivity;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator{

    @Inject
    public LoginViewModel loginViewModel;

    ActivityLoginBinding mActivityLoginBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginViewModel getViewModel() {
        return loginViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        loginViewModel.setNavigator(this);
    }
}
