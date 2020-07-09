package com.srp.carwash.ui.news;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.srp.carwash.R;
import com.srp.carwash.data.model.api.News;
import com.srp.carwash.databinding.FragmentNewsBinding;
import com.srp.carwash.ui.base.BaseFragment;
import com.srp.carwash.ui.news.news_detail.NewsDetailFragment;

import javax.inject.Inject;

public class NewsFragment extends BaseFragment<FragmentNewsBinding, NewsFragmentViewModel> implements NewsFragmentCallback {

    public static final String TAG = NewsFragment.class.getSimpleName();

    @Inject
    NewsFragmentViewModel mViewModel;

    public static NewsFragment newInstance(int matchId) {
        NewsFragment fragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("matchId", matchId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        mViewModel.setMatchId(getArguments().getInt("matchId") + "");
        try {
            mViewModel.getMatchNews();
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
        return R.layout.fragment_news;
    }

    @Override
    public NewsFragmentViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onNewsDetail(News news) {
        changeFragmentNeedBack(R.id.fl_main, NewsDetailFragment.newInstance(news), NewsDetailFragment.TAG);
    }
}
