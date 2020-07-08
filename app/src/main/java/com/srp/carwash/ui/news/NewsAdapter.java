package com.srp.carwash.ui.news;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.srp.carwash.R;
import com.srp.carwash.data.model.api.News;
import com.srp.carwash.databinding.ListItemNewsBinding;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<News> data;
    private OnNews onNews;

    public NewsAdapter(ArrayList<News> data, OnNews onNews) {
        this.data = data;
        this.onNews = onNews;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemNewsBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.list_item_news, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder h, final int position) {
        h.binding.setAdapter(this);
        h.binding.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void notifyData(ArrayList<News> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void OnItemClick(News news) {
        onNews.onNews(news);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ListItemNewsBinding binding;

        public ViewHolder(ListItemNewsBinding listItemCardsMeBinding) {
            super(listItemCardsMeBinding.getRoot());
            binding = listItemCardsMeBinding;
        }
    }

}