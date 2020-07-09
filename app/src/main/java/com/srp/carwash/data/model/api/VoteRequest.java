package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VoteRequest {

    @Expose
    @SerializedName("type")
    private int type;

    @Expose
    @SerializedName("id")
    private int id;

    public VoteRequest(int type, int id) {
        this.type = type;
        this.id = id;
    }
}
