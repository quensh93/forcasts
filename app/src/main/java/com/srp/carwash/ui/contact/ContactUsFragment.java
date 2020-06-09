package com.srp.carwash.ui.contact;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.srp.carwash.R;
import com.srp.carwash.databinding.FragmentContactUsBinding;
import com.srp.carwash.ui.base.BaseFragment;

import javax.inject.Inject;

public class ContactUsFragment extends BaseFragment<FragmentContactUsBinding, ContactUsFragmentViewModel> implements ContactUsFragmentCallback {

    public static final String TAG = ContactUsFragment.class.getSimpleName();

    @Inject
    ContactUsFragmentViewModel mViewModel;

    public static ContactUsFragment newInstance() {
        ContactUsFragment fragment = new ContactUsFragment();
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
        return R.layout.fragment_contact_us;
    }

    @Override
    public ContactUsFragmentViewModel getViewModel() {
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
    public void onSend() {
        try {
            mViewModel.doContactUs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
