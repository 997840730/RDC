package com.wangkaisheng.notes.util.Impl;

import com.wangkaisheng.notes.bean.AnnotationUser;

import java.lang.reflect.Field;

/**
 * @author Administrator
 */
public class BeanUtils{
    public BeanUtils() {
    }
    public static <T> void copyProperty(T t, String columnName, Object value) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field f:fields) {
            if(f.isAnnotationPresent(AnnotationUser.class)){
                AnnotationUser annotation = f.getAnnotation(AnnotationUser.class);
                if(annotation.value().equals(columnName)){
                    f.setAccessible(true);
                    try {
                        f.set(t,value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
