package com.srp.carwash.ui.forecasts;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.srp.carwash.R;
import com.srp.carwash.databinding.FragmentForecastsBinding;
import com.srp.carwash.ui.base.BaseFragment;

import javax.inject.Inject;

public class ForecastsFragment extends BaseFragment<FragmentForecastsBinding, ForecastsFragmentViewModel> implements ForecastsFragmentCallback {

    public static final String TAG = ForecastsFragment.class.getSimpleName();

    @Inject
    ForecastsFragmentViewModel mViewModel;

    public static ForecastsFragment newInstance(String matchId) {
        ForecastsFragment fragment = new ForecastsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("matchId", matchId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        try {
            mViewModel.getForecasts(getArguments().getString("matchId"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getBindingVariable() {
        return com.srp.carwash.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_forecasts;
    }

    @Override
    public ForecastsFragmentViewModel getViewModel() {
        return mViewModel;
    }

}
