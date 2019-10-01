package com.song.frame.utils;

import java.lang.reflect.Field;

import android.app.Activity;

import androidx.fragment.app.Fragment;

import com.song.frame.interfaces.BindView;

public class Bind {

    public static void InjectView(Activity activity) {
        //获取类
        Class<? extends Activity> recfClass = activity.getClass();
        //获取类中的所有field（域/变量）
        Field[] fields = recfClass.getDeclaredFields();
        //对获取到的field做遍历
        for (Field field : fields) {
            //对遍历到的field做判断，是否带特定注解标识
            if (field.isAnnotationPresent(BindView.class)) {
                //获取到该field的注解
                BindView injectView = field.getAnnotation(BindView.class);
                //获取到该field的注解的value
                int id = injectView.value();
                //设置属性
                field.setAccessible(true);
                try {
                    //对该field做控件绑定操作
                    field.set(activity, activity.findViewById(id));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void InjectView(Fragment fragment) {
        //获取类
        Class<? extends Fragment> recfClass = fragment.getClass();
        //获取类中的所有field（域/变量）
        Field[] fields = recfClass.getDeclaredFields();
        //对获取到的field做遍历
        for (Field field : fields) {
            //对遍历到的field做判断，是否带特定注解标识
            if (field.isAnnotationPresent(BindView.class)) {
                //获取到该field的注解
                BindView injectView = field.getAnnotation(BindView.class);
                //获取到该field的注解的value
                int id = injectView.value();
                //设置属性
                field.setAccessible(true);
                try {
                    //对该field做控件绑定操作
                    field.set(fragment, fragment.getActivity().findViewById(id));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}