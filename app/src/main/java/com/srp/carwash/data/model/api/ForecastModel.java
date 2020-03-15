package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForecastModel {

    @Expose
    @SerializedName("id")
    private int id;

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
    @SerializedName("Risk")
    private int Risk;

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
    private String  offeredPrice;

    @Expose
    @SerializedName("sellPrice")
    private String  sellPrice;

    @Expose
    @SerializedName("startTime")
    private String startTime;

    @Expose
    @SerializedName("startDate")
    private String startDate;

    @Expose
    @SerializedName("numberOfSell")
    private int numberOfSell;

    @Expose
    @SerializedName("status")
    private int status;

    @Expose
    @SerializedName("bought")
    private boolean bought;

    @Expose
    @SerializedName("createdAt")
    private String createdAt;

    public ForecastModel(){

    }

    public float getRatio() {
        return ratio;
    }

    public float getTotalRatio() {
        return totalRatio;
    }

    public int getForecastId() {
        return forecastId;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfSell() {
        return numberOfSell;
    }

    public int getRisk() {
        return Risk;
    }

    public int getSportId() {
        return sportId;
    }

    public int getStatus() {
        return status;
    }

    public int getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getForecast() {
        return forecast;
    }

    public String getLeague() {
        return league;
    }

    public String getOfferedPrice() {
        return offeredPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    public boolean isBought() {
        return bought;
    }
}
