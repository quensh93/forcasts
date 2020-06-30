package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForecastModel {

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("ratio")
    private float ratio;

    @Expose
    @SerializedName("offeredPrice")
    private String offeredPrice;

    @Expose
    @SerializedName("combinationsId")
    private int combinationsId;

    @Expose
    @SerializedName("agree")
    private int agree;

    @Expose
    @SerializedName("disagree")
    private int disagree;

    @Expose
    @SerializedName("status")
    private int status;

    @Expose
    @SerializedName("prediction")
    private Prediction prediction;

    public int getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public float getRatio() {
        return ratio;
    }

    public int getAgree() {
        return agree;
    }

    public int getCombinationsId() {
        return combinationsId;
    }

    public int getDisagree() {
        return disagree;
    }

    public Prediction getPrediction() {
        return prediction;
    }

    public String getOfferedPrice() {
        return offeredPrice;
    }

}
