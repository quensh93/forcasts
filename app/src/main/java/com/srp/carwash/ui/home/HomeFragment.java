package com.srp.carwash.ui.home;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.srp.carwash.R;
import com.srp.carwash.data.model.api.MatchesModel;
import com.srp.carwash.databinding.FragmentHomeBinding;
import com.srp.carwash.ui.base.BaseFragment;
import com.srp.carwash.ui.match_detail.MatchDetailFragment;

import javax.inject.Inject;

public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeFragmentViewModel> implements HomeFragmentCallback {

    public static final String TAG = HomeFragment.class.getSimpleName();

    @Inject
    HomeFragmentViewModel mViewModel;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        try {
            mViewModel.getMatches("2020-06-30");
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
        return R.layout.fragment_home;
    }

    @Override
    public HomeFragmentViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onDateChange(String date) {
        try {
            mViewModel.getMatches(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMatch(MatchesModel matchesModel) {
        changeFragmentNeedBack(R.id.fl_main, MatchDetailFragment.newInstance(matchesModel), MatchDetailFragment.TAG);
    }
}