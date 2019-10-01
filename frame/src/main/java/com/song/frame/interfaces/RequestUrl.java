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
@Target(ElementType.METHOD)//元注解，标记该注解作用范围
@Retention(RetentionPolicy.RUNTIME)////元注解，标记该注解生命周期
@Documented //元注解，标记生成javadoc时解释说明该注解
public @interface RequestUrl {
    String value() default "";
}
