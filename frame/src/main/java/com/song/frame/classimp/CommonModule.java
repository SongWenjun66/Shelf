package com.song.frame.classimp;

import com.song.frame.OverAppLocation;
import com.song.frame.config.ApiConfig;
import com.song.frame.config.RequestConfig;
import com.song.frame.http.utils.HttpUtils;
import com.song.frame.http.utils.RetrofitManager;
import com.song.frame.interfaces.ICommonModule;
import com.song.frame.interfaces.ICommonView;
import com.song.frame.interfaces.INetService;
import com.song.frame.interfaces.OnParInterfices;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * SongWenjun
 * Created by dell
 * on 2019/10/1
 * The package is com.song.frame.classimp
 * This Class is ...
 */
public class CommonModule implements ICommonModule {

    OnParInterfices parInterfices = getPro();

    private OnParInterfices getPro() {
        return OverAppLocation.onParInterfices;
    }

    /**
     * 进行普通的get请求
     *
     * @param presenter     传入一个p层实现类
     * @param refreshConfig 传入什么类型的请求
     * @param apiConfig     传入第几次请求这个网络
     * @param t             传入其他参数，可变参
     */
    @Override
    public void getData(ICommonView presenter, RequestConfig refreshConfig, ApiConfig apiConfig, Object... t) {
        INetService service = RetrofitManager.getInstance().getNetService();
        Map<String, Object> userMap = new HashMap<>();//接口对应的普通参数
        Map<String, String> headers = new HashMap<>();//接口对应的请求头

        if (t.length > 2 && t[2] instanceof Map) {
            headers = (Map<String, String>) t[2];
            if (parInterfices != null) {
                Map<String, String> head = parInterfices.getHeaders();
                for (String k : head.keySet()) {
                    headers.put(k, head.get(k));
                }
            }
        }
        if (t[1] instanceof Map) {
            userMap = (Map<String, Object>) t[1];
            if (parInterfices != null) {
                Map<String, Object> par = parInterfices.getPar();
                for (String k : par.keySet()) {
                    userMap.put(k, par.get(k));
                }
            }
        }
        Observable<String> data = service.getData(String.valueOf(t[0]), userMap, headers);
        HttpUtils.getRespone(data, presenter, refreshConfig, apiConfig, t);
    }

    /**
     * 进行普通的post请求
     *
     * @param presenter 传入p层实现类
     * @param apiConfig 传入第几次请求
     * @param t
     */
    @Override
    public void postData(ICommonView presenter, RequestConfig refreshConfig, ApiConfig apiConfig, Object... t) {
        INetService netService = RetrofitManager.getInstance().getNetService();
        //t[1]传入访问网址，t[2]传入参数集合Map<String,Object>
        Map<String, Object> userMap = new HashMap<>();
        Map<String, String> headers = new HashMap<>();

        if (t.length > 2 && t[2] instanceof Map) {
            headers = (Map<String, String>) t[2];
            if (parInterfices != null) {
                Map<String, String> head = parInterfices.getHeaders();
                for (String k : head.keySet()) {
                    headers.put(k, head.get(k));
                }
            }
        }

        if (t[1] instanceof Map) {
            userMap = (Map<String, Object>) t[1];
            if (parInterfices != null) {
                Map<String, Object> par = parInterfices.getPar();
                for (String k : par.keySet()) {
                    userMap.put(k, par.get(k));
                }
            }
        }
        Observable<String> postData = netService.postData(String.valueOf(t[0]), userMap, headers);
        HttpUtils.getRespone(postData, presenter, refreshConfig, apiConfig, t);
    }

    /**
     * 进行from请求
     *
     * @param presenter
     * @param apiConfig
     * @param t
     */
    @Override
    public void fromData(ICommonView presenter, RequestConfig refreshConfig, ApiConfig apiConfig, Object... t) {

    }

    /**
     * 进行文件提交请求
     *
     * @param presenter
     * @param t         0网址  1参数  2文件路径  3请求头  4文件存放的路径
     */
    @Override
    public void fileCommit(ICommonView presenter, RequestConfig refreshConfig, ApiConfig apiConfig, Object... t) {
        INetService netService = RetrofitManager.getInstance().getNetService();
        //t[2]文件路径
        File file = new File(String.valueOf(t[2]));
        RequestBody body = RequestBody.create(MediaType.parse("*/*"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData(String.valueOf(t[4]), file.getName(), body);

        Map<String, RequestBody> bodyMap = new HashMap<>();
        Map<String, String> headers = new HashMap<>();

        if (t.length > 3 && t[3] instanceof Map) {
            headers = (Map<String, String>) t[3];
            if (parInterfices != null) {
                Map<String, String> head = parInterfices.getHeaders();
                for (String k : head.keySet()) {
                    headers.put(k, head.get(k));
                }
            }
        }
        Map<String, Object> userMap;
        if (t[1] instanceof Map) {
            userMap = (Map<String, Object>) t[1];
            if (parInterfices != null) {
                Map<String, Object> par = parInterfices.getPar();
                for (String k : par.keySet()) {
                    userMap.put(k, par.get(k));
                }
            }
            for (String k : userMap.keySet()) {
                bodyMap.put(k, convertToRequestBody(String.valueOf(userMap.get(k))));
            }
        }

        //t[1]传入服务器网址(文件提交网址)
        Observable<String> fileCommit = netService.updateOneFile(String.valueOf(t[0]), bodyMap, part, headers);
        HttpUtils.getRespone(fileCommit, presenter, refreshConfig, apiConfig, t);
    }

    /**
     * json提交的请求
     *
     * @param presenter
     * @param json      需要提交的json串
     * @param apiConfig
     * @param t
     */
    @Override
    public void jsonData(ICommonView presenter, String json, RequestConfig refreshConfig, ApiConfig apiConfig, Object... t) {
        INetService netService = RetrofitManager.getInstance().getNetService();
        RequestBody body = RequestBody.create(MediaType.parse("application/json,charset-UTF-8"), json);
        //t[1]传入访问网址
        netService.jsonData(String.valueOf(t[1]), body);
    }

    private RequestBody convertToRequestBody(String param) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), param);
        return requestBody;
    }
}
