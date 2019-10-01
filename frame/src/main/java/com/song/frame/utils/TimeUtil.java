package com.song.frame.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 包名： com.example.yxw.fuelgasproect.utils
 * 项目名称： TimeUtil
 * 时间： 2019-08-28 14:22
 * 作者： SongWenjun
 */
public class TimeUtil {
    public static String getStandardDate(String timeStr) {
        StringBuffer sb = new StringBuffer();
        long t = Long.parseLong(timeStr);
        long time = System.currentTimeMillis() - (t * 1000);
        long mill = (long) Math.ceil(time / 1000);//秒前
        long minute = (long) Math.ceil(time / 60 / 1000.0f);// 分钟前
        long hour = (long) Math.ceil(time / 60 / 60 / 1000.0f);// 小时
        long day = (long) Math.ceil(time / 24 / 60 / 60 / 1000.0f);// 天前
        if (day - 1 > 0) {
            sb.append(day + "天");
        } else if (hour - 1 > 0) {
            if (hour >= 24) {
                sb.append("1天");
            } else {
                sb.append(hour + "小时");
            }
        } else if (minute - 1 > 0) {
            if (minute == 60) {
                sb.append("1小时");
            } else {
                sb.append(minute + "分钟");
            }
        } else if (mill - 1 > 0) {
            if (mill == 60) {
                sb.append("1分钟");
            } else {
                sb.append(mill + "秒");
            }
        } else {
            sb.append("刚刚");
        }
        if (!sb.toString().equals("刚刚")) {
            sb.append("前");
        }
        return sb.toString();
    }

    public static String getCurrentTime() {
        //获取时间戳
        long timeStamp = System.currentTimeMillis();
        return String.valueOf(timeStamp);
    }

    /**
     * 返回date对象实例
     *
     * @param time 传入当前毫秒值
     * @return
     */
    public static Date getData(long time) {
        return new Date(time);
    }

    /**
     * 毫秒转化成秒
     *
     * @param time
     * @return
     */
    public static int milli2sccond(long time) {
        return new Date(time).getSeconds();
    }

    public static String getStringTime(String timeStr) {
        Long timetamp = Long.parseLong(timeStr) * 1000;
        return new SimpleDateFormat("yyyy-MM-dd    HH:mm").format(new Date(timetamp));
    }
}
