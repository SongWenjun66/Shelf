package com.song.frame.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import com.song.frame.OverAppLocation;

public class ToastUtil {
    private static Toast mToast;

    public static void show(String str) {
        try {
            if (mToast == null) {
                mToast = Toast.makeText(OverAppLocation.getOverAppLocation(), str, Toast.LENGTH_SHORT);
            }
            if (!TextUtil.isEmpty(str)) {
                mToast.setText(str);
                mToast.setGravity(Gravity.CENTER, 0, 0);
                mToast.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void show(Context context, String str) {
        try {
            if (mToast == null) {
                mToast = Toast.makeText(context, str, Toast.LENGTH_SHORT);
            }
            if (!TextUtil.isEmpty(str)) {
                mToast.setText(str);
                mToast.setGravity(Gravity.CENTER, 0, 0);
                mToast.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void show(int resId) {
        show(OverAppLocation.getOverAppLocation().getString(resId));
    }

    public static void cancel() {
        if (null != mToast) {
            mToast.cancel();
        }
    }

    public static void showerr() {
        show("网络异常");
    }

    public static void Showtoamsg(Context context, String msg) {
        try {
            Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
