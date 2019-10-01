package com.song.frame.interfaces;

import com.song.frame.config.ApiConfig;
import com.song.frame.config.RequestConfig;

/**
 * Song Wenjun
 * Created by dell on 2019/2/23 10:37
 * Created prepare
 * package is com.example.frame
 * <p>
 * This class is used to do:
 */
public interface ICommonModule<T> {
    /**
     * 进行普通的get请求
     *
     * @param presenter     传入一个p层实现类
     * @param refreshConfig 传入正常请求还是刷新
     * @param apiConfig     传入第几次请求这个网络
     * @param t             传入其他参数，可变参
     */
    void getData(ICommonView presenter, RequestConfig refreshConfig, ApiConfig apiConfig, T... t);

    /**
     * 进行普通的post请求
     *
     * @param presenter 传入p层实现类
     * @param apiConfig 传入第几次请求
     * @param t
     */
    void postData(ICommonView presenter, RequestConfig refreshConfig, ApiConfig apiConfig, T... t);

    /**
     * 进行from请求
     *
     * @param presenter
     * @param apiConfig
     * @param t
     */
    void fromData(ICommonView presenter, RequestConfig refreshConfig, ApiConfig apiConfig, T... t);

    /**
     * 进行文件提交请求
     *
     * @param presenter
     * @param t
     */
    void fileCommit(ICommonView presenter, RequestConfig refreshConfig, ApiConfig apiConfig, T... t);

    /**
     * json提交的请求
     *
     * @param presenter
     * @param json
     * @param apiConfig
     * @param t
     */
    void jsonData(ICommonView presenter, String json, RequestConfig refreshConfig, ApiConfig apiConfig, T... t);
}
