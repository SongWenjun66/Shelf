package com.song.frame.interfaces;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * SongWenjun
 * Created by dell
 * on 2019/10/1
 * The package is com.song.frame.interfaces
 * This Class is ...
 */


@Target({ElementType.TYPE, ElementType.FIELD})//元注解，标记作用范围在类或者接口中
@Documented //元注解，标记生产文档时不清除
@Retention(RetentionPolicy.RUNTIME)//元注解，标记注解生命周期，有运行时，class
public @interface BaseUrl {
    String value() default "http://www.songwenjun.top";
}
