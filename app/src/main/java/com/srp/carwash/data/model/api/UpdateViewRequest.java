package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateViewRequest {

    @Expose
    @SerializedName("newsId")
    private int newsId;

    public UpdateViewRequest(int newsId) {
        this.newsId = newsId;
    }
}
