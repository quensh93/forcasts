package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompositionModel {

    @Expose
    @SerializedName("matchId")
    private int matchId;

    @Expose
    @SerializedName("team1")
    private String team1;

    @Expose
    @SerializedName("team2")
    private String team2;

    @Expose
    @SerializedName("createdAt")
    private String createdAt;

    public int getMatchId() {
        return matchId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

}
