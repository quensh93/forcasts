package com.srp.carwash.di.builder;

import com.srp.carwash.ui.about.AboutUsFragmentProvider;
import com.srp.carwash.ui.checkout.CheckoutFragmentProvider;
import com.srp.carwash.ui.composition.CompositionFragmentProvider;
import com.srp.carwash.ui.contact.ContactUsFragmentProvider;
import com.srp.carwash.ui.forecasts.ForecastsFragmentProvider;
import com.srp.carwash.ui.home.HomeFragmentProvider;
import com.srp.carwash.ui.increase_credit.IncreaseCreditFragmentProvider;
import com.srp.carwash.ui.investment.InvestmentFragmentProvider;
import com.srp.carwash.ui.login.LoginActivity;
import com.srp.carwash.ui.login.LoginActivityModule;
import com.srp.carwash.ui.main.MainActivity;
import com.srp.carwash.ui.main.MainActivityModule;
import com.srp.carwash.ui.match_detail.MatchDetailFragmentProvider;
import com.srp.carwash.ui.news.NewsFragmentProvider;
import com.srp.carwash.ui.news.news_detail.NewsDetailFragmentProvider;
import com.srp.carwash.ui.packages.PackagesFragmentProvider;
import com.srp.carwash.ui.profile.ProfileFragmentProvider;
import com.srp.carwash.ui.reports.ReportsFragmentProvider;
import com.srp.carwash.ui.splash.SplashActivity;
import com.srp.carwash.ui.splash.SplashActivityModule;
import com.srp.carwash.ui.statistics.StatisticsFragmentProvider;

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
            IncreaseCreditFragmentProvider.class,
            InvestmentFragmentProvider.class,
            PackagesFragmentProvider.class,
            CheckoutFragmentProvider.class,
            MatchDetailFragmentProvider.class,
            ForecastsFragmentProvider.class,
            NewsFragmentProvider.class,
            NewsDetailFragmentProvider.class,
            StatisticsFragmentProvider.class,
            CompositionFragmentProvider.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules =LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();

}
