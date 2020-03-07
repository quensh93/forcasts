package com.srp.carwash.ui.increase_credit;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.srp.carwash.R;
import com.srp.carwash.databinding.FragmentIncreaseCreditBinding;
import com.srp.carwash.ui.base.BaseFragment;
import javax.inject.Inject;

public class IncreaseCreditFragment extends BaseFragment<FragmentIncreaseCreditBinding, IncreaseCreditFragmentViewModel> implements IncreaseCreditFragmentCallback {

    public static final String TAG = IncreaseCreditFragment.class.getSimpleName();

    @Inject
    IncreaseCreditFragmentViewModel mViewModel;

    public static IncreaseCreditFragment newInstance() {
        IncreaseCreditFragment fragment = new IncreaseCreditFragment();
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
        return R.layout.fragment_increase_credit;
    }

    @Override
    public IncreaseCreditFragmentViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onBack() {
        if(getActivity() != null)
            getActivity().onBackPressed();
    }

}
