/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.srp.carwash.utils;

import android.content.Context;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.srp.carwash.R;
import com.srp.carwash.data.model.api.ForecastModel;
import com.srp.carwash.ui.home.ForcastsAdapter;

import java.util.Calendar;

/**
 * Created by amitshekhar on 11/07/17.
 */

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }



    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }



    @BindingAdapter("openEmail")
    public static void setOpenEmail(View view, boolean isEnable) {
        view.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            emailIntent.setType("vnd.android.cursor.item/email");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"sajadrahmanipour@gmail.com"});
            view.getContext().startActivity(Intent.createChooser(emailIntent, "ارسال ایمیل"));
        });
    }

    @BindingAdapter("openDialer")
    public static void setOpenDialer(View view, boolean isEnable) {
        view.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:09199315027"));
            view.getContext().startActivity(intent);
        });
    }

    @BindingAdapter("openTelegram")
    public static void setOpenTelegram(View view, boolean isEnable) {
        view.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://telegram.me/sajadrahmanipour"));
                intent.setPackage("org.telegram.messenger");
                view.getContext().startActivity(intent);
            } catch (android.content.ActivityNotFoundException anfe) {
                Toast.makeText(view.getContext(), "تلگرام بر روی تلفن همراه شما نصب نمی باشد.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @BindingAdapter("forecastAdapter")
    public static void setForecastAdapter(RecyclerView view, ForcastsAdapter adapter) {
        view.setAdapter(adapter);
    }

    @BindingAdapter("leagueIcon")
    public static void setLeagueIcon(ImageView view, String league) {
        switch (league){
            case "لیگ قهرمانان اروپا":
            default:
                view.setImageResource(R.drawable.denmark);
                break;
            case "لیگ برتر انگلیس":
                view.setImageResource(R.drawable.england);
                break;
            case "بوندس لیگا":
                view.setImageResource(R.drawable.germany);
                break;
            case "لالیگا":
                view.setImageResource(R.drawable.spain);
                break;
        }
    }

    @BindingAdapter("sportIcon")
    public static void setSportIcon(ImageView view, int sportId) {
        switch (sportId){
            case 1:
            default:
                view.setImageResource(R.drawable.ic_football);
                break;
            case 2:
                view.setImageResource(R.drawable.ic_volleyball);
                break;
            case 3:
                view.setImageResource(R.drawable.ic_basketball_ball);
                break;
            case 4:
                view.setImageResource(R.drawable.ic_ice_hockey);
                break;
        }
    }

    @BindingAdapter("today")
    public static void setToday(TextView view, boolean enable) {
        view.setText("");
    }

    @BindingAdapter("forecastTimer")
    public static void setForecastAdapter(TextView view, String startTime) {
        timer(view,startTime);
    }

    private static void timer(TextView view, String startTime){
        //bug dare
        new Handler().postDelayed(() -> {
            Calendar calendar = Calendar.getInstance();
            int currentHours = calendar.get(Calendar.HOUR_OF_DAY);
            int currentMinute = calendar.get(Calendar.MINUTE);
            int currentSecond = calendar.get(Calendar.SECOND);
            int startHours = Integer.parseInt(startTime.split(":")[0]);
            int startMinute = Integer.parseInt(startTime.split(":")[1]);
            if (startHours >= currentHours){
                if (startMinute > currentMinute){
                    view.setText((startHours-currentHours) +":"+(startMinute-currentMinute)+":"+(60-currentSecond));
                }else {
                    if ((startHours - currentHours)==1){
                        view.setText(00 +":"+(startMinute+(60-currentMinute))+":"+(60-currentSecond));
                    }else{
                        view.setText((startHours-currentHours) +":"+(startMinute+(60-currentMinute))+":"+(60-currentSecond));
                    }
                }
                timer(view,startTime);
            }
        },1000);
    }
}
