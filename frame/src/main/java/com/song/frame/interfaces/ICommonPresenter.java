package com.song.frame.interfaces;

import com.song.frame.config.ApiConfig;
import com.song.frame.config.RequestConfig;

/**
 * SongWenjun
 * Created by dell
 * on 2019/10/1
 * The package is com.song.frame.interfaces
 * This Class is ...
 */
public interface ICommonPresenter<T> {
    /**
     * 这个是m层和v层之间的万能接口,主要用来连接module和view
     *
     * @param refreshConfig
     * @param apiConfig
     * @param t
     */
    void universalNode(RequestConfig refreshConfig, ApiConfig apiConfig, T... t);
}
