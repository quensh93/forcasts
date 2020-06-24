package com.srp.carwash.ui.packages;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.srp.carwash.R;
import com.srp.carwash.data.model.api.Packages;
import com.srp.carwash.databinding.ListItemPackagesBinding;

import java.util.ArrayList;

public class PackagesAdapter extends RecyclerView.Adapter<PackagesAdapter.ViewHolder> {

    private ArrayList<Packages> data;
    private OnPackagesListener onPackagesListener;

    public PackagesAdapter(ArrayList<Packages> data, OnPackagesListener onPackagesListener) {
        this.data = data;
        this.onPackagesListener = onPackagesListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemPackagesBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.list_item_packages, parent, false);
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

    public void onClicked(Packages packages) {
        onPackagesListener.onPackageClicked(packages);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ListItemPackagesBinding binding;

        public ViewHolder(ListItemPackagesBinding listItemCardsMeBinding) {
            super(listItemCardsMeBinding.getRoot());
            binding = listItemCardsMeBinding;
        }
    }

}