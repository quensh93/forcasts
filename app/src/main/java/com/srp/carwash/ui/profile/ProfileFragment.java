package com.srp.carwash.ui.profile;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.srp.carwash.R;
import com.srp.carwash.databinding.FragmentProfileBinding;
import com.srp.carwash.ui.about.AboutUsFragment;
import com.srp.carwash.ui.base.BaseFragment;
import com.srp.carwash.ui.contact.ContactUsFragment;
import com.srp.carwash.ui.reports.ReportsFragment;

import javax.inject.Inject;

public class ProfileFragment extends BaseFragment<FragmentProfileBinding, ProfileFragmentViewModel> implements ProfileFragmentCallback {

    public static final String TAG = ProfileFragment.class.getSimpleName();

    @Inject
    ProfileFragmentViewModel mViewModel;

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
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
        return R.layout.fragment_profile;
    }

    @Override
    public ProfileFragmentViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onBack() {
        if(getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void onEditprofile() {

    }

    @Override
    public void onChangeAvatar() {

    }

    @Override
    public void onContactUs() {
        changeFragmentNeedBack(R.id.fl_main, ContactUsFragment.newInstance(), ContactUsFragment.TAG);
    }

    @Override
    public void onAboutUs() {
        changeFragmentNeedBack(R.id.fl_main, AboutUsFragment.newInstance(), AboutUsFragment.TAG);
    }

    @Override
    public void onReports() {
        changeFragmentNeedBack(R.id.fl_main, ReportsFragment.newInstance(), ReportsFragment.TAG);
    }

    @Override
    public void onCashout() {

    }

    @Override
    public void onIncreaseCredit() {

    }

    @Override
    public void onLicence() {

    }

}
