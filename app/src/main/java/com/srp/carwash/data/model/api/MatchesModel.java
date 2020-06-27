package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchesModel {

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("startDate")
    private String startDate;

    @Expose
    @SerializedName("startTime")
    private String startTime;

    @Expose
    @SerializedName("homeScore")
    private int homeScore;

    @Expose
    @SerializedName("awayScore")
    private int awayScore;

    @Expose
    @SerializedName("status")
    private int status;

    @Expose
    @SerializedName("createdAt")
    private String createdAt;

    @Expose
    @SerializedName("country")
    private CountryModel country;

    @Expose
    @SerializedName("sport")
    private SportsModel sport;

    @Expose
    @SerializedName("league")
    private LeaguesModel league;

    @Expose
    @SerializedName("home")
    private TeamsModel home;

    @Expose
    @SerializedName("away")
    private TeamsModel away;

    public int getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public CountryModel getCountry() {
        return country;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getStatus() {
        return status;
    }

    public LeaguesModel getLeague() {
        return league;
    }

    public SportsModel getSport() {
        return sport;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public TeamsModel getAway() {
        return away;
    }

    public TeamsModel getHome() {
        return home;
    }
}
