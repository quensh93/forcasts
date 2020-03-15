package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyOrder {


    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("forcastId")
    private int forcastId;

    @Expose
    @SerializedName("buyAt")
    private String buyAt;

    public MyOrder(){

    }

    public String getBuyAt() {
        return buyAt;
    }

    public int getForcastId() {
        return forcastId;
    }

    public int getId() {
        return id;
    }
}
