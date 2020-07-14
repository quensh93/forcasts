package com.srp.carwash.ui.statistics;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.srp.carwash.R;
import com.srp.carwash.databinding.FragmentStatisticsBinding;
import com.srp.carwash.ui.base.BaseFragment;

import javax.inject.Inject;

public class StatisticsFragment extends BaseFragment<FragmentStatisticsBinding, StatisticsFragmentViewModel> implements StatisticsFragmentCallback {

    public static final String TAG = StatisticsFragment.class.getSimpleName();

    @Inject
    StatisticsFragmentViewModel mViewModel;

    public static StatisticsFragment newInstance(String matchId) {
        StatisticsFragment fragment = new StatisticsFragment();
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
            mViewModel.doGetMatchStatistics(getArguments().getString("matchId"));
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
        return R.layout.fragment_statistics;
    }

    @Override
    public StatisticsFragmentViewModel getViewModel() {
        return mViewModel;
    }

}
