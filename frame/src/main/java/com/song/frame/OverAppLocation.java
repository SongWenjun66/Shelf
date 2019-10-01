package com.song.frame;

import android.app.Application;
import android.content.Context;

import androidx.annotation.AnimRes;
import androidx.annotation.DrawableRes;

import com.song.frame.interfaces.OnParInterfices;

public class OverAppLocation extends Application {

    private static OverAppLocation overAppLocation;
    public static OnParInterfices onParInterfices;
    public Context context;
    private static int startActivity = -1;
    private static int endActivity = -1;
    private static String BASE_URL = "http://www.songwenjun.top";

    public static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static int getStartActivity() {
        return startActivity;
    }

    public static void setStartActivity(@AnimRes int startActivity) {
        OverAppLocation.startActivity = startActivity;
    }

    public static int getEndActivity() {
        return endActivity;
    }

    public static void setEndActivity(@AnimRes int endActivity) {
        OverAppLocation.endActivity = endActivity;
    }

    public static void setOnParInterfices(OnParInterfices onParInterfices) {
        OverAppLocation.onParInterfices = onParInterfices;
    }

    public static OverAppLocation getOverAppLocation() {
        return overAppLocation;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        overAppLocation = this;
    }
}
