package com.song.frame.interfaces;

import com.song.frame.config.OperType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

/**
 * SongWenjun
 * Created by dell
 * on 2019/10/1
 * The package is com.song.frame.interfaces
 * This Class is ...
 */
@Target(ElementType.PARAMETER)//元注解，标记作用范围在局部变量中
@Documented //元注解，标记生产文档时不清除
@Retention(RetentionPolicy.RUNTIME)//元注解，标记注解生命周期，有运行时，class
public @interface OrdinaryMap {
//    OperType value();
}
