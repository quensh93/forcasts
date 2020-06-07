package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    @Expose
    @SerializedName("mobile")
    private String mobile;

    public LoginRequest(String mobile) {
        this.mobile = mobile;
    }
}
