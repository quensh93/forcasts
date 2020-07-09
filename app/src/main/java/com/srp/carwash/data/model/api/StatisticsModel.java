package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatisticsModel {

    @Expose
    @SerializedName("total")
    private int total;

    @Expose
    @SerializedName("win")
    private int win;

    @Expose
    @SerializedName("loose")
    private int loose;

    @Expose
    @SerializedName("revoc")
    private int revoc;

    @Expose
    @SerializedName("pend")
    private int pend;

    public int getLoose() {
        return loose;
    }

    public int getLoosePercent() {
        if (loose == 0)
            return 0;
        return Math.round(((float) (loose * 100 / total)));
    }

    public int getPend() {
        return pend;
    }

    public int getPendPercent() {
        if (pend == 0)
            return 0;
        return Math.round(((float) (pend * 100 / total)));
    }

    public int getRevoc() {
        return revoc;
    }

    public int getRevocPercent() {
        if (revoc == 0)
            return 0;
        return Math.round(((float) (revoc * 100 / total)));
    }

    public int getTotal() {
        return total;
    }

    public int getWin() {
        return win;
    }

    public int getWinPercent() {
        if (win == 0)
            return 0;
        return Math.round(((float) (win * 100 / total)));
    }
}
