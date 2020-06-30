package com.srp.carwash.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableInt;
import androidx.recyclerview.widget.RecyclerView;

import com.srp.carwash.R;
import com.srp.carwash.databinding.ListItemDateBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import ir.huri.jcal.JalaliCalendar;

public class DatePickerAdapter extends RecyclerView.Adapter<DatePickerAdapter.ViewHolder> {

    public ObservableInt currentPosition = new ObservableInt(0);
    private OnDateChange onDateChange;
    private ArrayList<String> days = new ArrayList<>();
    private ArrayList<String> month = new ArrayList<>();
    private ArrayList<String> monthInt = new ArrayList<>();

    public DatePickerAdapter(OnDateChange onDateChange) {
        this.onDateChange = onDateChange;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -8);
        for (int i = -7; i < 7; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            JalaliCalendar jalaliDate = new JalaliCalendar(new GregorianCalendar(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)));
            days.add("" + jalaliDate.getDay());
            month.add(jalaliDate.getMonthString());
            monthInt.add("" + jalaliDate.getMonth());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemDateBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.list_item_date, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder h, final int position) {
        h.binding.setAdapter(this);
        h.binding.setDay(days.get(position));
        h.binding.setMonth(month.get(position));
        h.binding.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public void setCurrentPosition(int pos) {
        this.currentPosition.set(pos);
        onDateChange.onDateChange(days.get(pos), monthInt.get(pos));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ListItemDateBinding binding;

        public ViewHolder(ListItemDateBinding listItemCardsMeBinding) {
            super(listItemCardsMeBinding.getRoot());
            binding = listItemCardsMeBinding;
        }
    }

}