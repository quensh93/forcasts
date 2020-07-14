package com.srp.carwash.ui.news.news_detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.google.gson.Gson;
import com.srp.carwash.R;
import com.srp.carwash.data.model.api.News;
import com.srp.carwash.databinding.DialogNewsDetailBinding;
import com.srp.carwash.ui.base.BaseDialog;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class NewsDetailDialog extends BaseDialog implements NewsDetailDialogCallback {

    public static final String TAG = NewsDetailDialog.class.getSimpleName();
    @Inject
    NewsDetailDialogViewModel mViewModel;
    private DialogNewsDetailBinding binding;

    public static NewsDetailDialog newInstance(News news) {
        NewsDetailDialog fragment = new NewsDetailDialog();
        Bundle bundle = new Bundle();
        bundle.putString("news", new Gson().toJson(news));
        fragment.setCancelable(true);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_news_detail, container, false);
        View view = binding.getRoot();
        AndroidSupportInjection.inject(this);
        mViewModel.setNavigator(this);
        mViewModel.setNews(new Gson().fromJson(getArguments().getString("news"), News.class));
        binding.setViewModel(mViewModel);
        try {
            mViewModel.updateView();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int message) {

    }

    @Override
    public void onBack() {
        dismiss();
    }
}
