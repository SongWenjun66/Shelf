package com.song.frame.utils;

import com.song.frame.base.BaseRequestUtils;
import com.song.frame.classimp.CommonModule;
import com.song.frame.classimp.CommonPresenter;
import com.song.frame.config.ApiConfig;
import com.song.frame.config.OperType;
import com.song.frame.config.RequestConfig;
import com.song.frame.interfaces.ApiConfType;
import com.song.frame.interfaces.ICommonView;
import com.song.frame.interfaces.OrdinaryMap;
import com.song.frame.interfaces.RequestUrl;
import com.song.frame.interfaces.RequstType;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class RequestNet<T extends ICommonView> extends BaseRequestUtils<CommonPresenter, CommonModule> {

    private static RequestNet requestNet;
    T t;

    private RequestNet() {
        startRequest();
    }

    public static RequestNet getInstance() {
        if (requestNet == null) {
            synchronized (RequestNet.class) {
                if (requestNet == null) {
                    requestNet = new RequestNet();
                }
            }
        }
        return requestNet;
    }

    public void doGetRequest(String url, ApiConfig apiConfig, Map<String, Object> map) {
        String result = "";
        if (null == url) {
            try {
                throw new Throwable("empty netUrl!!!");
            } catch (Throwable e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        presenter.universalNode(RequestConfig.GET_DATA, apiConfig, url, map);
    }

    public void doPostRequest(String url, ApiConfig apiConfig, Map<String, Object> map) {
        String result = "";
        if (null == url) {
            try {
                throw new Throwable("empty netUrl!!!");
            } catch (Throwable e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        presenter.universalNode(RequestConfig.GET_DATA, apiConfig, url, map);
    }

    //解析传入的对象中含有的注解
    //注解底层就是反射
    public void parseRequest(T obj, Map<String, Object> map) {
        t = obj;
        String url = "";
        String result = "";
        ApiConfig apiConfig = ApiConfig.ONE;
//        Map<String, Object> map = new HashMap<>();
        //第一步。获取class文件
        Class clazz = obj.getClass();
        System.out.println("test class 名字：" + clazz.getSimpleName());
        //第二部，注解都是在方法上的，获取所有的方法
        Field[] fields = clazz.getFields();
        Method[] methods = clazz.getMethods();
        for (Field f : fields) {
            if (f.isAnnotationPresent(ApiConfType.class)) {
                ApiConfType annotation = f.getAnnotation(ApiConfType.class);
                apiConfig = annotation.value();
            }
        }
        //第三步：遍历方法
        for (Method method : methods) {
            System.out.println("test 方法名字：" + method.getName());
            //判断每个方法上的注解是否含有
            if (method.isAnnotationPresent(RequestUrl.class)) {
                //拿出方法上的这个注解
                RequestUrl urlAnotation = method.getAnnotation(RequestUrl.class);
                //拿出注解传入的值
                url = urlAnotation.value();
                System.out.println("test 网址的值11：" + url);
            }

            if (method.isAnnotationPresent(RequstType.class)) {
                RequstType requestType = method.getAnnotation(RequstType.class);
                if (requestType.value().equals(RequestConfig.GET_DATA)) {
                    //执行GET网络请求
                    doGetRequest(url, apiConfig, map);
                }

                if (requestType.value().equals(RequestConfig.POST_DATA)) {
                    //执行POST网络请求
                    doPostRequest(url, apiConfig, map);
                }
            }
        }
    }

    @Override
    protected CommonModule createModule() {
        return new CommonModule();
    }

    @Override
    protected CommonPresenter createPresenter() {
        return new CommonPresenter();
    }

    @Override
    public void onSuccess(RequestConfig requestConfig, ApiConfig apiConfig, Object o) {
        t.onSuccess(requestConfig, apiConfig, o);
    }

    @Override
    public void onError(RequestConfig requestConfig, ApiConfig apiConfig, String e) {
        t.onError(requestConfig, apiConfig, e);
    }

    //获取该注解对象的属性值
    public static Map<String, Object> getAnnotationValue(Annotation annotation, String property) {
        Map<String, Object> map = new HashMap<>();
        if (annotation != null) {
            InvocationHandler invo = Proxy.getInvocationHandler(annotation); //获取被代理的对象
            map = (Map) getFieldValue(invo, property);
        }
        return map;
    }

    public static <T> Object getFieldValue(T object, String property) {
        if (object != null && property != null) {
            Class<T> currClass = (Class<T>) object.getClass();
            try {
                Field field = currClass.getDeclaredField(property);
                field.setAccessible(true);
                return field.get(object);
            } catch (NoSuchFieldException e) {
                throw new IllegalArgumentException(currClass + " has no property: " + property);
            } catch (IllegalArgumentException e) {
                throw e;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获取指定注解类型的方法参数的值
     *
     * @param method
     * @return
     * @throws Exception
     */
    private Object getParamValueByAnnotation(Method method, Object[] params,
                                             Class<?> clazz) throws Exception {
        Object result = null;
        Annotation[][] ans = method.getParameterAnnotations();
        firstLoop:
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                if (clazz.isInstance(ans[i][j])) {
                    result = params[i];
                    break firstLoop;
                }
            }
        }
        return result;
    }
}