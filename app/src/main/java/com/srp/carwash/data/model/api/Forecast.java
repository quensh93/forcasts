package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {

    @Expose
    @SerializedName("forecastId")
    private int forecastId;

    @Expose
    @SerializedName("totalRatio")
    private float totalRatio;

    @Expose
    @SerializedName("sportId")
    private int sportId;

    @Expose
    @SerializedName("country")
    private String country;

    @Expose
    @SerializedName("league")
    private String league;

    @Expose
    @SerializedName("type")
    private int type;

    @Expose
    @SerializedName("risk")
    private int risk;

    @Expose
    @SerializedName("ratio")
    private float ratio;

    @Expose
    @SerializedName("team1")
    private String team1;

    @Expose
    @SerializedName("team2")
    private String team2;

    @Expose
    @SerializedName("forecast")
    private String forecast;

    @Expose
    @SerializedName("offeredPrice")
    private String offeredPrice;

    @Expose
    @SerializedName("image")
    private String image;

    @Expose
    @SerializedName("startTime")
    private String startTime;

    @Expose
    @SerializedName("startDate")
    private String startDate;

    @Expose
    @SerializedName("numberOfSell")
    private int numberOfSell;

    public Forecast(){

    }

}
