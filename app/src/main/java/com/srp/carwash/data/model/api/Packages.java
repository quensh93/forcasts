package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Packages {

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("period")
    private int period;

    @Expose
    @SerializedName("price")
    private int price;

    @Expose
    @SerializedName("discount")
    private int discount;

    public Packages() {

    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }

    public int getId() {
        return id;
    }

    public int getPeriod() {
        return period;
    }

    public int getPrice() {
        return price;
    }
}
