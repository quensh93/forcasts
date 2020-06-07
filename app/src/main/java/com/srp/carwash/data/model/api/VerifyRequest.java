package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyRequest {

    @Expose
    @SerializedName("mobile")
    private String mobile;

    @Expose
    @SerializedName("code")
    private String code;

    public VerifyRequest(String mobile, String code) {
        this.mobile = mobile;
        this.code = code;
    }
}
