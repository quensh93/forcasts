package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamsModel {

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
    private int countryId;

    @Expose
    @SerializedName("sportId")
    private int sportId;

    @Expose
    @SerializedName("leagueId")
    private int leagueId;

    @Expose
    @SerializedName("establishment")
    private String establishment;

    @Expose
    @SerializedName("stadiumFa")
    private String stadiumFa;

    @Expose
    @SerializedName("stadiumEn")
    private String stadiumEn;

    @Expose
    @SerializedName("coachFa")
    private String coachFa;

    @Expose
    @SerializedName("coachEn")
    private String coachEn;

    @Expose
    @SerializedName("gender")
    private int gender;

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

    public int getGender() {
        return gender;
    }

    public int getCountryId() {
        return countryId;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public String getCoachEn() {
        return coachEn;
    }

    public String getCoachFa() {
        return coachFa;
    }

    public String getEstablishment() {
        return establishment;
    }

    public String getStadiumEn() {
        return stadiumEn;
    }

    public String getStadiumFa() {
        return stadiumFa;
    }
}
