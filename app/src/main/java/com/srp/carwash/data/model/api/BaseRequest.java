package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseRequest {

    @Expose
    @SerializedName("uid")
    private int uid;

    public BaseRequest(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }
}
