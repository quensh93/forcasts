package com.srp.carwash.ui.home.detail;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.srp.carwash.R;
import com.srp.carwash.data.model.api.MixForecastModel;
import com.srp.carwash.databinding.FragmentContactUsBinding;
import com.srp.carwash.ui.base.BaseFragment;

import javax.inject.Inject;

public class MixForecastsDetailFragment extends BaseFragment<FragmentContactUsBinding, MixForecastsDetailViewModel> implements MixForecastsDetailCallback {

    public static final String TAG = MixForecastsDetailFragment.class.getSimpleName();

    @Inject
    MixForecastsDetailViewModel mViewModel;

    public static MixForecastsDetailFragment newInstance(MixForecastModel model) {
        MixForecastsDetailFragment fragment = new MixForecastsDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("model", new Gson().toJson(model));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        mViewModel.setModelData(new Gson().fromJson(getArguments().getString("model"), MixForecastModel.class));
    }

    @Override
    public int getBindingVariable() {
        return com.srp.carwash.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mix_forecasts_detail;
    }

    @Override
    public MixForecastsDetailViewModel getViewModel() {
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

    }

}
