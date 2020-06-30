package com.srp.carwash.ui.match_detail;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.srp.carwash.R;
import com.srp.carwash.data.model.api.MatchesModel;
import com.srp.carwash.databinding.FragmentAboutUsBinding;
import com.srp.carwash.ui.base.BaseFragment;
import com.srp.carwash.ui.composition.CompositionFragment;
import com.srp.carwash.ui.forecasts.ForecastsFragment;
import com.srp.carwash.ui.news.NewsFragment;
import com.srp.carwash.ui.statistics.StatisticsFragment;

import javax.inject.Inject;

public class MatchDetailFragment extends BaseFragment<FragmentAboutUsBinding, MatchDetailFragmentViewModel> implements MatchDetailFragmentCallback {

    public static final String TAG = MatchDetailFragment.class.getSimpleName();

    @Inject
    MatchDetailFragmentViewModel mViewModel;

    public static MatchDetailFragment newInstance(MatchesModel matchesModel) {
        MatchDetailFragment fragment = new MatchDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("match", new Gson().toJson(matchesModel));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        mViewModel.setState(1);
        mViewModel.setMatch(new Gson().fromJson(getArguments().getString("match"), MatchesModel.class));
    }

    @Override
    public int getBindingVariable() {
        return com.srp.carwash.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_match_detail;
    }

    @Override
    public MatchDetailFragmentViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onBack() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void onForecasts() {
        changeFragment(R.id.fl_match, ForecastsFragment.newInstance(new Gson().fromJson(getArguments().getString("match"), MatchesModel.class).getId() + ""), ForecastsFragment.TAG);
    }

    @Override
    public void onNews() {
        changeFragment(R.id.fl_match, NewsFragment.newInstance(), NewsFragment.TAG);
    }

    @Override
    public void onComposition() {
        changeFragment(R.id.fl_match, CompositionFragment.newInstance(), CompositionFragment.TAG);
    }

    @Override
    public void onStatistics() {
        changeFragment(R.id.fl_match, StatisticsFragment.newInstance(), StatisticsFragment.TAG);
    }

}
