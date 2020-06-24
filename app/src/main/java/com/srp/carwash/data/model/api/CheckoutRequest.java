package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckoutRequest {

    @Expose
    @SerializedName("uid")
    private int uid;

    @Expose
    @SerializedName("price")
    private String price;

    public CheckoutRequest(int uid, String price) {
        this.uid = uid;
        this.price = price;
    }
}
