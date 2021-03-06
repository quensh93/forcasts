package com.srp.carwash.ui.checkout;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.srp.carwash.R;
import com.srp.carwash.databinding.FragmentCheckoutBinding;
import com.srp.carwash.ui.base.BaseFragment;

import javax.inject.Inject;

public class CheckoutFragment extends BaseFragment<FragmentCheckoutBinding, CheckoutFragmentViewModel> implements CheckoutFragmentCallback {

    public static final String TAG = CheckoutFragment.class.getSimpleName();

    @Inject
    CheckoutFragmentViewModel mViewModel;

    public static CheckoutFragment newInstance() {
        CheckoutFragment fragment = new CheckoutFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        try {
            mViewModel.doGetCheckouts();
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
        return R.layout.fragment_checkout;
    }

    @Override
    public CheckoutFragmentViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void showMessage(String message) {
        showMessageToast(message);
    }

    @Override
    public void showMessage(int message) {
        showMessageToast(message);
    }

    @Override
    public void onBack() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void onAddCheckout() {
        try {
            mViewModel.doAddCheckout();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
