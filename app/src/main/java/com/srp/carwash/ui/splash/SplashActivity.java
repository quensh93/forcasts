package com.srp.carwash.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.srp.carwash.BR;
import com.srp.carwash.R;
import com.srp.carwash.data.model.api.User;
import com.srp.carwash.databinding.ActivitySplashBinding;
import com.srp.carwash.ui.base.BaseActivity;
import com.srp.carwash.ui.login.LoginActivity;
import com.srp.carwash.ui.main.MainActivity;

import javax.inject.Inject;

import static com.srp.carwash.MvvmApp.token;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Inject
    SplashViewModel mSplashViewModel;

    public static Intent newIntent(Context context) {
        return new Intent(context, SplashActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        return mSplashViewModel;
    }


    private void decideNext() {
        if (User.count(User.class) == 0)
            startActivity(LoginActivity.newIntent(SplashActivity.this));
        else {
            token = User.find(User.class, null, null).get(0).getToken();
            startActivity(MainActivity.newIntent(SplashActivity.this));
        }
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);
        new Handler().postDelayed(this::decideNext, 3000);
    }
}
