package com.srp.carwash.di.builder;

import com.srp.carwash.ui.about.AboutUsFragmentProvider;
import com.srp.carwash.ui.contact.ContactUsFragmentProvider;
import com.srp.carwash.ui.home.HomeFragmentProvider;
import com.srp.carwash.ui.increase_credit.IncreaseCreditFragmentProvider;
import com.srp.carwash.ui.login.LoginActivity;
import com.srp.carwash.ui.login.LoginActivityModule;
import com.srp.carwash.ui.main.MainActivity;
import com.srp.carwash.ui.main.MainActivityModule;
import com.srp.carwash.ui.profile.ProfileFragmentProvider;
import com.srp.carwash.ui.reports.ReportsFragmentProvider;
import com.srp.carwash.ui.splash.SplashActivity;
import com.srp.carwash.ui.splash.SplashActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = {
            MainActivityModule.class,
            HomeFragmentProvider.class,
            ProfileFragmentProvider.class,
            AboutUsFragmentProvider.class,
            ContactUsFragmentProvider.class,
            ReportsFragmentProvider.class,
            IncreaseCreditFragmentProvider.class})

    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules =LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();

}
