package com.srp.carwash.ui.forecasts;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.srp.carwash.R;
import com.srp.carwash.data.model.api.ForecastModel;
import com.srp.carwash.databinding.ListItemForecastsBinding;

import java.util.ArrayList;

public class ForecastsAdapter extends RecyclerView.Adapter<ForecastsAdapter.ViewHolder> {

    private ArrayList<ForecastModel> data;

    public ForecastsAdapter(ArrayList<ForecastModel> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemForecastsBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.list_item_forecasts, parent, false);
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

    public void notifyData(ArrayList<ForecastModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ListItemForecastsBinding binding;

        public ViewHolder(ListItemForecastsBinding listItemCardsMeBinding) {
            super(listItemCardsMeBinding.getRoot());
            binding = listItemCardsMeBinding;
        }
    }

}