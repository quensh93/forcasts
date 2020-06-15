package com.srp.carwash.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

import com.srp.carwash.R;
import com.srp.carwash.data.model.api.ForecastModel;
import com.srp.carwash.data.model.api.MixForecastModel;
import com.srp.carwash.databinding.ListItemForcastBinding;
import com.srp.carwash.databinding.ListItemForcastMixBinding;

public class ForcastsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ObservableList<MixForecastModel> mixed = new ObservableArrayList<>();
    private onMixListener onMixListener;

    public ForcastsAdapter(ObservableList<ForecastModel> data, onMixListener onMixListener) {
        this.onMixListener = onMixListener;
        calculateData(data);
    }

    public void notifyData(ObservableList<ForecastModel> data) {
        calculateData(data);
    }

    private void calculateData(ObservableList<ForecastModel> data) {
        int i;
        for (i = 0; i < data.size(); i++) {
            ForecastModel forecastModel = data.get(i);
            if (forecastModel.getType() == 1) {
                MixForecastModel mixForecastModel1 = new MixForecastModel(forecastModel.getForecastId(), forecastModel.getTotalRatio(), forecastModel.getOfferedPrice(), forecastModel.getCreatedAt(), 1);
                mixForecastModel1.setMatch(forecastModel);
                mixed.add(mixForecastModel1);
            } else {
                MixForecastModel mixForecastModel = new MixForecastModel(forecastModel.getForecastId(), forecastModel.getTotalRatio(), forecastModel.getOfferedPrice(), forecastModel.getCreatedAt(), 2);
                mixForecastModel.setMatch(forecastModel);
                for (int j = i + 1; j < data.size(); j++) {
                    ForecastModel forecastModelNext = data.get(j);
                    if (forecastModelNext.getForecastId() == forecastModel.getForecastId()) {
                        mixForecastModel.setMatch(forecastModelNext);
                        i = i + 1;
                    }
                }
                mixed.add(mixForecastModel);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1:
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
        switch (mixed.get(position).getType()) {
            case 1:
                ViewHolder0 viewHolder0 = (ViewHolder0) holder;
                viewHolder0.binding.setData(mixed.get(position).getMatchList().get(0));
                break;

            case 2:
                ViewHolder1 viewHolder2 = (ViewHolder1) holder;
                viewHolder2.binding.setData(mixed.get(position));
                viewHolder2.binding.setAdapter(this);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mixed.size();
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

    @Override
    public int getItemViewType(int position) {
        return mixed.get(position).getType();
    }

    public void onMixClicked(MixForecastModel model) {
        this.onMixListener.onMix(model);
    }
}