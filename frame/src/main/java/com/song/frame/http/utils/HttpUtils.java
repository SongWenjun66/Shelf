package com.song.frame.http.utils;

import com.google.gson.Gson;
import com.song.frame.config.ApiConfig;
import com.song.frame.config.RequestConfig;
import com.song.frame.interfaces.ICommonView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Song Wenjun
 * Created by dell on 2019/2/23 11:10
 * Created prepare
 * package is com.example.frame.http.utils
 * <p>
 * This class is used to do:
 */
public class HttpUtils {
    public static <T, C> void getRespone(Observable<T> observable, final ICommonView presenter, final RequestConfig refreshConfig, final ApiConfig apiConfig, final Object... o) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver() {
                    @Override
                    public void onBaseNext(Object value) {
                        if (o[0] != null && o[0] instanceof Class) {
                            Class<C> c = (Class<C>) o[0];
                            C c1 = new Gson().fromJson(String.valueOf(value), c);
                            presenter.onSuccess(refreshConfig, apiConfig, c1);
                        } else {
                            presenter.onSuccess(refreshConfig, apiConfig, value);
                        }
                    }

                    @Override
                    public void onBaseError(Throwable e) {
                        presenter.onError(refreshConfig, apiConfig, e.getMessage());
                    }
                });
    }
}
