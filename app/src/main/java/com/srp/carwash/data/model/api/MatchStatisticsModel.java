package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchStatisticsModel {

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("matchId")
    private int matchId;

    @Expose
    @SerializedName("shots")
    private String shots;

    @Expose
    @SerializedName("shotsOnGoal")
    private String shotsOnGoal;

    @Expose
    @SerializedName("fouls")
    private String fouls;

    @Expose
    @SerializedName("corner")
    private String corner;

    @Expose
    @SerializedName("offsides")
    private String offsides;

    @Expose
    @SerializedName("yellowCards")
    private String yellowCards;

    @Expose
    @SerializedName("redCards")
    private String redCards;

    @Expose
    @SerializedName("dangerousAttacks")
    private String dangerousAttacks;

    @Expose
    @SerializedName("possession")
    private String possession;

    @Expose
    @SerializedName("createdAt")
    private String createdAt;

    public String getCreatedAt() {
        return createdAt;
    }

    public int getMatchId() {
        return matchId;
    }

    public int getId() {
        return id;
    }

    public int getCornerHome() {
        return getHomeValue(corner);
    }

    public int getCornerAway() {
        return getAwayValue(corner);
    }

    public String getCornerHomeString() {
        return getHomeValueString(corner);
    }

    public String getCornerAwayString() {
        return getAwayValueString(corner);
    }

    public int getDangerousAttacksHome() {
        return getHomeValue(dangerousAttacks);
    }

    public int getDangerousAttacksAway() {
        return getAwayValue(dangerousAttacks);
    }

    public String getDangerousAttacksHomeString() {
        return getHomeValueString(dangerousAttacks);
    }

    public String getDangerousAttacksAwayString() {
        return getAwayValueString(dangerousAttacks);
    }

    public int getFoulsHome() {
        return getHomeValue(fouls);
    }

    public int getFoulsAway() {
        return getAwayValue(fouls);
    }

    public String getFoulsHomeString() {
        return getHomeValueString(fouls);
    }

    public String getFoulsAwayString() {
        return getAwayValueString(fouls);
    }

    public int getOffsidesHome() {
        return getHomeValue(offsides);
    }

    public int getOffsidesAway() {
        return getAwayValue(offsides);
    }

    public String getOffsidesHomeString() {
        return getHomeValueString(offsides);
    }

    public String getOffsidesAwayString() {
        return getAwayValueString(offsides);
    }

    public int getPossessionHome() {
        return getHomeValue(possession);
    }

    public int getPossessionAway() {
        return getAwayValue(possession);
    }

    public String getPossessionHomeString() {
        return getHomeValueString(possession);
    }

    public String getPossessionAwayString() {
        return getAwayValueString(possession);
    }

    public int getRedCardsHome() {
        return getHomeValue(redCards);
    }

    public int getRedCardsAway() {
        return getAwayValue(redCards);
    }

    public String getRedCardsHomeString() {
        return getHomeValueString(redCards);
    }

    public String getRedCardsAwayString() {
        return getAwayValueString(redCards);
    }

    public int getShotsHome() {
        return getHomeValue(shots);
    }

    public int getShotsAway() {
        return getAwayValue(shots);
    }

    public String getShotsHomeString() {
        return getHomeValueString(shots);
    }

    public String getShotsAwayString() {
        return getAwayValueString(shots);
    }

    public int getShotsOnGoalHome() {
        return getHomeValue(shotsOnGoal);
    }

    public int getShotsOnGoalAway() {
        return getAwayValue(shotsOnGoal);
    }

    public String getShotsOnGoalHomeString() {
        return getHomeValueString(shotsOnGoal);
    }

    public String getShotsOnGoalAwayString() {
        return getAwayValueString(shotsOnGoal);
    }

    public int getYellowCardsHome() {
        return getHomeValue(yellowCards);
    }

    public int getYellowCardsAway() {
        return getAwayValue(yellowCards);
    }

    public String getYellowCardsHomeString() {
        return getHomeValueString(yellowCards);
    }

    public String getYellowCardsAwayString() {
        return getAwayValueString(yellowCards);
    }

    public int getHomeValue(String key) {
        if (Integer.parseInt(key.split("/")[0]) == 0)
            return 0;
        return (Integer.parseInt(key.split("/")[0]) * 100) / (Integer.parseInt(key.split("/")[0]) + Integer.parseInt(key.split("/")[1]));
    }

    public int getAwayValue(String key) {
        if (Integer.parseInt(key.split("/")[1]) == 0)
            return 0;
        return (Integer.parseInt(key.split("/")[1]) * 100) / (Integer.parseInt(key.split("/")[0]) + Integer.parseInt(key.split("/")[1]));
    }

    public String getHomeValueString(String key) {
        return key.split("/")[0];
    }

    public String getAwayValueString(String key) {
        return key.split("/")[1];
    }

}
