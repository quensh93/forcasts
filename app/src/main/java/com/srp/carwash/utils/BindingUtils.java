package com.srp.carwash.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.lukelorusso.verticalseekbar.VerticalSeekBar;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.srp.carwash.BuildConfig;
import com.srp.carwash.R;
import com.srp.carwash.data.remote.ApiEndPoint;
import com.srp.carwash.ui.checkout.CheckoutsAdapter;
import com.srp.carwash.ui.forecasts.ForecastsAdapter;
import com.srp.carwash.ui.home.DatePickerAdapter;
import com.srp.carwash.ui.home.MatchesAdapter;
import com.srp.carwash.ui.increase_credit.VouchersAdapter;
import com.srp.carwash.ui.news.NewsAdapter;
import com.srp.carwash.ui.packages.PackagesAdapter;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(BuildConfig.BASE_URL + "uploads/" + url).into(imageView);
    }

    @BindingAdapter("matchesAdapter")
    public static void setMatchesAdapter(RecyclerView view, MatchesAdapter adapter) {
        view.setAdapter(adapter);
    }

    @BindingAdapter("forecastsAdapter")
    public static void setForecastsAdapter(RecyclerView view, ForecastsAdapter adapter) {
        view.setAdapter(adapter);
    }

    @BindingAdapter("newsAdapter")
    public static void setNewsAdapter(RecyclerView view, NewsAdapter adapter) {
        view.setAdapter(adapter);
    }


    @BindingAdapter("percent")
    public static void setPercent(VerticalSeekBar view, int value) {
        view.setProgress(value);
    }

    @BindingAdapter("dateAdapter")
    public static void setDateAdapter(DiscreteScrollView view, DatePickerAdapter adapter) {
        view.setAdapter(adapter);
        view.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1.05f)
                .setMinScale(0.8f)
                .setPivotX(Pivot.X.CENTER)
                .setPivotY(Pivot.Y.CENTER)
                .build());
        view.scrollToPosition(7);
        view.setOverScrollEnabled(true);
        // view.setSlideOnFling(true);
        view.addOnItemChangedListener((viewHolder, i) -> adapter.setCurrentPosition(i));
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

    @BindingAdapter("vouchersAdapter")
    public static void setVouchersAdapter(RecyclerView view, VouchersAdapter adapter) {
        view.setAdapter(adapter);
    }

    @BindingAdapter("checkoutAdapter")
    public static void setCheckoutAdapter(RecyclerView view, CheckoutsAdapter adapter) {
        view.setAdapter(adapter);
    }

    @BindingAdapter("packagesAdapter")
    public static void setPackagesAdapter(RecyclerView view, PackagesAdapter adapter) {
        view.setAdapter(adapter);
    }

    @BindingAdapter("loadAvatar")
    public static void setLoadAvatar(CircularImageView view, int userId) {
        Log.e("avatar", ApiEndPoint.LOAD_AVATAR + userId + ".jpg");
        Glide
                .with(view.getContext())
                .load(ApiEndPoint.LOAD_AVATAR + userId + ".jpg")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .placeholder(R.drawable.avatar)
                .addListener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Log.e("avatar", "onLoadFailed");
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        Log.e("avatar", "onResourceReady");
                        return false;
                    }
                })
                .into(view);
    }

    @BindingAdapter("thousandSeparator")
    public static void setThousandSeparator(TextView view, String price) {
        if (price == null || price.length() < 4)
            view.setText("0 ریال");
        else
            view.setText(NumberFormat.getNumberInstance(Locale.US).format(Double.valueOf(price)) + " ریال ");
    }

    @BindingAdapter("riskText")
    public static void setRiskText(TextView view, int risk) {
        switch (risk) {
            case 1:
            default:
                view.setText("ریسک : پایین");
                break;
            case 2:
                view.setText("ریسک : متوسط");
                break;
            case 3:
                view.setText("ریسک : بالا");
                break;

        }
    }

    @BindingAdapter("countryIcon")
    public static void setLeagueIcon(ImageView view, String league) {
        if (league == null)
            return;
        switch (league) {
            case "لیگ قهرمانان اروپا":
            default:
                view.setImageResource(R.drawable.denmark);
                break;
            case "انگلیس":
                view.setImageResource(R.drawable.england);
                break;
            case "آلمان":
                view.setImageResource(R.drawable.germany);
                break;
            case "اسپانیا":
                view.setImageResource(R.drawable.spain);
                break;
            case "ایران":
                view.setImageResource(R.drawable.iran);
                break;
            case "ایتالیا":
                view.setImageResource(R.drawable.italy);
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

    @BindingAdapter("splashFont")
    public static void setSplashFont(TextView view, boolean enable) {
        view.setTypeface(Typeface.createFromAsset(view.getContext().getAssets(), "firstblood.ttf"));
    }

    @BindingAdapter("forecastTimer")
    public static void setForecastAdapter(TextView view, String startTime) {
        timer(view, startTime);
    }

    private static void timer(TextView view, String startTime) {
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
