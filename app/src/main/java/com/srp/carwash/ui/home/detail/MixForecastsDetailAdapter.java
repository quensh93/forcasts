package com.srp.carwash.ui.home.detail;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.srp.carwash.R;
import com.srp.carwash.data.model.api.ForecastModel;
import com.srp.carwash.data.model.api.MixForecastModel;
import com.srp.carwash.databinding.ListItemForcastMixItemDetailBinding;

import java.util.ArrayList;

public class MixForecastsDetailAdapter extends RecyclerView.Adapter<MixForecastsDetailAdapter.ViewHolder> {

    private ArrayList<ForecastModel> data;

    public MixForecastsDetailAdapter() {

    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemForcastMixItemDetailBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.list_item_forcast_mix_item_detail, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder h, final int position) {
        h.binding.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(MixForecastModel model) {
        data = model.getMatchList();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ListItemForcastMixItemDetailBinding binding;

        public ViewHolder(ListItemForcastMixItemDetailBinding listItemCardsMeBinding) {
            super(listItemCardsMeBinding.getRoot());
            binding = listItemCardsMeBinding;
        }
    }

}