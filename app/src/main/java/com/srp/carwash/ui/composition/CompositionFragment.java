package com.srp.carwash.ui.composition;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.srp.carwash.R;
import com.srp.carwash.databinding.FragmentCompositionBinding;
import com.srp.carwash.ui.base.BaseFragment;

import javax.inject.Inject;

public class CompositionFragment extends BaseFragment<FragmentCompositionBinding, CompositionFragmentViewModel> implements CompositionFragmentCallback {

    public static final String TAG = CompositionFragment.class.getSimpleName();

    @Inject
    CompositionFragmentViewModel mViewModel;

    public static CompositionFragment newInstance() {
        CompositionFragment fragment = new CompositionFragment();
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
        return R.layout.fragment_composition;
    }

    @Override
    public CompositionFragmentViewModel getViewModel() {
        return mViewModel;
    }

}
