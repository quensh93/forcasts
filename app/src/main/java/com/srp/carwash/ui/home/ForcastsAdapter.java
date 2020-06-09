package com.srp.carwash.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

import com.srp.carwash.R;
import com.srp.carwash.data.model.api.ForecastModel;
import com.srp.carwash.databinding.ListItemForcastBinding;
import com.srp.carwash.databinding.ListItemForcastMixBinding;

public class ForcastsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ObservableList<ForecastModel> data;

    public ForcastsAdapter(ObservableList<ForecastModel> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
            default:
                ListItemForcastBinding binding = DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.list_item_forcast, parent, false);
                return new ViewHolder0(binding);
            case 2:
                ListItemForcastMixBinding binding1 = DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.list_item_forcast_mix, parent, false);
                return new ViewHolder1(binding1);
        }
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        switch (data.get(position).getType()) {
            case 1:
                ViewHolder0 viewHolder0 = (ViewHolder0) holder;
                viewHolder0.binding.setData(data.get(position));
                break;

            case 3:
                ViewHolder1 viewHolder2 = (ViewHolder1) holder;

                break;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class ViewHolder0 extends RecyclerView.ViewHolder {
        public ListItemForcastBinding binding;

        public ViewHolder0(ListItemForcastBinding listItemCardsMeBinding) {
            super(listItemCardsMeBinding.getRoot());
            binding = listItemCardsMeBinding;
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        public ListItemForcastMixBinding binding;

        public ViewHolder1(ListItemForcastMixBinding listItemCardsMeBinding) {
            super(listItemCardsMeBinding.getRoot());
            binding = listItemCardsMeBinding;
        }
    }


}