package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeaguesModel {

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

    @Expose
    @SerializedName("countryId")
    private String countryId;

    @Expose
    @SerializedName("sportId")
    private int sportId;

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

    public int getSportId() {
        return sportId;
    }

    public String getCountryId() {
        return countryId;
    }

}
