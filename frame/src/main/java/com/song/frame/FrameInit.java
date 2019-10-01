package com.song.frame;

import android.app.Application;

import com.song.frame.config.NetConfig;
import com.song.frame.interfaces.BaseUrl;

import java.lang.reflect.Field;

/**
 * SongWenjun
 * Created by dell
 * on 2019/10/1
 * The package is com.song.frame
 * This Class is ...
 */
public class FrameInit {

    private static String baseUrl;

    public static void initBaseUrl(OverAppLocation application) throws NoSuchFieldException, IllegalAccessException {
        Class<? extends OverAppLocation> aClass = application.getClass();
        Class<NetConfig> netConfigClass = NetConfig.class;
        if (aClass.isAnnotationPresent(BaseUrl.class)) {
            BaseUrl annotation = aClass.getAnnotation(BaseUrl.class);
            baseUrl = annotation.value();
        }
        Field base_url = netConfigClass.getField("BASE_URL");
        base_url.set(netConfigClass, baseUrl);
    }
}
