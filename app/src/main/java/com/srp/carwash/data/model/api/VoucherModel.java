package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VoucherModel {

    @Expose
    @SerializedName("voucher")
    private String voucher;

    @Expose
    @SerializedName("price")
    private String price;

    @Expose
    @SerializedName("status")
    private int status;

    @Expose
    @SerializedName("createdAt")
    private String createdAt;

    public VoucherModel() {

    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getPrice() {
        return price;
    }

    public int getStatus() {
        return status;
    }

    public String getVoucher() {
        return voucher;
    }

}
