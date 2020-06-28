package com.srp.carwash.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.srp.carwash.R;
import com.srp.carwash.data.model.api.MatchesModel;
import com.srp.carwash.databinding.ListItemMatchesBinding;

import java.util.ArrayList;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {

    private ArrayList<MatchesModel> data;
    private OnMatchesListener onMatchesListener;

    public MatchesAdapter(ArrayList<MatchesModel> data, OnMatchesListener onMatchesListener) {
        this.data = data;
        this.onMatchesListener = onMatchesListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemMatchesBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.list_item_matches, parent, false);
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

    public void onClicked(MatchesModel packages) {
        onMatchesListener.onMatch(packages);
    }

    public void notifyData(ArrayList<MatchesModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ListItemMatchesBinding binding;

        public ViewHolder(ListItemMatchesBinding listItemCardsMeBinding) {
            super(listItemCardsMeBinding.getRoot());
            binding = listItemCardsMeBinding;
        }
    }

}