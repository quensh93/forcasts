package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

public class User extends SugarRecord {

    @Expose
    @SerializedName("uid")
    private int uid;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("mobile")
    private String mobile;

    @Expose
    @SerializedName("credit")
    private int credit;

    @Expose
    @SerializedName("gender")
    private int gender;

    @Expose
    @SerializedName("registeredAt")
    private String registeredAt;

    public User() {

    }

    public int getCredit() {
        return credit;
    }

    public int getGender() {
        return gender;
    }

    public int getUid() {
        return uid;
    }

    public String getMobile() {
        return mobile;
    }

    public String getName() {
        return name;
    }

    public String getRegisteredAt() {
        return registeredAt;
    }

}
