package com.song.frame.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.song.frame.OverAppLocation;


/**
 * Created by  SongWenjun on 2018/2/1.
 */

public class OpactivityUtils {
    public static void openActivity(Activity context, Class<?> pClass, Bundle pBundle, Uri uri) {
        Intent intent = new Intent(context, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        if (uri != null) {
            intent.setData(uri);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (OverAppLocation.getStartActivity() != -1) {
            context.overridePendingTransition(OverAppLocation.getStartActivity(), 0);
        }

        context.startActivity(intent);
    }

    public static void openActivity(Activity context, Class<?> pClass, Bundle pBundle) {
        openActivity(context, pClass, pBundle, null);
    }

    public static void openActivity(Activity context, Class<?> pClass) {
        openActivity(context, pClass, null, null);
    }

    public static void startBrod(String str) {
        Intent intent = new Intent();
        intent.setAction(str);
        OverAppLocation.getOverAppLocation().sendBroadcast(intent);
    }

    public static void startBrod(String str, Bundle pBundle) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtras(pBundle);
        OverAppLocation.getOverAppLocation().sendBroadcast(intent);
    }

    /**
     * 获取当前程序中的本地目标
     *
     * @param localIntent
     * @return
     */
    public static Intent getLocalIntent(Context context, Class<? extends Context> localIntent, Bundle bd) {
        Intent intent = new Intent(context, localIntent);
        if (null != bd) {
            intent.putExtras(bd);
        }

        return intent;
    }

    /**
     * 以绑定参数参数并返回数据的模式启动Activity
     *
     * @param activityClass
     */
    public static void startActivityBack(Context context, Class<? extends Activity> activityClass, Bundle bd, int code) {
        ((Activity) context).startActivityForResult(getLocalIntent(context, activityClass, bd), code);
    }

    /**
     * 返回数据的模式启动Activity
     *
     * @param activityClass
     */
    public static void startActivityBack(Context context, Class<? extends Activity> activityClass, int code) {
        ((Activity) context).startActivityForResult(getLocalIntent(context, activityClass, null), code);
    }

    public void startBrod(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction(str);
        context.sendBroadcast(intent);
    }

}
