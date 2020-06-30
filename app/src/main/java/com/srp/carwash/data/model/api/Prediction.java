package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Prediction {

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("titleFa")
    private String titleFa;

    @Expose
    @SerializedName("titleEn")
    private String titleEn;

    @Expose
    @SerializedName("createdAt")
    private String createdAt;

    public String getCreatedAt() {
        return createdAt;
    }

    public int getId() {
        return id;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public String getTitleFa() {
        return titleFa;
    }
}
