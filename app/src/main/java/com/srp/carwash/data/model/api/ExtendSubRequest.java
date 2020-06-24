package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtendSubRequest {

    @Expose
    @SerializedName("uid")
    private String uid;

    @Expose
    @SerializedName("pid")
    private String pid;

    public ExtendSubRequest(String uid, String pid) {
        this.uid = uid;
        this.pid = pid;
    }
}
