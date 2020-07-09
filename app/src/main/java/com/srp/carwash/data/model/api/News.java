package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.GregorianCalendar;

import ir.huri.jcal.JalaliCalendar;

public class News {


    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("matchId")
    private int matchId;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("summary")
    private String summary;

    @Expose
    @SerializedName("description")
    private String description;

    @Expose
    @SerializedName("nView")
    private int nView;

    @Expose
    @SerializedName("createdAt")
    private String createdAt;

    public News() {

    }

    public int getId() {
        return id;
    }

    public String getCreatedAt() {
        String[] split = createdAt.split("\\s+")[0].split("-");
        JalaliCalendar jalaliDate = new JalaliCalendar(new GregorianCalendar(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
        return jalaliDate.getDayOfWeekDayMonthString();
    }

    public int getMatchId() {
        return matchId;
    }

    public int getView() {
        return nView;
    }

    public String getDescription() {
        return description;
    }

    public String getSummary() {
        return summary;
    }

    public String getTitle() {
        return title;
    }
}
