package com.srp.carwash.ui.checkout;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

import com.srp.carwash.R;
import com.srp.carwash.data.model.api.CheckoutModel;
import com.srp.carwash.databinding.ListItemCheckoutsBinding;

public class CheckoutsAdapter extends RecyclerView.Adapter<CheckoutsAdapter.ViewHolder> {

    private ObservableList<CheckoutModel> data;

    public CheckoutsAdapter(ObservableList<CheckoutModel> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemCheckoutsBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.list_item_checkouts, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder h, final int position) {
        h.binding.setModel(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ListItemCheckoutsBinding binding;

        public ViewHolder(ListItemCheckoutsBinding listItemCardsMeBinding) {
            super(listItemCardsMeBinding.getRoot());
            binding = listItemCardsMeBinding;
        }
    }

}