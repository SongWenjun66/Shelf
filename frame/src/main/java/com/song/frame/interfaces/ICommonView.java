package com.song.frame.interfaces;

import com.song.frame.config.ApiConfig;
import com.song.frame.config.RequestConfig;

public interface ICommonView<T> {

    void onSuccess(RequestConfig requestConfig, ApiConfig apiConfig, T t);

    void onError(RequestConfig requestConfig, ApiConfig apiConfig, String e);
}
