package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.GregorianCalendar;

import ir.huri.jcal.JalaliCalendar;

public class CheckoutModel {

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("price")
    private String price;

    @Expose
    @SerializedName("voucher")
    private String voucher;

    @Expose
    @SerializedName("deliveredAt")
    private String deliveredAt;

    @Expose
    @SerializedName("createdAt")
    private String createdAt;

    public CheckoutModel() {

    }

    public int getId() {
        return id;
    }

    public String getVoucher() {
        return voucher.length() > 0 ? voucher : "در حال بررسی";
    }

    public boolean getStatus() {
        return voucher != null && voucher.length() > 5;
    }

    public String getPrice() {
        return price;
    }

    public String getCreatedAt() {
        String[] split = createdAt.split("\\s+")[0].split("-");
        JalaliCalendar jalaliDate = new JalaliCalendar(new GregorianCalendar(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
        return jalaliDate.getDayOfWeekDayMonthString();
//        return jalaliDate.getYear()
//                +"-"
//                +(jalaliDate.getMonth() < 10 ? "0"+jalaliDate.getMonth() : jalaliDate.getMonth())
//                +"-"
//        +(jalaliDate.getDay() < 10 ? "0"+jalaliDate.getDay() : jalaliDate.getDay());
    }

    public String getDeliveredAt() {
        return deliveredAt;
    }

}
