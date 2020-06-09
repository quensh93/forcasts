package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactUsRequest {

    @Expose
    @SerializedName("uid")
    private int uid;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("description")
    private String description;

    public ContactUsRequest(int uid, String title, String description) {
        this.uid = uid;
        this.title = title;
        this.description = description;
    }
}
