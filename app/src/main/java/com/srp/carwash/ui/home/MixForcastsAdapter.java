package com.srp.carwash.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.srp.carwash.R;
import com.srp.carwash.data.model.api.ForecastModel;
import com.srp.carwash.databinding.ListItemForcastMixItemBinding;

import java.util.ArrayList;

public class MixForcastsAdapter extends RecyclerView.Adapter<MixForcastsAdapter.ViewHolder> {

    private ArrayList<ForecastModel> data;

    public MixForcastsAdapter(ArrayList<ForecastModel> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemForcastMixItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.list_item_forcast_mix_item, parent, false);
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ListItemForcastMixItemBinding binding;

        public ViewHolder(ListItemForcastMixItemBinding listItemCardsMeBinding) {
            super(listItemCardsMeBinding.getRoot());
            binding = listItemCardsMeBinding;
        }
    }

}