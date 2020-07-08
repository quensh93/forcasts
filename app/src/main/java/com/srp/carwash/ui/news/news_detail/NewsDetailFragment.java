package com.srp.carwash.ui.news.news_detail;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.srp.carwash.R;
import com.srp.carwash.data.model.api.News;
import com.srp.carwash.databinding.FragmentNewsBinding;
import com.srp.carwash.ui.base.BaseFragment;

import javax.inject.Inject;

public class NewsDetailFragment extends BaseFragment<FragmentNewsBinding, NewsDetailFragmentViewModel> implements NewsDetailFragmentCallback {

    public static final String TAG = NewsDetailFragment.class.getSimpleName();

    @Inject
    NewsDetailFragmentViewModel mViewModel;

    public static NewsDetailFragment newInstance(News news) {
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("news", new Gson().toJson(news));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        mViewModel.setNews(new Gson().fromJson(getArguments().getString("news"), News.class));
        try {
            mViewModel.updateView();
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
        return R.layout.fragment_news_detail;
    }

    @Override
    public NewsDetailFragmentViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int message) {

    }

    @Override
    public void onBack() {
        getActivity().onBackPressed();
    }
}
