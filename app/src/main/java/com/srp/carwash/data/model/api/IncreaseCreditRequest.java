package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IncreaseCreditRequest {

    @Expose
    @SerializedName("uid")
    private int uid;

    @Expose
    @SerializedName("voucher")
    private String voucher;

    public IncreaseCreditRequest(int uid, String voucher) {
        this.uid = uid;
        this.voucher = voucher;
    }
}
