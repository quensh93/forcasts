package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SportsModel {

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("nameFa")
    private String nameFa;

    @Expose
    @SerializedName("nameEn")
    private String nameEn;

    @Expose
    @SerializedName("image")
    private String image;

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getNameFa() {
        return nameFa;
    }

}
