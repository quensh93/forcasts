package com.srp.carwash.ui.packages;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.srp.carwash.R;
import com.srp.carwash.databinding.FragmentPackagesBinding;
import com.srp.carwash.ui.base.BaseFragment;

import javax.inject.Inject;

public class PackagesFragment extends BaseFragment<FragmentPackagesBinding, PackagesFragmentViewModel> implements PackagesFragmentCallback {

    public static final String TAG = PackagesFragment.class.getSimpleName();

    @Inject
    PackagesFragmentViewModel mViewModel;

    public static PackagesFragment newInstance() {
        PackagesFragment fragment = new PackagesFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        try {
            mViewModel.getPackages();
        } catch (Exception e) {

            Log.e("getPackages", "e : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public int getBindingVariable() {
        return com.srp.carwash.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_packages;
    }

    @Override
    public PackagesFragmentViewModel getViewModel() {
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
    public void onExtend(int pid) {
        try {
            mViewModel.extendSubscription(pid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
