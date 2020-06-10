package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MixForecastModel {

    @Expose
    @SerializedName("forecastId")
    private int forecastId;

    @Expose
    @SerializedName("type")
    private int type;

    @Expose
    @SerializedName("totalRatio")
    private float totalRatio;

    @Expose
    @SerializedName("offeredPrice")
    private String offeredPrice;

    @Expose
    @SerializedName("createdAt")
    private String createdAt;

    @Expose
    @SerializedName("matchList")
    private ArrayList<ForecastModel> matchList = new ArrayList<>();

    public MixForecastModel(int forecastId, float totalRatio, String offeredPrice, String createdAt, int type) {
        this.forecastId = forecastId;
        this.totalRatio = totalRatio;
        this.offeredPrice = offeredPrice;
        this.createdAt = createdAt;
        this.type = type;
    }

    public float getTotalRatio() {
        return totalRatio;
    }

    public int getForecastId() {
        return forecastId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getOfferedPrice() {
        return offeredPrice;
    }

    public ArrayList<ForecastModel> getMatchList() {
        return matchList;
    }

    public void setMatch(ForecastModel match) {
        this.matchList.add(match);
    }

    public int getType() {
        return type;
    }
}
