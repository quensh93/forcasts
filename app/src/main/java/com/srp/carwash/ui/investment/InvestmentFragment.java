package com.srp.carwash.ui.investment;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.srp.carwash.R;
import com.srp.carwash.databinding.FragmentInvestmentBinding;
import com.srp.carwash.ui.base.BaseFragment;

import javax.inject.Inject;

public class InvestmentFragment extends BaseFragment<FragmentInvestmentBinding, InvestmentFragmentViewModel> implements InvestmentFragmentCallback {

    public static final String TAG = InvestmentFragment.class.getSimpleName();

    @Inject
    InvestmentFragmentViewModel mViewModel;

    public static InvestmentFragment newInstance() {
        InvestmentFragment fragment = new InvestmentFragment();
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
        return R.layout.fragment_investment;
    }

    @Override
    public InvestmentFragmentViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onBack() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

}
