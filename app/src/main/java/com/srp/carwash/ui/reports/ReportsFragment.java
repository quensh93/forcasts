package com.srp.carwash.ui.reports;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.srp.carwash.R;
import com.srp.carwash.databinding.FragmentReportsBinding;
import com.srp.carwash.ui.base.BaseFragment;

import javax.inject.Inject;

public class ReportsFragment extends BaseFragment<FragmentReportsBinding, ReportsFragmentViewModel> implements ReportsFragmentCallback {

    public static final String TAG = ReportsFragment.class.getSimpleName();

    @Inject
    ReportsFragmentViewModel mViewModel;

    public static ReportsFragment newInstance() {
        ReportsFragment fragment = new ReportsFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
    }

    @Override
    public int getBindingVariable() {
        return com.srp.carwash.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_reports;
    }

    @Override
    public ReportsFragmentViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onBack() {
        if(getActivity() != null)
            getActivity().onBackPressed();
    }

}
